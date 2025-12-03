/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestioneUtenti;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;

/**
 * FXML Controller class
 *
 * @author Utente
 */
public class UtentiViewController implements Initializable {

    @FXML
    private Menu LibriID;
    @FXML
    private Menu PrestitiID;
    @FXML
    private Menu HomeID;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCognome;
    @FXML
    private TextField txtMatricola;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button addButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button searchButton;
    @FXML
    private TableView<Utente> utenteTable;
    @FXML
    private TableColumn<Utente, String> colNome;
    @FXML
    private TableColumn<Utente, String> colCognome;
    @FXML
    private TableColumn<Utente, Integer> colMatricola;
    @FXML
    private TableColumn<Utente, String> colEmail;
    @FXML
    private Button viewButton;

    private ArchivioUtenti archivioUtenti;
    
    private ObservableList<Utente> listaUtenti;
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void clickLibri(ActionEvent event) {
    }

    @FXML
    private void clickPrestiti(ActionEvent event) {
    }

    @FXML
    private void clickHome(ActionEvent event) {
    }



    @FXML
    private void onAggiungiUtente(ActionEvent event) {
    }

    @FXML
    private void onRimuoviUtente(ActionEvent event) {
    }

    @FXML
    private void onRicercaUtente(ActionEvent event) {
    }

    @FXML
    private void onVisualizzaUtenti(ActionEvent event) {
    }

    
}
