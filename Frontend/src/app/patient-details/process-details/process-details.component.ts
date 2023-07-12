import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ignoreElements, Subscription } from 'rxjs';
import { AuthService } from 'src/app/auth/auth.service';
import { PatientDetails } from '../patient-details.services';
import { Patientprocesspost} from './patient.model';
import { Patientsprocess } from './patientproces.model';

@Component({
  selector: 'app-process-details',
  templateUrl: './process-details.component.html',
  styleUrls: ['./process-details.component.css']
})
export class ProcessDetailsComponent implements OnInit {
    
  patientname: any;
  setactive : boolean=false;
  formactive: boolean=false;
    processed: boolean=false;
    data :boolean=false;
    isAuthenticated:boolean=true;
    authsubscription: Subscription=new Subscription();
    username:any;

  constructor(private patientservice: PatientDetails,private router:Router,private authservice:AuthService) { }

  ngOnInit(): void {this.authsubscription=this.authservice.user.subscribe((user)=>{
    this.isAuthenticated=user?true:false;
    this.username=user?.username
  })
  }
  
  Updatesuccess:boolean=false;

  //get detail code
  patient: Patientprocesspost=new Patientprocesspost();
  patients: Patientsprocess=new Patientsprocess;
  fetchprocessdata(name: any){
    console.log(name);
    this.patientservice.retrieveprocess(name)
      .subscribe(data=>{
        this.patients=data;
        
        console.log(this.patient);
        if(this.patients.status=="inducted"){
          this.patient.patientName=this.patients.patientName;
          this.patient.patientAddress=this.patients.patientAddress;
          this.patient.patientEmail=this.patients.patientEmail;
          this.patient.drugId=this.patients.drugId;
          this.patient.drugName=this.patients.drugName;
          this.patient.dateofbirth=this.patients.dateofbirth;
          this.patient.contactNumber=this.patients.contactNumber;
          this.processed=false;
          console.log(this.patient);
          this.formactive=true;
          
        }     
        else if(this.patients.status=="processes"){
          this.patient={} as any;
          this.processed=true;
          this.setactive=false;
        }
        else{
          this.setactive=false;
        }
        
  });}


  retrieve(patientName){
    this.setactive=false;

    if(patientName!=""){
      const name=patientName.value;
      
      this.fetchprocessdata(name);
      
  
    if(this.patient.patientName==this.patientname){
        
        
     
       this.setactive=false;
       this.formactive=true;
       this.processed=false;
       this.data=false;
       this.Updatesuccess=false;
       }
       else if(this.processed==true){
        this.data=true;
        
       }
      else{
        this.setactive=true;
       this.processed=false;
       this.data=false;
       }
       
  
    }
    
  
      
    }
    onLogout(){
      this.authservice.logout();
    }


//update details code
processDetails(form:NgForm){
  console.log(this.patient);
  if(!this.patient){
    return;
  }
  this.patientservice.updatepatient(this.patientname,this.patient)
  .subscribe((response)=>{
    this.router.navigate(['./portal/Process']);
    form.reset();
      
      this.formactive=false;

  })
  this.Updatesuccess=true;
  
}
removesuccessmessage(){
  this.processed=false;
  this.setactive=false;
}
removesuccessmessage1(){
  this.Updatesuccess=false;
  this.setactive=false;
  
} 
removesuccessmessage2(){
  this.setactive=false;
} 



}
