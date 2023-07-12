import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule,HTTP_INTERCEPTORS} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthComponent } from './auth/auth.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { AddDetailsComponent } from './patient-details/add-details/add-details.component';
import { UpdateDetailsComponent } from './patient-details/update-details/update-details.component';
import { ProcessDetailsComponent } from './patient-details/process-details/process-details.component';
import { FormsModule } from '@angular/forms';
import { from } from 'rxjs';
import { AuthInterceptorService } from './auth/auth-interceptor.service';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthComponent,
    PatientDetailsComponent,
    AddDetailsComponent,
    UpdateDetailsComponent,
    ProcessDetailsComponent,
    HomeComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptorService,
      multi: true,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
