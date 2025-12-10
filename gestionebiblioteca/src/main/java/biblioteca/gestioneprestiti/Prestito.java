
package biblioteca.gestioneprestiti;
import biblioteca.gestioneutenti.Utente;
import biblioteca.gestionelibri.Libro;
import java.time.LocalDate;
/**
 * @class Prestito
 * @brief Rappresenta un prestito del sistema bibliotecario
 * 
 * Questa classe contiene solo i dati del prestito
 * Tutti i controlli sono stati affidati alla classe {@link PrestitoService}
 * 
 * @author Gerardo
 */
public class Prestito {
    /** Identificativo del prestito*/
    private final int id;
    /** contatore per aggiornare l'id del prestito*/
    private static int cont=0;
    /** dati dell'Utente*/
    private Utente utente;
    /** Dati del libro*/
    private Libro libro;
    /** data inizio prestito*/
    private LocalDate dataInizio;
    /** data fine prestito, restituzione libro*/
    private LocalDate dataFine;
    /** stato del prestito (attivo,ritardo,chiuso)*/
    private StatoPrestiti stato;
    
    /**
     * @brief Costruttore di inserimento della classe Prestito
     * @param utente Dati dell'utente
     * @param libro Dati del libro
     * @param dataInizio Data di inizio prestito
     * @param dataFine Data di fine prestito, restituzione libro
     * 
     * @pre I dati passati devono essere validi (controllo gestito da PrestitoService)     * @pre stato del prestito attivo
     * @post Il prestito è inizializzato
     */
    public Prestito(Utente utente,Libro libro, LocalDate dataInizio, LocalDate dataFine){
        this.id=++cont;
        this.utente=utente;
        this.libro=libro;
        this.dataInizio= dataInizio;
        this.dataFine= dataFine;
        this.stato=StatoPrestiti.ATTIVO;
    }
     /**
     * @brief Costruttore di caricamento da file della classe Prestito
     * @param id Identificativo del prestito
     * @param utente Dati dell'utente
     * @param libro Dati del libro
     * @param dataInizio Data di inizio prestito
     * @param dataFine Data di fine prestito, restituzione libro
     * @param stato lo stato del prestito(attivo,chiuso,ritardo)
     * 
     * @pre {@link PrestitoService} deve garantire tutti i controlli sui dati
     * @post Il prestito è preso da file
     */
    public Prestito(int id,Utente utente,Libro libro,LocalDate dataInizio,LocalDate dataFine, StatoPrestiti stato){
        this.id=id;
        this.utente=utente;
        this.libro=libro;
        this.dataInizio=dataInizio;
        this.dataFine=dataFine;
        this.stato=stato;
    }
    /**
    * @brief Imposta il valore del contatore degli ID
    * Questo metodo viene utilizzato dopo aver caricato da file
    * l'ultimo ID assegnato, così che il contatore interno non
    * riparta da 0 ma continui correttamente dalla posizione salvata.
    * 
    * @param val l'ultimo ID letto da file (nuovo valore del contatore)
    * 
    * @pre val deve essere un intero >= 0 e rappresentare un ID valido
    * già presente nei dati caricati.
    * @post Il contatore interno della classe avrà valore pari a `val`.
     */
    public static void setContatore(int val){
    }
     /**
     * @return I dati dell'utente
     */
    public Utente getUtente() {
        return utente;
    }
    /**
     *@brief Imposta un nuovo utente per il prestito
     * 
     * @param utente Nuovo utente.
     * 
     * @pre utente != null 
     * @post L'utente viene aggiornato
     */
    public void setUtente(Utente utente) {
        this.utente = utente;
    }
     /**
     * @return I dati del libro
     */
    public Libro getLibro() {
        return libro;
    }
     /**
     *@brief Imposta un nuovo libro per il prestito
     * 
     * @param libro Nuovo libro.
     * @pre libro != null
     * @post Il libro viene aggiornato
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    /**
     * @return Data di inizio prestito
     */
    public LocalDate getDataInizio() {
        return dataInizio;
    }
     /**
     *@brief Imposta una nuova data di inizio prestito
     * 
     * @param dataInizio Nuova data di inizio.
     * @pre dataInizio != null 
     * @post La data di inizio prestito viene aggiornata
     */
    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }
    /**
     * @return Data di fine prestito
     */
    public LocalDate getDataFine() {
        return dataFine;
    }
     /**
     *@brief Imposta una nuova data fine prestito
     * 
     * @param dataFine Nuova data fine prestito.
     * @pre dataFine != null 
     * @post La data di fine prestito viene aggiornata
     */
    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }
    /**
     * @return Stato del prestito
     */
    public StatoPrestiti getStato() {
        return stato;
    }
     /**
     *@brief Imposta una nuovo stato del prestito
     * 
     * @param stato Nuovo stato del prestito
     * @pre stato != null 
     * @post Lo stato del prestito viene aggiornato
     */
    public void setStato(StatoPrestiti stato) {
        this.stato = stato;
    }
    
    
}
