package it.epicode.be.childrenClass;

import it.epicode.be.parentClass.File;
import it.epicode.be.parentClass.Luminosita;
import it.epicode.be.parentClass.Multimediale;
import it.epicode.be.parentClass.Riproduzione;

public class Video extends Multimediale implements Riproduzione, Luminosita {
    private int luminosita; // Luminosità del video
    private int durata; // Durata del video
    private int volume; // Volume del video

    // Costruttore che inizializza il titolo, la luminosità, la durata e il volume del video
    public Video(String titolo, int luminosita, int durata, int volume) {
        super(titolo, File.VIDEO); // Chiamata al costruttore della superclasse (Multimediale)
        this.volume = volume; // Inizializza il volume
        this.durata = durata; // Inizializza la durata
        this.luminosita = luminosita; // Inizializza la luminosità
    }

    // GETTER che ottiene la luminosità del video
    public int getLuminosita() {
        return luminosita;
    }

    // SETTER che imposta la luminosità del video
    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }

    // Metodo che aumenta la luminosità del video
    @Override
    public void aumLum() {
        if (!(getLuminosita() == 10)) { // Se la luminosità non è già al massimo
            setLuminosita(getLuminosita() + 1); // Aumenta la luminosità
            System.out.println("LUMINOSITA ALZATA"); // Stampa un messaggio di conferma
        }
    }

    // GETTER che ottiene la durata del video
    public int getDurata() {
        return durata;
    }

    // SETTER che imposta la durata del video
    public void setDurata(int durata) {
        this.durata = durata;
    }

    // GETTER che ottiene il volume del video
    public int getVolume() {
        return volume;
    }

    // SETTER che imposta il volume del video
    public void setVolume(int volume) {
        this.volume = volume;
    }

    // Metodo che diminuisce la luminosità del video
    @Override
    public void dimLum() {
        if (!(getLuminosita() == 0)) { // Se la luminosità non è già al minimo
            setLuminosita(getLuminosita() - 1); // Diminuisce la luminosità
            System.out.println("Luminosita abbassata"); // Stampa un messaggio di conferma
        }
    }

    // Metodo che aumenta il volume del video
    @Override
    public void plusVol() {
        if (!(getVolume() == 10)) { // Se il volume non è già al massimo
            setVolume(getVolume() + 1); // Aumenta il volume
            System.out.println("VOLUME ALZATO"); // Stampa un messaggio di conferma
        }
    }

    // Metodo che diminuisce il volume del video
    @Override
    public void minVol() {
        if (!(getVolume() == 0)) { // Se il volume non è già al minimo
            setVolume(getVolume() - 1); // Diminuisce il volume
            System.out.println("Volume abbassato"); // Stampa un messaggio di conferma
        }
    }

    // Metodo che riproduce il video con titolo, volume e luminosità rappresentati da caratteri "!" e "*"
    @Override
    public void play() {
        System.out.println("------------------");
        for (int i = 0; i < getDurata(); i++) {
            System.out.printf(getTitolo()); // Stampa il titolo del video
            for (int j = 0; j < getVolume(); j++) {
                System.out.print("!"); // Stampa "!" per ogni livello di volume
            }
            for (int j = 0; j < getLuminosita(); j++) {
                System.out.print("*"); // Stampa "*" per ogni livello di luminosità
            }
            if (i == getDurata() - 1) { // Se è l'ultimo secondo, esce dal ciclo
                break;
            } else {
                System.out.println(" "); // Vai a capo dopo la riproduzione di un secondo
            }
        }
        System.out.println(" ");
        System.out.println("------------------");
    }

    // Metodo toString che restituisce una rappresentazione testuale dell'oggetto Video
    @Override
    public String toString() {
        return "Video{" +
                "titolo=" + getTitolo() +
                ", durata=" + getDurata() +
                ", volume=" + getVolume() +
                ", luminosità=" + luminosita +
                '}';
    }
}
