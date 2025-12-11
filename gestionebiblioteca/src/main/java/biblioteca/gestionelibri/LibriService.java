/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.gestionelibri;
import biblioteca.gestioneeccezioni.DuplicatoException;
import biblioteca.gestioneeccezioni.ValidazioneException;
import biblioteca.gestioneeccezioni.CancellazionePrestitoAttivoException;
import biblioteca.gestioneeccezioni.LibroNonTrovatoException;
import java.time.Year;
import java.util.Set;
import java.util.Collections;

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
     * @throws DuplicatoException se esiste già un libro con lo stesso ISBN
     * 
     * @pre l != null 
     * @post il libro viene aggiunto all'archivio
     */
    public void registraLibro(Libro l) throws ValidazioneException, DuplicatoException{
    // --- Validazioni ---
    if (l.getTitolo() == null || l.getTitolo().trim().isEmpty())
        throw new ValidazioneException("Titolo non valido.");

    if (l.getAutore() == null || l.getAutore().trim().isEmpty())
        throw new ValidazioneException("Autore non valido.");

    if (l.getISBN() == null || l.getISBN().trim().isEmpty() || ( l.getISBN().length() != 10 && l.getISBN().length() != 13))
        throw new ValidazioneException("ISBN non valido.");

    if (l.getCopieDisponibili() < 0)
        throw new ValidazioneException("Numero copie disponibili non valido.");
    
    int annoCorrente = Year.now().getValue();

    if (l.getAnnoPubblicazione()< 0 || l.getAnnoPubblicazione() > annoCorrente) {
        throw new ValidazioneException("L'anno di pubblicazione non  valido");
    }

    // --- Controllo duplicato ---
    Libro l1= archivioLibri.ricercaISBN(l.getISBN());
    if(l1!= null) throw new DuplicatoException("Esiste già un libro con questo ISBN.");

    // --- Aggiunta all’archivio ---
    archivioLibri.aggiungiLibro(l);
    }
     /**
     * @brief Elimina un libro esistente
     * @param l Dati del libro da eliminare
     * @return Il libro eliminato (oppure null)
     * @throws CancellazionePrestitoAttivoException se il libro ha prestiti attivi
     * 
     * @pre l != null 
     * @pre il libro non deve avere prestiti attivi
     * @post libro viene rimosso se esiste
     */
    public Libro eliminaLibro(Libro l) throws CancellazionePrestitoAttivoException{
    
    //MANCA IL CONTROLLO SUL PRESTITO ATTIVO.    
    // Elimina il libro dal tuo archivio
    Libro rimosso = archivioLibri.rimuoviLibro(l);
    return rimosso;
    }
 /**
 * @brief Esegue una ricerca libro in base ai campi forniti (titolo, autore, ISBN).
 *
 * La ricerca segue la seguente priorità:
 * - Se è stato inserito l'ISBN, viene effettuata la ricerca per ISBN.
 * - Altrimenti, se è stato inserito il titolo, viene effettuata la ricerca per titolo.
 * - Altrimenti, se è stato inserito l'autore, viene effettuata la ricerca per autore.
 *
 * @param titolo Titolo da cercare (può essere vuoto)
 * @param autore Autore da cercare (può essere vuoto)
 * @param isbn ISBN da cercare (può essere vuoto)
 * 
 * @return L'insieme dei libri trovati (può contenere un solo libro in caso di ricerca per ISBN)
 *
 * @throws ValidazioneException se tutti i campi sono vuoti o non validi
 * @throws LibroNonTrovatoException se nessun libro corrisponde ai criteri
 *
 * @pre Almeno uno tra titolo, autore o ISBN deve essere compilato.
 * @post Restituisce l'insieme dei libri trovati secondo il criterio di ricerca applicato.
 */
