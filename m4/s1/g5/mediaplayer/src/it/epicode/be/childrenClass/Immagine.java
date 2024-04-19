package it.epicode.be.childrenClass;

import it.epicode.be.parentClass.File;
import it.epicode.be.parentClass.Luminosita;
import it.epicode.be.parentClass.Multimediale;

public class Immagine extends Multimediale implements Luminosita {
    private int luminosita; // Variabile che memorizza la luminosità dell'immagine

    // Costruttore che inizializza il titolo e la luminosità dell'immagine
    public Immagine(String titolo, int luminosita) {
        super(titolo, File.IMMAGINE); // Chiamata al costruttore della superclasse (Multimediale)
        this.luminosita = luminosita; // Inizializza la luminosità
    }

    // Metodo che aumenta la luminosità
    @Override
    public void aumLum() {
        if (!(getLuminosita() == 10)) { // Se la luminosità non è già al massimo
            setLuminosita(getLuminosita() + 1); // Aumenta la luminosità
            System.out.println("LUMINOSITA ALZATA"); // Stampa un messaggio di conferma
        }
    }

    // Metodo che diminuisce la luminosità
    @Override
    public void dimLum() {
        if (!(getLuminosita() == 0)) { // Se la luminosità non è già al minimo
            setLuminosita(getLuminosita() - 1); // Diminuisce la luminosità
            System.out.println("Luminosita abbassata"); // Stampa un messaggio di conferma
        }
    }

    // Metodo che visualizza l'immagine con la luminosità rappresentata da asterischi
    public void show() {
        System.out.print(getTitolo()); // Stampa il titolo dell'immagine
        for (int i = 0; i < getLuminosita(); i++) {
            System.out.print("*"); // Stampa un asterisco per ogni livello di luminosità
        }
        System.out.println(); // Vai a capo dopo la stampa della luminosità
    }

    // GETTER per ottenere la luminosità
    public int getLuminosita() {
        return luminosita;
    }

    // SETTER per impostare la luminosità
    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }

    // Metodo toString che restituisce una rappresentazione testuale dell'oggetto Immagine
    @Override
    public String toString() {
        return "Immagine{" +
                "titolo=" + getTitolo() +
                ", luminosita=" + luminosita +
                '}';
    }
}
