import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Route } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home/home.component';
import { NavbarComponent } from './components/navbar/navbar/navbar.component';
import { FiatComponent } from './components/fiat/fiat/fiat.component';
import { FordComponent } from './components/ford/ford/ford.component';
import { AudiComponent } from './components/audi/audi/audi.component';
import { FooterComponent } from './components/footer/footer/footer.component';

const routes: Route[] = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'fiat',
    component: FiatComponent,
  },
  {
    path: 'ford',
    component: FordComponent,
  },
  {
    path: 'audi',
    component: AudiComponent,
  },
  {
    path: '**',
    redirectTo: '',
  },
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    FiatComponent,
    FordComponent,
    AudiComponent,
    FooterComponent,
  ],
  imports: [BrowserModule, RouterModule.forRoot(routes)],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
