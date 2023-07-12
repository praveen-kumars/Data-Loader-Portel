import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, catchError, Subject, tap, throwError } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { User } from './user.model';

interface AuthResponse{
  username: string,
  jwtAuthTokenString: string,
  serverCurrentTime: number,
  tokenExpirationTime: number;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  user=new BehaviorSubject<User |null>(null);
  timeout=new Subject<boolean>();
  private tokenExpirationTime:any;

  constructor(private http: HttpClient,private router:Router) { }

  login(inputFields:{username:string,password: string}){
    return this.http
        .post<AuthResponse>(environment.AUTH_SERVICE_URL+'/login',inputFields)
        .pipe(
          catchError(this.handleError),
          tap((response)=>{
            this.handleAuthentication(
              response['username'],
              response['jwtAuthTokenString'],
              response['serverCurrentTime'],
              response['tokenExpirationTime']
            );
          })
        
        )
  }


  autoLogin(){
    const user=localStorage.getItem('userData');
    if(!user) return;
    const parsedUser:{
      username: string,
      _token: string,
      serverCurrentTime: number,
      _tokenExpirationTime: number;
    }=JSON.parse(user);
    const loadeduser=new User(parsedUser.username,
      parsedUser._token,parsedUser.serverCurrentTime,parsedUser._tokenExpirationTime);

    if(loadeduser.token){
      this.user.next(loadeduser);
      const expirationDuration=loadeduser.tokenExpirationTime-new Date().getTime();
      this.autoLogout(expirationDuration);
    }
  }


  logout(){
    this.user.next(null);
    this.router.navigate(['./auth']);
    this.removeUser();
    if(this.tokenExpirationTime){
      clearTimeout(this.tokenExpirationTime);

    }
    this.tokenExpirationTime=null;

  }

  autoLogout(expirationDuration: number){
    this.tokenExpirationTime=setTimeout(()=>{
      this.timeout.next(true);
      this.logout();
    },expirationDuration)
  }

  private handleError(errorResponse: HttpErrorResponse){
    let errorMessage='Invalid Username or password';
    if(!errorResponse.error || !errorResponse.error.error){
      return throwError(errorMessage);
    }
    if(errorResponse.error.message){
      if(errorResponse.error.message=="No value present")
         errorMessage='Invalid Username';
      else errorMessage='Invalid username or password';
    }
    return throwError(errorMessage);

  }

  private handleAuthentication(
    username: string,
    token: string,
    serverCurrentTime: number,
    tokenExpirationTime: number
  ){
    const user=new User(username,token,serverCurrentTime,tokenExpirationTime);
    this.storeUser(user),
    this.autoLogout(tokenExpirationTime-serverCurrentTime);
    this.user.next(user);
    console.log(user);



  }
  private storeUser(user:User){
    localStorage.setItem('userData',JSON.stringify(user));
  }

  private removeUser(){
    localStorage.removeItem('userData');
  }

}
