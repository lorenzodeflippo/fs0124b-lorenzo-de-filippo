package lucafavaretto.GestionePrenotazioni.dao;

import lombok.extern.slf4j.Slf4j;
import lucafavaretto.GestionePrenotazioni.entities.Edificio;
import lucafavaretto.GestionePrenotazioni.entities.Postazione;
import lucafavaretto.GestionePrenotazioni.entities.Utente;
import lucafavaretto.GestionePrenotazioni.enums.Tipo;
import lucafavaretto.GestionePrenotazioni.exeption.EmailAlreadyExistsException;
import lucafavaretto.GestionePrenotazioni.exeption.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UtenteService {
    @Autowired
    UtenteDao utenteDao;

    public void save(Utente u) throws EmailAlreadyExistsException {
        if (utenteDao.existsByEmail(u.getEmail())) {
            throw new EmailAlreadyExistsException(u.getUsername());
        } else {
            utenteDao.save(u);
            log.info("Utente " + u.getUsername() + " add with success!");
        }
    }

    public Utente findById(long userId) throws ItemNotFoundException {
        return utenteDao.findById(userId).orElseThrow(() -> new ItemNotFoundException(userId));
    }

    public Utente findByUsername(String username) throws ItemNotFoundException {
        return utenteDao.findByUsername(username).orElseThrow(ItemNotFoundException::new);
    }

    public List<Postazione> findPostazioneByCittaETipo(String citta, Tipo tipo) {
        return utenteDao.findPostazioneByCittaETipo(citta, tipo);
    }

    ///////////////////////////////////////
    public List<Utente> findByEmailNull() {
        return utenteDao.findByEmailNull();
    }
}
