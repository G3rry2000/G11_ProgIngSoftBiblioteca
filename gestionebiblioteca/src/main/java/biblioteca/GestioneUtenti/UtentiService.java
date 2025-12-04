/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestioneUtenti;
import biblioteca.gestioneEccezioni.*;

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
    /**
     * @brief Costruttore del Service 
     * @param archivioUtenti archivio da usare come dati
     * 
     * @pre archivioutenti != null
     * @post this.archivioUtenti ==archivioUtenti
     */
    public UtentiService(ArchivioUtenti archivioUtenti){
        this.archivioUtenti = archivioUtenti;
    }
    /**
     * @brief Aggiunge un nuovo utente effettuando i dovuti controlli
     * @param u Utente da registrare
     * @throws ValidazioneException se i dati non sono validi
     * @throws DuplicatoException se esuste guà un utente con la stesas matricola
     * 
     * @pre u != null
     * @pre tutti i campi di u validi
     * @post l'utente viene aggiunto all'archivio
     */
    public void registraUtente(Utente u) throws ValidazioneException, DuplicatoException{
    }
    /**
     * @brief Elimina un utente esistente
     * @param u Dati dell'utente da eliminare
     * @return l'utente eliminato
     * @throws ValidazioneException se i campi forniti non sono validi
     * @throws CancellazionePrestitoAttivoException se l'utente ha prestiti attivi
     * 
     * @pre u!= null
     * @pre l'utente non deve avere prestiti attivi
     * @post utente viene rimosso se esiste
     */
    public Utente eliminaUtente(Utente u)throws ValidazioneException, CancellazionePrestitoAttivoException{
    return null;
    }
    /**
     * @brief Cerca utenti per cognome
     * @param cognome Cognome da cercare
     * @return Insieme degli utenti con quel cognome
     * @throws ValidazioneException se il cognome è vuoto
     * @throws UtenteNonTrovatoException se nessun utente è stato trovato
     * 
     * @pre cognome != null && !cognome.isEmpty(
     * @post trova l'insieme degli utenti trovati
     */
    public Set<Utente> cercaUtentePerCognome(String cognome) throws ValidazioneException, UtenteNonTrovatoException{
    return null;
    }
     /**
     * @brief Cerca un utente tramite la matricola
     * @param matricola Matricola da cercare
     * @return l'utente trovato
     * @throws UtenteNonTrovatoException se la matricola non esiste
     * @throws ValidazioneException se la matricola non è valida
     * 
     * @pre matricola >0 
     * @post restituisce l'utente con quella matricola
     */
    public Utente cercaUtentePerMatricola(int matricola) throws ValidazioneException, UtenteNonTrovatoException{
    return null;
    }    
    /**
    * @brief Aggiorna un utente esistente
    * @param u Utente aggiornato
    * @return true se aggiornamento riuscito, false altrimenti
    * @throws ValidazioneException se i dati inseriti non sono validi
    * 
    * @pre u!=null
    */
    public boolean aggiornaUtente(Utente u) throws ValidazioneException{
    return false;
    }
     /**
    * @brief Restituisce l'insieme completo degli utenti
    * @return Set ordinato degli utenti
    */  
   public Set<Utente> visualizzaUtenti(){ 
   return null;
   }
    
    
}
