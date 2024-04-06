function updateCounter() {
  let counterElement = document.getElementById("counter");
  let startTime = sessionStorage.getItem("startTime");
  if (!startTime) {
    startTime = Date.now();
    sessionStorage.setItem("startTime", startTime);
  } else {
    startTime = parseInt(startTime);
  }
  let elapsedTime = Math.floor((Date.now() - startTime) / 1000);
  counterElement.textContent = "Tempo trascorso: " + elapsedTime + " secondi";
}
setInterval(updateCounter, 1000);
updateCounter();
