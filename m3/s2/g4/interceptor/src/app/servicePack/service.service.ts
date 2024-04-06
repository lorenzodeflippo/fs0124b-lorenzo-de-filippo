import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Interface } from '../models/interface';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ServiceService {
  getAllFoto() {
    throw new Error('Method not implemented.');
  }
  apiUrl: string = 'https://jsonplaceholder.typicode.com/photos';

  arrayFoto: Interface[] = [];

  interfaceSubject = new Subject<Interface[]>();

  constructor(private http: HttpClient) {
    this.getAllInterface().subscribe();
  }

  getAllInterface() {
    return this.http.get<Interface[]>(this.apiUrl);
  }
}
