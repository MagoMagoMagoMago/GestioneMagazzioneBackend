import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { PurchasesRoutingModule } from './purchases-routing.module';
import { PurchasesComponent } from './purchases.component';


@NgModule({
  declarations: [
    PurchasesComponent
  ],
  imports: [
    CommonModule,
    PurchasesRoutingModule,
    FormsModule, 
    ReactiveFormsModule
  ]
})
export class PurchasesModule { }
