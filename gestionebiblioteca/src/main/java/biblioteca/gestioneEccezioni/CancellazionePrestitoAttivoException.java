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
public class CancellazionePrestitoAttivoException extends BibliotecaException{

    /**
     * Creates a new instance of
     * <code>CancellazionePrestitoAttivoException</code> without detail message.
     */
    public CancellazionePrestitoAttivoException() {
    }

    /**
     * Constructs an instance of
     * <code>CancellazionePrestitoAttivoException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public CancellazionePrestitoAttivoException(String msg) {
        super(msg);
    }
}
