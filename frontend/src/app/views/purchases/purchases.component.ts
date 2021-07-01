import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { PurchaseItemsApiService } from 'src/app/api/purchase-items-api.service';
import { PurchasesApiService } from 'src/app/api/purchases-api.service';
import { SupplierApiService } from 'src/app/api/supplier-api.service';
import { Column } from 'src/app/models/columns';
import { PurchaseItems } from 'src/app/models/purchaseItems';
import { Supplier } from 'src/app/models/supplier';
import { Purchases } from '../../models/purchases';

@Component({
  selector: 'app-purchases',
  templateUrl: './purchases.component.html',
  styleUrls: ['./purchases.component.scss']
})
export class PurchasesComponent implements OnInit {

  @ViewChild('myModalClose') modalClose: any;

  constructor(
    private purchasesApi: PurchasesApiService,
    private supplierApi: SupplierApiService,
    private purchaseItemsApi: PurchaseItemsApiService,
    public fb: FormBuilder,
    public toast: ToastrService
    ) { }

  public colPurchases!: Column[];
  public listaPurchases!: Purchases[];
  public listaPurchaseItems!: PurchaseItems[];
  public purchaseSelected: Purchases = new Purchases();
  public suppliers!: Supplier[] | null;
  submitted: boolean = false;

  //dettagli paginazione
  readonly nameOnStorage = "table_purchases";
  public quantity!: number;
  public page: number = 0;
  public sort = { name: "note", orderBy: true};
  public totalPages: number = 0;
  //ordinamento
  public order = "name";

  updateForm = this.fb.group({
    id: [null, Validators.required],
    number_invoice : [null, Validators.required],
    note: [null, Validators.required], 
    date_invoice: [null, Validators.required],
    supplier: [null, Validators.required],
    createdAt: [null, Validators.required],
    updatedAt: [null],
    deletedAt: [null],
  })

  ngOnInit(): void {
    if(localStorage.getItem(this.nameOnStorage) != null){
      this.colPurchases = JSON.parse(localStorage.getItem(this.nameOnStorage)!) as Column[];
    }else{
      this.colPurchases = [
        { name: "number_invoice", text: "N. Fattura",  visible: true },
        { name: "note", text: "Descrizione",  visible: true },
        { name: "date_invoice", text: "Data", visible: true},
        { name: "supplier", text: "Fornitore", visible: true}, 
      ];

      localStorage.setItem(this.nameOnStorage, JSON.stringify(this.colPurchases));
    }

    if (localStorage.getItem(this.nameOnStorage + "_itemPerPage") !=  null) {
      this.quantity = Number(localStorage.getItem(this.nameOnStorage + "_itemPerPage"));
    
    }else{
      this.quantity = 5;
      localStorage.setItem(this.nameOnStorage + "_itemPerPage", this.quantity.toString());
    }
    this.loadPurchases();
  }

  loadPurchases() {
    this.purchasesApi.getAll(this.sort.name, this.sort.orderBy, this.page, this.quantity).subscribe((resp) => {
      this.listaPurchases = resp.list;
      this.totalPages = resp.pagine;
    })
  }

  // DELETE
  openDeleteModal(purchase: Purchases): void{
    this.purchaseSelected = purchase;
    this.purchaseItemsApi.getAll(this.purchaseSelected.id).subscribe((resp) => {
      this.listaPurchaseItems = resp;
      console.log("listaOrder", this.listaPurchaseItems)
    })
  }

  deletePurchase(id: number): void{
    this.purchasesApi.deleteById(id).subscribe(
      (success) => { 
        this.toast.success("Acquisto eliminato con successo.", "Eliminazione", { positionClass: 'toast-bottom-right'}); 
        this.loadPurchases();
      },
      (error) => { this.toast.error("Errore riscontrato nella eliminazione.", "Eliminazione", { positionClass: 'toast-bottom-right'}) }
    )
  }
  
  //UPDATE
  onUpdateButtonClick(purchase: Purchases): void{
    if(this.suppliers){
      this.updateForm.patchValue(
        {
          id: purchase.id,
          number_invoice: purchase.number_invoice,
          note: purchase.note, 
          date_invoice: purchase.date_invoice,
          createdAt: purchase.createdAt,
          updatedAt: purchase.updateAt,
          deletedAt: purchase.deletedAt,
          supplier: this.suppliers?.filter(x => x.name == purchase.supplier)[0].id
        }
      );
    }else{
      this.supplierApi.getAll(this.order, true).subscribe((resp: Supplier[])=>{
        this.suppliers = resp;
        this.updateForm.patchValue(
          {
            id: purchase.id,
            number_invoice: purchase.number_invoice,
            note: purchase.note, 
            date_invoice: purchase.date_invoice,
            createdAt: purchase.createdAt,
            updatedAt: purchase.updateAt,
            deletedAt: purchase.deletedAt,
            supplier: this.suppliers?.filter(x => x.name == purchase.supplier)[0].id
          }
        );
      });
    }
  }

  onSubmitUpdate(): void{
    this.updateForm.controls['supplier'].setValue({id: this.updateForm.get("supplier")?.value});
    this.purchasesApi.update(this.updateForm.value).subscribe(
      (success) => { 
        this.toast.success("Articolo modificato con successo.", "Modifica", { positionClass: 'toast-bottom-right'}); 
        this.loadPurchases();
        this.modalClose.nativeElement.click();
      },
      (error) => { 
        console.log(error);
        this.updateForm.controls['supplier'].setValue(this.suppliers?.find((x)=> x.id == this.updateForm.get("supplier")?.value.id)?.id);
        this.toast.error("Errore riscontrato nella modifica.", "Modifica", { positionClass: 'toast-bottom-right'}) 
      }
    );
  }

  //MODALE ARTICOLI PER ACQUISTO
  openDetailsModal(purchase: Purchases): void{
    this.purchaseSelected = purchase;
    this.purchaseItemsApi.getAll(this.purchaseSelected.id).subscribe((resp) => {
      this.listaPurchaseItems = resp;
      console.log("listaOrder", this.listaPurchaseItems)
    })
  }

  onChangePurchasePerPage(orderPerPage: string): void{
    this.quantity = Number(orderPerPage);
    localStorage.setItem(this.nameOnStorage + "_itemPerPage", this.quantity.toString());
    this.loadPurchases();
  }

  isListEmpty(): boolean{
    if(this.listaPurchases?.length == 0){
      return true;
    } else {
      return false;
    }
  } 

  changeVisibility(column: Column): void{
    column.visible = !column.visible;
    localStorage.setItem(this.nameOnStorage, JSON.stringify(this.colPurchases));
  }
 
  changePage(page: number): void{
    this.page = page;
    this.loadPurchases();
  }

  changePurchasesBy(column: Column): void{
    if (this.sort.name == column.name){
      this.sort.orderBy = !this.sort.orderBy;
    } else{
      this.sort = {
        name: column.name,
        orderBy: true
      };
    }
  }
  
}
