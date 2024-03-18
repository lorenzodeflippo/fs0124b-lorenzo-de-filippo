interface Smartphone {
  credito: number;
  numeroChiamate: number;

  ricarica(ammontare: number): void;
  chiamata(durataMinuti: number): void;
  get numero404(): number;
  get getNumeroChiamate(): number;
  azzeraChiamate(): void;
}
class User implements Smartphone {
  name: string;
  lastName: string;
  credito: number = 0;
  numeroChiamate: number = 0;
  constructor(name: string, lastName: string) {
    this.name = name;
    this.lastName = lastName;
  }
  ricarica(ammontare: number): void {
    this.credito += ammontare;
  }
  chiamata(durataMinuti: number): void {
    this.credito -= durataMinuti * 0.2;
    this.numeroChiamate += 1;
  }
  azzeraChiamate(): void {
    this.numeroChiamate = 0;
  }
  get numero404() {
    return this.credito;
  }
  get getNumeroChiamate() {
    return this.numeroChiamate;
  }
}

const me = new User("lorenzo", "de Filippo");
me.ricarica(10);
me.chiamata(1);
me.chiamata(2);
me.chiamata(3);
me.chiamata(4);
console.log(me.numero404);
console.log(me.getNumeroChiamate);
me.azzeraChiamate();
