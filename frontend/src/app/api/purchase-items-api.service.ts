import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PurchaseItemsApiService {

  private url = environment.host + "/" + environment.endpoint.purchaseItems;

  constructor(private http: HttpClient) { }

  public getAll(id: number): Observable<any> {
    return this.http.get(this.url + "/purchase/" + id);
  }
}
