import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from "@angular/common/http";
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ItemApiService {

  private host = environment.host + "/api/" + environment.endpoint.items;

  constructor(private http: HttpClient) {  }

  public getAll(ordinamento: string, pagine: number, quantita: number ): Observable<any> {
    return this.http.get(this.host + "/pagina/" + ordinamento + "/" + pagine + "/" + quantita );
  }
}
