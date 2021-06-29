import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { PurchaseItem } from '../models/purchases';

@Injectable({
  providedIn: 'root'
})
export class PurchaseItemApiService {
  private url = environment.host + "/" + environment.endpoint.purchaseItems;

  constructor(private http: HttpClient) { }

  public insertPurchaseItems(items: PurchaseItem[]): Observable<any>{
    return this.http.post(this.url, items);
  }
}
