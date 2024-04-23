package it.epicode;

import java.util.*;

public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserisci il numero di elementi:");
		int n = scanner.nextInt();
		List<Integer> randomIntegers = getRandomList(n);
		printList("FUNZIONE 1", randomIntegers);
		List<Integer> mirrored = mirrorList(randomIntegers);
		printList("FUNZIONE 2", mirrored);
		printOddEven("FUNZIONE 3 (pari)", mirrored, true);
		printOddEven("FUNZIONE 3 (dispari)", mirrored, false);
		scanner.close();
	}

	public static List<Integer> getRandomList(int n) {
		List<Integer> arr = new ArrayList<>();
		Random rnd = new Random();
		for (int i = 0; i < n; i++) {
			arr.add(rnd.nextInt(101));
		}
		Collections.sort(arr);
		return arr;
	}

	public static List<Integer> mirrorList(List<Integer> list) {
		List<Integer> mirrored = new ArrayList<>(list);
		Collections.reverse(mirrored);
		return new ArrayList<>(list); // Creazione di una nuova lista per mantenere l'originale
	}

	public static void printList(String title, List<Integer> list) {
		System.out.println("-------------------- " + title + " ----------------------");
		System.out.println("Stampo lista lunga " + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Posizione [" + i + "]: " + list.get(i));
		}
	}

	public static void printOddEven(String title, List<Integer> list, boolean even) {
		System.out.println("-------------------- " + title + " ----------------------");
		System.out.println("Stampo lista lunga " + list.size());
		System.out.println("Stampo solo i numeri in posizione " + (even ? "pari" : "dispari"));
		for (int i = (even ? 2 : 1); i <= list.size(); i += 2) {
			System.out.println("Posizione [" + i + "]: " + list.get(i - 1));
		}
	}
}
