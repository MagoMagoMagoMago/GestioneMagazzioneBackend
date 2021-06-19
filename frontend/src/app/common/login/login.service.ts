import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private host = environment.host + environment.endpoint.login;

  constructor() { }
}
