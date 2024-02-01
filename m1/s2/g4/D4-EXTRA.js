// Esercizi aggiuntivi (facoltativi) per D4

/* EXTRA 1
 Scrivi una funzione chiamata "checkArray" che riceve un array di numeri casuali (creati con la funzione "giveMeRandom") e per ogni elemento stampa in console
 se il suo valore è maggiore di 5 o no.
 La funzione deve inoltre ritornare la somma di tutti i valori maggiori di 5.
*/

function givemeRandom() {
  return Math.floor(Math.random() * 10) + 1;
}
function checkArray(numbers) {
  let maggioriDi5 = 0;
  for (let i = 0; i < numbers.length; i++) {
    console.log(
      numbers[i] > 5
        ? `${numbers[i]} è maggiore di 5`
        : `${numbers[i]} non è maggiore di 5`
    );
    if (numbers[i] > 5) {
      maggioriDi5 += numbers[i];
    }
  }
  return maggioriDi5;
}
const randomNumbers = [
  givemeRandom(),
  givemeRandom(),
  givemeRandom(),
  givemeRandom(),
  givemeRandom(),
];
const resultSum = checkArray(randomNumbers);
console.log("Totale dei coefficienti maggiori di 5:", resultSum);

/* EXTRA 2
 Nel tuo eCommerce disponi di un'array di oggetti chiamato "shoppingCart". Ognuno di questi oggetti ha le seguenti proprietà: "price", "name", "id" e "quantity".
 Crea una funzione chiamata "shoppingCartTotal" che calcola il totale dovuto al negozio (tenendo conto delle quantità di ogni oggetto).
*/

let shoppingCart = [
  { id: 1, name: "Prodotto 1", price: 119.99, quantity: 3 },
  { id: 2, name: "Prodotto 2", price: 79.99, quantity: 1 },
];
function shoppingCartTotal(cart) {
  let totale = 0;
  for (let i = 0; i < cart.length; i++) {
    totale += cart[i].price * cart[i].quantity;
  }
  return totale;
}
let totalAmount = shoppingCartTotal(shoppingCart);
console.log("Totale del carrello:", totalAmount.toFixed(2));

/* EXTRA 3
 Nel tuo eCommerce disponi di un'array di oggetti chiamato "shoppingCart". Ognuno di questi oggetti ha le seguenti proprietà: "price", "name", "id" e "quantity".
 Crea una funzione chiamata "addToShoppingCart" che riceve un nuovo oggetto dello stesso tipo, lo aggiunge a "shoppingCart" e ritorna il nuovo numero totale degli elementi.
*/

let shoppingCart3 = [];
function addToShoppingCart3(newItem) {
  shoppingCart3.push(newItem);
  let totalItems = shoppingCart3.reduce(
    (total, item) => total + item.quantity,
    0
  );
  return totalItems;
}
let newItem = {
  price: 99.99,
  name: "Console",
  id: 123340567987,
  quantity: 1,
};
let totalItemsAfterAddition = addToShoppingCart3(newItem);
console.log("Carrello aggiornato:", totalItemsAfterAddition);
console.log("Contenuto del carrello:", shoppingCart3);

/* EXTRA 4
 Nel tuo eCommerce disponi di un'array di oggetti chiamato "shoppingCart". Ognuno di questi oggetti ha le seguenti proprietà: "price", "name", "id" e "quantity".
 Crea una funzione chiamata "maxShoppingCart" che riceve l'array "shoppingCart" e ritorna l'oggetto più costoso in esso contenuto.
*/

function maxShoppingCart(shoppingCart4) {
  if (shoppingCart4.length === 0) {
    return null;
  }
  let maxItem = shoppingCart4[0];
  for (let i = 1; i < shoppingCart4.length; i++) {
    if (shoppingCart4[i].price > maxItem.price) {
      maxItem = shoppingCart4[i];
    }
  }
  return maxItem;
}
const shoppingCart4 = [
  { id: 1, name: "Prodotto 1", price: 20, quantity: 3 },
  { id: 2, name: "Prodotto 2", price: 40, quantity: 2 },
  { id: 3, name: "Prodotto 3", price: 60, quantity: 1 },
];
const maxItemInCart = maxShoppingCart(shoppingCart4);
console.log("Prodott più costoso:", maxItemInCart);

/* EXTRA 5
 Nel tuo eCommerce disponi di un'array di oggetti chiamato "shoppingCart". Ognuno di questi oggetti ha le seguenti proprietà: "price", "name", "id" e "quantity".
 Crea una funzione chiamata "latestShoppingCart" che riceve l'array "shoppingCart" e ritorna l'ultimo elemento.
*/

function latestShoppingCart(shoppingCart5) {
  if (shoppingCart5.length === 0) {
    return null;
  }
  return shoppingCart5[shoppingCart5.length - 1];
}
const shoppingCart5 = [
  { price: 10, name: "Prodotto 1", id: 0o1, quantity: 3 },
  { price: 20, name: "Prodotto 2", id: 0o2, quantity: 2 },
  { price: 15, name: "Prodotto 3", id: 0o3, quantity: 1 },
];
const latestItem = latestShoppingCart(shoppingCart5);
console.log(latestItem);

/* EXTRA 6
 Crea una funzione chiamata "loopUntil" che riceve un numero intero come parametro con valore tra 0 e 9.
 La funzione è composta da un ciclo che stampa un numero casuale tra 0 e 9 finchè il numero casuale non è maggiore di x per tre volte di fila.
*/

/* SCRIVI QUI LA TUA RISPOSTA */

/* EXTRA 7
Crea una funzione chiamata "average" che riceve un array come parametro e ne ritorna la media aritmetica. La funzione salta automaticamente i valori non numerici nell'array.
*/

/* SCRIVI QUI LA TUA RISPOSTA */

/* EXTRA 8
 Crea una funzione chiamata "longest" che trova la stringa più lunga all'interno di un array di stringhe fornito come parametro.
*/

/* SCRIVI QUI LA TUA RISPOSTA */

/* EXTRA 9
 Crea una funzione per creare un filtro anti-spam per la tua casella email. La funzione riceve un parametro stringa chiamato "emailContent", e torna un valore booleano.
 La funzione deve ritornare true se "emailContent" non contiene le parole "SPAM" o "SCAM".
*/

/* SCRIVI QUI LA TUA RISPOSTA */

/* EXTRA 10
 Scrivi una funzione che riceve una data come parametro, e calcola il numero di giorni passati da quella data.
*/

/* SCRIVI QUI LA TUA RISPOSTA */

/* EXTRA 11
 Scrivi una funzione chiamata "matrixGenerator" che riceve come parametri due numeri interi, "x" e "y".
 Il risultato deve essere una matrice di "x" volte "y", e i valori devono rispecchiare gli indici della posizione all'interno della matrice.
 Es.: x = 3, y = 2
 ["00","01","02"
 "10","11","12"]
*/

/* SCRIVI QUI LA TUA RISPOSTA */
