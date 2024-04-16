package java1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = inputInteger(sc, "Inserisci un intero");
        double d = inputDouble(sc, "Inserisci un numero");
        String s = input(sc, "Inserisci un testo qualsiasi");

        System.out.println(n);
        System.out.println(d);
        System.out.println(s);

        int a = 20;
        int b = 50;
        int result = multiply(a, b);
        System.out.println(result);

        System.out.println(concat("bla", 6));

        String[] arr = insertIntoArray(new String[]{"A", "B", "C", "D", "E"}, "aaaaa");
        System.out.println(Arrays.toString(arr));

        String[] inputStrings = new String[3];
        inputStrings[0] = input(sc, "Insert first string then Enter");
        inputStrings[1] = input(sc, "Insert second string then Enter");
        inputStrings[2] = input(sc, "Insert third string then Enter");

        System.out.println("Here the strings concatenated");
        System.out.println(inputStrings[0] + inputStrings[1] + inputStrings[2]);

        System.out.println("Here they are in reverse order");
        System.out.println(inputStrings[2] + inputStrings[1] + inputStrings[0]);

        System.out.println(perimeter(10, 12.5));
        System.out.println(evenOdd(4));
        System.out.println(area(2.5, 4.2, 5.6));

        sc.close();
    }

    public static String input(Scanner sc, String prompt) {
        System.out.print(prompt + ": ");
        return sc.nextLine();
    }

    public static int inputInteger(Scanner sc, String prompt) {
        System.out.print(prompt + ": ");
        return sc.nextInt();
    }

    public static double inputDouble(Scanner sc, String prompt) {
        System.out.print(prompt + ": ");
        return sc.nextDouble();
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static String concat(String str, int num) {
        return str + num;
    }

    public static String[] insertIntoArray(String[] stringArray, String str) {
        String[] array = Arrays.copyOf(stringArray, stringArray.length + 1);
        array[stringArray.length] = str;
        return array;
    }

    public static double perimeter(double l1, double l2) {
        return 2 * (l1 + l2);
    }

    public static int evenOdd(int input) {
        return input % 2 == 0 ? 0 : 1;
    }

    public static double area(double l1, double l2, double l3) {
        double semiPerimeter = (l1 + l2 + l3) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - l1) * (semiPerimeter - l2) * (semiPerimeter - l3));
    }
}
