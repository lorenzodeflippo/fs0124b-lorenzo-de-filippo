package org.example;

import org.example.classes.Storage;
import org.example.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Archive {
    static private List<Storage> storage = new ArrayList<>();


    public static void main(String[] args) {

        final Logger logger = LoggerFactory.getLogger(Archive.class);

        for (int i = 0; i < 2; i++) {
            Utility.addElementsMagazine(storage);
            Utility.addElementBook(storage);
        }


        System.out.println("Before elimination");
        storage.forEach(System.out::println);


        Utility.removeElement(storage.get(0).getCodISBN(), storage);

        System.out.println("After elimination");
        storage.forEach(System.out::println);


        System.out.println("Result of I D");
        Utility.findByISBN(storage.get(0).getCodISBN(), storage);

        System.out.println("Result of year of Publication");
        Utility.findByYearPublication(storage.get(0).getYearPublication(), storage);


        System.out.println("Result of Author");
        Utility.findByAuthor("author", storage);


        try {
            System.out.println("Save to disk");
            Utility.saveToDisk(storage);

            System.out.println("From Disk");
            Utility.findToDisk(storage);
            storage.forEach(System.out::println);
        } catch (IOException er) {
            logger.error("An error occurred: ", er);
        }


    }

}
