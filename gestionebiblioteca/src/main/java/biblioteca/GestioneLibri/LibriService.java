/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestioneLibri;
import java.util.Set;
/**
 *
 * @author vince
 */
public class LibriService {
    private ArchivioLibri archivioLibri;
    public LibriService(ArchivioLibri archivioLibri){
        this.archivioLibri = archivioLibri;
    }
    
    public void registraLibro(Libro l){
    }
    public Libro eliminaLibro(Libro l){
    return null;
    }
    public Set<Libro> cercaLibroPerTitolo(String titolo){
    return null;
    }
    public Libro cercaLibroPerISBN(String ISBN){
    return null;
    }
    public Set<Libro> cercaLibroPerAutore(String autore){
    return null;
    }
    
    public Libro aggiornaLibro(Libro l){
    return null;
    }
   public Set<Libro> visualizzaLibri(){ 
   return null;
   }
    
}
