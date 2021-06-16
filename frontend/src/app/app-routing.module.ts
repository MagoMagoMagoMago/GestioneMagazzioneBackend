import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErrorPageComponent } from './common/error-page/error-page.component';
import { LoginComponent } from './common/login/login.component';

const routes: Routes = [
  {
    path: "",
    component: LoginComponent,
    data: {
      title: 'Login'
    }
  },
  { path: 'items', loadChildren: () => import('./views/items/items.module').then(m => m.ItemsModule) },
  { path: 'orders', loadChildren: () => import('./views/orders/orders.module').then(m => m.OrdersModule) },
  { path: 'purchases', loadChildren: () => import('./views/purchases/purchases.module').then(m => m.PurchasesModule) },
  {
    path: "**",
    component: ErrorPageComponent,
    data: {
      title: 'Not Found'
    }
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
