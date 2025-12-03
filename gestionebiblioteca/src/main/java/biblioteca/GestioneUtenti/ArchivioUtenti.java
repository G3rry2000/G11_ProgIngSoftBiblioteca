/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestioneUtenti;
import biblioteca.Archivio;
import java.util.TreeSet;
import java.util.Set;
/**
 *
 * @author Utente
 */
public class ArchivioUtenti implements Archivio{
   private Set<Utente> utenti;
   public ArchivioUtenti(){
        this.utenti= new TreeSet<>(); 
   }
   
   @Override
   public void leggiDaFile(String filename){
   }
   @Override
   public void scriviSuFile(String filename){
   }
   public void aggiungiUtente(Utente u){
   }
   public Utente rimuoviUtente(Utente u){
   return null;
   }
   
   public Set<Utente> ricercaCognome(String cognome){
   return null;
   }
   public Utente ricercaMatricola(int matricola){
   return null;
   }
   public Utente modificaUtente(Utente u){ 
   return null;
   }
   public Set<Utente> visualizzaUtenti(){ 
   return null;
   }
}
