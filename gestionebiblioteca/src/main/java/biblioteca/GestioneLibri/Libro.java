/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestioneLibri;
/**
 *
 * @author vince
 */
public class Libro implements Comparable<Libro>{
    
    private String titolo;
    private String autore;
    private int annoPubblicazione;
    private String ISBN;          
    private int copieDisponibili; 

    public Libro(String titolo, String autore, int annoPubblicazione, String ISBN, int copieDisponibili) {
         this.titolo=titolo;
         this.autore=autore;
         this.annoPubblicazione=annoPubblicazione;
         this.ISBN=ISBN;
         this.copieDisponibili=copieDisponibili;
    }

    public String getTitolo() {
        return null;  
    }

    public String getAutore() {
        return null;
    }

    public int getAnnoPubblicazione() {
        return 0;
    }

    public String getISBN() {

        return null;

    }

    public int getCopieDisponibili() {
        return 0;
    }
    public void setTitolo(String titolo) {
    }

    public void setAutore(String autore) {
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
    }

    public void setISBN(String ISBN) {
    }

    public void setCopieDisponibili(int copieDisponibili) {
    }
    
    public void decrementaCopie(){
    }
    
    public void incrementaCopie(){
        
    }
    
    @Override 
    public String toString(){
    return null;
    }
    
    @Override
    public boolean equals(Object o){ 
        return false;
    }
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    @Override
    public int compareTo(Libro o){
    return 0;
    }
    
//controlli
}
