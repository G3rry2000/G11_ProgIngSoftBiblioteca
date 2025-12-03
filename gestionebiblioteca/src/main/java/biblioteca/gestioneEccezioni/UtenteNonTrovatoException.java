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
public class UtenteNonTrovatoException extends BibliotecaException{

    /**
     * Creates a new instance of <code>UtenteNonTrovatoException</code> without
     * detail message.
     */
    public UtenteNonTrovatoException() {
    }

    /**
     * Constructs an instance of <code>UtenteNonTrovatoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UtenteNonTrovatoException(String msg) {
        super(msg);
    }
}
