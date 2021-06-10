import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ItemsRoutingModule } from './items-routing.module';
import { ItemsComponent } from './items.component';
import { NewEditItemComponent } from './new-edit-item/new-edit-item.component';


@NgModule({
  declarations: [
    ItemsComponent,
    NewEditItemComponent
  ],
  imports: [
    CommonModule,
    ItemsRoutingModule
  ]
})
export class ItemsModule { }
