package lucafavaretto.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.*;
import lucafavaretto.GestionePrenotazioni.enums.Tipo;

import java.util.Random;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private int maxUtenti;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_edificio")
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione")
    @ToString.Exclude
    private Set<Prenotazione> prenotazioni;

    public Postazione(Edificio edificio) {
        Tipo[] values = Tipo.values();
        Random rndm = new Random();
        this.descrizione = "descrizione bella";
        this.tipo = values[rndm.nextInt(values.length)];
        this.maxUtenti = 3;
        this.edificio = edificio;

    }
}
