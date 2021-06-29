import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { PurchaseInsert } from '../models/purchases';

@Injectable({
  providedIn: 'root'
})
export class PurchasesApiService {

  private url = environment.host + "/" + environment.endpoint.purchases;

  constructor(private http: HttpClient) {  }

  public getAll(sortBy: string, orderBy: boolean,  pagine: number, quantita: number ): Observable<any> {
    return this.http.get(this.url + "/pagina/" + sortBy + "/" + orderBy + "/" + pagine + "/" + quantita );
  }

  public deleteById(id: number): Observable<any>{
    return this.http.get(this.url + "/delete/" + id);
  }
  
  public update(item: any){
    return this.http.put(this.url, item);
  }

  public insertPurchase(purchase: PurchaseInsert): Observable<any>{
    return this.http.put(this.url + "/insert", purchase);
  }
}
