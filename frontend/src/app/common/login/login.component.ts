import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  submitted = false;

  constructor(
    private router: Router,
    private loginService: LoginService,
    public fb: FormBuilder) { }

  loginForm = this.fb.group({
    username: ['', Validators.required],
    password: ['', Validators.required]
  })

  ngOnInit(): void {
  }

  // Getter method to access formcontrols
  get myForm() {
    return this.loginForm.controls;
  }

  login(): void {
    this.submitted = true;

    if (this.loginForm.valid){
      this.loginService.authenticate(this.loginForm.get("username")?.value, this.loginForm.get("password")?.value).subscribe(
        res => {
          console.log('HTTP response', res)
          this.loginService._logged = true;
        },
        err => {
          console.log('HTTP Error', err);
        },
        () => console.log('HTTP request completed.')
      );
    }
  }
}
