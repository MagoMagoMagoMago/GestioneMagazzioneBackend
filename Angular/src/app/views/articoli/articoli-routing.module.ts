import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ArticoliComponent } from './articoli.component';

const routes: Routes = [
  {
    path: '',
    component: ArticoliComponent,
    data: {
      title: 'Articoli'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ArticoliRoutingModule {}
