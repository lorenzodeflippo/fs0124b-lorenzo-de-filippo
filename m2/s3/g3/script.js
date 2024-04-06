fetch("https://striveschool-api.herokuapp.com/books")
  .then((response) => response.json())
  .then((dati) => {
    for (let libro of dati) {
      let colonna = document.createElement("div");
      colonna.classList.add("col-4");
      document.querySelector(".row").append(colonna);

      let cards = document.createElement("div");
      cards.classList.add("card");
      colonna.append(cards);

      let img = document.createElement("img");
      img.classList.add("card-img-top", "img-custom");
      img.src = libro.img;
      cards.appendChild(img);

      let card_body = document.createElement("div");
      card_body.classList.add("card-body");
      cards.appendChild(card_body);

      let card_title = document.createElement("h4");
      card_title.classList.add("card-title");
      card_title.textContent = libro.title;
      card_body.appendChild(card_title);

      let price = document.createElement("h5");
      price.classList.add("card-text", "text-danger");
      price.textContent = libro.price;
      card_body.appendChild(price);

      let btn = document.createElement("button");
      btn.classList.add("btn", "btn-success");
      btn.innerText = "Scarta";
      card_body.appendChild(btn);
    }
  })
  .catch((error) => console.error("Errore nel recupero dei dati:", error));
