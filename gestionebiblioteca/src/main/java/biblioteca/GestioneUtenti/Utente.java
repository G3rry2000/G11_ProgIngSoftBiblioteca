
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestioneUtenti;
import biblioteca.GestionePrestiti.Prestito;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Utente
 */
public class Utente implements Comparable<Utente>{
    private String nome;
    private String cognome;
    private int matricola;
    private String email;
    private List<Prestito> prestitiAttivi;
    
    public Utente(String nome,String cognome, int matricola){
        this.nome=nome;
        this.cognome=cognome;
        this.matricola=matricola;
        this.prestitiAttivi = new ArrayList<>(); //DUBBIO aggiungiPrestitoAttivo e rimuoviPrestitoAttivo
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Prestito> getPrestitiAttivi() {
        return prestitiAttivi;
    }
    
    @Override
    public String toString(){
    return null;
    }
    @Override
    public boolean equals(Object o){
        return true;
    }
    @Override
    public int hashCode(){
    return 0;
    }
    @Override
    public int compareTo(Utente o1){
    return 0;
    }
    
    //controlli
    
    
}
