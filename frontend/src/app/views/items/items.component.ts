import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { CategoryApiService } from 'src/app/api/category-api.service';
import { ItemApiService } from 'src/app/api/item-api.service';
import { Category } from 'src/app/models/category';
import { Column } from 'src/app/models/columns';
import { Item } from './item';


@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.scss']
})
export class ItemsComponent implements OnInit {

  @ViewChild('myModalClose') modalClose: any;

  constructor(
    private itemService: ItemApiService, 
    private router: Router, 
    private toast: ToastrService,
    public fb: FormBuilder,
    private categoriyService: CategoryApiService
    ) { }
  public colItems!: Column[];

  submitted: boolean = false;
  readonly nameOnStorage = "table_items";
  public listaItems!: Item[] | null;
  public itemSelected: Item = new Item();
  public categories!: Category[] | null;

  //dettagli paginazione
  public quantity!: number;
  public page: number = 0;
  public sort = { name: "title", orderBy: true};
  public totalPages: number = 0;

  updateForm = this.fb.group({
    id : [null, Validators.required],
    asin : [null, [Validators.required, Validators.minLength(10)]],
    title : [null, Validators.required],
    description : [null],
    price : [null, [Validators.required, Validators.pattern("^\\d+\\.\\d{0,2}$")]],
    storage : [null, Validators.required],
    minAvailability : [null, Validators.required],
    image : [null, Validators.required],
    createdAt: [null, Validators.required],
    updatedAt: [null],
    deletedAt: [null],
    category: [null, Validators.required],
  })

  ngOnInit(): void {
    
    if(localStorage.getItem(this.nameOnStorage) != null){
      this.colItems = JSON.parse(localStorage.getItem(this.nameOnStorage)!) as Column[];
    }else{
      this.colItems = [
        { name: "asin", text: "Asin", visible: false },
        { name: "title", text: "Titolo", visible: true },
        { name: "description", text: "Descrizione", visible: true },
        { name: "categoryId", text: "Categoria", visible: true },
        { name: "price", text: "Prezzo", visible: true },
        { name: "storage", text: "Giacenza", visible: true },
        { name: "minAvailability", text: "Minimo", visible: true }
      ];
      localStorage.setItem(this.nameOnStorage, JSON.stringify(this.colItems));
    }
    if (localStorage.getItem(this.nameOnStorage + "_itemPerPage") !=  null) {
      this.quantity = Number(localStorage.getItem(this.nameOnStorage + "_itemPerPage"));
    }else{
      this.quantity = 5;
      localStorage.setItem(this.nameOnStorage + "_itemPerPage", this.quantity.toString());
    }

    this.loadItems();
  }

  loadItems() {
   this.itemService.getAll(this.sort.name, this.sort.orderBy, this.page, this.quantity).subscribe((resp) => {
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
    localStorage.setItem(this.nameOnStorage, JSON.stringify(this.colItems));
  }

  onChangeItemPerPage(itemPerPage: string): void{
    this.quantity = Number(itemPerPage);
    localStorage.setItem(this.nameOnStorage + "_itemPerPage", this.quantity.toString());
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
    this.itemSelected = item;
  }

  deleteItems(id: number): void{
    this.itemService.deleteById(id).subscribe(
      (success) => { 
        this.toast.success("Articolo eliminato con successo.", "Eliminazione"); 
        this.loadItems();
      },
      (error) => { this.toast.error("Erorre riscontrato nella eliminazione.", "Eliminazione") }
    )
  }

  onUpdateButtonClick(item: Item): void{
    if(this.categories){
      this.updateForm.patchValue(
        {
          id: item.id,
          asin: item.asin,
          title: item.title,
          description: item.description,
          price: item.price,
          storage: item.storage,
          minAvailability: item.minAvailability,
          image: item.image,
          createdAt: item.createdAt,
          updatedAt: item.updatedAt,
          deletedAt: item.deletedAt,
          category: this.categories?.filter(x => x.name == item.category)[0].id
        }
      );
    }else{
      this.categoriyService.getAll().subscribe((resp: Category[])=>{
        this.categories = resp;
        this.updateForm.patchValue(
          {
            id: item.id,
            asin: item.asin,
            title: item.title,
            description: item.description,
            price: item.price,
            storage: item.storage,
            minAvailability: item.minAvailability,
            image: item.image,
            createdAt: item.createdAt,
            updatedAt: item.updatedAt,
            deletedAt: item.deletedAt,
            category: resp?.filter(x => x.name == item.category)[0].id
          }
        );
      });
    }
    
  }

  onSubmitUpdate(): void{
    this.updateForm.controls['category'].setValue({id: this.updateForm.get("category")?.value});
    this.itemService.update(this.updateForm.value).subscribe(
      (success) => { 
        this.toast.success("Articolo modificato con successo.", "Modifica"); 
        this.loadItems();
        this.modalClose.nativeElement.click();
      },
      (error) => { 
        console.log(error);
        this.updateForm.controls['category'].setValue(this.categories?.find((x)=> x.id == this.updateForm.get("category")?.value.id)?.id);
        this.toast.error("Erorre riscontrato nella modifica.", "Modiica") 
      }
    );
  }

}
