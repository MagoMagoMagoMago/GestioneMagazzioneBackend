import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OrderItemsApiService {

  private url = environment.host + "/" + environment.endpoint.orderItems;

  constructor(private http: HttpClient) { }

  public getAll(amazonOrderId: string): Observable<any> {
    return this.http.get(this.url + "/" + amazonOrderId);
  }
}
