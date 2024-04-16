package java2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Inserire un numero seguito dal tasto Invio");
        int test = scan.nextInt();
        System.out.println(stampaNumero(test));
        scan.nextLine(); // Consuming the newline character after nextInt()

        System.out.println("Inserire una stringa seguita dal tasto Invio");
        String input = "";
        do {
            input = scan.nextLine();
            String[] caratteri = input.split("");
            System.out.println(String.join(",", caratteri));
        } while (!input.equals(":q"));

        countdown(test);

        scan.close();
        System.out.println("Exit");
    }

    public static boolean stringaPariDispari(String str) {
        return str.length() % 2 == 0;
    }

    public static boolean annoBisestile(int anno) {
        return anno % 400 == 0 || (anno % 4 == 0 && anno % 100 != 0);
    }

    public static String stampaNumero(int num) {
        String risultato;
        switch (num) {
            case 0:
                risultato = "zero";
                break;
            case 1:
                risultato = "uno";
                break;
            case 2:
                risultato = "due";
                break;
            case 3:
                risultato = "tre";
                break;
            default:
                risultato = "Numero non compreso tra 0 e 3, impossibile convertire";
        }
        return risultato;
    }

    public static void countdown(int num) {
        System.out.println("Conto alla rovescia da " + num + " a 0");

        for (int i = num; i >= 0; i--) {
            System.out.println(i);
        }
    }
}
