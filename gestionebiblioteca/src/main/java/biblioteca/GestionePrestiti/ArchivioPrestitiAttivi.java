/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestionePrestiti;
import biblioteca.Archivio;
import biblioteca.GestioneLibri.Libro;
import biblioteca.GestioneUtenti.Utente;

import java.util.List;
import java.util.LinkedList;


/**
 *
 * @author Utente
 */
public class ArchivioPrestitiAttivi implements Archivio{
   private List<Prestito> prestitiAttivi;
   
   public ArchivioPrestitiAttivi(){
   this.prestitiAttivi= new LinkedList<>();
   }
   @Override
   public void leggiDaFile(String filename){
   }
   @Override
   public void scriviSuFile(String filename){
   }
   public void aggiungiPrestitoAttivo(Prestito p){
   }
   public Prestito rimuoviPrestitoAttivo(Prestito p){
   return null;
   }
   public Prestito ricercaPrestitoAttivo(Utente utente, Libro libro){
   return null;
   }
   public List<Prestito> getPrestitiAttivi(){ 
   return null;
   }
   
   
   //
    
}
