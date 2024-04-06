/*
REGOLE
- Tutte le risposte devono essere scritte in JavaScript
- Puoi usare Google / StackOverflow ma solo quanto ritieni di aver bisogno di qualcosa che non è stato spiegato a lezione
- Puoi testare il tuo codice in un file separato, o de-commentando un esercizio alla volta
- Per visualizzare l'output, lancia il file HTML a cui è collegato e apri la console dagli strumenti di sviluppo del browser. 
- Utilizza dei console.log() per testare le tue variabili e/o i risultati delle espressioni che stai creando.
*/

/* ESERCIZIO 1
 Elenca e descrivi i principali datatype in JavaScript. Prova a spiegarli come se volessi farli comprendere a un bambino.
*/

/* 1. Le STRINGHE sono le classiche 'parole' detto in gergo. Sono un insieme di lettere o parole che si usano per formare una frase.
   2. I NUMERI sono dei valori che possiamo sommare, sottrarre, moltiplicare o dividere e creare ciò di cui abbiamo bisogno.
   3, I BOOLEANI sono come un'interruttore, può essere solamente o acceso o spento: vero (acceso) o falso (spento).
      Sono molto utili quando vogliamo o dobbiamo fare delle scelte.
*/

/* ESERCIZIO 2
 Crea una variable chiamata "myName" e assegna ad essa il tuo nome, sotto forma di stringa.
*/

let mioNome = "Lorenzo";
console.log(mioNome);

/* ESERCIZIO 3
 Scrivi il codice necessario ad effettuare un addizione (una somma) dei numeri 12 e 20.
*/

console.log(12 + 20);

/* ESERCIZIO 4
 Crea una variable di nome "x" e assegna ad essa il numero 12.
*/

let x = 12;

/* ESERCIZIO 5
  Riassegna un nuovo valore alla variabile "myName" già esistente: il tuo cognome.
  Dimostra l'impossibilità di riassegnare un valore ad una variabile dichiarata con il costrutto const.
*/

mioNome = "de Filippo";

/* Se non c'è la variabile 'const' allora possiamo cambiare il valore del 'mioNome' quante volte vogliamo.
Se il 'mioNme' ha una constante all'interno, es.  mioConstNome, allora la console mi genererà un errore, questo perchè
variabili dichiarate con 'const' sono considerate COSTANTI cio significa che non possono essere riassegnate:
es. mioConstNome= 'de Filippo'
 */

/* ESERCIZIO 6
 Esegui una sottrazione tra i numeri 4 e la variable "x" appena dichiarata (che contiene il numero 12).
*/

console.log(4 - x);

/* ESERCIZIO 7
 Crea due variabili: "name1" e "name2". Assegna a name1 la stringa "john", e assegna a name2 la stringa "John" (con la J maiuscola!).
 Verifica che name1 sia diversa da name2 (suggerimento: è la stessa cosa di verificare che la loro uguaglianza sia falsa).
 EXTRA: verifica che la loro uguaglianza diventi true se entrambe vengono trasformate in lowercase (senza cambiare il valore di name2!).
*/

let name1 = "john";
let name2 = "John";
if (name1 !== name2) {
  console.log("name1 è diverso da name2");
} else {
  console.log("name1 è uguale a name2");
}

if (name1.toLowerCase() === name2.toLowerCase()) {
  console.log("Dopo la conversione in minuscolo, name1 è uguale a name2");
} else {
  console.log("Dopo la conversione in minuscolo, name1 non è uguale a name2");
}
