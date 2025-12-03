/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.GestioneLibri;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;

/**
 *
 * @author vince
 */
public class LibroViewController {

    @FXML
    private TextField txtTitolo;
    @FXML
    private TextField txtAutori;
    @FXML
    private TextField txtISBN;
    @FXML
    private TextField txtCopie;
    @FXML
    private TextField txtAnno;
    @FXML
    private Button addButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button searchButton;
    @FXML
    private TableView<Libro> libroTable;
    @FXML
    private TableColumn<Libro, String> colTitolo;
    @FXML
    private TableColumn<Libro, String> colAutore;
    @FXML
    private TableColumn<Libro, String> colISBN;
    @FXML
    private TableColumn<Libro, Integer> colNumCopie;
    @FXML
    private TableColumn<Libro, Integer> colAnno;
    @FXML
    private Button viewButton;
    @FXML
    private Menu HomeID;
    @FXML
    private Menu UtentiID;
    
    private ArchivioLibri archivioLibri;
    
    private LibriService libroService;

    private ObservableList<Libro> listaLibri;
    
    public void initialize(URL url, ResourceBundle rb){
        //inizializzaione archivio e tabella
    }




    @FXML
    private void clickUtenti(ActionEvent event) {
    }

    @FXML
    private void clickPrestiti(ActionEvent event) {
    }

    @FXML
    private void ClickHome(ActionEvent event) {
    }

    @FXML
    private void onAggiungiLibro(ActionEvent event) {
    }

    @FXML
    private void onRimuoviLibro(ActionEvent event) {
    }

    @FXML
    private void onRicercaLibro(ActionEvent event) {
    }

    @FXML
    private void onVisualizzaLibri(ActionEvent event) {
    }
    
    
    
    
}
