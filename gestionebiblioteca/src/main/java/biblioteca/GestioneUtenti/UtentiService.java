/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestioneUtenti;

import java.util.Set;

/**
 *
 * @author vince
 */
public class UtentiService {
    
    private ArchivioUtenti archivioUtenti;
    public UtentiService(ArchivioUtenti archivioUtenti){
        this.archivioUtenti = archivioUtenti;
    }
    
    public void registraUtente(Utente u){
    }
    public Utente eliminaUtente(Utente u){
    return null;
    }
    public Set<Utente> cercaUtentePerCognome(String cognome){
    return null;
    }
    public Utente cercaUtentePerMatricola(int matricola){
    return null;
    }    
    public Utente aggiornaUtente(Utente u){
    return null;
    }
   public Set<Utente> visualizzaUtenti(){ 
   return null;
   }
    
    
}
