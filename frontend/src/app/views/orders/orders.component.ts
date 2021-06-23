import { Component, OnInit } from '@angular/core';
import { OrdersApiService } from 'src/app/api/orders-api.service';
import { Column } from 'src/app/models/columns';
import { Order } from './order';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss']
})
export class OrdersComponent implements OnInit {

  constructor(private api: OrdersApiService) { }

  public colOrders: Column[] = [
    { name: "OrderStatus", text: "Stato", visible: true}, //0
    { name: "OrderType", text: "Tipo",  visible: false }, //1
    { name: "AmazonOrderId", text: "ID Amazon", visible: false},
    { name: "BuyerName", text: "Acquirente",  visible: true }, //3
    { name: "BuyerEmail", text: "Email Acquirente", visible: false},
    { name: "EarliestShipDate", text: "Data Spedizione", visible: false},
    { name: "FulfillmentChannel", text: "Canale di adempimento", visible: false},
    { name: "IsBusinessOrder", text: "Ordine Business", visible: false},
    { name: "IsPremiumOrder", text: "Ordine Premium", visible: false},
    { name: "IsPrime", text: "Ordine Prime", visible: false},
    { name: "IsSoldByAB", text: "Venduto da AB", visible: false},//10
    { name: "MarketplaceId", text: "ID MarketPlace", visible: false},
    { name: "NumberOfItemsShipped", text: "Ordini Spediti", visible: false},
    { name: "NumberOfItemsUnshipped", text: "Ordini non Spediti", visible: false},
    { name: "PaymentMethod", text: "Metodo di Pagamento",  visible: true }, //14
    { name: "PaymentMethodDetails", text: "Dettagli Pagamento",  visible: false },
    { name: "PurchaseOrderNumber", text: "Numero Acquisto",  visible: false },
    { name: "PurchaseDate", text: "Data Acquisto",  visible: false },
    { name: "ShipmentServiceLevelCategory", text: "Categoria Spedizione",  visible: false },
    { name: "ShippingAddressLine1", text: "Indirizzo",  visible: true },
    { name: "ShippingCityStateOrRegion", text: "Stato",  visible: true },
    { name: "ShippingAddressCity", text: "Città",  visible: true },//22
    { name: "ShippingStateOrRegionPostalCode", text: "CAP",  visible: true },
  
  ];

  public listaOrders!: Order[];
  //dettagli paginazione
  public quantity: number = 10;
  public page: number = 0;
  public sort = { name: "AmazonOrderId", orderBy: true};
  public totalPages: number = 0;
 
  ngOnInit(): void {
    this.loadOrders();
  }

  loadOrders() {
    this.api.getAll(this.sort.name, this.sort.orderBy, this.page, this.quantity).subscribe((resp) => {
      this.listaOrders = resp.list;
      this.totalPages = resp.pagine;
    })
   }

  changePage(page: number): void{
    this.page = page;
    this.loadOrders();
  }

  onChangeOrderPerPage(orderPerPage: string): void{
    this.quantity = Number(orderPerPage);
    this.loadOrders();
  }

  isListEmpty(): boolean{
    if(this.listaOrders?.length == 0){
      return true;
    } else {
      return false;
    }
  } 
  changeOrderBy(column: Column): void{
    if (this.sort.name == column.name){
      this.sort.orderBy = !this.sort.orderBy;
    } else{
      this.sort = {
        name: column.name,
        orderBy: true
      };
    }
    
    this.loadOrders();
  }

}
