import { Injectable } from '@angular/core';
    import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest, HttpHeaders } from '@angular/common/http';
    import { exhaustMap, Observable, take } from 'rxjs';
import { AuthService } from './auth.service';
import { User } from './user.model';

    
    @Injectable()
    export class AuthInterceptorService implements HttpInterceptor {
        constructor(private authService: AuthService) {}
    
        intercept(req: HttpRequest<any>, next: HttpHandler) {
            return this.authService.user.pipe(
                take(1),
                exhaustMap((user)=>{
                    if(!user) return next.handle(req);

                    const modifiedReq=req.clone({
                        headers:new HttpHeaders({
                            'Authorization':'Bearer '+ user.token,  
                            'Content-Type':'application/json',
                        }),
                    });
                    console.log(user.token);
                    return next.handle(modifiedReq);
                })
            );
           
        }
    }