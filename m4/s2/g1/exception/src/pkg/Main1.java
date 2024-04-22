package pkg;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr = generateRandomArray(5);

		while (true) {
			System.out.println("Inserire un numero seguito dal tasto Invio. Inserire 0 per uscire");
			int num = scanner.nextInt();

			if (num == 0) {
				break;
			}

			System.out.println("Inserire la posizione in cui inserire il numero seguita dal tasto Invio");
			int position = scanner.nextInt();

			if (position < 0 || position >= arr.length) {
				System.out.println("Posizione fuori dal limite dell'array: " + position);
				continue;
			}

			arr[position] = num;
			System.out.println(Arrays.toString(arr));
		}

		scanner.close();
	}

	public static int[] generateRandomArray(int length) {
		Random random = new Random();
		int[] arr = new int[length];

		for (int i = 0; i < length; i++) {
			arr[i] = random.nextInt(10) + 1; // Genera numeri casuali da 1 a 10
		}

		return arr;
	}
}
