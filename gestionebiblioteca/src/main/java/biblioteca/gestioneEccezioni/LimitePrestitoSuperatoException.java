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
public class LimitePrestitoSuperatoException extends BibliotecaException{

    /**
     * Creates a new instance of <code>LimitePrestitoSuperatoException</code>
     * without detail message.
     */
    public LimitePrestitoSuperatoException() {
    }

    /**
     * Constructs an instance of <code>LimitePrestitoSuperatoException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public LimitePrestitoSuperatoException(String msg) {
        super(msg);
    }
}
