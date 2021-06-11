import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ErrorPageComponent } from './error-page/error-page.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {
    path: "",
    component: LoginComponent,
    data: {
      title: 'Login'
    }
  },
  { path: 'items', loadChildren: () => import('./items/items.module').then(m => m.ItemsModule) },
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
