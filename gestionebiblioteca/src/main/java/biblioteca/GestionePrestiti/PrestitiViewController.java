/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestionePrestiti;

import biblioteca.GestioneLibri.ArchivioLibri;
import biblioteca.GestioneUtenti.ArchivioUtenti;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.collections.ObservableList;
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
    //mancano alcuni attributi da aggiungere
    @FXML
    private TableColumn<Prestito, Integer> colID;
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

    private ArchivioPrestitiAttivi archivioPrestitiAttivi;
    private ArchivioCronologiaPrestiti archivioCronologiaPrestiti;
    private ArchivioLibri archivioLibri;
    private ArchivioUtenti archivioUtenti;
    
    private PrestitiService prestitiService;
    
    private ObservableList<Prestito> listaPrestiti;
    @FXML
    private Button backButton;
    
    public void initialize(URL url, ResourceBundle rb){
        //inizializzaione archivio e tabella
    }
    
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
    private void onAggiungiPrestito(ActionEvent event) {
    }

    @FXML
    private void onRicercaPrestito(ActionEvent event) {
    }

    @FXML
    private void onRestituzioneLibro(ActionEvent event) {
    }

    @FXML
    private void onVisualizzaPrestito(ActionEvent event) {
    }

    @FXML
    private void onVisualizzaCronologia(ActionEvent event) {
    }




    
}
