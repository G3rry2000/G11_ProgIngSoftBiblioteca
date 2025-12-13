package biblioteca.gestioneutenti;

import biblioteca.gestioneeccezioni.DuplicatoException;
import biblioteca.gestioneeccezioni.ValidazioneException;
import biblioteca.gestioneeccezioni.UtenteNonTrovatoException;
import biblioteca.gestioneeccezioni.CancellazionePrestitoAttivoException;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

/**
 * @class UtentiService
 * @brief Service che esegue la validazione dei dati degli utenti.
 *
 * Effettua i controlli su:
 * - nome e cognome non vuoti
 * - email non vuota e con formato valido
 * - matricola non vuota, univoca e con formato valido
 * - massimo 3 prestiti attivi
 *
 * Le operazioni vengono delegate a ArchivioUtenti.
 */

public class UtentiService {
    /**
     * Archivio degli utenti su cui operare
     */
    private ArchivioUtenti archivioUtenti;
    private String filename = "utenti.csv";
    /**
     * @brief Costruttore del Service 
     * @param archivioUtenti archivio degli utenti da usare come dati
     * 
     * @pre archivioUtenti != null
     * @post this.archivioUtenti ==archivioUtenti
     */
    public UtentiService(ArchivioUtenti archivioUtenti){
        this.archivioUtenti = archivioUtenti;
    }
    /**
     * @brief Aggiunge un nuovo utente effettuando i dovuti controlli
     * @param u Utente da registrare
     * @throws ValidazioneException se i dati non sono validi
     * @throws DuplicatoException se esiste già un utente con la stessa matricola
     * 
     * @pre u != null
     * @post l'utente viene aggiunto all'archivio
     */
    public void registraUtente(Utente u) throws ValidazioneException, DuplicatoException{
    if(u.getNome() == null || u.getNome().trim().isEmpty()){
        throw new ValidazioneException("Nome non valido");
    }
    if(u.getCognome() == null || u.getCognome().trim().isEmpty()){
        throw new ValidazioneException("cognome non valido");
    }
    String matricola = u.getMatricola();

    if (matricola == null || matricola.isEmpty()) {
        throw new ValidazioneException("La matricola non può essere vuota");
    }

    // Controllo che ci siano solo numeri
    if (!matricola.matches("\\d+")) {
        throw new ValidazioneException("La matricola deve contenere solo cifre");
    }

    // Controllo la lunghezza esatta
    if (matricola.length() != 10) {
        throw new ValidazioneException("La matricola deve essere composta da 10 cifre");
    }
    if(u.getEmail() == null || u.getEmail().trim().isEmpty()){
        throw new ValidazioneException("email non valida");
    }
    if(!u.getEmail().endsWith(".unisa.it")){
        throw new ValidazioneException("l'email deve essere istituzionale");
    }
    
    //--- Controllo duplicato ---
    Utente u1 = archivioUtenti.ricercaMatricola(u.getMatricola());
    if(u1 != null){
        throw new DuplicatoException("Esiste già un utente con questa matricola");
    }
    
    // --- Aggiunta all'archivio ---
    archivioUtenti.aggiungiUtente(u);
        try {
         archivioUtenti.scriviSuFile(filename);
        } catch(IOException e) {
         e.printStackTrace();
        }
    }
    /**
     * @brief Elimina un utente esistente
     * @param u Utente da eliminare
     * @return l'utente eliminato
     * @throws ValidazioneException se i campi forniti non sono validi
     * @throws CancellazionePrestitoAttivoException se l'utente ha prestiti attivi
     * 
     * @pre u != null 
     * @pre l'utente non deve avere prestiti attivi
     * @post utente viene rimosso se esiste
     */
    public Utente eliminaUtente(Utente u) throws CancellazionePrestitoAttivoException{
    if(u.getPrestitiAttivi()!= null && !u.getPrestitiAttivi().isEmpty()){
        throw new CancellazionePrestitoAttivoException("impossibile eliminare l'utente, ha ancora" + u.getPrestitiAttivi().size() + "prestiti attivi");
    }
        try {
         archivioUtenti.scriviSuFile(filename);
        } catch(IOException e) {
         e.printStackTrace();
        }
    return archivioUtenti.rimuoviUtente(u);
    }

