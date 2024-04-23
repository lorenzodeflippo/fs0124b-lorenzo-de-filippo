package it.epicode;

import java.util.*;

public class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Set<String> words = new HashSet<>();

		System.out.println("Inserisci il numero di elementi (clicca 0 per uscire):");
		int numElementi = scanner.nextInt();
		scanner.nextLine(); // Consuma il newline

		for (int i = 0; i < numElementi; i++) {
			System.out.println("Inserisci una parola:");
			String word = scanner.nextLine();
			if (!words.add(word)) {
				System.out.println(word + " è duplicata!");
			}
		}

		System.out.println("Numero di parole distinte: " + words.size());
		System.out.println("Elenco delle parole distinte: " + words);

		scanner.close();
	}
}
