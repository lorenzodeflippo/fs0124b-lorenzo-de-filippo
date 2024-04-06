function saveName() {
  let name = document.getElementById("nameInput").value;
  if (typeof name === "string" && name.trim() !== "") {
    localStorage.setItem("userName", name);
    document.getElementById("savedName").innerText = "Nome salvato: " + name;
  } else {
    alert("Inserisci un nome valido.");
  }
}

function clearName() {
  localStorage.removeItem("userName").value;
  document.getElementById("nameInput").value = "";
  document.getElementById("savedName").innerText = "";
}

window.onload = function () {
  let savedName = localStorage.getItem("userName");
  if (savedName) {
    document.getElementById("savedName").innerText =
      "Nome salvato: " + savedName;
  }
};
