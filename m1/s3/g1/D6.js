/* ESERCIZIO 1
               Scrivi una funzione per cambiare il titolo della pagina in qualcos'altro
            */

const changeTitle = function (nuovoTitolo) {
  document.title = nuovoTitolo;
};
changeTitle("EPICODE");

/* ESERCIZIO 2
               Scrivi una funzione per aggiungere al titolo della pagina una classe "myHeading"
            */

const addClassToTitle = function (nomeClasse) {
  const titleElement = document.querySelector("title");
  titleElement.classList.add(nomeClasse);
};
addClasstoTitle("myHeading");

/* ESERCIZIO 3
               Scrivi una funzione che cambi il testo dei p figli di un div
              */

const changePcontent = function (divId, newText) {
  const divElement = document.getElementById(divId);

  if (divElement) {
    const paragrafi = divElement.getElementsByTagName("p");
    for (let i = 0; i < paragrafi.length; i++) {
      paragrafi[i].textContent = nuovoTesto;
    }
  }
};

/* ESERCIZIO 4
               Scrivi una funzione che cambi la proprietà href di ogni link (tranne quello nel footer) con il valore https://www.google.com
              */

const changeUrls = function () {
  const allLinksExeptFooter = document.querySelectorAll("a:not(#footer a)");
  allLinksExceptFooter.forEach(function (link) {
    link.href = "https://www.google.com";
  });
};
changeUrls();

/* ESERCIZIO 5
               Scrivi una funzione che aggiunga un nuovo elemento lista alla seconda lista non ordinata
            */

const addToTheSecond = function (newItemText) {
  const secondUl = document.querySelectorAll("ul")[1];
  const newItem = document.createElement("li");
  newItem.textContent = newItemText;
  secondUl.appendChild(newItem);
};
addToTheSecond("Nuovo Elemento");

/* ESERCIZIO 6
               Scrivi una funzione che aggiunga un paragrafo al primo div
            */

const addParagraph = function (NewParagraphText) {
  const firstDiv = document.querySelector("div");
  const newParagraph = document.createElement("p");
  newParagraph.textContent = newParagraphText;
  firstDiv.appendChild(newParagraph);
};
addParagraph("NuovoParagrafo");

/* ESERCIZIO 7
               Scrivi una funzione che faccia scomparire la prima lista non ordinata
            */

const hideFirstUl = function () {};
const firstUl = document.querySelector("ul");
if (firstUl) {
  firstUl.style.display = "none";
}
hideFirstUl();

/* ESERCIZIO 8
               Scrivi una funzione che renda verde il background di ogni lista non ordinata
              */

const paintItGreen = function () {
  const allUls = document.querySelectorAll("ul");
  allUls.forEach(function (ul) {
    ul.style.backgroundColor = "green";
  });
};
paintItGreen();

/* ESERCIZIO 9
               Scrivi una funzione che rimuova l'ultima lettera dall'h1 ogni volta che l'utente lo clicca
              */

const makeItClickable = function () {
  const h1Element = document.querySelector("h1");
  if (h1Element) {
    h1Element.addEventListener("click", function () {
      let currentText = h1Element.textContent;
      currentText = currentText.slice(0, -1);
      h1Element.textContent = currentText;
    });
  }
};
makeItClickable();

/* ESERCIZIO 10
               Crea una funzione che, al click sul footer, riveli l'URL del link interno come contenuto di un alert()
              */

const revealFooterLink = function () {
  const footerLink = footerElement.querySelector("a");
  if (footerLink) {
    const linkUrl = footerLink.href;
    alert("URL del link nel footer:" + linkUrl);
  }
};
revealFooterLink();

/* ESERCIZIO 11
               Crea una funzione che crei una tabella nell'elemento con id "tableArea".
               La tabella avrà 5 elementi e questa struttura: immagine, nome prodotto, quantità, prezzo
            */

const generateTable = function () {};

/* ESERCIZIO 12
               Crea una funzione che aggiunga una riga alla tabella precedentemente creata e fornisca i dati necessari come parametri
            */

const addRow = function () {};

/* ESERCIZIO 14
              Crea una funzione che nasconda le immagini della tabella quando eseguita
            */

const hideAllImages = function () {};

/* EXTRA ESERCIZIO 15
              Crea una funzione che cambi il colore del h2 con id "changeMyColor" con un colore random ad ogni click ricevuto
            */
const changeColorWithRandom = function () {
  const h2Element = document.getElementById("changeMyColor");
};
if (h2Element) {
  h2Element.addEventListener("click", function () {
    const randomColor = getRandomColor();
    h2Element.style.color = randomColor;
  });
}
const getRandomColor = function () {
  const letters = "0123456789ABCDEF";
  let color = "#";
  for (let i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
};
changeColorWithRandom();
