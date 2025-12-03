/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestionePrestiti;
import biblioteca.Archivio;
import biblioteca.GestioneUtenti.Utente;
import biblioteca.GestioneLibri.Libro;

import java.util.List;
import java.util.LinkedList;
/**
 *
 * @author Utente
 */
public class ArchivioCronologiaPrestiti implements Archivio{
   private List<Prestito> cronologia;
   
   public ArchivioCronologiaPrestiti(){
   this.cronologia= new LinkedList<>();
   }
    
   @Override
   public void leggiDaFile(String filename){
   
   }
   @Override
   public void scriviSuFile(String filename){
   
   }
    
   public void aggiungiPrestito(Prestito p){
   }
   public Prestito rimuoviPrestito(Prestito p){
   return null;
   }
   public List<Prestito> ricercaPrestitoUtente(Utente utente){
   return null;
   }
    public List<Prestito> ricercaPrestitoLibro(Libro libro){
   return null;
   }
   public List<Prestito> visualizzaCronologia(){ 
   return null;
   }
   
}
