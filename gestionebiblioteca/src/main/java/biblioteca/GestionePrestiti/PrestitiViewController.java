/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestionePrestiti;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author Utente
 */
public class PrestitiViewController {

    @FXML
    private Menu utentiID;
    @FXML
    private Menu LibriID;
    @FXML
    private Menu HomeID;
    @FXML
    private TextField textISBN;
    @FXML
    private TextField txtMatricola;
    @FXML
    private Button searchButton;
    @FXML
    private Button addButton;
    @FXML
    private TableView<Prestito> prestitoTable;
    @FXML
    private TableColumn<Prestito, String> colID;
    @FXML
    private TableColumn<Prestito, String> colNome;
    @FXML
    private TableColumn<Prestito, String> colCognome;
    @FXML
    private TableColumn<Prestito, String> colMatricola;
    @FXML
    private TableColumn<Prestito, String> colTitolo;
    @FXML
    private TableColumn<Prestito, String> colAutori;
    @FXML
    private TableColumn<Prestito, String> colISBN;
    @FXML
    private TableColumn<Prestito, Integer> colNumCopie;
    @FXML
    private Button viewButton;
    @FXML
    private Button cronButton;

    @FXML
    private void clickUtenti(ActionEvent event) {
    }

    @FXML
    private void clickLibri(ActionEvent event) {
    }

    @FXML
    private void clickHome(ActionEvent event) {
    }

    @FXML
    private void searchPrestito(ActionEvent event) {
    }

    @FXML
    private void addPrestito(ActionEvent event) {
    }

    @FXML
    private void viewPrestiti(ActionEvent event) {
    }

    @FXML
    private void viewCron(ActionEvent event) {
    }



    
}
