import { Component, OnInit } from '@angular/core';
import { ChartDataSets, ChartOptions, ChartType } from 'chart.js';
import * as moment from 'moment';
import { Color, Label } from 'ng2-charts';
import { ChartApiService } from 'src/app/api/chart-api.service';
import { ItemApiService } from 'src/app/api/item-api.service';
import { ChartOne } from 'src/app/models/chartDto';
import { Item } from 'src/app/models/item';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  chartone!: ChartOne[];
  public lineChartData: ChartDataSets[] = [
    { data: [65, 59, 80, 81, 56, 55, 40], label: 'Series A' },
  ];
  public lineChartLabels: Label[] = ['January', 'February', 'March', 'April', 'May', 'June', 'July'];
  public lineChartOptions: ChartOptions = {
    responsive: true,
  };
  public lineChartColors: Color[] = [
    {
      borderColor: 'black',
      borderWidth: 1,
      hoverBorderWidth: 5,
      backgroundColor: 'rgba(255,0,0,0.3)',
    },
  ];
  public lineChartLegend = true;
  public lineChartType =  "bar" as ChartType;
  public lineChartPlugins = [];

  public articoli!: Item[];

  dataInizio1 = moment(new Date()).add(-1, "week").format("YYYY-MM-DD");
  dataFine1 = moment(new Date()).format("YYYY-MM-DD");
  articoloSelezionato = "-----------------------------TUTTI----------------------------";
  quantita = 0;
  ricavi = 0;

  constructor(
    private chartService: ChartApiService,
    private itemService: ItemApiService
    ) { }

  ngOnInit() {
    this.itemService.getAll("title", true,0,20).subscribe(
      (success)=>{
        this.articoli = success.list;
      }
      );
    this.filter1();
  }

  filter1(): void{
    this.chartService.chartTotalOrderItems(this.dataInizio1.toString(), this.dataFine1.toString()).subscribe(
      (success: ChartOne)=>{
        this.quantita = success.quantita;
        this.ricavi = success.ricavi;
      },
      (err)=>{console.log(err)}
    );
  }

}
