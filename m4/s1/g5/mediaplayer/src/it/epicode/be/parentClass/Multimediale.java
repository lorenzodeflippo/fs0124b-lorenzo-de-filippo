package it.epicode.be.parentClass;

// Definisco la classe ASTRATTA Multimediale
public abstract class Multimediale {

    private String titolo; // Attributo per il titolo del multimediale
    private File file; // Attributo per il tipo di file del multimediale

    // Costruttore della classe Multimediale
    public Multimediale(String titolo, File file) {
        this.titolo = titolo;
        this.file = file;
    }

    // Metodo GETTER che ottiene il tipo di file del multimediale
    public File getFile() {
        return file;
    }

    // Metodo SETTER che imposta il tipo di file del multimediale
    public void setFile(File file) {
        this.file = file;
    }

    // Metodo GETTER che ottiene il titolo del multimediale
    public String getTitolo() {
        return titolo;
    }

    // Metodo SETTER che imposta il titolo del multimediale
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    // Metodo toString che rappresenta il multimediale come stringa
    @Override
    public String toString() {
        return "Multimediale{" +
                "titolo='" + titolo + '\'' +
                ", file=" + file +
                '}';
    }
}
