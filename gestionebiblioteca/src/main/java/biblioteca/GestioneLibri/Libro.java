/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestioneLibri;
/**
 * @class Libro
 * @brief Rappresenta un libro del sistema bibliotecario
 * 
 * Questa classe contiene i dati del libro
 * Tutti i controlli sono stati affidati alla classe {@link LibriService}
 * 
 * @author Gerardo
 */


public class Libro implements Comparable<Libro>{
    
    /** Titolo del libro */
    private String titolo;
    /** Autore del libro */
    private String autore;
    /** Anno di pubblicazione del libro */
    private int annoPubblicazione;
    /** ISBN del libro */
    private String ISBN;      
    /** Copie Disponibili del libro */    
    private int copieDisponibili; 

    /** 
     * @brief Costruttore della classe Libro
     * @param titolo Titolo del libro
     * @param autore Autore del libro
     * @param annoPubblicazione Anno di pubblicazione del libro
     * @param ISBN ISBN del libro
     * @param copieDisponibili Numero di copie disponibili
     * 
     * @pre {@link LibriService} deve garantire tutti i controlli sui dati
     * 
     * @pre I dati passati devono essere validi (controllo delegato a LibriService)
     * @post Il libro è inizializzato
     * 
     */
    public Libro(String titolo, String autore, int annoPubblicazione, String ISBN, int copieDisponibili) {
         this.titolo=titolo;
         this.autore=autore;
         this.annoPubblicazione=annoPubblicazione;
         this.ISBN=ISBN;
         this.copieDisponibili=copieDisponibili;
    }

     /**
     * @return Il titolo del libro
     */
    public String getTitolo() {
        return null;  
    }
         /**
     * @return L'autore del libro
     */
    public String getAutore() {
        return null;
    }
         /**
     * @return L'anno di pubblicazione del libro
     */
    public int getAnnoPubblicazione() {
        return 0;
    }
     /**
     * @return ISBN del libro
     */
    public String getISBN() {
        return null;
    }
     /**
     * @return Le copie disponibili
     */
    public int getCopieDisponibili() {
        return 0;
    }
     /**
     *@brief Imposta un nuovo titolo per il libro
     * 
     * @param titolo Nuovo titolo.
     * @pre titolo != null && !titolo.isEmpty()
     * @post Il titolo viene aggiornato
     */
    public void setTitolo(String titolo) {
    }
        /**
     *@brief Imposta un nuovo autore per il libro
     * 
     * @param autore Nuovo autore.
     * @pre autore != null && !autore.isEmpty()
     * @post L'autore viene aggiornato
     */
    public void setAutore(String autore) {
    }
        /**
     *@brief Imposta un nuovo anno di pubblicazione per il libro
     * 
     * @param annoPubblicazione Nuovo anno di pubblicazione.
     * @pre annoPubblicazione > 0 
     * @post L'anno di pubblicazione viene aggiornato
     */
    public void setAnnoPubblicazione(int annoPubblicazione) {
    }
     /**
     *@brief Imposta un nuovo ISBN per il libro
     * 
     * @param ISBN Nuovo ISBN.
     * @pre ISBN != null && !ISBN.isEmpty()
     * @post L'ISBN viene aggiornato
     */
    public void setISBN(String ISBN) {
    }
        /**
     *@brief Imposta un nuovo numero di copie disponibili per il libro
     * 
     * @param copieDisponibili Nuovo numero di copie disponibili.
     * @pre copieDisponibili >= 0 
     * @post Il numero di copie disponibili viene aggiornato
     */
    public void setCopieDisponibili(int copieDisponibili) {
    }
     /**
     *@return Una rappresentazione leggibile del libro
     */
    @Override 
    public String toString(){
    return null;
    }
    
     /**
     * @brief Due libri sono uguali se hanno lo stesso ISBN
     */
    @Override
    public boolean equals(Object o){ 
        return false;
    }
     /**
     * @brief hash coerente con equals(basato sull'ISBN)
     */
    @Override
    public int hashCode() {
        return 0;
    }
     /**
     * @brief Ordina i libri per titolo
     * @param o altro libro
     */
    @Override
    public int compareTo(Libro o){
    return 0;
    }
}
