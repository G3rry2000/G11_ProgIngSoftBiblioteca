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
import java.io.IOException;
/**
 * @class ArchivioPrestitiAttivi
 * @brief Gestisce la collezione dei prestiti attivi della biblioteca
 * 
 * Questa classe si occupa della sola gestione dati:
 * - memorizzazione dei prestiti tramite linkedlist
 * - operazioni di aggiungi, rimuovi, ricerca, modifica e visualizza
 * - salvataggio e caricamento da file
 * 
 * Tutti i controlli sono stati affidati alla classe {@link PrestitoService}
 * 
 * @author Gerardo
 */
public class ArchivioPrestitiAttivi implements Archivio{
    /** Insieme ordinato per inserimento dei prestiti */
   private List<Prestito> prestitiAttivi;
    /**
    * @brief Costruttore: inizializza una LinkedList vuota
    * @post prestiti è inizializzato come nuova LinkedList vuota.
    */
   public ArchivioPrestitiAttivi(){
   this.prestitiAttivi= new LinkedList<>();
   }
    /**
    * @brief Carica i prestiti attivi da un file di testo
    * 
    * @param filename Nome del file da cui leggere
    * @throws IOException se si verificano errori di lettura
    * 
    * @pre filename!=null && !filename.isEmpty()
    * @post prestiti attivi contiene i prestiti attivi letti dal file 
    */
   @Override
   public void leggiDaFile(String filename) throws IOException{
   }
    /**
    * @brief Salva i prestiti attivi nel file specificato
    * 
    * @param filename Nome del file su cui scrivere
    * @throws IOException se si verificano errori di scrittura
    * 
    * @pre filename!=null && !filename.isEmpty()
    * @post il file contiene tutti i prestiti attivi memorizzati
    */
   @Override
   public void scriviSuFile(String filename) throws IOException{
   }
    /**
    * @brief Aggiunge un nuovo prestito attivo all'archivio
    * Non effettua controlli vengono delegati a {@link PrestitoService}
    * 
    * @param p Prestito da aggiungere
    * 
    * @pre p!=null 
    * @post prestitiAttivi contiene il prestito p
    */
   public void aggiungiPrestitoAttivo(Prestito p){
   }
    /**
    * @brief Rimuove un prestito attivo dall'archivio
    * 
    * @param p prestito attivo da rimuovere
    * @return Il prestito attivo che è stato rimosso oppure null se non presente
    * 
    * @pre p !=null
    * @post se presente, il prestito attivo viene rimosso dall'archivio.
    */
   public Prestito rimuoviPrestitoAttivo(Prestito p){
   return null;
   }
    /**
    * @brief Cerca tutti i prestiti attivi tramite ISBN (campo di libro) e matricola (campo di utente)
    * 
    * @param utente Dati (matricola) di utente
    * @param libro Dati (ISBN) di libro
    * @return il prestito attivo con la matricola e ISBN cercato
    * 
    * @pre utente!= null &&  libro!= null 
    * @post restituisce il prestito attivo corrispondente
    */
   public Prestito ricercaPrestitoAttivo(Utente utente, Libro libro){
   return null;
   }
    /**
    * @brief Restituisce l'intero insieme dei prestiti attivi
    * @return Set ordinato per inserimento dei prestiti attivi
    */
   public List<Prestito> getPrestitiAttivi(){ 
   return null;
   }
   
   
   //
    
}
