/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestionePrestiti;
import biblioteca.Archivio;
import biblioteca.GestioneUtenti.Utente;
import biblioteca.GestioneLibri.Libro;

import java.util.Map;
import java.util.LinkedHashMap;
/**
 *
 * @author Utente
 */
public class ArchivioCronologiaPrestiti implements Archivio{
   Map<Integer,Prestito> libri= new LinkedHashMap<>();
    
   @Override
   public void leggiDaFile(String filename){
   
   }
   @Override
   public void scriviSuFile(String filename){
   
   }
    
   public void aggiungiPrestito(Prestito p){
   }
   public void rimuoviPrestito(Prestito p){}
   public Prestito ricercaPrestito(Utente utente, Libro libro){
   return null;
   }
   public Map<Integer,Prestito> visualizzaCronologia(){ //DA CONTROLLARE
   return null;
   }
   
}
