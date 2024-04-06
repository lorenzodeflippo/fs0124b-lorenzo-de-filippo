class Pet {
  constructor(petName, ownerName, species, breed) {
    this.petName = petName;
    this.ownerName = ownerName;
    this.species = species;
    this.breed = breed;
  }

  sameOwner(anotherPet) {
    if (this.ownerName === anotherPet.ownerName) {
      return true;
    } else {
      return false;
    }
  }
}

let petName = document.getElementById("petName");
let ownerName = document.getElementById("ownerName");
let species = document.getElementById("species");
let breed = document.getElementById("breed");
let pet = document.getElementById("pet");

let pets = [];
