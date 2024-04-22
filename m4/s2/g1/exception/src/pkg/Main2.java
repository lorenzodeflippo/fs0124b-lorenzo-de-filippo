package pkg;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Inserire i kilometri percorsi: ");
		int km = scanner.nextInt();

		System.out.print("Inserire i litri di benzina consumati: ");
		double liters = scanner.nextDouble();

		if (liters == 0) {
			System.out.println("Impossibile dividere per zero. Assicurati di inserire un valore diverso da zero per i litri.");
		} else {
			double kmLiter = km / liters;
			System.out.println("L'auto percorre " + kmLiter + " km al litro");
		}

		scanner.close();
	}
}
