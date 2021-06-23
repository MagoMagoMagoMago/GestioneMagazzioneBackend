import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ItemApiService } from 'src/app/api/item-api.service';
import { Column } from 'src/app/models/columns';
import { Item } from './item';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.scss']
})
export class ItemsComponent implements OnInit {

  constructor(private api: ItemApiService, private router: Router, private toast: ToastrService) { } 

  public colItems: Column[] = [
    { name: "asin", text: "Asin", visible: false },
    { name: "title", text: "Titolo", visible: true },
    { name: "description", text: "Descrizione", visible: true },
    { name: "price", text: "Prezzo", visible: true },
    { name: "storage", text: "Giacenza", visible: true },
    { name: "minAvailability", text: "Minimo", visible: true }
  ];

  public listaItems!: Item[] | null;
  public itemToDelete: Item = new Item();

  //dettagli paginazione
  public quantity: number = 5;
  public page: number = 0;
  public sort = { name: "title", orderBy: true};
  public totalPages: number = 0;

  ngOnInit(): void {
    this.loadItems();
  }

  loadItems() {
   this.api.getAll(this.sort.name, this.sort.orderBy, this.page, this.quantity).subscribe((resp) => {
     this.listaItems = resp.list;
     this.totalPages = resp.pagine;
   })
  }

  isListEmpty(): boolean{
    if(this.listaItems?.length == 0){
      return true;
    }else{
      return false;
    }
  }

  changeVisibility(column: Column): void{
    column.visible = !column.visible;
  }

  onChangeItemPerPage(itemPerPage: string): void{
    this.quantity = Number(itemPerPage);
    this.loadItems();
  }

  changePage(page: number): void{
    this.page = page;
    this.loadItems();
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
    
    this.loadItems();
  }

  openDeleteModal(item: Item): void{
    this.itemToDelete = item;
  }

  deleteItems(id: number): void{
    this.api.deleteById(id).subscribe(
      (success) => { 
        this.toast.success("Articolo eliminato con successo.", "Eliminazione"); 
        this.loadItems();
      },
      (error) => { this.toast.error("Erorre riscontrato nella eliminazione.", "Eliminazione") }
    )
  }

}
