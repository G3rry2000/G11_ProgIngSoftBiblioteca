package biblioteca.gestioneprestiti;

import biblioteca.gestioneeccezioni.PrestitoNonTrovatoException;
import biblioteca.gestioneeccezioni.ValidazioneException;
import biblioteca.gestioneeccezioni.LimitePrestitoSuperatoException;
import biblioteca.gestioneeccezioni.LibroNonDisponibileException;
import biblioteca.gestionelibri.ArchivioLibri;
import biblioteca.gestionelibri.Libro;
import biblioteca.gestioneutenti.ArchivioUtenti;
import biblioteca.gestioneutenti.Utente;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Collections;
/**
 * @class PrestitiService
 * @brief Service che esegue la validazione dei dati dei prestiti.
 *
 * Effettua i controlli su:
 * - utente, libro, dataInizio, dataFine e lo stato
 * - l'utente non ha superato il limite di Prestiti consetito (minore di 3) 
 * - il numero di copie non è minore di 0 
 * Le operazioni vengono delegate a ArchivioPrestitiAttivi e ArchivioCronologiaPrestiti.
 */
public class PrestitiService {
    /** Archivio dei libri su cui operare */
    private ArchivioLibri archivioLibri;
     /** Archivio degli utenti su cui operare */
    private ArchivioUtenti archivioUtenti;
     /** Archivio dei prestiti attivi su cui operare */
    private ArchivioPrestitiAttivi archivioPrestitiAttivi;
     /** Archivio della cornologia dei prestiti su cui operare */
    private ArchivioCronologiaPrestiti archivioCronologia;
    
