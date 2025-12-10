
package biblioteca.GestioneUtenti;

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
import java.time.LocalDate;
import javafx.fxml.Initializable;
/**
 * @class UtentiViewController
 * @brief Controller della vista FXML dedicata alla gestione degli utenti.
 *
 * Questa classe gestisce l'interazione dell'interfaccia grafica con:
 * - inserimento di un nuovo utente
 * - ricerca utenti
 * - rimozione utenti
 * - visualizzazione dell’elenco degli utenti
 *
 * Tutti i controlli sono stati affidati alla classe {@link UtentiService}.
 *
 */
public class UtentiViewController implements Initializable{
    // ------------------ MENU ----------------------
    @FXML
    private Label homeID;
    @FXML
    private Label libriID;
    @FXML
    private Label prestitiID;
    // ------------------ CAMPI INPUT ---------------
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCognome;
    @FXML
    private TextField txtMatricola;
    @FXML
    private TextField txtEmail;
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
    private TableColumn<Utente, String> colPrestiti;
    @FXML
    private TableColumn<Utente, LocalDate> colDataRest;
  // ------------- LOGICA --------------
    private ArchivioUtenti archivioUtenti;
    
    private UtentiService utenteService;
    
    private ObservableList<Utente> listaUtenti;

    /**
     * @brief Metodo di inizializzazione del controller
     * 
     * Viene eseguito automaticamente all'avvio della schermata
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
     * @brief Apre la sezione Libri.
     * 
     * @param event Evento del click generato dall'interazione dell'utente.
     *
     * @pre event != null
     */
    @FXML
    private void clickLibri(MouseEvent event) {
        try {
        Parent root = FXMLLoader.load(getClass().getResource("/view/LibroView.fxml"));
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
     * @brief Aggiunge un nuovo utente utilizzando i dati inseriti nei campi testo.
     */
    @FXML
    private void onAggiungiUtente(ActionEvent event) {
    }
    /**
     * @brief Rimuove un utente utilizzando i dati inseriti nei campi testo.
     */
    @FXML
    private void onRimuoviUtente(ActionEvent event) {
    }
     /**
     * @brief Esegue una ricerca utenti sui campi compilando cognome o matricola
     */
    @FXML
    private void onRicercaUtente(ActionEvent event) {
    }
    /**
     * @brief Mostra l'intero elenco degli utenti presenti nell’archivio.
     */
    @FXML
    private void onVisualizzaUtenti(ActionEvent event) {
    }


    
}