public Set<Libro> ricercaLibro(String titolo, String autore, String isbn)
        throws ValidazioneException, LibroNonTrovatoException {

    titolo = titolo == null ? "" : titolo.trim();
    autore = autore == null ? "" : autore.trim();
    isbn   = isbn   == null ? "" : isbn.trim();

    if (titolo.isEmpty() && autore.isEmpty() && isbn.isEmpty()) {
        throw new ValidazioneException("Inserire almeno un campo per la ricerca.");
    }

    // PRIORITÀ 1: ISBN
    if (!isbn.isEmpty()) {
        Libro trovato = archivioLibri.ricercaISBN(isbn);
        if (trovato == null) {
            throw new LibroNonTrovatoException("Nessun libro trovato con questo ISBN.");
        }
        return Collections.singleton(trovato);
    }

    // PRIORITÀ 2: Titolo
    if (!titolo.isEmpty()) {
        Set<Libro> trovati = archivioLibri.ricercaTitolo(titolo);
        if (trovati == null || trovati.isEmpty()) {
            throw new LibroNonTrovatoException("Nessun libro trovato con questo titolo.");
        }
        return trovati;
    }

    // PRIORITÀ 3: Autore
    Set<Libro> trovati = archivioLibri.ricercaAutore(autore);
    if (trovati == null || trovati.isEmpty()) {
        throw new LibroNonTrovatoException("Nessun libro trovato per questo autore.");
    }

    return trovati;
}

/**
 * @brief Modifica un libro già esistente nell’archivio.
 *
 * Questo metodo applica le modifiche già presenti nell’oggetto libro passato
 * come parametro, dopo aver effettuato i necessari controlli di validità.
 * Viene controllato che l'anno non sia futuro, che il numero di copie non
 * sia negativo e che l'ISBN non sia duplicato.
 *
 * @param libro Il libro già modificato (tramite tabella) da validare e salvare.
 *
 * @throws ValidazioneException Se uno dei campi è invalido.
 * @throws DuplicatoException Se un altro libro con lo stesso ISBN esiste già.
 *
 * @pre libro != null
 * @post Le modifiche vengono salvate nell’archivio, se valide.
 */
public void modificaLibro(Libro libro, String isbnOriginale)
        throws ValidazioneException, DuplicatoException {

    if (libro == null) {
        throw new ValidazioneException("Il libro non può essere nullo.");
    }

    // --- Controllo campi vuoti ---
    if (libro.getTitolo() == null || libro.getTitolo().trim().isEmpty())
        throw new ValidazioneException("Il titolo non può essere vuoto.");

    if (libro.getAutore() == null || libro.getAutore().trim().isEmpty())
        throw new ValidazioneException("L'autore non può essere vuoto.");

    if (libro.getISBN() == null || libro.getISBN().trim().isEmpty())
        throw new ValidazioneException("L'ISBN non può essere vuoto.");

    // --- Controllo ISBN valido ---
    String isbn = libro.getISBN().trim();
    if (isbn.length() != 10 && isbn.length() != 13)
        throw new ValidazioneException("L'ISBN deve essere di 10 o 13 cifre.");

    // --- Controllo anno ---
    int anno = libro.getAnnoPubblicazione();
    if (anno < 0 || anno > java.time.Year.now().getValue()) {
        throw new ValidazioneException("Anno di pubblicazione non valido");
    }

    // --- Controllo copie ---
    if (libro.getCopieDisponibili() < 0) {
        throw new ValidazioneException("Il numero di copie non può essere negativo.");
    }

    // --- Controllo ISBN duplicato solo se modificato ---
    if (!isbn.equals(isbnOriginale)) {
        Libro esistente = archivioLibri.ricercaISBN(isbn);
        if (esistente != null) {
            throw new DuplicatoException("Esiste già un libro con questo ISBN.");
        }
    }
}


    /**
    * @brief Restituisce l'insieme completo dei libri
    * @return Set ordinato dei libri
    * 
    * @post restituisce una copia dell’archivio
    */ 
public Set<Libro> visualizzaLibri(){ 
    return archivioLibri.getLibri();
}
    
}
