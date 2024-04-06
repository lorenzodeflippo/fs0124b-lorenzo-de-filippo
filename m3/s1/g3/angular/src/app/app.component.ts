import { Component } from '@angular/core';
import { Books } from './models/books';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  title = 'fetch';

  booksArr: Books[] = [];

  ngOnInit() {
    fetch('../assets/db.json')
      .then((books) => books.json())
      .then((book) => {
        this.booksArr = book.posts;
        this.generateRandomArray();
      });
  }

  generateRandomNumber() {
    let index: number = Math.floor(Math.random() * this.booksArr.length);
    return index;
  }

  randomArray: Books[] = [];

  generateRandomArray() {
    for (let i = 0; i < 4; i++) {
      this.randomArray.push(this.booksArr[this.generateRandomNumber()]);
    }
  }
}
