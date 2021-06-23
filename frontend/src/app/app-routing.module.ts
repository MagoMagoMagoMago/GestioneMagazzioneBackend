import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErrorPageComponent } from './common/error-page/error-page.component';
import { ActivatedGuard } from './common/login/activated.guard';
import { AuthGuard } from './common/login/auth.guard';
import { LoginComponent } from './common/login/login.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/login' },
  {
    path: "login",
    component: LoginComponent,
    data: {
      title: 'Login'
    },
    canActivate: [AuthGuard]
  },
  {
    path: 'items',
    loadChildren: () => import('./views/items/items.module').then(m => m.ItemsModule),
    canActivate: [ActivatedGuard],
    canLoad: [ActivatedGuard]
  },
  {
    path: 'orders',
    loadChildren: () => import('./views/orders/orders.module').then(m => m.OrdersModule),
    canActivate: [ActivatedGuard],
    canLoad: [ActivatedGuard]
  },
  {
    path: 'purchases',
    loadChildren: () => import('./views/purchases/purchases.module').then(m => m.PurchasesModule),
    canActivate: [ActivatedGuard],
    canLoad: [ActivatedGuard]
  },
  {
    path: 'dashboard',
    loadChildren: () => import('./views/dashboard/dashboard.module').then(m => m.DashboardModule),
    canActivate: [ActivatedGuard],
    canLoad: [ActivatedGuard]
  },
  {
    path: 'suppliers',
    loadChildren: () => import('./views/suppliers/suppliers.module').then(m => m.SuppliersModule)
  },
  {
    path: "**",
    component: ErrorPageComponent,
    data: {
      title: 'Not Found'
    },
    canActivate: [ActivatedGuard],
    canLoad: [ActivatedGuard]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
