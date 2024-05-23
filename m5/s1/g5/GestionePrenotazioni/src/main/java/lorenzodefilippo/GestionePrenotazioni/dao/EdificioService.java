package lucafavaretto.GestionePrenotazioni.dao;

import lombok.extern.slf4j.Slf4j;
import lucafavaretto.GestionePrenotazioni.entities.Edificio;
import lucafavaretto.GestionePrenotazioni.exeption.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EdificioService {
    @Autowired
    EdificioDao edificioDao;

    public void save(Edificio e) {
        edificioDao.save(e);
        log.info("Edificio " + e + " add with success!");
    }

    public Edificio findById(long itemId) throws ItemNotFoundException {
        return edificioDao.findById(itemId).orElseThrow(ItemNotFoundException::new);
    }

    public List<Edificio> findByCitta(String citta) {
        return edificioDao.findByCitta(citta);
    }
}