    /**
     * @brief Esegue una ricerca utente in base ai campi forniti (cognome, matricola).
     * La ricerca segue la seguente priorità:
     * - Se è stata inserita la matricola,viene effettuata la ricerca per matricola.
     * - Altrimenti, se è stato inserito il cognome, viene effettuata la ricerca per cognome.
     * 
     * @param cognome Cognome da cercare(può essere vuoto)
     * @param matricola Matricola da cercare (può essere 0)
     * 
     * @return L'insieme deigli utenti trovati (può contenere un solo utente in caso di ricerca per matricola)
     * 
     * @throws ValidazioneException se tutti i campi sono vuoti o non validi
     * @throws UtenteNonTrovatoException se nessun utente corrisponde ai criteri
     * 
     * @pre Almeno uno tra cognome o matricola deve essere compilato.
     * @post Restituisce l'insieme degli utenti trovati secondo il criterio di ricerca applicato.
     */
    public Set<Utente> ricercaUtente(String cognome, String matricola) throws ValidazioneException, UtenteNonTrovatoException{
     cognome = cognome == null ? "" : cognome.trim();
     matricola = matricola == null ? "" : matricola.trim();
     
      if (cognome.isEmpty() && matricola.isEmpty()) {
        throw new ValidazioneException("Inserire almeno un campo per la ricerca.");
    }
     
     //PRIORITÀ 1: Matricola
     if(!matricola.isEmpty()){
         Utente trovato = archivioUtenti.ricercaMatricola(matricola);
         if(trovato == null){
             throw new UtenteNonTrovatoException("Nessun utente con questa matricola.");
         }
         return Collections.singleton(trovato);
     }
     
     // PRIORITÀ 2: Cognome
     Set<Utente> trovati = archivioUtenti.ricercaCognome(cognome);
     if (trovati == null || trovati.isEmpty()){
         throw new UtenteNonTrovatoException("nessun utente trovato con questo cognome.");
     }
     
     return trovati;
    }
    /**
     * @brief Modifica un utente già esistente nell'archivio.
     * 
     * Questo metodo applica le modifiche già presenti nell'oggetto utente passato 
     * come parametro, dopo aver effettuato i necessari controlli di validità.
     * Viene controllato anche che la matricola non sia duplicata.
     *
     * @param utente L'utente già modificato(tramite tabella) da validare e salvare.
     * @param matricolaOriginale la matricola originale dell'utente prima della modifica
     * 
     * @throws ValidazioneException Se uno dei campi non è valido.
     * @throws DuplicatoException Se un altro utente con la stessa matricola esiste già.
     * 
     * @pre utente != null
     * @post Le modificge vengono salvate nell'archivio, se valide.
     */  
        public void modificaUtente(Utente utente, String matricolaOriginale) 
            throws ValidazioneException, DuplicatoException {

        if (utente == null) {
            throw new ValidazioneException("l'utente non può essere nullo.");
        }

        // --- Validazione solo sui campi effettivamente presenti ---
        if (utente.getNome() == null || utente.getNome().trim().isEmpty()) {
            throw new ValidazioneException("il nome non può essere vuoto");
        }

        if (utente.getCognome() == null || utente.getCognome().trim().isEmpty()) {
            throw new ValidazioneException("il cognome non può essere vuoto");
        }

        if (utente.getEmail() == null || utente.getEmail().trim().isEmpty()) {
            throw new ValidazioneException("l'email non può essere vuota");
        }

        if (!utente.getEmail().endsWith(".unisa.it")) {
            throw new ValidazioneException("l'email deve terminare con @unisa.it");
        }

        // --- Validazione matricola ---
        String matricola = utente.getMatricola();

        if (matricola == null || matricola.isEmpty()) {
            throw new ValidazioneException("La matricola non può essere vuota");
        }

        if (!matricola.matches("\\d{10}")) {
            throw new ValidazioneException("La matricola deve essere composta da 10 cifre");
        }

        // --- Controllo duplicati SOLO se modificata ---
        if (!matricola.equals(matricolaOriginale)) {
            Utente esistente = archivioUtenti.ricercaMatricola(matricola);
            if (esistente != null) {
                throw new DuplicatoException("esiste già un utente con questa matricola");
            }
        }
        try {
         archivioUtenti.scriviSuFile(filename);
        } catch(IOException e) {
         e.printStackTrace();
        }
    }

    
    /**
     * @brief Restituisce l'insieme completo degli utenti
     * @return Set ordinato degli utenti
     * 
     * @post restituisce una copia dell'archivio
     */  
   public Set<Utente> visualizzaUtenti(){ 
   return archivioUtenti.getUtenti();
   }
    
    
}
