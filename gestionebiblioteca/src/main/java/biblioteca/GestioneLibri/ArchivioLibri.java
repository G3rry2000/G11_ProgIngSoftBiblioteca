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
   private Set<Libro> libri;
   
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
   public Libro rimuoviLibro(Libro l){
   return null;
   }
   public Set<Libro> ricercaTitolo(String titolo){
   return null;
   }
   public Libro ricercaISBN(String ISBN){ 
   return null;
   }
   public Set<Libro> ricercaAutore(String autore){   
   return null;
   }
   public Libro modificaLibro(Libro l){
      return null;
   }
   public Set<Libro> getLibri(){ 
   return null;
   }
   
   
}

