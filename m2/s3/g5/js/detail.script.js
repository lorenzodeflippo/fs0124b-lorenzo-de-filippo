const params = new URLSearchParams(window.location.search).get("id");
console.log(params);

window.onload = () => {
  fetch("https://striveschool-api.herokuapp.com/api/product/" + params, {
    headers: {
      Authorization:
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZGY5NzJkN2IxMTAwMTkwZTZlMmQiLCJpYXQiOjE3MDk4OTE0ODAsImV4cCI6MTcxMTEwMTA4MH0.r2AKIWHtejS0hjkESzw6_Jqbq8Wv6TpW6QEgVYO2Eb4",
      "Content-Type": "application/json",
    },
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("Errore nella richiesta di rete");
      }
      return response.json();
    })
    .then((data) => {
      console.log(data);
      const main = document.querySelector("main");

      const { name, imageUrl, description } = data;
    })
    .catch((error) => {
      console.error("Si è verificato un errore:", error);
    });
};
