/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestioneLibri;
import biblioteca.Archivio;
import java.util.TreeSet;
import java.util.Set;
import java.io.IOException;
/**
 * @class ArchivioLibri
 * @brief Gestisce la collezione dei libri della biblioteca
 * 
 * Questa classe si occupa della sola gestione dati:
 * - memorizzazione dei libri tramite TreeSet
 * - operazioni di aggiungi, rimuovi, ricerca, modifica e visualizza
 * - salvataggio e caricamento da file
 * 
 * Tutti i controlli sono stati affidati alla classe {@link LibriService}
 * 
 * @author Gerardo
 */
public class ArchivioLibri implements Archivio{
   /** Insieme ordinato dei libri */
    private Set<Libro> libri;
   
    /**
    * @brief Costruttore: inizializza un TreeSet vuoto
    * @post libri è inizializzato come nuovo TreeSet vuoto.
    */
   public ArchivioLibri(){
   this.libri= new TreeSet<>();
   }
   
    /**
    * @brief Carica i libri da un file di testo
    * 
    * @param filename Nome del file da cui leggere
    * @throws IOException se si verificano errori di lettura
    * 
    * @pre filename!=null && !filename.isEmpty()
    * @post libri contiene i libri letti dal file 
    */
   @Override
   public void leggiDaFile(String filename)throws IOException{
   }
    /**
    * @brief Salva i libri nel file specificato
    * 
    * @param filename Nome del file su cui scrivere
    * @throws IOException se si verificano errori di scrittura
    * 
    * @pre filename!=null && !filename.isEmpty()
    * @post il file contiene tutti i libri memorizzati.
    */
   @Override
   public void scriviSuFile(String filename) throws IOException{
   }
    /**
    * @brief Aggiunge un nuovo libro all'archivio
    * Non effettua controlli vengono delegati a {@link LibriService}
    * 
    * @param l Libro da aggiungere
    * 
    * @pre l!=null 
    * @post libri contiene il libro l
    */
   public void aggiungiLibro(Libro l){
   }
      /**
    * @brief Rimuove un libro dall'archivio
    * 
    * @param l libro da rimuovere
    * @return Il libro che è stato rimosso oppure null se non presente
    * 
    * @pre l !=null
    * @pre il libro non deve avere prestiti attivi (verifica delegata alla classe {@link LibriService}).
    * @post se presente, il libro viene rimosso dall'archivio.
    */
   public Libro rimuoviLibro(Libro l){
   return null;
   }
    /**
    * @brief Cerca tutti i libri che hanno un determinato titolo
    * 
    * @param titolo Titolo da cercare
    * @return Insieme dei libri con quel titolo oppure un insieme vuoto se nessuno viene trovato
    * 
    * @pre titolo!= null && !titolo.isEmpty()
    * @post restituisce l'insieme dei libri corrispondenti
    */
   public Set<Libro> ricercaTitolo(String titolo){
   return null;
   }
    /**
    * @brief Cerca se esiste un libro con un determinato ISBN
    * 
    * @param ISBN ISBN da cercare
    * @return il libro con l'ISBN dato oppure null in caso di libro non trovato
    * 
    * @pre ISBN!= null && !ISBN.isEmpty()
    * @post restituisce il libro corrispondente
    */
   public Libro ricercaISBN(String ISBN){ 
   return null;
   }
    /**
    * @brief Cerca se esiste un libro con un determinato autore.
    * 
    * @param autore Autore da cercare
    * @return  l'insieme dei libri con l'autore dato oppure un insieme vuoto in caso di libro non trovato
    * 
    * @pre autore!= null && !autore.isEmpty()
    * @post restituisce il libro corrispondente
    */
   public Set<Libro> ricercaAutore(String autore){   
   return null;
   }
    /**
    * @brief Modifica un libro già presente.
    * @param l Libro aggiornato
    * @return Torna true se la modifica è avvenuta con successo, altrimenti false
    * 
    * @pre l!=null e libro già registrato
    * se esiste, il libro viene sostituito con l
    */
   public boolean modificaLibro(Libro l){
      return true;
   }
    /**
    * @brief Restituisce l'intero insieme dei libri
    * @return Set ordinato dei libri
    */
   public Set<Libro> getLibri(){ 
   return null;
   }
  
}

