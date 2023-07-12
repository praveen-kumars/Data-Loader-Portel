import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { AuthService } from '../auth/auth.service';
import { User } from '../auth/user.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  isAuthenticated:boolean=false;
  authsubscription: Subscription=new Subscription();
  username:any;

  constructor(private authservice: AuthService){}

  ngOnInit(){this.authsubscription=this.authservice.user.subscribe((user)=>{
    this.isAuthenticated=user?true:false;
    this.username=user?.username;
  })
  
    
    
  }

  onLogout(){
    this.authservice.logout();
  }

  
  

}
