import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import * as moment from 'moment';
import { ToastrService } from 'ngx-toastr';
import { CartService } from 'src/app/api/internal-services/cart.service';
import { PurchaseItemApiService } from 'src/app/api/purchase-item-api.service';
import { PurchasesApiService } from 'src/app/api/purchases-api.service';
import { SupplierApiService } from 'src/app/api/supplier-api.service';
import { ItemToCart } from 'src/app/models/cart';
import { PurchaseInsert, PurchaseItem, Purchases } from 'src/app/models/purchases';
import { Supplier } from 'src/app/models/supplier';
import { AuthService } from '../login/auth.service';
import { Navbar } from './navbar';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit, OnDestroy {
  visible!: boolean;
  quantityItemsToCard!: number;
  public navbar: Navbar[] = [
    {
      title: "Dashboard ",
      icon: "bootstrap-icons.svg#speedometer2",
      hover: false,
      link: "dashboard",
      visible: true
    },
    {
      title: "Ordini",
      icon: "bootstrap-icons.svg#table",
      hover: false,
      link: "orders",
      visible: true
    },
    {
      title: "Articoli",
      icon: "bootstrap-icons.svg#grid",
      hover: false,
      link: "items",
      visible: true
    },
    {
      title: "Acquisti",
      icon: "bootstrap-icons.svg#bag",
      hover:false,
      link:"purchases",
      visible: true
    },
    {
      title: "Fornitori",
      icon: "bootstrap-icons.svg#people",
      hover:false,
      link:"suppliers",
      visible: true
    }
  ];
  public suppliers!: Supplier[];
  public fornitore!: number | null;
  public numeroFattura!: number | null;
  public dataFattura = moment().format('YYYY-MM-DD');
  public note!: string | null;

  constructor(
    public authService: AuthService,
    public router: Router,
    public cartService: CartService,
    public purchaseService: PurchasesApiService,
    public supplierService: SupplierApiService,
    private pruchaseItemService: PurchaseItemApiService,
    private toast: ToastrService,) { }

  ngOnInit(): void {
    
  }

  loadSuppliers(): void{
    this.supplierService.getAll("name", true).subscribe((resp: Supplier[])=>{
      this.suppliers = resp;
    });
  }
    
  ngOnDestroy(): void {
    this.logout();
  }

  logout(): void{
    this.authService.logout().subscribe( () =>{
      this.router.navigate(['']);
      sessionStorage.clear();
    });
  }

  onHover(item: Navbar): void {
    // event.target.className = String(event.target.className).replace('text-white', 'text-warning');
    item.hover = true;
  }

  removeHover(item: Navbar): void {
    // event.target.className = String(event.target.className).replace('text-warning', 'text-white');
    item.hover = false;
  }

  changeQuantity(op: string, itemToCard: ItemToCart): void{
    if (op === "-") {
      itemToCard.quantity = itemToCard.quantity - 1;
    }else if (op === "+"){
      itemToCard.quantity = itemToCard.quantity + 1;
    }else{
      itemToCard.quantity = 0;
    }
    this.cartService.setQuantity(itemToCard);
  }

  buy(): void{
    const purchaseBody: PurchaseInsert = {
      id: null,
      number_invoice: this.numeroFattura!,
      note: this.note!,
      date_invoice: moment(this.dataFattura).format("YYYY-MM-DDTHH:mm:ssZ"),
      supplier: { id: Number(this.fornitore) },
      createdAt: null,
      updateAt: null,
      deletedAt: null
    };

    this.purchaseService.insertPurchase(purchaseBody)
    .subscribe(
      (success)=> {
        let itemBody: PurchaseItem[] = [];
        this.cartService.getItemsOnCartSessionStorage().forEach(element => {
          const item: PurchaseItem = {
            id: null,
            purchase_id: success,
            item: element.item.id,
            quantity: element.quantity,
            unit_price: element.item.price,
            created_at: null,
            updated_at: null,
            deleted_at: null
          };
          itemBody.push(item);
        });
        this.pruchaseItemService.insertPurchaseItems(itemBody).subscribe(
          (success)=>{
            this.toast.success("Acquisto caricato correttamente", "Acquisto", { positionClass: 'toast-bottom-right'});
            this.cartService.clearItemsOnCartSessionStorage();
            this.fornitore = null;
            this.numeroFattura = null;
            this.dataFattura = moment().format('YYYY-MM-DD');
            this.note = null;
          },
          (error)=>{this.toast.error("Gli articoli non sono stati carricati correttamente", "Acquisto", { positionClass: 'toast-bottom-right'})}
        );
       },
      (err)=>{this.toast.error("I campi non sono stati inseriti correttamente. </br></br> Ricontrolla e riprova", "Acquisto", { enableHtml: true, positionClass: 'toast-bottom-right'})},
    )
  }

}
