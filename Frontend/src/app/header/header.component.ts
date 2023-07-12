import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isAuthenticated:boolean=false;
  authsubscription: Subscription=new Subscription();

  constructor(private authservice: AuthService){}

  ngOnInit(){
    this.authsubscription=this.authservice.user.subscribe((user)=>{
      this.isAuthenticated=user?true:false;
    })
    
    
  }

  onLogout(){
    this.authservice.logout();
  }

}
