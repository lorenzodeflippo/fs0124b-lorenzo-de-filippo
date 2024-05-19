package lucafavaretto.GestionePrenotazioni.dao;

import lucafavaretto.GestionePrenotazioni.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdificioDao extends JpaRepository<Edificio, Long> {

    List<Edificio> findByCitta(String citta);

}
