/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestionePrestiti;
import biblioteca.GestioneUtenti.Utente;
import biblioteca.GestioneLibri.Libro;
import java.time.LocalDate;
/**
 *
 * @author Utente
 */
public class Prestito {
    private final int id;
    private static int cont=0;
    private Utente utente;
    private Libro libro;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private StatoPrestiti stato;
    
    //costruttore di inserimento
    public Prestito(Utente utente,Libro libro, LocalDate dataInizio, LocalDate dataFine){
        this.id=++cont;
        this.utente=utente;
        this.libro=libro;
        this.dataInizio= dataInizio;
        this.dataFine= dataFine;
        this.stato=StatoPrestiti.ATTIVO;
    }
    //costruttore di caricamento
    public Prestito(int id,Utente utente,Libro libro,LocalDate dataInizio,LocalDate dataFine, StatoPrestiti stato){
        this.id=id;
        this.utente=utente;
        this.libro=libro;
        this.dataInizio=dataInizio;
        this.dataFine=dataFine;
        this.stato=stato;
    }

    //serve per settare il contatore quando prendi da file
    public static void setContatore(int val){
    }
    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
    
    public Libro getLibro() {
        return libro;
    }
    
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public StatoPrestiti getStato() {
        return stato;
    }

    public void setStato(StatoPrestiti stato) {
        this.stato = stato;
    }
    
    
}
