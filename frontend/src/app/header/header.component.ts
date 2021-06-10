import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {


  constructor() { }

  ngOnInit(): void {
  }

  onHover(event: any): void {
    event.target.className = String(event.target.className).replace('text-white', 'text-info');
  }

  removeHover(event: any): void {
    event.target.className = String(event.target.className).replace('text-info', 'text-white');
  }
}
