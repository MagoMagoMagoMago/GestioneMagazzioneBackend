import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { ButtonsModule } from 'ngx-bootstrap/buttons';
import { ArticoliRoutingModule } from './articoli-routing.module';
import { ArticoliComponent } from './articoli.component';

@NgModule({
  imports: [
    FormsModule,
    ArticoliRoutingModule,
    ButtonsModule.forRoot()
  ],
  declarations: [ ArticoliComponent ]
})
export class ArticoliModule { }
