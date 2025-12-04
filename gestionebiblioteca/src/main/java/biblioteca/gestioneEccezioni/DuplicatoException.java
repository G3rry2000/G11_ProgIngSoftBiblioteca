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
public class DuplicatoException extends BibliotecaException{

    /**
     * Creates a new instance of <code>DuplicatoException</code> without detail
     * message.
     */
    public DuplicatoException() {
    }

    /**
     * Constructs an instance of <code>DuplicatoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DuplicatoException(String msg) {
        super(msg);
    }
}
