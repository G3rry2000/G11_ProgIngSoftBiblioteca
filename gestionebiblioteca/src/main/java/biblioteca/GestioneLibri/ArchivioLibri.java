/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestioneLibri;
import biblioteca.Archivio;
import java.util.TreeSet;
import java.util.Set;
/**
 *
 * @author Utente
 */
public class ArchivioLibri implements Archivio{
   Set<Libro> libri;
   
   public ArchivioLibri(){
   this.libri= new TreeSet<>();
   }
   
   @Override
   public void leggiDaFile(String filename){
   
   }
   @Override
   public void scriviSuFile(String filename){
   
   }
   
   public void aggiungiLibro(Libro l){
   }
   public void rimuoviLibro(Libro l){}
   public Libro ricercaTitolo(String titolo){
   return null;
   }
   public Libro ricercaISBN(String ISBN){
   return null;
   }
   public Libro ricercaAutore(String autore){
   return null;
   }
   public Libro modificaLibro(Libro l){ //DA CONTROLLARE
   return null;
   }
   public Set<Libro> visualizzaLibri(){ //DA CONTROLLARE
   return null;
   }
   
   
}
