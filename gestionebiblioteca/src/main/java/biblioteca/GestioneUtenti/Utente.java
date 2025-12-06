
package biblioteca.GestioneUtenti;
import biblioteca.GestionePrestiti.Prestito;
import java.util.List;
import java.util.ArrayList;
/**
 * @class Utente
 * @brief Rappresenta un utente del sistema bibliotecario
 * 
 * Questa classe contiene i dati dell'utente 
 * e le operazioni per gestire la lista dei prestiti attivi.
 * Tutti i controlli sono stati affidati alla classe {@see UtenteService}
 * 
 */
public class Utente implements Comparable<Utente>{
    
    /** Nome dell'utente */
    private String nome;
    
    /** Cognome dell'utente */
    private String cognome;
    
    /** Matricola univoca dell'utente */
    private int matricola;
    
    /** Email dell'utente */
    private String email;
    
    /** Lista dei prestiti attivi dell'utente */
    private List<Prestito> prestitiAttivi;
    
    /** 
     * @brief Costruttore della classe Utente
     * @param nome Nome dell'utente
     * @param cognome Cognome dell'utente
     * @param matricola Matricola univoca dell'utente
     * @param email Email dell'utente
     * 
     * @pre Tutti i controlli sono stati affidati alla classe {@link UtentiService}.
     * @post L'utente è inizializzato con lista dei prestiti vuota
     * 
     */
    public Utente(String nome,String cognome, int matricola, String email){
        this.nome=nome;
        this.cognome=cognome;
        this.matricola=matricola;
        this.email=email;
        this.prestitiAttivi = new ArrayList<>(); 
    }

    /**
     * @return Il nome dell'utente
     */
    public String getNome() {
        return nome;
    }
    
    /**
     *@brief Imposta un nuovo nome per l'utente
     * 
     * @param nome Nuovo nome.
     * @pre nome != null && !nome.isEmpty()
     * @post Il nome viene aggiornato
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

     /**
     * @return Il cognome dell'utente
     */
    public String getCognome() {
        return cognome;
    }

     /**
     *@brief Imposta un nuovo cognome
     * 
     * @param cognome Nuovo cognome
     * @pre cognome !=null && !cognome.isEmpty() 
     * @post Il cognome viene aggiornato
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return La matricola dell'utente
     */
    public int getMatricola() {
        return matricola;
    }

    /**
     *@brief Imposta una nuova matricola
     * 
     * @param matricola Nuova matricola.
     * @pre matricola > 0; l’univocità è garantita da UtentiService
     * @post La matricola viene aggiornata
     */
    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

        /**
     * @return L'email dell'utente
     */
    public String getEmail() {
        return email;
    }

     /**
     *@brief Imposta una nuova email 
     * 
     * @param email Nuova email. 
     * @pre email!= null && !email.isEmpty()
     * @post L'email viene aggiornata
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * @brief Aggiunge un prestito 
     * @param p Prestito da aggiungere
     * 
     * @pre prestitiAttivi.size()<3
     * @post prestitiAttivi contiene p
     */
    public void aggiungiPrestitoAttivo(Prestito p){
    }
    /**
     * @brief Rimuove un prestito attivo
     * @param p Prestito da rimuovere
     * 
     * @pre !prestitiAttivi.isEmpty()
     * @post prestitiAttivi non contiene più p
     */
    public void rimuoviPrestitoAttivo(Prestito p){
    }
    /**
     * @return lista dei prestiti attivi
     */
    public List<Prestito> getPrestitiAttivi() {
        return prestitiAttivi;
    }
    
    /**
     *@return Una rappresentazione leggibile dell'utente
     */
    @Override
    public String toString(){
    return null;
    }
    
    /**
     * @brief Due utenti sono uguali se hanno la stessa matricola
     */
    @Override
    public boolean equals(Object o){
        return true;
    }
    /**
     * @brief hash coerente con equals(basato sulla matricola)
     */
    @Override
    public int hashCode(){
    return 0;
    }
    /**
     * @brief Ordina per cognome, a parità di cognome, per nome.
     * @param u1 altro utente
     */
    @Override
    public int compareTo(Utente u1){
    return 0;
    }
    
    
    
}
