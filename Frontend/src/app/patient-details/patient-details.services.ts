import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHandler, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { catchError, Observable, tap, throwError } from 'rxjs';
import { UpdateDetailsComponent } from './update-details/update-details.component';
import { Patient } from './update-details/patient.model';
import { Patientprocesspost } from './process-details/patient.model';



@Injectable({providedIn: 'root'})
export class PatientDetails {

  retrievestatus=false;

  patient:Patient=new Patient();

    //Adding patient to db
    constructor(private httpClient: HttpClient,private router: Router) { }
   
    submitdetail(data:any){
      return this.httpClient.post(environment.ADD_PATIENT_URL+'/add-patient',data)
      .pipe(catchError(this.handleError))
      };


    handleError(errorResponse: HttpErrorResponse){
        return throwError(errorResponse.error.message);
    }

    //retrieving data

    retrieveData(patientName:string):Observable<any>{
      return this.httpClient.get
      (environment.UPDATE_PATIENT_URL+`/retrieve/${patientName}`)    
    }

    //updating in db
    updatepatient(patientName:string,patient: Patient){
      let body=JSON.stringify(patient);
      console.log(body);
      return this.httpClient.put
      (environment.UPDATE_PATIENT_URL+`/updatepatient/${patientName}`,body)
    }


    //retrieving data

    retrieveprocess(patientName:string):Observable<any>{
      return this.httpClient.get
      (environment.PROCESS_PATIENT_URL+`/retrieve/${patientName}`)    
    }

    //updating in db
    processpatient(patientName:string,patient: Patientprocesspost){
      let body=JSON.stringify(patient);
      console.log(body);
      return this.httpClient.put
      (environment.PROCESS_PATIENT_URL+`/updatepatient/${patientName}`,body)
    }

    

    }


 



