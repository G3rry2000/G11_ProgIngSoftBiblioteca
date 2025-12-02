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
public class ErroreLetturaFileException extends Exception{

    /**
     * Creates a new instance of <code>ErroreLetturaFileException</code> without
     * detail message.
     */
    public ErroreLetturaFileException() {
    }

    /**
     * Constructs an instance of <code>ErroreLetturaFileException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ErroreLetturaFileException(String msg) {
        super(msg);
    }
}
