/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestionePrestiti;

/**
 * @enum StatoPrestiti
 * @brief Rappresenta lo stato di un prestito
 * @author Utente
 */
public enum StatoPrestiti {
    /** il prestito è attivo */
    ATTIVO,
    /** il prestito è in ritardo */
    RITARDO,
    /** il prestito è chiuso */
    CHIUSO;
}
