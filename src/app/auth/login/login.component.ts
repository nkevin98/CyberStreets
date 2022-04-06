import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  successMessage:string ="";
  loginForm!: FormGroup; 
  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email:['',[Validators.required, Validators.pattern("[a-z0-9]+@[a-z]+\.[a-z]{2,3}")]], // [A-Za-z0-9]*@capgemini.com
      password:['',[Validators.required,Validators.pattern("[A-Za-z0-9@!_]{8,}")]]
    })
  }

  login(){
    this.successMessage="Successfully Logged In..."
  }

}
