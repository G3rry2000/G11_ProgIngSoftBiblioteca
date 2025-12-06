
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
import java.time.LocalDate;
/**
 * @class PrestitiViewController
 * @brief Controller della vista FXML dedicata alla gestione dei prestiti.
 *
 * Questa classe gestisce l'interazione dell'interfaccia grafica con:
 * - inserimento di un nuovo prestito
 * - ricerca cronologia e prestiti attivi
 * - rimozione prestito
 * - visualizzazione dell’elenco dei prestiti e della cronologia
 *
 * Tutti i controlli vengono delegati a {@link PrestitiService}.
 */
public class PrestitiViewController {
    // ----------------MENU --------------
    @FXML
    private Menu utentiID;
    @FXML
    private Menu LibriID;
    @FXML
    private Menu HomeID;
    // ------------------ CAMPI INPUT ---------------
    @FXML
    private TextField textISBN;
    @FXML
    private TextField txtMatricola1;
    @FXML
    private TextField txtDataRestituzione;
    // --------------- BOTTONI --------------------
    @FXML
    private Button searchButton;
    @FXML
    private Button addButton;
    @FXML
    private Button viewButton;
    @FXML
    private Button cronButton;
    @FXML
    private Button backButton;
    // -------------- TABELLA -----------------
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
    private TableColumn<Prestito, String> colEmail;
    @FXML
    private TableColumn<Prestito, String> colSBN;
    @FXML
    private TableColumn<Prestito, Integer> colCopie;
    @FXML
    private TableColumn<Prestito, LocalDate> colDataInizio;
    @FXML
    private TableColumn<Prestito, LocalDate> colDataFine;
    @FXML
    private TableColumn<Prestito, StatoPrestiti> colStato;
     // ------------- LOGICA --------------
    private ArchivioPrestitiAttivi archivioPrestitiAttivi;
    private ArchivioCronologiaPrestiti archivioCronologiaPrestiti;
    private ArchivioLibri archivioLibri;
    private ArchivioUtenti archivioUtenti;
    
    private PrestitiService prestitiService;
    
    private ObservableList<Prestito> listaPrestiti;
     /**
     * @brief Metodo di inizializzazione del controller
     * Inizializza archivi, configura tabella e popola colonne.
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
     * @brief Apre la sezione Libri.
     */
    @FXML
    private void clickLibri(ActionEvent event) {
    }
     /**
     * @brief Apre la sezione Home.
     */
    @FXML
    private void clickHome(ActionEvent event) {
    }
     //------------OPERAZIONI UTENTI ------------
     /**
     * @brief Aggiunge un nuovo prestito utilizzando i dati inseriti nei campi testo.
     */
    @FXML
    private void onAggiungiPrestito(ActionEvent event) {
    }
     /**
     * @brief Esegue una ricerca prestito sui campi compilando ISBN e matricola
     */
    @FXML
    private void onRicercaPrestito(ActionEvent event) {
    }
     /**
     * @brief Rimuove un prestito attivo dall'archivio utilizzando i dati inseriti nei campi testo (ISBN e matricola)
     */
    @FXML
    private void onRestituzioneLibro(ActionEvent event) {
    }
     /**
     * @brief Mostra l'intero elenco degli prestiti attivi presenti nell’archivio.
     */
    @FXML
    private void onVisualizzaPrestito(ActionEvent event) {
    }
     /**
     * @brief Mostra l'intero elenco della cronologia dei prestiti nell’archivio.
     */
    @FXML
    private void onVisualizzaCronologia(ActionEvent event) {
    }




    
}
