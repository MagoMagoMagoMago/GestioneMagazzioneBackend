import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login/login.service';
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
      link:"home",
      visible: true
    }
  ]
  constructor(public loginService: LoginService) { }

  ngOnInit(): void {
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
