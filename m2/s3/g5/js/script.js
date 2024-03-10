window.onload = () => {
  const name = document.getElementById("name");
  console.log(name);
  const description = document.getElementById("description");
  console.log(description);
  const urlProduct = document.getElementById("url");
  console.log(urlProduct);
  const price = document.getElementById("price");
  console.log(price);
  const brand = document.getElementById("brand");
  console.log(brand);
  const newProductBtn = document.getElementById("newProductBtn");
  console.log(newProductBtn);
  const modBtn = document.getElementById("modBtn");
  console.log(modBtn);
  const deleteBtn = document.getElementById("deleteBtn");
  console.log(deleteBtn);
  const resetBtn = document.getElementById("resetBtn");
  console.log(resetBtn);

  const params = new URLSearchParams(window.location.search).get("id");
  console.log(params);
  const url = "https://striveschool-api.herokuapp.com/api/product/";

  if (params) {
    fillForm(url, params);
    modBtn.classList.remove("d-none");
    deleteBtn.classList.remove("d-none");
  } else {
    newProductBtn.classList.add("d-none");
  }

  newProductBtn.addEventListener("click", (event) => {
    postFetch(
      url,
      {
        name: name.value,
        description: description.value,
        imageUrl: urlProduct.value,
        price: parseFloat(price.value),
        brand: brand.value,
      },
      event
    );
  });

  modBtn.addEventListener("click", (event) => {
    putFetch(
      url,
      params,
      {
        name: name.value,
        description: description.value,
        imageUrl: urlProduct.value,
        price: parseFloat(price.value),
        brand: brand.value,
      },
      event
    );
  });

  deleteBtn.addEventListener("click", (event) => {
    deleteFetch(url, params, event);
  });
};

const fillForm = function (url, params, _event) {
  fetch(url + params, {
    method: "GET",
    headers: {
      Authorization:
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZGY5NzJkN2IxMTAwMTkwZTZlMmQiLCJpYXQiOjE3MDk4OTE0ODAsImV4cCI6MTcxMTEwMTA4MH0.r2AKIWHtejS0hjkESzw6_Jqbq8Wv6TpW6QEgVYO2Eb4",
      "Content-Type": "application/json",
    },
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("Errore nella richiesta HTTP: " + response.status);
      }
      return response.json();
    })

    .then((data) => {
      console.log(data);

      const { name, description, imageUrl, price, brand } = obj;

      document.getElementById("name").value = name;
      document.getElementById("description").value = description;
      document.getElementById("url").value = imageUrl;
      document.getElementById("price").value = price;
      document.getElementById("brand").value = brand;
    })

    .catch((error) => {
      console.error("Errore:", error);
    });
};

const putFetch = function (url, params, newProduct, event) {
  event.preventDefault();
  console.log("PUT fetch");
  fetch(url + params, {
    method: "PUT",
    body: JSON.stringify(newProduct),
    headers: {
      Authorization:
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZGY5NzJkN2IxMTAwMTkwZTZlMmQiLCJpYXQiOjE3MDk4OTE0ODAsImV4cCI6MTcxMTEwMTA4MH0.r2AKIWHtejS0hjkESzw6_Jqbq8Wv6TpW6QEgVYO2Eb4",
      "Content-Type": "application/json",
    },
  })
    .then((createdObj) => {
      console.log(createdObj);
      document.getElementById("name").value = "";
      document.getElementById("description").value = "";
      document.getElementById("url").value = "";
      document.getElementById("price").value = "";
      document.getElementById("brand").value = "";
      const allertBlue = document.getElementById("allert-yellow");
      allertBlue.classList.remove("d-none");
      setTimeout(function () {
        allertBlue.classList.add("d-none");
      }, 2000);
    })
    .catch((error) => console.log(error));
};

const postFetch = function (url, newProduct, event) {
  event.preventDefault();
  console.log("POST fetch");
  fetch(url, {
    method: "POST",
    body: JSON.stringify(newProduct),
    headers: {
      Authorization:
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZGY5NzJkN2IxMTAwMTkwZTZlMmQiLCJpYXQiOjE3MDk4OTE0ODAsImV4cCI6MTcxMTEwMTA4MH0.r2AKIWHtejS0hjkESzw6_Jqbq8Wv6TpW6QEgVYO2Eb4",
      "Content-Type": "application/json",
    },
  })
    .then((createdObj) => {
      console.log(createdObj);
      const allertYellow = document.getElementById("allert-blue");
      allertYellow.classList.remove("d-none");
      setTimeout(function () {
        allertYellow.classList.add("d-none");
      }, 2000);
    })

    .catch((error) => console.log(error));
};

const deleteFetch = function (url, _id, _event) {
  console.log("PUT fetch");
  fetch(url + _id, {
    method: "DELETE",
    headers: {
      Authorization:
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZGY5NzJkN2IxMTAwMTkwZTZlMmQiLCJpYXQiOjE3MDk4OTE0ODAsImV4cCI6MTcxMTEwMTA4MH0.r2AKIWHtejS0hjkESzw6_Jqbq8Wv6TpW6QEgVYO2Eb4",
      "Content-Type": "application/json",
    },
  })
    .then((createdObj) => {
      console.log(createdObj);
      document.getElementById("name").value = "";
      document.getElementById("description").value = "";
      document.getElementById("url").value = "";
      document.getElementById("price").value = "";
      document.getElementById("brand").value = "";
      const allertRed = document.getElementById("red-allert");
      allertRed.classList.remove("d-none");
      setTimeout(function () {
        allertRed.classList.add("d-none");
      }, 2000);
    })

    .catch((error) => console.log(error));
};
