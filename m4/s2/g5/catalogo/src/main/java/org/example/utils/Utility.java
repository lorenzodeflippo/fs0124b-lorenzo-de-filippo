package org.example.utils;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.example.classes.Book;
import org.example.classes.Magazine;
import org.example.classes.Storage;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.BiPredicate;

public class Utility {


    static BiPredicate<Long, Storage> correctCodISBN = (codISBN, elem) -> elem.getCodISBN() == codISBN;
    static BiPredicate<Integer, Storage> correctyearPublication = (yearPublication, elem) -> elem.getYearPublication() == yearPublication;
    static BiPredicate<String, Book> correctAuthor = (autor, elem) -> elem.getAuthor().equals(autor);

    public static Periodicity getRandomEnum(Class<Periodicity> enumeration) {
//        public static <T extends Enum<?>> T getRandomEnum(Class<T> enumeration) {
//            Random random = new Random();
//            T[] values = enumeration.getEnumConstants();
//            return values[random.nextInt(values.length)];
//        }

        Random random = new Random();
        Periodicity[] values = enumeration.getEnumConstants();
        return values[random.nextInt(values.length)];
    }

    static public void addElementBook(List<Storage> Storage) {
        Faker faker = new Faker(Locale.ITALY);
        Random rnd = new Random();
        String title = faker.book().title();
        int numPages = rnd.nextInt(30, 400);
        String autor = faker.book().author();
        String type = faker.book().genre();
        Book book = new Book(title, numPages, autor, type);

        Storage.add(book);
        System.out.println("Success add " + book);
    }


    static public void addElementsMagazine(List<Storage> Storage) {
        Faker faker = new Faker(Locale.ITALY);
        Random rnd = new Random();
        String title = faker.book().title();
        int numPages = rnd.nextInt(10, 50);


        Magazine magazine = new Magazine(title, numPages, getRandomEnum(Periodicity.class));
        Storage.add(magazine);
        System.out.println("Success add " + magazine);
    }

    static public void addElement(long codISBN, String title, int yearPublication, int numPages, String author, String type, List<Storage> Storage) {

        Book book = new Book(codISBN, title, yearPublication, numPages, author, type);
        Storage.add(book);

    }


    static public void addElement(long codISBN, String title, int yearPublication, int numPages, Enum periodicity, List<Storage> Storage) {

        Magazine magazine = new Magazine(codISBN, title, yearPublication, numPages, periodicity);
        Storage.add(magazine);

    }


    static public void removeElement(long codISBN, List<Storage> storage) {
        if (storage.removeIf(elem -> correctCodISBN.test(codISBN, elem))) {
            System.out.println("Success remove");
        } else {
            System.out.println("Didn't find");
        }
    }


    static public Storage findByISBN(long codISBN, List<Storage> storage) {
        List<Storage> list = storage.stream().filter(elem -> correctCodISBN.test(codISBN, elem)).toList();
        Storage elem = list.get(0);
        System.out.println("Find" + elem);
        return elem;
    }


    static public List<Storage> findByYearPublication(int yearPublication, List<Storage> storage) {
        List<Storage> list = storage.stream().filter(elem -> correctyearPublication.test(yearPublication, elem)).toList();
        list.forEach(System.out::println);
        return list;
    }


    static public List<Storage> findByAuthor(String author, List<Storage> storage) {
        List<Storage> list = storage.stream().filter(elem -> elem instanceof Book).filter(elem -> correctAuthor.test(author, (Book) elem)).toList();
        list.forEach(System.out::println);
        return list;
    }

    static public void saveToDisk(List<Storage> storage) throws IOException {
        StringBuilder toWrite = new StringBuilder();


        for (Storage product : storage) {
            StringBuilder str = new StringBuilder();

            if (product instanceof Book) {
                str.append(((Book) product).getAuthor()).append("@")
                        .append(((Book) product).getType());
            }

            if (product instanceof Magazine) {
                str.append(((Magazine) product).getPeriodicity());

            }

            toWrite.append(product.getCodISBN()).append("@")
                    .append(product.getTitle()).append("@")
                    .append(product.getYearPublication()).append("@")
                    .append(product.getNumPages()).append("@")
                    .append(str)
                    .append("#");

        }
        File file = new File("prova.txt");
        FileUtils.writeStringToFile(file, toWrite.toString(), "UTF-8");
    }

    static public List<Storage> findToDisk(List<Storage> storage) throws IOException {
        storage.clear();
        File file = new File("prova.txt");
        String fileString = FileUtils.readFileToString(file, "UTF-8");
        List<String> splitElementString = Arrays.asList(fileString.split("#"));


        splitElementString.stream().forEach(stringa -> {
            String[] productInfos = stringa.split("@");
            if (productInfos.length == 5) {
                addElement(Long.parseLong(productInfos[0]), productInfos[1], Integer.parseInt(productInfos[2]), Integer.parseInt(productInfos[3]), Periodicity.valueOf(productInfos[4]), storage);
            } else if (productInfos.length == 6) {
                addElement(Long.parseLong(productInfos[0]), productInfos[1], Integer.parseInt(productInfos[2]), Integer.parseInt(productInfos[3]), productInfos[4], productInfos[5], storage);
            }
        });

        return storage;
    }
}

