import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ItemsComponent } from './items.component';
import { NewEditItemComponent } from './new-edit-item/new-edit-item.component';

const routes: Routes = [
  { 
    path: '', 
    component: ItemsComponent,
  },
  {
    path: 'new-edit-item', 
    component: NewEditItemComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ItemsRoutingModule { }
