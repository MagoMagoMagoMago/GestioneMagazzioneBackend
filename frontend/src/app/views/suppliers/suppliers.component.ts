import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { SupplierApiService } from 'src/app/api/supplier-api.service';
import { Column } from 'src/app/models/columns';
import { Supplier, SupplierInsert, SupplierUpdate } from 'src/app/models/supplier';

@Component({
  selector: 'app-suppliers',
  templateUrl: './suppliers.component.html',
  styleUrls: ['./suppliers.component.scss']
})
export class SuppliersComponent implements OnInit {

  @ViewChild('myModalClose') modalClose: any;

  constructor(
    private supplierService: SupplierApiService,
    public fb: FormBuilder,
    private toast: ToastrService
    ) { }

  public columns!: Column[];

  public listaSuppliers!: Supplier[] | null;
  //paginazione
  public sort = { name: "name", orderBy: true};
  public order = "name";

  public new!: boolean | null;
  public selectedSupplier!: Supplier | null;

  public submitted: boolean = false;

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
    this.supplierService.getAll(this.sort.name, this.sort.orderBy).subscribe((resp: Supplier[]) => {
      this.listaSuppliers = resp;
    })
  }
  
  // Getter method to access formcontrols
  get myForm() {
    return this.formNewEditSupplier.controls;
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
    this.submitted = false;
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
    this.submitted = true;
    if (!this.formNewEditSupplier.valid) {
      return;
    }
    if (this.new) {
      const supplierTemp: SupplierInsert = {
        name: this.formNewEditSupplier.controls['name'].value,
        indirizzo: this.formNewEditSupplier.controls['indirizzo'].value,
        telefono: this.formNewEditSupplier.controls['telefono'].value,
        email: this.formNewEditSupplier.controls['email'].value,
        nazione: this.formNewEditSupplier.controls['nazione'].value,
        note: this.formNewEditSupplier.controls['note'].value
  
      }
      this.supplierService.insert(supplierTemp).subscribe(
        (success)=>{
          this.toast.success("Fornitore inserito correttamente!", "Fornitore");
          this.modalClose.nativeElement.click();
          this.loadAllSuppliers();
        },
        (err)=>{
          this.toast.error("Errore nella creazione del fornitore.", "Fornitore");
        }
      );
    }else{
      const supplierTemp: SupplierUpdate = {
        id: this.formNewEditSupplier.controls['id'].value,
        name: this.formNewEditSupplier.controls['name'].value,
        indirizzo: this.formNewEditSupplier.controls['indirizzo'].value,
        telefono: this.formNewEditSupplier.controls['telefono'].value,
        email: this.formNewEditSupplier.controls['email'].value,
        nazione: this.formNewEditSupplier.controls['nazione'].value,
        note: this.formNewEditSupplier.controls['note'].value
  
      }
      this.supplierService.update(supplierTemp).subscribe(
        (success)=>{
          this.toast.success("Fornitore modificato correttamente!", "Fornitore");
          this.modalClose.nativeElement.click();
          this.loadAllSuppliers();
        },
        (err)=>{
          this.toast.error("Errore nella modifica del fornitore.", "Fornitore");
        }
      );
    }
    
  }

  openDeleteModal(supplier: Supplier):void{
    this.selectedSupplier = supplier;
  }

  deleteSupplier(id: number): void{
    this.supplierService.delete(id).subscribe(
      (success)=>{
        this.toast.success("Fornitore eliminato con successo", "Eliminazione");
        this.loadAllSuppliers();
      },
      (error)=>{
        this.toast.error("Questo fornitore non può essere eliminato", "Eliminazione")
      }
    )
  }

  


}
