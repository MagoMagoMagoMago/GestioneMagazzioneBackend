import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../login/auth.service';
import { Navbar } from './navbar';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  visible!: boolean;

  public navbar: Navbar[] = [
    {
      title: "Dashboard ",
      icon: "bootstrap-icons.svg#speedometer2",
      hover: false,
      link: "dashboard",
      visible: true
    },
    {
      title: "Ordini",
      icon: "bootstrap-icons.svg#table",
      hover: false,
      link: "orders",
      visible: true
    },
    {
      title: "Articoli",
      icon: "bootstrap-icons.svg#grid",
      hover: false,
      link: "items",
      visible: true
    },
    {
      title: "Acquisti",
      icon: "bootstrap-icons.svg#bag",
      hover:false,
      link:"purchases",
      visible: true
    },
    {
      title: "Fornitori",
      icon: "bootstrap-icons.svg#people",
      hover:false,
      link:"suppliers",
      visible: true
    }
  ]
  constructor(
    public authService: AuthService,
    public router: Router) { }

  ngOnInit(): void {
  }

  logout(): void{
    this.authService.logout().subscribe( () =>{
      this.router.navigate(['']);
    });
  }

  onHover(item: Navbar): void {
    // event.target.className = String(event.target.className).replace('text-white', 'text-warning');
    item.hover = true;
  }

  removeHover(item: Navbar): void {
    // event.target.className = String(event.target.className).replace('text-warning', 'text-white');
    item.hover = false;
  }
}
