package it.epicode.be.childrenClass;

import it.epicode.be.parentClass.File;
import it.epicode.be.parentClass.Multimediale;
import it.epicode.be.parentClass.Riproduzione;

public class Audio extends Multimediale implements Riproduzione {
    private int durata; // Durata dell'audio
    private int volume; // Livello del volume dell'audio

    // Costruttore che inizializza il titolo, la durata e il volume dell'audio
    public Audio(String titolo, int durata, int volume) {
        super(titolo, File.AUDIO); // Chiamata al costruttore della superclasse (Multimediale)
        this.durata = durata; // Inizializza la durata
        this.volume = volume; // Inizializza il volume
    }

    // Metodo che aumenta il volume dell'audio
    @Override
    public void plusVol() {
        if (!(getVolume() == 10)) { // Se il volume non è già al massimo
            setVolume(getVolume() + 1); // Aumenta il volume
            System.out.println("VOLUME ALZATO"); // Stampa un messaggio di conferma
        }
    }

    // Metodo che diminuisce il volume dell'audio
    @Override
    public void minVol() {
        if (!(getVolume() == 0)) { // Se il volume non è già al minimo
            setVolume(getVolume() - 1); // Diminuisce il volume
            System.out.println("Volume abbassato"); // Stampa un messaggio di conferma
        }
    }

    // Metodo che riproduce l'audio con il titolo e il volume rappresentati da caratteri "!"
    @Override
    public void play() {
        System.out.println("------------------");
        for (int i = 0; i < getDurata(); i++) {
            System.out.printf(getTitolo()); // Stampa il titolo dell'audio
            for (int j = 0; j < getVolume(); j++) {
                System.out.printf("!"); // Stampa un "!" per ogni livello di volume
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

    // GETTER che ottiene la durata dell'audio
    public int getDurata() {
        return durata;
    }

    // SETTER che imposta la durata dell'audio
    public void setDurata(int durata) {
        this.durata = durata;
    }

    // GETTER che ottiene il volume dell'audio
    public int getVolume() {
        return volume;
    }

    // SETTER che imposta il volume dell'audio
    public void setVolume(int volume) {
        this.volume = volume;
    }

    // Metodo toString che restituisce una rappresentazione testuale dell'oggetto Audio
    @Override
    public String toString() {
        return "Audio{" +
                "titolo=" + getTitolo() +
                ", durata=" + durata +
                ", volume=" + volume +
                '}';
    }
}
