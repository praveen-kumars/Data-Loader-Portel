import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, Subscription } from 'rxjs';
import { AuthService } from 'src/app/auth/auth.service';
import * as XLSX from 'xlsx';
import { PatientDetails } from '../patient-details.services';

@Component({
  selector: 'app-add-details',
  templateUrl: './add-details.component.html',
  styleUrls: ['./add-details.component.css']
})
export class AddDetailsComponent implements OnInit {
  
  authsubscription: Subscription=new Subscription();

  username:any;
  arrayBuffer: any;
  file: File;
  JSONObject={
    object:{},
    string:''
  };
  isAuthenticated:boolean=false;
  filesent:boolean=false;

  nofile:boolean=false;
  constructor(private patientservice: PatientDetails,private router: Router,private authservice:AuthService) { }

  ngOnInit(): void{this.authsubscription=this.authservice.user.subscribe((user)=>{
    this.isAuthenticated=user?true:false;
    this.username=user?.username
  })
  }

  incommingfile(event){
    this.file=event.target.files[0];
  }


  submitdetails(data: any){
    this.patientservice.submitdetail(data).subscribe((response)=>{
    this.router.navigate(['./portal/Enroll']);
  })};

  Upload(){

    const fileReader=new FileReader();
    fileReader.onload=(e)=>{
      this.arrayBuffer=fileReader.result;
      const data=new Uint8Array(this.arrayBuffer);
      const arr=new Array();
      for(let i=0;i!==data.length;++i){
        arr[i]=String.fromCharCode(data[i]);
      }
      const bstr=arr.join('');
      const workbook=XLSX.read(bstr,{type:'binary'});
      const first_sheet_name=workbook.SheetNames[0];
      const worksheet=workbook.Sheets[first_sheet_name];
      const JSON_Object=XLSX.utils.sheet_to_json(worksheet,{raw:true});

      this.JSONObject.object=JSON_Object;
      this.JSONObject.string=JSON.stringify(JSON_Object);

      console.log(this.JSONObject.string);
      console.log(JSON.parse(this.JSONObject.string));

    }
    fileReader.readAsArrayBuffer(this.file);
    
    
    this.submitdetails(this.JSONObject.string);
  
    this.filesent=true;
    

    
    

  }
  onLogout(){
    this.authservice.logout();
  }

}

