package lucafavaretto.GestionePrenotazioni.dao;

import lombok.extern.slf4j.Slf4j;
import lucafavaretto.GestionePrenotazioni.entities.Postazione;
import lucafavaretto.GestionePrenotazioni.entities.Prenotazione;
import lucafavaretto.GestionePrenotazioni.entities.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
public class PrenotazioneService {
    @Autowired
    PrenotazioneDao prenotazioneDao;

    public void save(Prenotazione p) {
        prenotazioneDao.save(p);
        log.info("Prenotazione " + p + " add with success!");
    }

    public boolean filterByUtenteAndDay(Utente utente, LocalDate day) {
        if (prenotazioneDao.filterByUtenteAndDay(utente, day).isEmpty()) {
            log.info("Nessuna prenotazione per questo giorno " + utente.getUsername() + "procediamo");
            return true;
        } else {
            log.info("Hai già prenotazioni per questo giorno!");
            return false;
        }
    }


    public void newPrenotazione(Utente utente, LocalDate date, Postazione postazione) {
        if (filterByUtenteAndDay(utente, date)) {
            if (postazione.getMaxUtenti() > prenotazioneDao.countByPostazione(postazione, date)) {
                save(new Prenotazione(date, utente, postazione));
            } else {
                log.info("Ci dispiace, ma postazione è già al completo utente" + utente.getUsername());
            }

        }
    }


}
