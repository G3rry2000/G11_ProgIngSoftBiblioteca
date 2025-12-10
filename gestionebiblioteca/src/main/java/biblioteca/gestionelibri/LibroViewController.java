/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.gestionelibri;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.Event;
import java.io.IOException;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

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
public class LibroViewController implements Initializable{
    //--------------- MENU ---------------
    @FXML
    private Label homeID;
    @FXML
    private Label utentiID;
    @FXML
    private Label prestitiID;
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
    
    // ------------- LOGICA --------------
    private ArchivioLibri archivioLibri;
    
    private LibriService libroService;

    private ObservableList<Libro> listaLibri;

     /**
     *@brief Metodo di inizializzazione del controller
     * 
     * Viene eseguito automaticamente all'avvio della schermata
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        //inizializzaione archivio e tabella
    }
     /** @brief Restituisce lo stage (finestra) attualmente associato alla vista.
     * Viene utilizzato principalmente per effettuare cambi di scena senza
     * ripetere codice in ogni metodo di navigazione, migliorando la pulizia
     * e la manutenibilità del controller.
     *
     * @return Lo {@link Stage} corrente della finestra in cui è caricata la vista
     */
    private Stage getStage(Label label) {
        return (Stage) label.getScene().getWindow();
    }
    // ------------NAVIGAZIONE MENU ------------
    /**
     * @brief Apre la sezione Home.
     * 
     * @param event Evento del click generato dall'interazione dell'utente.
     *
     * @pre event != null
     */
    @FXML
    private void clickHome(MouseEvent event) {
        try {
        Parent root = FXMLLoader.load(getClass().getResource("/view/HomeView.fxml"));
        Stage stage = getStage((Label) event.getSource());
        stage.setScene(new Scene(root));
        stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @brief Apre la sezione Utenti.
     * 
     * @param event Evento del click generato dall'interazione dell'utente.
     *
     * @pre event != null
     */
    @FXML
    private void clickUtenti(MouseEvent event) {
         try {
        Parent root = FXMLLoader.load(getClass().getResource("/view/UtentiView.fxml"));
        Stage stage = getStage((Label) event.getSource());
        stage.setScene(new Scene(root));
        stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @brief Apre la sezione Prestiti.
     * 
     * @param event Evento del click generato dall'interazione dell'utente.
     *
     * @pre event != null
     */
    @FXML
    private void clickPrestiti(MouseEvent event) {
        try {
        Parent root = FXMLLoader.load(getClass().getResource("/view/PrestitiView.fxml"));
        Stage stage = getStage((Label) event.getSource());
        stage.setScene(new Scene(root));
        stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
