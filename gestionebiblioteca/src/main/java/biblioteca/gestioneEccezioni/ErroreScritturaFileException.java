/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.gestioneEccezioni;

/**
 *
 * @author Utente
 */
public class ErroreScritturaFileException extends Exception{

    /**
     * Creates a new instance of <code>ErroreScritturaFileException</code>
     * without detail message.
     */
    public ErroreScritturaFileException() {
    }

    /**
     * Constructs an instance of <code>ErroreScritturaFileException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ErroreScritturaFileException(String msg) {
        super(msg);
    }
}
