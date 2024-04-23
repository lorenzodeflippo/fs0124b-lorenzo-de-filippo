package it.epicode;

import java.util.HashMap;
import java.util.Map;

public class Main3 {
	private static final Map<String, String> rubrica = new HashMap<>();

	public static void main(String[] args) {
		addContact("Lorenzo de Filippo", "+39 3409526970");
		addContact("Mikael Bisceglia", "+39 3469763244");
		addContact("Gianluca Armillotta", "+39 3429497992");
		System.out.println("Aggiunti " + rubrica.size() + " contatti");

		removeContactByName("Gianluca Armillotta");
		System.out.println("Rimosso un contatto");

		findPersonByPhoneNumber("+39 3409526970");
		findNumberByName("Lorenzo de Filippo");

		printList();
	}

	private static void addContact(String name, String phone) {
		rubrica.put(name, phone);
	}

	private static void removeContactByName(String name) {
		rubrica.remove(name);
	}

	private static void findPersonByPhoneNumber(String phone) {
		String result = rubrica.entrySet().stream()
				.filter(entry -> phone.equals(entry.getValue()))
				.map(Map.Entry::getKey)
				.findFirst()
				.orElse("Contatto non trovato");
		System.out.println(result);
	}

	private static void findNumberByName(String name) {
		String phone = rubrica.getOrDefault(name, "Non trovato!");
		System.out.println(phone);
	}

	private static void printList() {
		rubrica.forEach((name, phone) -> System.out.println("Nome: " + name + ", numero di telefono: " + phone));
	}
}
