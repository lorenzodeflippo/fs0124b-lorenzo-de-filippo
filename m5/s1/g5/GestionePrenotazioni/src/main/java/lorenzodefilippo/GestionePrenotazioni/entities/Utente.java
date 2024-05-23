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
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String username;
    private String nomeCompleto;
    private String email;
    @ToString.Exclude
    @OneToMany(mappedBy = "utente")
    private Set<Prenotazione> prenotazioni;

    public Utente() {
        Faker faker = new Faker(Locale.ITALIAN);
        this.username = faker.name().username();
        this.nomeCompleto = faker.name().firstName().concat(faker.name().lastName());
        this.email = faker.internet().emailAddress();
    }

    public Utente(String username, String nomeCompleto, String email) {
        this.username = username;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
    }
}
