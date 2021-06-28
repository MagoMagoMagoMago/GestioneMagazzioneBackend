import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SupplierApiService {

  private url = environment.host + "/" + environment.endpoint.suppliers;

  constructor(private http: HttpClient) {  }

  public getAll(): Observable<any> {
    return this.http.get(this.url + "/all");
  }
}
