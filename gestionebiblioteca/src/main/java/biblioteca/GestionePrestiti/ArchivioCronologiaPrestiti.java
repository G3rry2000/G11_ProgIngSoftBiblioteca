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
import java.io.IOException;
/**
 * @class ArchivioCronologiaPrestiti
 * @brief Gestisce la collezione della cronologia dei prestiti della biblioteca
 * 
 * Questa classe si occupa della sola gestione dati:
 * - memorizzazione della cronologia dei prestiti tramite linkedlist
 * - operazioni di aggiungi, rimuovi, ricerca, modifica e visualizza
 * - salvataggio e caricamento da file
 * 
 * Tutti i controlli sono stati affidati alla classe {@link PrestitoService}
 * 
 * @author Gerardo
 */
public class ArchivioCronologiaPrestiti implements Archivio{
   /** Insieme ordinato per inserimento della cronologia dei prestiti */
   private List<Prestito> cronologia;
    /**
    * @brief Costruttore: inizializza una LinkedList vuota
    * @post cronologia è inizializzato come nuova LinkedList vuota.
    */
   public ArchivioCronologiaPrestiti(){
   this.cronologia= new LinkedList<>();
   }
    /**
    * @brief Carica la cronologia dei prestiti da un file di testo
    * 
    * @param filename Nome del file da cui leggere
    * @throws IOException se si verificano errori di lettura
    * 
    * @pre filename!=null && !filename.isEmpty()
    * @post cronologia prestiti contiene la cronologia dei prestiti letti dal file 
    */
   @Override
   public void leggiDaFile(String filename) throws IOException{
    /**
    * @brief Salva la cronologia dei prestiti nel file specificato
    * 
    * @param filename Nome del file su cui scrivere
    * @throws IOException se si verificano errori di scrittura
    * 
    * @pre filename!=null && !filename.isEmpty()
    * @post il file contiene tutta la cronologia dei prestiti memorizzati
    */
   }
   @Override
   public void scriviSuFile(String filename)throws IOException{
   }
    /**
    * @brief Aggiunge un nuovo prestito attivo all'archivio
    * Non effettua controlli vengono delegati a @see PrestitoService
    * 
    * @param p Prestito da aggiungere
    * 
    * @pre p!=null 
    * @post cronologia prestito contiene il prestito p
    */
   public void aggiungiPrestitoCronologia(Prestito p){
   }
    /**
    * @brief Rimuove un prestito dall'archivio
    * 
    * @param p prestito da rimuovere
    * @return Il prestito che è stato rimosso oppure null se non presente
    * 
    * @pre p !=null
    * @post se presente, il prestito viene rimosso dall'archivio.
    */
   public Prestito rimuoviPrestitoCronologia(Prestito p){
   return null;
   }
    /**
    * @brief Cerca tutti i prestiti tramite  matricola (campo di utente)
    * 
    * @param utente Dati (matricola) di utente
    * @return l'insieme dei prestiti con la matricola cercata
    * 
    * @pre utente!= null
    * @post restituisce l'insieme dei presiti corrispondenti
    */
   public List<Prestito> ricercaPrestitoUtenteCronologia(Utente utente){
   return null;
   }
    /**
    * @brief Cerca tutti i prestiti tramite  ISBN (campo di libro)
    * 
    * @param libro Dati (ISBN) di libro
    * @return l'insieme dei prestiti con l'ISBN cercata
    * 
    * @pre libro!= null
    * @post restituisce l'insieme dei libri corrispondenti
    */
    public List<Prestito> ricercaPrestitoLibroCronologia(Libro libro){
   return null;
   }
    /**
    * @brief Restituisce l'intero insieme deilla cronologia dei prestiti
    * @return Set ordinato per inserimento della cronologia dei prestiti
    */ 
   public List<Prestito> getCronologia(){ 
   return null;
   }
   
}
