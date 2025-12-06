
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
import java.time.LocalDate;
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
public class UtentiViewController implements Initializable {
    // ----------------MENU --------------
    @FXML
    private Menu LibriID;
    @FXML
    private Menu PrestitiID;
    @FXML
    private Menu HomeID;
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
    // ------------NAVIGAZIONE MENU ------------
    /**
     * @brief Apre la sezione Libri.
     */
    @FXML
    private void clickLibri(ActionEvent event) {
    }
    /**
     * @brief Apre la sezione Prestiti.
     */
    @FXML
    private void clickPrestiti(ActionEvent event) {
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

    @FXML
    private void ClickHome(ActionEvent event) {
    }

    
}
