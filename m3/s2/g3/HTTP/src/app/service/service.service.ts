import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Products } from '../models/products';

@Injectable({
  providedIn: 'root',
})
export class ServiceService {
  apiUrl: string = 'https://dummyjson.com/products';

  constructor(private http: HttpClient) {}

  getAllProducts() {
    return this.http.get<Products[]>(this.apiUrl);
  }
}
