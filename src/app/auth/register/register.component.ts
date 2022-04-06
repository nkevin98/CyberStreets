import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  successMessage:string =""

  regForm!:FormGroup

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.regForm = this.fb.group({
      name: ['',[Validators.required]],
      //phone number
      mobileNumber: ['',[Validators.pattern("(([(]?[0-9]{1,3}[)]?)|([(]?[0-9]{4}[)]?))\s*[)]?[-\s\.]?[(]?[0-9]{1,3}[)]?([-\s\.]?[0-9]{3})([-\s\.]?[0-9]{3,4})")]],    //  (([+][(]?[0-9]{1,3}[)]?)|([(]?[0-9]{4}[)]?))\s*[)]?[-\s\.]?[(]?[0-9]{1,3}[)]?([-\s\.]?[0-9]{3})([-\s\.]?[0-9]{3,4})
      email:['',[Validators.required, Validators.pattern("[a-z0-9]+@[a-z]+\.[a-z]{2,3}")]],
      //Minimum 8, at least one uppercase letter, one lowercase letter, one number and one special character:
      password: ['',[Validators.required,Validators.pattern("[A-Za-z0-9@!_]{8,}")]],
      creditcard: ['',[Validators.required,Validators.pattern("\d{16}|\d{4}[- ]\d{4}[- ]\d{4}[- ]\d{4}")]]
    })
  }

  register(){
    this.successMessage = "Successfully Registered..."
    // console.log(this.regForm)
  }

}
