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
public class ValidazioneException extends BibliotecaException{

    /**
     * Creates a new instance of <code>ValidazioneException</code> without
     * detail message.
     */
    public ValidazioneException() {
    }

    /**
     * Constructs an instance of <code>ValidazioneException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ValidazioneException(String msg) {
        super(msg);
    }
}
