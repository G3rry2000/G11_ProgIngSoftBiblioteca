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
    private TextField txtMatricola;
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
    private TableColumn<Prestito, String> colISBN;
    @FXML
    private TableColumn<Prestito, Integer> colNumCopie;
     // ------------- LOGICA --------------
    private ArchivioPrestitiAttivi archivioPrestitiAttivi;
    private ArchivioCronologiaPrestiti archivioCronologiaPrestiti;
    private ArchivioLibri archivioLibri;
    private ArchivioUtenti archivioUtenti;
    
    private PrestitiService prestitiService;
    
    private ObservableList<Prestito> listaPrestiti;
     /**
     * @brief Metodo di inizializzazione del controller
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
     * @brief Esegue una ricerca presito sui campi compilando ISBN e matricola
     */
    @FXML
    private void onRicercaPrestito(ActionEvent event) {
    }
     /**
     * @brief Rimuove un nuovo prestito attivo dall'archivio utilizzando i dati inseriti nei campi testo (ISBN e matricola)
     */
    @FXML
    private void onRestituzioneLibro(ActionEvent event) {
    }
     /**
     * @brief Mostra l'intero elenco degi prestiti attivi presenti nell’archivio.
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
