import { Component, OnInit } from '@angular/core';
import { SupplierApiService } from 'src/app/api/supplier-api.service';
import { Column } from 'src/app/models/columns';
import { Supplier } from 'src/app/models/supplier';

@Component({
  selector: 'app-suppliers',
  templateUrl: './suppliers.component.html',
  styleUrls: ['./suppliers.component.scss']
})
export class SuppliersComponent implements OnInit {

  constructor(private supplierService: SupplierApiService) { }

  public columns: Column[] = [
    { name: "name", text: "Nome", visible: true },
    { name: "indirizzo", text: "Indirizzo", visible: true },
    { name: "email", text: "Email", visible: true },
    { name: "telefono", text: "Telefono", visible: true },
    { name: "nazione", text: "Nazione", visible: true },
    { name: "note", text: "Note", visible: true }
  ];

  public listaSuppliers!: Supplier[] | null; 
  
  ngOnInit(): void {
    this.supplierService.getAll().subscribe((resp: Supplier[])=>{
      this.listaSuppliers = resp;
    })
  }

  isListEmpty(): boolean{
    if(this.listaSuppliers?.length == 0){
      return true;
    }else{
      return false;
    }
  }

}
