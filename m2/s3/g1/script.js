class User {
  constructor(firstName, lastName, age, location) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.location = location;
  }

  compareAge(anotherUser) {
    if (this.age < anotherUser.age) {
      return `${anotherUser.firstName} è più anziano di ${this.firstName}.`;
    } else if (this.age > anotherUser.age) {
      return `${anotherUser.firstName} è più giovane di ${this.firstName}.`;
    } else {
      return `${anotherUser.firstName} è della stessa età di ${this.firstName}.`;
    }
  }
}

a = new User("Matteo", "de Filippo", 64, "Mattinata");
b = new User("Lucia", "Lapomarda", 67, "Mattinata");
console.log(a.compareAge(b));
