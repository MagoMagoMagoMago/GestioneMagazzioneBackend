import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OrdersApiService {

  private host = environment.host + "/" + environment.endpoint.orders;

  constructor(private http: HttpClient) { }

  public getAll(ordinamento: string, pagine: number, quantita: number ): Observable<any> {
    return this.http.get(this.host + "/pagina/" + ordinamento + "/" + pagine + "/" + quantita );
    
  }}
