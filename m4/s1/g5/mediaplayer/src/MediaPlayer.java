import it.epicode.be.childrenClass.Audio;
import it.epicode.be.childrenClass.Immagine;
import it.epicode.be.childrenClass.Video;
import it.epicode.be.parentClass.Multimediale;

import java.util.Arrays;
import java.util.Scanner;

public class MediaPlayer {
    public static void main(String[] args) {
        System.out.println("Media Player");

        Scanner scanner = new Scanner(System.in);
        Multimediale[] multimedia = createMultimediaArray(scanner); // Chiamata alla funzione per creare l'array
        try {
            loop(scanner, multimedia); // Chiamata alla funzione per il loop
        } finally {
            scanner.close();
        }
    }

    // Creo un array di oggetti multimediale
    static private Multimediale[] createMultimediaArray(Scanner scanner) {
        Multimediale[] multimedia = new Multimediale[5]; // Creazione di un array di lunghezza 5
        for (int p = 0; p < 5; p++) {
            System.out.println("Vuoi creare un video/audio/immagine?");
            String str = scanner.nextLine();
            switch (str) {
                case "video" -> {
                    multimedia[p] = createVideo(scanner); // Crea un oggetto Video
                }
                case "audio" -> {
                    multimedia[p] = createAudio(scanner); // Crea un oggetto Audio
                }
                case "immagine" -> {
                    multimedia[p] = createImage(scanner); // Crea un oggetto Immagine
                }
            }
        }
        return multimedia;
    }

    // Creo un oggetto Video
    static private Video createVideo(Scanner scanner) {
        System.out.println("Che titolo vuoi dare?");
        String titolo = scanner.nextLine();

        System.out.println("Che luminosita mettiamo?");
        int luminosita = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Quanto vuoi che duri?");
        int durata = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Potenza volume?");
        int volume = scanner.nextInt();
        scanner.nextLine();

        return new Video(titolo, luminosita, durata, volume);
    }

    // Creo un oggetto Audio
    static private Audio createAudio(Scanner scanner) {
        System.out.println("Che titolo vuoi dare?");
        String titolo = scanner.nextLine();

        System.out.println("Quanto vuoi che duri?");
        int durata = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Potenza volume?");
        int volume = scanner.nextInt();
        scanner.nextLine();

        return new Audio(titolo, durata, volume);
    }

    // Creo un oggetto Immagine
    static private Immagine createImage(Scanner scanner) {
        System.out.println("Che titolo vuoi dare?");
        String titolo = scanner.nextLine();

        System.out.println("Che luminosita mettiamo?");
        int luminosita = scanner.nextInt();
        scanner.nextLine();

        return new Immagine(titolo, luminosita);
    }

    // Funzione per il LOOP principale
    static private void loop(Scanner scanner, Multimediale[] multimedia) {
        int input = 0;
        do {
            try {
                if (input == 0) {
                    System.out.println("Elementi creati");
                } else {
                    System.out.println("Elementi modificati");
                }

                System.out.println(Arrays.toString(multimedia));
                System.out.printf("-----------------------------------------------------------------------------------------------------%n" +
                        "Inserisci un numero da 1 a 5 per selezionare cosa riprodurre, 0 se vuoi concludere%n");
                input = scanner.nextInt();
                scanner.nextLine();
                selectAndPlay(input - 1, multimedia, scanner); // Chiamata alla funzione per selezionare e riprodurre l'elemento multimediale
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input non valido. Inserisci un numero intero.");
                scanner.nextLine();
            }
        } while (input != 0);
    }

    // Seleziono e riproduco l'elemento multimediale
    static private void selectAndPlay(int num, Multimediale[] array, Scanner scanner) {
        if (num != -1) {
            Multimediale selected = array[num];
            System.out.printf("Hai selezionato un '%s' %n", selected.getFile());
            switch (selected.getFile()) {
                case AUDIO -> {
                    Audio audio = (Audio) selected;
                    System.out.println("Vuoi alzare il volume? true/false");
                    boolean increaseVolume = scanner.nextBoolean();
                    if (increaseVolume) {
                        audio.plusVol();
                    } else {
                        audio.minVol();
                    }
                    audio.play();
                }
                case VIDEO -> {
                    Video video = (Video) selected;
                    System.out.println("Vuoi alzare la luminosità? true/false");
                    boolean increaseBrightness = scanner.nextBoolean();
                    if (increaseBrightness) {
                        video.aumLum();
                    } else {
                        video.dimLum();
                    }
                    System.out.println("Vuoi alzare il volume? true/false");
                    boolean increaseVolume = scanner.nextBoolean();
                    if (increaseVolume) {
                        video.plusVol();
                    } else {
                        video.minVol();
                    }
                    video.play();
                }
                case IMMAGINE -> {
                    Immagine image = (Immagine) selected;
                    System.out.println("Vuoi alzare la luminosità? true/false");
                    boolean increaseBrightness = scanner.nextBoolean();
                    if (increaseBrightness) {
                        image.aumLum();
                    } else {
                        image.dimLum();
                    }
                    image.show();
                }
            }
        } else {
            System.out.println("Ciclo concluso");
        }
    }
}