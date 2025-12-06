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
 * @class LibroViewController
 * @brief Controller della vista FXML dedicata alla gestione dei libri.
 *
 * Questa classe gestisce l'interazione dell'interfaccia grafica con:
 * - inserimento di un nuovo libro
 * - ricerca libro
 * - rimozione libro
 * - visualizzazione dell’elenco dei libri
 *
 * Tutti i controlli vengono delegati a {@link LibriService}.
 */
public class LibroViewController {
     // ------------------ CAMPI INPUT ---------------
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
    // --------------- BOTTONI --------------------
    @FXML
    private Button addButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button viewButton;
    // -------------- TABELLA -----------------
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
    // ----------------MENU --------------
    @FXML
    private Menu HomeID;
    @FXML
    private Menu UtentiID;
    @FXML
    private Menu PrestitiID;
    
    // ------------- LOGICA --------------
    private ArchivioLibri archivioLibri;
    
    private LibriService libroService;

    private ObservableList<Libro> listaLibri;
     /**
     *@brief Metodo di inizializzazione del controller
     * 
     * Viene eseguito automaticamente all'avvio della schermata
     */
    public void initialize(URL url, ResourceBundle rb){
        //inizializzaione archivio e tabella
    }

    // ------------NAVIGAZIONE MENU ------------
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
     /**
     * @brief Apre la sezione Home.
     */
    @FXML
    private void ClickHome(ActionEvent event) {
    }
    //------------OPERAZIONI UTENTI ------------
     /**
     * @brief Aggiunge un nuovo libro utilizzando i dati inseriti nei campi testo.
     * 
     * @pre I campi del libro devono essere compilati in modo valido.
     */
    @FXML
    private void onAggiungiLibro(ActionEvent event) {
    }
    /**
     * @brief Rimuove un libro utilizzando i dati inseriti nei campi testo.
     * 
     * @pre ISBN o altri identificatori devono essere compilati correttamente.
     */
    @FXML
    private void onRimuoviLibro(ActionEvent event) {
    }
     /**
     * @brief Esegue una ricerca libro sui campi compilando titolo, autore o ISBN
     * 
     * @pre Almeno un campo tra titolo, autore o ISBN deve essere compilato.
     */
    @FXML
    private void onRicercaLibro(ActionEvent event) {
    }
    /**
     * @brief Mostra l'intero elenco dei libri presenti nell’archivio.
     * 
     * @post La tabella mostra tutti i libri correnti dell’archivio.
     */
    @FXML
    private void onVisualizzaLibri(ActionEvent event) {
    }    
}
