async function chiamata(query) {
  const apiKey = "wZvQUT2kmx0epk3xOIcedcT2KRwvSiEu4dUM9BnbP7Sle0yTCmEMa741";
  return await fetch(`https://api.pexels.com/v1/search?query=${query}`, {
    method: "GET",
    headers: {
      Authorization: "apiKey",
    },
  })
    .then((dati) => dati.json())
    .then((dati) =>
      dati.photos.forEach((photo) => {
        let imgBox = document.querySelector("img");
        imgBox.src = photo.url;
      })
    );
}
let loadBtn = document.querySelector("#loadBtn");
loadBtn.addEventListener("click", () => {
  chiamata("pizze");
});

chiamata("pizza").then((pizze) => {
  console.log(pizze);

  let img = generaClone();
  let image = img.querySelector(".card-img-top");
  img.src = pizze.photoimg;

  document.querySelector(".my-2").addEventListener("click", () => {});
});

function inserisciTesto(selettore, contenuto) {
  let titolo = colonna.querySelector(selettore);
  titolo.innerText = contenuto;
}

function generaClone() {
  let template = document.querySelector("#card-template");
  let clone = template.content.cloneNode(true);
  return clone;
}
