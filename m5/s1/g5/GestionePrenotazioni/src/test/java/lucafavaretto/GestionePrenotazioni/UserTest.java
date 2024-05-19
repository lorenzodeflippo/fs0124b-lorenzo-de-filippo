package lucafavaretto.GestionePrenotazioni;

import lombok.extern.slf4j.Slf4j;
import lucafavaretto.GestionePrenotazioni.dao.UtenteService;
import lucafavaretto.GestionePrenotazioni.entities.Utente;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
public class UserTest {
    @Autowired
    UtenteService utenteService;


    @BeforeEach
    public void testSaveUtente() {
        Utente utente = new Utente("Cosmin", "3run", "email@tipo");
        try {
            utenteService.save(utente);
        } catch (Exception er) {
            log.error("errore di tipo" + er);
        }
        assertNotNull(utenteService.findByUsername("Cosmin"));
    }

    @Test
    public void testSaveUtente_EmailGiaEsistente() {
        Utente utente = new Utente("Marta", "Rossi", "email@tipo");
        try {
            utenteService.save(utente);
            assertNull(utenteService.findByUsername("Marta"));
        } catch (Exception ex) {
            log.info(ex.getMessage());
        }

    }


}
