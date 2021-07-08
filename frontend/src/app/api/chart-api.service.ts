import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Item } from '../models/item';

@Injectable({
  providedIn: 'root'
})
export class ChartApiService {

  private url = environment.host + "/orderItems";

  constructor(private http: HttpClient) {  }

  public chartOrderItems(start: string, end: string): Observable<any> {
    return this.http.get(this.url + "/betweenitem/" + start +"T00:00:00.00Z" + "/" + end  + "T00:00:00.00Z");
  }

  public chartTotalOrderItems(start: string, end: string): Observable<any> {
    return this.http.get(this.url + "/between/" + start +"T00:00:00.00Z" + "/" + end  + "T00:00:00.00Z");
  }
  
  public chartTotalOrderItemsByAsin(start: string, end: string, asin: string): Observable<any> {
    return this.http.get(this.url + "/between/" + start +"T00:00:00.00Z" + "/" + end  + "T00:00:00.00Z/" + asin);
  }

  public istogrammaArticoli(start: string, end: string): Observable<any[]> {
    return this.http.get<any[]>(this.url + "/betweenitem/" + start +"T00:00:00.00Z" + "/" + end  + "T00:00:00.00Z");
  }

  public articoliConScarsaGiacenza(): Observable<Item[]> {
    return this.http.get<Item[]>(environment.host + "/" + environment.endpoint.items + "/graph4");
  }
}
