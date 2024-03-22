import { Component } from '@angular/core';
import { Auto } from 'src/app/models/auto.interface';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent {
  autos!: Auto[];
  randomAuto: Auto[] = [];
  brands!: string[];

  ngOnInit(): void {
    this.getAutos();
  }

  async getAutos() {
    const res = await fetch('../../assets/db.json');
    const response = await res.json();
    this.autos = response;
    console.log(this.autos);
    this.brands = this.getBrands();
    this.getRandomAutos(2);
  }

  getBrands(): string[] {
    const marchi: string[] = [];
    let marchio: string = '';
    for (let i = 0; i < this.autos.length; i++) {
      if (marchio != this.autos[i].brandLogo) {
        marchio = this.autos[i].brandLogo;
        marchi.push(this.autos[i].brandLogo);
      }
    }
    console.log(marchi);
    return marchi;
  }

  getRandomAutos(num: number) {
    const presenti: number[] = [];
    for (let i = 0; i < num; i++) {
      const indice = Math.floor(Math.random() * this.autos.length);
      if (presenti.includes(indice)) this.getRandomAutos(num - i);
      presenti.push(indice);
      this.randomAuto.push(this.autos[indice]);
    }
    console.log(this.randomAuto);
  }
}
