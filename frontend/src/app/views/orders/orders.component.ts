import { Component, OnInit } from '@angular/core';
import { OrdersApiService } from 'src/app/api/orders-api.service';
import { Order } from './order';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss']
})
export class OrdersComponent implements OnInit {

  constructor(private api: OrdersApiService) { }

  public colOrders!:any[];
  public listaOrders!: Order[];
  //dettagli paginazione
  public quantita: number = 20;
  public pagine: number = 0;
  public ordine: string = "id"

  ngOnInit(): void {

    this.colOrders = [
      { field: "OrderStatus", header: "Stato" },
      { field: "OrderType", header: "Tipo" },
      { field: "BuyerName", header: "Acquirente" },
      { field: "CompanyLegalName", header: "Ragione Sociale" },
      { field: "PaymentMethod", header: "Metodo di Pagamento" },
      { field: "ShippingAddressCity", header: "Città" },
      { field: "ShippingAddressName", header: "Indirizzo" },
      { field: "ShippingCityStateOrRegion", header: "Stato" },
      { field: "ShippingStateOrRegionPostalCode", header: "Codice Postale" },
    ];

    this.loadOrders(this.ordine, this.pagine, this.quantita);

  }

  loadOrders(ordine: string, pagine: number, quantita: number) {
    this.api.getAll(ordine, pagine, quantita).subscribe(resp => {
      this.listaOrders = resp.list;
      console.log("listaOrders", this.listaOrders)
    })
  }

}
