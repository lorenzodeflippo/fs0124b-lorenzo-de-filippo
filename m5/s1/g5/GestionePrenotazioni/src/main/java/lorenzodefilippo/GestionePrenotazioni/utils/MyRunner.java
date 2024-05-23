package lucafavaretto.GestionePrenotazioni.utils;

import lombok.extern.slf4j.Slf4j;
import lucafavaretto.GestionePrenotazioni.dao.EdificioService;
import lucafavaretto.GestionePrenotazioni.dao.PostazioneService;
import lucafavaretto.GestionePrenotazioni.dao.PrenotazioneService;
import lucafavaretto.GestionePrenotazioni.dao.UtenteService;
import lucafavaretto.GestionePrenotazioni.entities.Edificio;
import lucafavaretto.GestionePrenotazioni.entities.Postazione;
import lucafavaretto.GestionePrenotazioni.entities.Prenotazione;
import lucafavaretto.GestionePrenotazioni.entities.Utente;
import lucafavaretto.GestionePrenotazioni.enums.Tipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
@Slf4j
public class MyRunner implements CommandLineRunner {
    @Autowired
    EdificioService eS;
    @Autowired
    PostazioneService pS;
    @Autowired
    PrenotazioneService prS;
    @Autowired
    UtenteService uS;

    @Override
    public void run(String... args) throws Exception {

        Utente uA = new Utente();
        Utente uB = new Utente();
        Utente uC = new Utente();
        Utente uD = new Utente();
        Utente uF = new Utente();

        uS.save(uA);
        uS.save(uB);
        uS.save(uC);
        uS.save(uD);
        uS.save(uF);

        Edificio edA = new Edificio();
        Edificio edB = new Edificio();

        eS.save(edA);
        eS.save(edB);

        Postazione poA = new Postazione(edA);
        Postazione poB = new Postazione(edB);
        Postazione poC = new Postazione(edB);

        pS.save(poA);
        pS.save(poB);
        pS.save(poC);

        log.info("MyRunnerLog:" + edA);
        log.info("MyRunnerLog:" + edB);
        log.info("MyRunnerLog:" + poA);
        log.info("MyRunnerLog:" + poB);
        log.info("MyRunnerLog:" + poC);
        log.info("MyRunnerLog:" + uA);
        log.info("MyRunnerLog:" + uB);
        log.info("MyRunnerLog:" + uC);
        log.info("MyRunnerLog:" + uD);
        log.info("MyRunnerLog:" + uF);


        log.info("______________________________________________________________");
        log.info("utenti cerca tramite tipo e città");
        uS.findPostazioneByCittaETipo("Basile laziale", Tipo.SALA).forEach(el -> log.info("risultati:" + el));
        log.info("______________________________________________________________");
        log.info("salvataggi base senza complicazioni");
        prS.newPrenotazione(uA, LocalDate.parse("2024-02-12"), poA);
        prS.newPrenotazione(uB, LocalDate.parse("2024-02-12"), poB);
        prS.newPrenotazione(uB, LocalDate.parse("2024-02-13"), poB);
        log.info("______________________________________________________________");
        log.info("dovrebbe non poter prenotare a causa di una prenotazione lo stesso giorno");
        prS.newPrenotazione(uB, LocalDate.parse("2024-02-12"), poA);
        log.info("______________________________________________________________");
        log.info("l'utente F non dovrebbe poter prenotare a causa di un num max di 3");
        prS.newPrenotazione(uC, LocalDate.parse("2024-02-12"), poA);
        prS.newPrenotazione(uD, LocalDate.parse("2024-02-12"), poA);
        prS.newPrenotazione(uF, LocalDate.parse("2024-02-12"), poA);


    }
}
