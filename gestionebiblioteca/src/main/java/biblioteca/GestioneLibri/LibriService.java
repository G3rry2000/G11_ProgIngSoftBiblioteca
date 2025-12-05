/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestioneLibri;
import java.util.Set;
import biblioteca.gestioneEccezioni.*;

/**
 * @class LibriService
 * @brief Service che esegue la validazione dei dati dei libri.
 *
 * Effettua i controlli su:
 * - titolo, autore, anno di Pubblicazione e copie disponibili
 * - ISBN non vuoto, univoco e con formato valido
 * - numero di copie disponibile >0
 *
 * Le operazioni vengono delegate a ArchivioLibri.
 */
public class LibriService {
    /**
     * Archivio dei libri su cui operare
     */
    private ArchivioLibri archivioLibri;
     /**
     * @brief Costruttore del Service 
     * @param archivioLibri archivio dei libri da usare come dati
     * 
     * @pre archivioLibri != null
     * @post this.archivioLibri==archivioLibri
     */
    public LibriService(ArchivioLibri archivioLibri){
        this.archivioLibri = archivioLibri;
    }
     /**
     * @brief Aggiunge un nuovo libro effettuando i dovuti controlli
     * @param l Libro da registrare
     * @throws ValidazioneException se i dati non sono validi
     * @throws DuplicatoException se esiste già un utente con lo stesso ISBN
     * 
     * @pre l != null 
     * @post il libro viene aggiunto all'archivio
     */
    public void registraLibro(Libro l) throws ValidazioneException, DuplicatoException{
    }
     /**
     * @brief Elimina un libro esistente
     * @param l Dati del libro da eliminare
     * @return Libro da eliminare
     * @throws ValidazioneException se i campi forniti non sono validi
     * @throws CancellazionePrestitoAttivoException se il libro ha prestiti attivi
     * 
     * @pre l != null 
     * @pre il libro non deve avere prestiti attivi
     * @post libro viene rimosso se esiste
     */
    public Libro eliminaLibro(Libro l) throws ValidazioneException, CancellazionePrestitoAttivoException{
    return null;
    }
     /**
     * @brief Cerca libro per titolo
     * @param titolo Titolo da cercare
     * @return Insieme dei libri con quel titolo
     * @throws ValidazioneException se il titolo non è valido
     * @throws LibroNonTrovatoException se nessun libro è stato trovato
     * 
     * @pre titolo != null && !titolo.isEmpty()
     * @post trova l'insieme dei libri trovati
     */
    public Set<Libro> cercaLibroPerTitolo(String titolo) throws ValidazioneException, LibroNonTrovatoException{
    return null;
    }
     /**
     * @brief Cerca un libro tramite l'ISBN
     * @param ISBN ISBN da cercare
     * @return il libro trovato
     * @throws LibroNonTrovatoException se il libro non esiste
     * @throws ValidazioneException se il libro non è valido
     * 
     * @pre ISBN univoco, ISBN != null && !ISBN.isEmpty()
     * @post restituisce il libro con quel ISBN
     */
    public Libro cercaLibroPerISBN(String ISBN) throws LibroNonTrovatoException, ValidazioneException{
    return null;
    }
     /**
     * @brief Cerca libro per autore
     * @param autore Autore da cercare
     * @return Insieme dei libri con quell'autore
     * @throws ValidazioneException se l'autore non è valido
     * @throws LibroNonTrovatoException se nessun libro è stato trovato
     * 
     * @pre autore != null && !autore.isEmpty()
     * @post trova l'insieme dei libri trovati
     */
    public Set<Libro> cercaLibroPerAutore(String autore)throws LibroNonTrovatoException, ValidazioneException{
    return null;
    }
     /**
    * @brief Aggiorna un libro esistente
    * @param l Libro aggiornato
    * @return true se aggiornamento riuscito, false altrimenti
    * @throws ValidazioneException se i dati inseriti non sono validi
    * 
    * @pre l!=null
    */
    public boolean aggiornaLibro(Libro l) throws ValidazioneException{
    return true;
    }
    /**
    * @brief Restituisce l'insieme completo dei libri
    * @return Set ordinato dei libri
    */ 
   public Set<Libro> visualizzaLibri(){ 
   return null;
   }
    
}
