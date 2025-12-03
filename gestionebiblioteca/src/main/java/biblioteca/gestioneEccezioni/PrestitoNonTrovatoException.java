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
public class PrestitoNonTrovatoException extends BibliotecaException{

    /**
     * Creates a new instance of <code>PrestitoNonTrovatoException</code>
     * without detail message.
     */
    public PrestitoNonTrovatoException() {
    }

    /**
     * Constructs an instance of <code>PrestitoNonTrovatoException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public PrestitoNonTrovatoException(String msg) {
        super(msg);
    }
}
