package lucafavaretto.GestionePrenotazioni.entities;

import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.*;

import java.util.Locale;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString

public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String nome;
    private String indirizzo;
    private String citta;

    @OneToMany(mappedBy = "edificio", cascade = {CascadeType.ALL})
    @ToString.Exclude
    private Set<Postazione> postazione;

    public Edificio() {
        Faker faker = new Faker(Locale.ITALIAN);
        this.nome = faker.name().title();
        this.indirizzo = faker.address().fullAddress();
        this.citta = faker.address().city();
    }
}
