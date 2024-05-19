package lucafavaretto.GestionePrenotazioni.dao;

import lucafavaretto.GestionePrenotazioni.entities.Edificio;
import lucafavaretto.GestionePrenotazioni.entities.Postazione;
import lucafavaretto.GestionePrenotazioni.enums.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneDao extends JpaRepository<Postazione, Long> {
    List<Postazione> findByTipo(Tipo tipo);
}
