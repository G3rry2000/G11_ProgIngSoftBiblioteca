/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestionePrestiti;

import biblioteca.GestioneLibri.ArchivioLibri;
import biblioteca.GestioneLibri.Libro;
import biblioteca.GestioneUtenti.ArchivioUtenti;
import biblioteca.GestioneUtenti.Utente;
import java.util.List;
/**
 *
 * @author vince
 */
public class PrestitiService {
    private ArchivioLibri archivioLibri;
    private ArchivioUtenti archivioUtenti;
    private ArchivioPrestitiAttivi archivioPrestitiAttivi;
    private ArchivioCronologiaPrestiti archivioCronologia;

    public PrestitiService(ArchivioLibri archivioLibri, ArchivioUtenti archivioUtenti, ArchivioPrestitiAttivi archivioPrestitiAttivi, ArchivioCronologiaPrestiti archivioCronologia) {
        this.archivioLibri = archivioLibri;
        this.archivioUtenti = archivioUtenti;
        this.archivioPrestitiAttivi = archivioPrestitiAttivi;
        this.archivioCronologia = archivioCronologia;
    }
    public void registraPrestitoAttivo(Prestito p){
   }
   public Prestito eliminaPrestitoAttivo(Prestito p){
   return null;
   }
   public Prestito cercaPrestitoAttivo(Utente utente, Libro libro){
   return null;
   }
   public List<Prestito> visualizzaPrestitiAttivi(){ 
   return null;
   }
   
   public void registraPrestitoCronologia(Prestito p){
   }
   public Prestito eliminaPrestitoCronologia(Prestito p){
   return null;
   }
   public List<Prestito> cercaPrestitoUtenteCronologiaPerUtente(Utente utente){
   return null;
   }
    public List<Prestito> ricercaPrestitoLibroCronologiaPerLibro(Libro libro){
   return null;
   }
   public List<Prestito> visualizzaCronologia(){ 
   return null;
   }
    
}
