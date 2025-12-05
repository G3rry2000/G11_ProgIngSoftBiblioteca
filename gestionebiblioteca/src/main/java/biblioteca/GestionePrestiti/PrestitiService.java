/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestionePrestiti;

import biblioteca.GestioneLibri.ArchivioLibri;
import biblioteca.GestioneLibri.Libro;
import biblioteca.GestioneUtenti.ArchivioUtenti;
import biblioteca.GestioneUtenti.Utente;
import biblioteca.gestioneEccezioni.*;
import java.util.List;
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
     * @brief Aggiunge un nuovo prestito attivo effettuando i dovuti controlli
     * @param p Prestito da registrare
     * @throws ValidazioneException se i dati non sono validi
     * @throws LibroNonDisponibile se il libro non è attualmente disponibile (NumeroCopie >0)
     * @throws LimitePrestitoSuperato se l'utente ha suparato il limite prestito consentito (PrestitiAttivi positivo <3)
     * 
     * @pre p != null 
     * @post il prestito attivo viene aggiunto all'archivio
     */
    public void registraPrestitoAttivo(Prestito p) throws ValidazioneException, LibroNonDisponibileException, LimitePrestitoSuperatoException{
   }
      /**
     * @brief Elimina un prestito attivo esistente (libro restituito)
     * @param p Dati del prestito attivo da eliminare
     * @return Prestito attivo da eliminare
     * @throws ValidazioneException se i campi forniti non sono validi
     * 
     * @pre p != null 
     * @post prestito viene rimosso se esiste
     */
   public Prestito eliminaPrestitoAttivo(Prestito p)throws ValidazioneException{
   return null;
   }
   /**
     * @brief Cerca prestito attivo per dati (matricola) utente e dati (ISBN) libro
     * @param utente Dati (matricola) di utente
     * @param libro Dati (ISBN) di libro
     * 
     * @return Il prestito attivo per matricola e ISBN
     * @throws ValidazioneException se i dati non sono validi
     * @throws PrestitoNonTrovatoException se nessun prestito è stato trovato
     * 
     * @pre utente != null  &&  libro != null 
     * @post trova il prestito attivo corrispondente
    */
   public Prestito cercaPrestitoAttivo(Utente utente, Libro libro)throws ValidazioneException, PrestitoNonTrovatoException{
   return null;
   }
    /**
    * @brief Restituisce l'insieme completo dei prestiti attivi
    * @return Set ordinato dei prestiti attivi
    */ 
   public List<Prestito> visualizzaPrestitiAttivi(){ 
   return null;
   }
     /**
     * @brief Aggiunge un nuovo prestito effettuando i dovuti controlli
     * @param p Prestito da registrare
     * @throws ValidazioneException se i dati non sono validi
     * 
     * @pre p != null && 
     * @post il prestito viene aggiunto all'archivio
     */
   public void registraPrestitoCronologia(Prestito p) throws ValidazioneException{
   }
     /**
     * @brief Elimina un prestito esistente
     * @param p Dati del prestito da eliminare
     * 
     * @return Prestito da eliminare
     * @throws ValidazioneException se i campi forniti non sono validi
     * 
     * @pre p != null 
     * @post prestito viene rimosso se esiste
     */
   public Prestito eliminaPrestitoCronologia(Prestito p) throws ValidazioneException{
   return null;
   }
     /**
     * @brief Cerca prestito per dati (matricola) utente
     * @param utente Dati (matricola) di utente
     * 
     * @return L'insieme dei prestiti per utente
     * @throws ValidazioneException se i dati non sono validi
     * @throws PrestitoNonTrovatoException se nessun prestito è stato trovato
     * 
     * @pre utente != null 
     * @post trova l'insieme dei prestiti corrispondenti
    */
   public List<Prestito> cercaPrestitoUtenteCronologiaPerUtente(Utente utente) throws ValidazioneException, PrestitoNonTrovatoException{
   return null;
   }
        /**
     * @brief Cerca prestito per dati (ISBN) libro
     * @param libro Dati (ISBN) di libto
     * 
     * @return L'insieme dei prestiti per libro
     * @throws ValidazioneException se i dati non sono validi
     * @throws PrestitoNonTrovatoException se nessun prestito è stato trovato
     * 
     * @pre libro != null 
     * @post trova l'insieme dei prestiti corrispondenti
    */
    public List<Prestito> ricercaPrestitoLibroCronologiaPerLibro(Libro libro) throws ValidazioneException, PrestitoNonTrovatoException{
   return null;
   }
     /**
    * @brief Restituisce l'insieme completo della cronologia dei prestiti
    * @return Set ordinato della cronologia dei prestiti
    */ 
   public List<Prestito> visualizzaCronologia(){ 
   return null;
   }
    
}
