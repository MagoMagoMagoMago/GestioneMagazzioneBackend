import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Supplier, SupplierInsert, SupplierUpdate } from '../models/supplier';

@Injectable({
  providedIn: 'root'
})
export class SupplierApiService {

  private url = environment.host + "/" + environment.endpoint.suppliers;

  constructor(private http: HttpClient) {  }

  public getAll(sortBy: string, order: boolean): Observable<any> {
    return this.http.get(this.url + "/all?sortBy=" + sortBy + "&order=" + order.toString());
  }

  public insert(supplier: SupplierInsert): Observable<any>{
    return this.http.post(this.url + "/insert", supplier);
  }

  public update(supplier: SupplierUpdate): Observable<any>{
    return this.http.post(this.url + "/update", supplier);
  }

  public delete(id: number): Observable<any>{
    return this.http.delete(this.url + "/" + id);
  }
}