    /**
     * @brief Costruttore del Service 
     * @param archivioLibri archivio dei libri da usare come dati
     * @param archivioUtenti archivio degli utenti da usare come dati
     * @param archivioPrestitiAttivi archivio dei prestiti attivi da usare come dati
     * @param archivioCronologia archivio della cronologia dei prestiti da usare come dati
     * 
     * @pre archivioLibri != null, archivioUtenti != null,archivioPrestitiAttivi!= null, archivioCronologia != null
     * @post this.archivioLibri==archivioLibri, this.archivioUtenti==archivioUtenti, this.archivioPrestitiAttivi==archivioPrestitiAttivi, this.archivioCronologia==archivioCronologia
     */
    public PrestitiService(ArchivioLibri archivioLibri, ArchivioUtenti archivioUtenti, ArchivioPrestitiAttivi archivioPrestitiAttivi, ArchivioCronologiaPrestiti archivioCronologia) {
        this.archivioLibri = archivioLibri;
        this.archivioUtenti = archivioUtenti;
        this.archivioPrestitiAttivi = archivioPrestitiAttivi;
        this.archivioCronologia = archivioCronologia;
    }
    /**
 * @brief Aggiunge un nuovo prestito attivo effettuando i dovuti controlli.
 *
 * Il metodo verifica:
 * - la validità dei parametri forniti
 * - l'esistenza di utente e libro
 * - che l'utente non abbia superato il limite massimo di 3 prestiti attivi
 * - che il libro abbia almeno una copia disponibile
 * 
 * In caso di esito positivo, il prestito viene registrato come ATTIVO
 * e il numero di copie disponibili del libro viene decrementato.
 *
 * @param isbn ISBN del libro da prestare
 * @param matricola Matricola dell'utente (intero)
 * @param dataFine Data prevista di restituzione del libro
 *
 * @throws ValidazioneException se i dati forniti non sono validi
 * @throws LibroNonDisponibileException se il libro non ha copie disponibili
 * @throws LimitePrestitoSuperatoException se l'utente ha già 3 prestiti attivi
 *
 * @pre isbn != null && !isbn.isEmpty()
 * @pre matricola > 0
 * @pre dataFine != null
 * @post il prestito attivo viene aggiunto all'archivio dei prestiti attivi
 */
public void registraPrestito(String isbn, String matricola, LocalDate dataFine)
        throws ValidazioneException, LibroNonDisponibileException, LimitePrestitoSuperatoException {

    if (isbn == null || isbn.trim().isEmpty() || matricola == null || matricola.trim().isEmpty() || dataFine == null) {
        throw new ValidazioneException("Dati del prestito non validi.");
    }
        LocalDate oggi = LocalDate.now();


    if (dataFine.isBefore(oggi)) {
        throw new ValidazioneException(
                "La data di restituzione non può essere nel passato."
        );
    }
    if (dataFine.isEqual(oggi)) {
        throw new ValidazioneException(
                "La restituzione deve avvenire almeno il giorno successivo."
        );
    }

    Libro libro = archivioLibri.ricercaISBN(isbn);
    Utente utente = archivioUtenti.ricercaMatricola(matricola);

    // Controllo limite massimo prestiti
    if (archivioPrestitiAttivi.contaPrestitiAttiviUtente(utente) >= 3) {
        throw new LimitePrestitoSuperatoException(
                "L'utente ha già raggiunto il numero massimo di prestiti consentiti."
        );
    }

    // Controllo disponibilità libro
    if (libro.getCopieDisponibili() <= 0) {
        throw new LibroNonDisponibileException("Libro non disponibile.");
    }
int id = archivioPrestitiAttivi.generaNuovoId();
    Prestito p = new Prestito(
            id,
            utente,
            libro,
            oggi,
            dataFine,
            StatoPrestiti.ATTIVO
    );

    libro.setCopieDisponibili(libro.getCopieDisponibili() - 1);
    archivioPrestitiAttivi.aggiungiPrestitoAttivo(p);
    Utente u = p.getUtente();
    u.aggiungiPrestitoAttivo(p);
    
    try {
        archivioPrestitiAttivi.scriviSuFile("prestitiAttivi.csv");
        archivioLibri.scriviSuFile("libri.csv");
        archivioUtenti.scriviSuFile("utenti.csv");
    } catch(IOException e) {
        e.printStackTrace();
    }
}
/**
 * @brief Elimina un prestito attivo esistente (restituzione del libro).
 *
 * Il metodo rimuove il prestito dall'archivio dei prestiti attivi,
 * incrementa il numero di copie disponibili del libro e
 * inserisce il prestito nella cronologia impostando lo stato a CHIUSO.
 *
 * @param p Prestito attivo da eliminare
 * @return Il prestito eliminato oppure null se non presente
 *
 * @throws ValidazioneException se il prestito fornito è nullo
 *
 * @pre p != null
 * @post se presente, il prestito viene rimosso dai prestiti attivi
 *       e aggiunto alla cronologia
 */
    public Prestito eliminaPrestitoAttivo(Prestito p) throws ValidazioneException {

        if (p == null) {
            throw new ValidazioneException("Prestito nullo.");
        }

        Prestito rimosso = archivioPrestitiAttivi.rimuoviPrestitoAttivo(p);

        if (rimosso != null) {

            // recupero il libro VERO dall'archivio
            Libro libroArchivio = archivioLibri.ricercaISBN(
                    rimosso.getLibro().getISBN()
            );

            if (libroArchivio == null) {
                throw new IllegalStateException(
                    "Libro non presente in ArchivioLibri"
                );
            }

            // incremento copie SUL LIBRO GIUSTO
            libroArchivio.setCopieDisponibili(
                    libroArchivio.getCopieDisponibili() + 1
            );

            rimosso.setStato(StatoPrestiti.CHIUSO);
            archivioCronologia.aggiungiPrestitoCronologia(rimosso);
            Utente u = rimosso.getUtente();
            u.rimuoviPrestitoAttivo(rimosso);
        }

        try {
            archivioPrestitiAttivi.scriviSuFile("prestitiAttivi.csv");
            archivioLibri.scriviSuFile("libri.csv");
            archivioUtenti.scriviSuFile("utenti.csv");
            archivioCronologia.scriviSuFile("cronologia.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rimosso;
    }

/**
 * @brief Restituisce l'elenco completo dei prestiti attivi.
 *
 * @return Lista dei prestiti attivi presenti in archivio
 *
 * @post la lista restituita rappresenta lo stato corrente
 *       dell'archivio dei prestiti attivi
 */
public List<Prestito> visualizzaPrestitiAttivi() {
    for (Prestito p : archivioPrestitiAttivi.getPrestitiAttivi()) {
        if (prestitoInRitardo(p)) {
            p.setStato(StatoPrestiti.RITARDO);
        }
    }
    return archivioPrestitiAttivi.getPrestitiAttivi();
}
     /**
     * @brief Aggiunge un nuovo prestito effettuando i dovuti controlli
     * @param p Prestito da registrare
     * @throws ValidazioneException se i dati non sono validi
     * 
     * @pre p != null && i dati del prestito sono validi
     * @post il prestito viene aggiunto all'archivio
     */
   public void registraPrestitoCronologia(Prestito p) throws ValidazioneException{
        
        if (p == null) {
            throw new ValidazioneException("Prestito nullo.");
        }

        archivioCronologia.aggiungiPrestitoCronologia(p);
   }
     /**
     * @brief Elimina un prestito esistente
     * @param p Dati del prestito da eliminare
     * 
     * @return il prestito eliminato oppure null se non presente     * @throws ValidazioneException se i campi forniti non sono validi
     * 
     * @pre p != null 
     * @post prestito viene rimosso se esiste
     */
   public Prestito eliminaPrestitoCronologia(Prestito p) throws ValidazioneException{
        if (p == null) {
            throw new ValidazioneException("Prestito nullo.");
        }

        return archivioCronologia.rimuoviPrestitoCronologia(p);
   }
     /**
    * @brief Restituisce l'insieme completo della cronologia dei prestiti
    * @return lista dei prestiti attivi
    */ 
   public List<Prestito> visualizzaCronologia(){ 
        return archivioCronologia.getCronologia();
   }
   public List<Prestito> ricercaPrestitiAttivi(String matricola, String isbn)
        throws ValidazioneException, PrestitoNonTrovatoException {
    return ricercaPrestitiInterna(matricola, isbn, false);
    }
   public List<Prestito> ricercaPrestitiCronologia(String matricola, String isbn)
        throws ValidazioneException, PrestitoNonTrovatoException {
    return ricercaPrestitiInterna(matricola, isbn, true);
}
   
    private List<Prestito> ricercaPrestitiInterna(
         String matricola,
         String isbn,
         boolean cronologia)
         throws ValidazioneException, PrestitoNonTrovatoException {

     matricola = matricola == null ? "" : matricola.trim();
     isbn = isbn == null ? "" : isbn.trim();

     // NESSUN CAMPO
     if (matricola.isEmpty() && isbn.isEmpty()) {
         throw new ValidazioneException(
             "Inserire una matricola oppure un ISBN."
         );
     }

     // CASO 1: MATRICOLA + ISBN
     if (!matricola.isEmpty() && !isbn.isEmpty()) {

         Utente u = archivioUtenti.ricercaMatricola(matricola);
         Libro l = archivioLibri.ricercaISBN(isbn);
        if (u == null || l == null) {
            throw new PrestitoNonTrovatoException("Utente o libro inesistente.");
        }
        
         Prestito trovato = cronologia
             ? archivioCronologia.ricercaPrestitoUtenteLibro(u, l)
             : archivioPrestitiAttivi.ricercaPrestitoAttivo(u, l);

         if (trovato == null) {
             throw new PrestitoNonTrovatoException(
                 "Nessun prestito trovato per questo utente e libro."
             );
         }

         return Collections.singletonList(trovato);
     }

     // CASO 2: SOLO MATRICOLA
     if (!matricola.isEmpty()) {
         Utente u = archivioUtenti.ricercaMatricola(matricola);

         List<Prestito> risultati = cronologia
             ? archivioCronologia.ricercaPrestitoUtenteCronologia(u)
             : archivioPrestitiAttivi.ricercaPrestitoAttivoUtente(u);

         if (risultati.isEmpty()) {
             throw new PrestitoNonTrovatoException(
                 "Nessun prestito trovato per questo utente."
             );
         }
         return risultati;
     }

     // CASO 3: SOLO ISBN
     Libro l = archivioLibri.ricercaISBN(isbn);

     List<Prestito> risultati = cronologia
         ? archivioCronologia.ricercaPrestitoLibroCronologia(l)
         : archivioPrestitiAttivi.ricercaPrestitoAttivoLibro(l);

     if (risultati.isEmpty()) {
         throw new PrestitoNonTrovatoException(
             "Nessun prestito trovato per questo libro."
         );
     }

     return risultati;
 }

    public boolean prestitoInRitardo(Prestito p) {

         if (p == null) return false;

         if (p.getStato() != StatoPrestiti.ATTIVO) return false;

    return LocalDate.now().isAfter(p.getDataFine());
    }

}
