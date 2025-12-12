package biblioteca.gestioneprestiti;
import biblioteca.Archivio;
import biblioteca.gestionelibri.Libro;
import biblioteca.gestioneutenti.Utente;
import biblioteca.Main;
import java.util.List;
import java.util.LinkedList;
import java.io.IOException;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;

import java.time.LocalDate;
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
 */
public class ArchivioPrestitiAttivi implements Archivio{
    /** Lista in ordine di inserimento dei prestiti attivi */
   private List<Prestito> prestitiAttivi;
    /**
    * @brief Costruttore: inizializza una LinkedList vuota
    * @post prestiti è inizializzato come nuova LinkedList vuota.
    */
   public ArchivioPrestitiAttivi(String filename){
   this.prestitiAttivi= new LinkedList<>();
       try {
        leggiDaFile(filename);
    } catch (IOException e) {
        e.printStackTrace();
    }
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
    public void leggiDaFile(String filename) throws IOException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {

            if (scanner.hasNextLine()) scanner.nextLine(); // salta intestazione

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                if (line.trim().isEmpty()) continue;

                String[] parti = line.split(";");
                if (parti.length != 12) continue;

                int id = Integer.parseInt(parti[0]);

                String nome = parti[1];
                String cognome = parti[2];
                String email = parti[3];
                String matricola = parti[4];

                String titolo = parti[5];
                String autore = parti[6];
                int anno = Integer.parseInt(parti[7]);
                String isbn = parti[8];

                LocalDate dataInizio = LocalDate.parse(parti[9], formatter);
                LocalDate dataFine = LocalDate.parse(parti[10], formatter);
                StatoPrestiti stato = StatoPrestiti.valueOf(parti[11]);

                Utente u = new Utente(nome, cognome, email, matricola);
                Libro l = new Libro(titolo, autore, anno, isbn);

                Prestito p = new Prestito(id, u, l, dataInizio, dataFine, stato);

                prestitiAttivi.add(p);
            }
        }
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
    public void scriviSuFile(String filename) throws IOException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {

            pw.println("ID;NOME;COGNOME;EMAIL;MATRICOLA;TITOLO;AUTORE;ANNO;ISBN;DATA_INIZIO;DATA_FINE;STATO");

            for (Prestito p : prestitiAttivi) {

                Utente u = p.getUtente();
                Libro l = p.getLibro();

                pw.println(
                    p.getId() + ";" +
                    u.getNome() + ";" +
                    u.getCognome() + ";" +
                    u.getEmail() + ";" +
                    u.getMatricola() + ";" +
                    l.getTitolo() + ";" +
                    l.getAutore() + ";" +
                    l.getAnnoPubblicazione() + ";" +
                    l.getISBN() + ";" +
                    p.getDataInizio().format(formatter) + ";" +
                    p.getDataFine().format(formatter) + ";" +
                    p.getStato().name()
                );
            }
        }
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
       prestitiAttivi.add(p);
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
   boolean rimosso = prestitiAttivi.remove(p);
   return rimosso ? p : null;
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
   for(Prestito p : prestitiAttivi){
       if(p.getUtente().equals(utente) && p.getLibro().equals(libro)){
           return p;
       }
   }
   return null;
   }
    /**
    * @brief Restituisce l'intero insieme dei prestiti attivi
    * @return lista dei prestiti attivi in ordine di inserimento    
    */
   public List<Prestito> getPrestitiAttivi(){ 
   return prestitiAttivi;
   }
   public int contaPrestitiAttiviUtente(Utente utente) {
    int count = 0;

    for (Prestito p : prestitiAttivi) {
        if (p.getUtente().getMatricola().equals(utente.getMatricola())) {
            count++;
        }
    }

    return count;
}
}
