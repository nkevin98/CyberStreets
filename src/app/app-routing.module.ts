import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';

const routes: Routes = [{path: '', redirectTo: '/navigate', pathMatch: 'full'},
                        //{path: 'navigate', component: AppComponent},
                        {path: "signUp", component: RegisterComponent},
                        {path: "signIn", component: LoginComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
