package lucafavaretto.GestionePrenotazioni.dao;

import lucafavaretto.GestionePrenotazioni.entities.Edificio;
import lucafavaretto.GestionePrenotazioni.entities.Postazione;
import lucafavaretto.GestionePrenotazioni.entities.Prenotazione;
import lucafavaretto.GestionePrenotazioni.entities.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneDao extends JpaRepository<Prenotazione, Long> {

    @Query("SELECT p FROM Prenotazione p WHERE p.utente=:utente AND p.day=:day")
    List<Prenotazione> filterByUtenteAndDay(Utente utente, LocalDate day);

    @Query("SELECT COUNT(p) FROM Prenotazione p WHERE p.postazione = :postazione AND p.day=:day")
    long countByPostazione(Postazione postazione, LocalDate day);
}
