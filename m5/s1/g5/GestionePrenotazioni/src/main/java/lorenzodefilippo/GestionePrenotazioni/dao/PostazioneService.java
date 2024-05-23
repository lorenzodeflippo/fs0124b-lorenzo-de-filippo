package lucafavaretto.GestionePrenotazioni.dao;

import lombok.extern.slf4j.Slf4j;
import lucafavaretto.GestionePrenotazioni.entities.Edificio;
import lucafavaretto.GestionePrenotazioni.entities.Postazione;
import lucafavaretto.GestionePrenotazioni.enums.Tipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PostazioneService {
    @Autowired
    PostazioneDao postazioneDao;

    public void save(Postazione p) {
        postazioneDao.save(p);
        log.info("Postazione " + p + " add with success!");
    }

    public List<Postazione> findByTipo(Tipo tipo) {
        return postazioneDao.findByTipo(tipo);
    }
}
