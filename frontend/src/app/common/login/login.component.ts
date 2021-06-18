import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AuthService } from './auth.service';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit, OnDestroy {

  submitted = false;
  subcription!: Subscription | null;

  constructor(
    private router: Router,
    private loginService: LoginService,
    private authService: AuthService,
    public fb: FormBuilder) { }

  ngOnDestroy(): void {
    this.subcription?.unsubscribe();
  }

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

    if (this.loginForm.valid) {
      this.subcription = this.authService.login(
        {
          username: this.loginForm.get("username")?.value,
          password: this.loginForm.get("password")?.value
        }).subscribe((res) => {
          if (res) {
            this.router.navigate(['/dashboard']);
          }
        });
    }

  }
}
