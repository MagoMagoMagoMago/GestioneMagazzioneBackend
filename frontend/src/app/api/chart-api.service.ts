import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ChartApiService {

  private url = environment.host;

  constructor(private http: HttpClient) {  }

  public quanita(): Observable<any> {
    return this.http.get(this.url);
  }
  
  public ricavi(): Observable<any> {
    return this.http.get(this.url);
  }

  public bho(): Observable<any> {
    return this.http.get(this.url);
  }
}
