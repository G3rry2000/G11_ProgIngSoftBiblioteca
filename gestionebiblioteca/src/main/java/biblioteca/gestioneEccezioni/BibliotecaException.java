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
public abstract class BibliotecaException extends Exception{

    /**
     * Creates a new instance of <code>BibliotecaException</code> without detail
     * message.
     */
    public BibliotecaException() {
    }

    /**
     * Constructs an instance of <code>BibliotecaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BibliotecaException(String msg) {
        super(msg);
    }
}
