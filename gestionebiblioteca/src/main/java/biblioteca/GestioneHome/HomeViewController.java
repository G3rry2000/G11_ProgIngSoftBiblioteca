/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestioneHome;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;

/**
 * @brief Controller della vista principale dell'applicazione biblioteca.
 * 
 * Questa classe gestisce l'interfaccia principale della home,
 * fornendo metodi per reagire ai click sui menu "Libri", "Utenti" e "Prestiti".
 */
public class HomeViewController {
    // ----------------MENU --------------
    @FXML
    private Menu LibriID;
    @FXML
    private Menu UtentiID;
    @FXML
    private Menu PrestitiID;
    
     /**
     *@brief Metodo di inizializzazione del controller
     * 
     * Viene eseguito automaticamente all'avvio della schermata
     */
    public void initialize(URL url, ResourceBundle rb){
        
    }
      // ------------NAVIGAZIONE MENU ------------
    /**
     * @brief Apre la sezione Libri.
     */
    @FXML
    private void clickLibri(ActionEvent event) {
    }
     /**
     * @brief Apre la sezione Utenti.
     */
    @FXML
    private void clickUtenti(ActionEvent event) {
    }
    /**
     * @brief Apre la sezione Prestiti.
     */
    @FXML
    private void clickPrestiti(ActionEvent event) {
    }
    
}
