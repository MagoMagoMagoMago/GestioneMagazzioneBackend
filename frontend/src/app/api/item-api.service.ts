import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from "@angular/common/http";
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ItemApiService {

  private url = environment.host + "/" + environment.endpoint.items;

  constructor(private http: HttpClient) {  }

  public getAll(sortBy: string, orderBy: boolean,  pagine: number, quantita: number ): Observable<any> {
    return this.http.get(this.url + "/pagina/" + sortBy + "/" + orderBy + "/" + pagine + "/" + quantita );
  }

  public deleteById(id: number): Observable<any>{
    return this.http.delete(this.url + "/" + id);
  }

  public update(item: any){
    return this.http.put(this.url, item);
  }
}
