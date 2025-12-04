/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.IOException;

/**
 *
 * @author Utente
 */
public interface Archivio { //DA VALUTARE
    
    void leggiDaFile(String filename) throws IOException;
    void scriviSuFile(String filename) throws IOException; 
}
