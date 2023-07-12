import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AuthComponent } from './auth/auth.component';
import { AuthGuard } from './auth/auth.guard';
import { HomeComponent } from './home/home.component';
import { AddDetailsComponent } from './patient-details/add-details/add-details.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { ProcessDetailsComponent } from './patient-details/process-details/process-details.component';
import { UpdateDetailsComponent } from './patient-details/update-details/update-details.component';

const routes: Routes = [{path:'',pathMatch:'full',redirectTo:'home'},
{path:'home',component:HomeComponent,},
{path:'auth',component:AuthComponent},
{
  path:'portal',
  component:PatientDetailsComponent,
  canActivate:[AuthGuard],
  children:[
    {
      path:'Enroll',
      component:AddDetailsComponent,
      
    },
    {
      path:'Updation',
      component:UpdateDetailsComponent
    },
    {
      path:'Process',
      component:ProcessDetailsComponent
    }

  
  ]
  
  },
  {path:'home',component:HomeComponent},
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
}
