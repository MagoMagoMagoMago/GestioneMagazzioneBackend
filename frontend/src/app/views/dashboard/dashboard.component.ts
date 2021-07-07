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
    { data: [], label: 'Articoli' },
  ];
  public lineChartData2: ChartDataSets[] = [
    { data: [], label: 'Articoli' },
  ];
  public lineChartLabels: Label[] = [];
  public lineChartLabels2: Label[] = [];
  public lineChartOptions: ChartOptions = {
    responsive: true,
    scales: {
      yAxes: [
        {
          ticks: {
            beginAtZero: true
          }
        }
      ]
    }
  };
  public lineChartColors: Color[] = [
    {
      borderColor: 'black',
      borderWidth: 0,
      hoverBorderWidth: 1,
      backgroundColor: 'rgba(255,100,0,0.3)',
    },
  ];
  public lineChartLegend = false;
  public lineChartType = "bar" as ChartType;
  public lineChartPlugins = [];

  public articoli!: Item[];

  dataInizio1 = moment(new Date()).add(-1, "week").format("YYYY-MM-DD");
  dataFine1 = moment(new Date()).format("YYYY-MM-DD");
  articoloSelezionato = "null";
  quantita = 0;
  ricavi = 0;


  dataInizio2 = moment(new Date()).add(-1, "week").format("YYYY-MM-DD");
  dataFine2 = moment(new Date()).format("YYYY-MM-DD");

  dataInizio3 = moment(new Date()).add(-1, "week").format("YYYY-MM-DD");
  dataFine3 = moment(new Date()).format("YYYY-MM-DD");

  constructor(
    private chartService: ChartApiService,
    private itemService: ItemApiService
  ) { }

  ngOnInit() {
    this.itemService.getAll("title", true, 0, 20).subscribe(
      (success) => {
        this.articoli = success.list;
      }
    );

    this.filter1();
    this.filter2();
    this.filter3();

  }

  filter1(): void {
    if (this.articoloSelezionato == "null") {
      this.chartService.chartTotalOrderItems(this.dataInizio1.toString(), this.dataFine1.toString()).subscribe(
        (success: ChartOne) => {
          this.quantita = success.quantita;
          this.ricavi = success.ricavi;
        },
        (err) => { console.log(err) }
      );
    } else {
      this.chartService.chartTotalOrderItemsByAsin(this.dataInizio1.toString(), this.dataFine1.toString(), this.articoloSelezionato).subscribe(
        (success: ChartOne) => {
          this.quantita = success.quantita;
          this.ricavi = success.ricavi;
        },
        (err) => { console.log(err) }
      );
    }
  }

  filter2(): void {
    this.chartService.istogrammaArticoli(this.dataInizio2, this.dataFine2).subscribe(
      (success) => {
        this.lineChartData[0].data = [];
        this.lineChartLabels = [];
        
        success.map((x: { ricavi: number, quantita: number, asin: string }) => {
          this.lineChartData[0].data!.push(x.quantita);
          this.lineChartData[0].backgroundColor =["#EBEA74", "#F09756", "#D259D9", "#5697F0", "#53E66E"];
          const label: Label = x.asin;
          this.lineChartLabels.push(label);
        })
      },
      (error) => {
        alert("errore");
      }
    )
  }

  filter3(): void {
    this.chartService.istogrammaArticoli(this.dataInizio3, this.dataFine3).subscribe(
      (success) => {
        this.lineChartData2[0].data = [];
        this.lineChartLabels2 = [];
        
        success.map((x: { ricavi: number, quantita: number, asin: string }) => {
          this.lineChartData2[0].data!.push(x.ricavi);
          this.lineChartData2[0].backgroundColor =["#EBEA74", "#F09756", "#D259D9", "#5697F0", "#53E66E"];
          const label: Label = x.asin;
          this.lineChartLabels2.push(label);
        })
      },
      (error) => {
        alert("errore");
      }
    )
  }

}
