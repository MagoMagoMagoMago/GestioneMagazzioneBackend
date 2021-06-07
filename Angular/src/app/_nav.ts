import { INavData } from '@coreui/angular';

export const navItems: INavData[] = [
  {
    name: 'Statistiche',
    url: '/dashboard',
    icon: 'icon-chart',
    children: [
      {
        name: 'Grafici',
        url: '/charts',
        icon: 'icon-pie-chart'
      }
    ]
  },
  {
    name: 'Articoli',
    url: '/base',
    icon: 'icon-list'
  }
];
