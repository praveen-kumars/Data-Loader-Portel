  import { Component, OnInit } from '@angular/core';
  import { NgForm } from '@angular/forms';
  import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AuthService } from 'src/app/auth/auth.service';
  import { PatientDetails } from '../patient-details.services';
  import { Patient } from './patient.model';
import { Patients } from './patients.model';
  
  @Component({
    selector: 'app-update-details',
    templateUrl: './update-details.component.html',
    styleUrls: ['./update-details.component.css']
  })
  export class UpdateDetailsComponent implements OnInit {
    patientname: any;
    setactive : boolean=false;
    formactive: boolean=false;
    processed: boolean=false;
    data :boolean=false;
    isAuthenticated:boolean=true;
    username:any;
    authsubscription: Subscription=new Subscription();
  
    constructor(private patientservice:PatientDetails,private router:Router,private authservice:AuthService) { }
  
    ngOnInit() {this.authsubscription=this.authservice.user.subscribe((user)=>{
      this.isAuthenticated=user?true:false;
      this.username=user?.username
    })
  
    }
    Updatesuccess:boolean=false;
    




  //get detail code
    patient: Patient=new Patient();
    patients:Patients=new Patients();
    fetchdata(name: any){
      console.log(name);
      this.patientservice.retrieveData(name)
        .subscribe(data=>{
          this.setactive=false;
          this.patients=data;
          if(this.patients.status=="inducted"){
            this.patient.patientName=this.patients.patientName;
            this.patient.patientAddress=this.patients.patientAddress;
            this.patient.patientEmail=this.patients.patientEmail;
            this.patient.drugId=this.patients.drugId;
            this.patient.drugName=this.patients.drugName;
            this.patient.dateofbirth=this.patients.dateofbirth;
            this.patient.contactNumber=this.patients.contactNumber;
            this.processed=false;
            this.formactive=true;
            this.setactive=false;
          }     
          else if(this.patients.status=="processes"){
            this.patient={} as any;
            this.processed=true;
            this.setactive=false;
          }
          else{
            return this.setactive=true;
          }
          
          console.log(this.patient);
          
    });}




    retrieve(patientName){
      this.patient={} as any;
      if(patientName!=""){
        const name=patientName.value;
      
        
         this.fetchdata(name);
         if(this.patients.status=="inducted"){
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
          this.setactive=false;
          
           
           this.processed=false;
           this.data=false;
          
        }
        if(this.patientname!=this.patient.patientName){
          this.setactive=true;
      
      // }
    }
      }}
  
  
  //update details code
  updateDetails(form:NgForm){
    console.log(this.patient);
    // this.patient.patientAddress=form.value.address;
    // this.patient.patientEmail=form.value.emailid;
    // this.patient.contactNumber=form.value.phonenumber;
    // this.patient.dateofbirth=form.value.dataofbirth;
    if(!this.patient){
      return;
    }
    console.log(this.patient);
    this.patientservice.updatepatient(this.patientname,this.patient)
    .subscribe((response)=>{
      this.router.navigate(['./username/update-details']);
      this.setactive=false;
      form.reset();
      
      this.formactive=false;
      this.setactive=false;
      
  
    })
    this.Updatesuccess=true;
    this.setactive=false;
    
  }
  onLogout(){
    this.authservice.logout();
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
    console.log(this.setactive);
  } 
  
  
  
  
    }
    
  
  
  
  








  
  


