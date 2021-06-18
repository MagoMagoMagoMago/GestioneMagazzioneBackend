import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  url: string = environment.host + environment.endpoint.login;
  _logged: boolean = false;

  constructor(private http: HttpClient) { }

  authenticate(email: String, password: String ){
    return this.http.get(this.url + "/" + email + "&" + password);
  }

  isLogged(){
    return this._logged;
  }

  logged(){
    this._logged = true;
  }
  
}
