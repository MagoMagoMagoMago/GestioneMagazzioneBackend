import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { ItemsRoutingModule } from './items-routing.module';
import { ItemsComponent } from './items.component';
import { TableModule } from "primeng/table";
import { ButtonModule } from "primeng/button";

@NgModule({
  declarations: [
    ItemsComponent
  ],
  imports: [
    CommonModule,
    ItemsRoutingModule, 
    ReactiveFormsModule, 
    FormsModule,
    TableModule, 
    ButtonModule
  ]
})
export class ItemsModule { }
