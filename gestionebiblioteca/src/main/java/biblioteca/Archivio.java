/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.IOException;

/**
 * @brief Interfaccia per la gestione di archivi persistenti.
 * 
 * Questa interfaccia definisce i metodi di base per leggere e scrivere dati su file.
 * Le classi che implementano {@code Archivio} devono fornire l'implementazione
 * per la persistenza dei dati.
 */
public interface Archivio { //DA VALUTARE
    
    /**
     * @brief Carica i dati dell'archivio da un file di testo.
     * 
     * @param filename Il percorso del file da cui leggere i dati
     * @throws IOException Se si verifica un errore di lettura dal file
     * 
     * @pre filename != null && !filename.isEmpty()
     * @post I dati dell'archivio vengono caricati dal file specificato
     */
    void leggiDaFile(String filename) throws IOException;
     /**
     * @brief Salva i dati dell'archivio su un file di testo.
     * 
     * @param filename Il percorso del file su cui scrivere i dati
     * @throws IOException Se si verifica un errore di scrittura sul file
     * 
     * @pre filename != null && !filename.isEmpty()
     * @post I dati dell'archivio vengono salvati nel file specificato
     */
    void scriviSuFile(String filename) throws IOException; 
}
