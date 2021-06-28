import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { SupplierApiService } from 'src/app/api/supplier-api.service';
import { Column } from 'src/app/models/columns';
import { Supplier } from 'src/app/models/supplier';

@Component({
  selector: 'app-suppliers',
  templateUrl: './suppliers.component.html',
  styleUrls: ['./suppliers.component.scss']
})
export class SuppliersComponent implements OnInit {

  constructor(
    private supplierService: SupplierApiService,
    public fb: FormBuilder,
    ) { }

  public columns!: Column[];

  public listaSuppliers!: Supplier[] | null;
  public sort = { name: "title", orderBy: true};

  public new!: boolean | null;
  public selectedSupplier!: Supplier | null;

  formNewEditSupplier = this.fb.group({
    id: [null, Validators.required],
    name: [null, Validators.required],
    indirizzo: [null, Validators.required],
    telefono: [null, Validators.required],
    email: [null, Validators.required],
    nazione: [null, Validators.required],
    note: [null],
    createdAt: [null, Validators.required],
    updatedAt: [null],
    deletedAt: [null],
  });


  ngOnInit(): void {
    if (localStorage.getItem("table_supplier") != null){
      this.columns = JSON.parse(localStorage.getItem("table_supplier")!) as Column[];
    }else{
      this.columns = [
        { name: "name", text: "Nome", visible: true },
        { name: "indirizzo", text: "Indirizzo", visible: true },
        { name: "email", text: "Email", visible: true },
        { name: "telefono", text: "Telefono", visible: true },
        { name: "nazione", text: "Nazione", visible: true },
        { name: "note", text: "Note", visible: true }
      ];
      localStorage.setItem("table_supplier", JSON.stringify(this.columns));
    }
    
    this.loadAllSuppliers();
  }

  loadAllSuppliers(): void{
    this.supplierService.getAll().subscribe((resp: Supplier[]) => {
      this.listaSuppliers = resp;
    })
  }

  isListEmpty(): boolean {
    if (this.listaSuppliers?.length == 0 || this.listaSuppliers == null) {
      return true;
    } else {
      return false;
    }
  }

  changeVisibility(column: Column): void {
    column.visible = !column.visible;
    localStorage.setItem("table_supplier", JSON.stringify(this.columns));
  }

  changeOrderBy(column: Column): void {
    if (this.sort.name == column.name){
      this.sort.orderBy = !this.sort.orderBy;
    } else{
      this.sort = {
        name: column.name,
        orderBy: true
      };
    }
    
    this.loadAllSuppliers();

  }

  typeForm(type: string, supplier: Supplier | null): void{
    if(type == "new"){
      this.new = true;
      this.formNewEditSupplier.reset();
    }else{
      this.new = false;
      this.selectedSupplier = supplier;
      this.formNewEditSupplier.patchValue({
        id: this.selectedSupplier?.id,
        name: this.selectedSupplier?.name,
        indirizzo: this.selectedSupplier?.indirizzo,
        telefono: this.selectedSupplier?.telefono,
        email: this.selectedSupplier?.email,
        nazione: this.selectedSupplier?.nazione,
        note: this.selectedSupplier?.note,
        createdAt: this.selectedSupplier?.createAt,
        updatedAt: this.selectedSupplier?.updateAt,
        deletedAt: this.selectedSupplier?.deletedAt,
      })
    }
  }

  createorupdate(): void{
    console.log(this.formNewEditSupplier.value);
  }

  openDeleteModal(supplier: Supplier):void{
    this.selectedSupplier = supplier;
  }

  deleteSupplier(id: number): void{
    console.log(id);
  }

  


}
