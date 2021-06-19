import { Component, OnInit } from '@angular/core';
import { ItemApiService } from 'src/app/api/item-api.service';
import { Item } from './item';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.scss']
})
export class ItemsComponent implements OnInit {

  constructor(private api: ItemApiService) { } 

  public colItems!:any[];
  public listaItems!: Item[];
  public selectedItem: any;

  //dettagli paginazione
  public quantita: number = 20;
  public pagine: number = 0;
  public ordine: string = "id"

  ngOnInit(): void {

    this.colItems = [
      { field: "image", header: "Immagine" },
      { field: "asin", header: "ASIN" },
      { field: "title", header: "Titolo" },
      { field: "description", header: "Descrizione" },
      { field: "price", header: "Prezzo" },
      { field: "storage", header: "Giacenza" },
      { field: "min_availability", header: "Disponibilità Minima" },
    ];
    this.loadItems(this.ordine, this.pagine, this.quantita);
  }

  loadItems(ordine: string, pagine: number, quantita: number) {
   this.api.getAll(ordine, pagine, quantita).subscribe((resp) => {
     this.listaItems = resp.list;
     console.log("listaItems", this.listaItems);
   })
  }


}
