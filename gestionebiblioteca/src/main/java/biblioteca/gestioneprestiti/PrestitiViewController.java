package biblioteca.gestioneprestiti;

import biblioteca.Main;
import biblioteca.gestioneeccezioni.BibliotecaException;
import biblioteca.gestionelibri.ArchivioLibri;
import biblioteca.gestioneutenti.ArchivioUtenti;
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
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import javafx.scene.control.TableRow;

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
public class PrestitiViewController implements Initializable{
    // ----------------MENU --------------
    @FXML
    private Label utentiID;
    @FXML
    private Label homeID;
    @FXML
    private Label libriID;
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
    private TableColumn<Prestito, LocalDate> colDataInizio;
    @FXML
    private TableColumn<Prestito, LocalDate> colDataFine;
    @FXML
    private TableColumn<Prestito, StatoPrestiti> colStato;
    @FXML
    private TableColumn<Prestito, Integer> colAnnoP;
    
    // ------------- LOGICA --------------
    private ArchivioPrestitiAttivi archivioPrestitiAttivi;
    private ArchivioCronologiaPrestiti archivioCronologiaPrestiti;
    private ArchivioLibri archivioLibri;
    private ArchivioUtenti archivioUtenti;
    
    private PrestitiService prestitiService;
    
    private ObservableList<Prestito> listaPrestiti;
    
    private boolean vistaCronologia = false;

     /**
     * @brief Metodo di inizializzazione del controller
     * Inizializza archivi, configura tabella e popola colonne.
     * Viene eseguito automaticamente all'avvio della schermata
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        prestitiService = new PrestitiService(Main.archivioLibri, Main.archivioUtenti,Main.archivioPrestitiAttivi, Main.archivioCronologia);

        listaPrestiti = FXCollections.observableArrayList();
        listaPrestiti.setAll(prestitiService.visualizzaPrestitiAttivi());

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDataInizio.setCellValueFactory(new PropertyValueFactory<>("dataInizio"));
        colDataFine.setCellValueFactory(new PropertyValueFactory<>("dataFine"));
        colStato.setCellValueFactory(new PropertyValueFactory<>("stato"));
        
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colCognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        colMatricola.setCellValueFactory(new PropertyValueFactory<>("matricola"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        colTitolo.setCellValueFactory(new PropertyValueFactory<>("titolo"));
        colAutori.setCellValueFactory(new PropertyValueFactory<>("autori"));
        colSBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        colAnnoP.setCellValueFactory(new PropertyValueFactory<>("anno"));
        prestitoTable.setItems(listaPrestiti);
        
        //colora i prestiti in ritardo di rosso
        prestitoTable.setRowFactory(tv -> new TableRow<Prestito>() {
            @Override
            protected void updateItem(Prestito p, boolean empty) {
            super.updateItem(p, empty);

                if (p == null || empty) {
                    setStyle("");
                } else if (p.getStato() == StatoPrestiti.RITARDO) {
                    setStyle("-fx-background-color: #ffcccc;");
                } else {
                    setStyle("");
                }
            }
                });

        addButton.disableProperty().bind(
                textISBN.textProperty().isEmpty()
                        .or(txtMatricola1.textProperty().isEmpty())
                        .or(txtDataRestituzione.textProperty().isEmpty())
        );
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
     //------------OPERAZIONI UTENTI ------------
     /**
     * @brief Aggiunge un nuovo prestito utilizzando i dati inseriti nei campi testo.
     */
    @FXML
    private void onAggiungiPrestito(ActionEvent event) {
        try {
            String matricola = txtMatricola1.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataFine = LocalDate.parse(txtDataRestituzione.getText(), formatter);

            prestitiService.registraPrestito(
                    textISBN.getText(),
                    matricola,
                    dataFine
            );

            listaPrestiti.setAll(prestitiService.visualizzaPrestitiAttivi());
            alertInfo("Prestito registrato correttamente.");

            textISBN.clear();
            txtMatricola1.clear();
            txtDataRestituzione.clear();
        } catch (java.time.format.DateTimeParseException e) {
            alertErrore("Formato data non valido! Usa il formato dd/MM/yyyy.");
        } catch (BibliotecaException e) {
            alertErrore(e.getMessage());
        }
    }
    
    /**
    * @brief Esegue la ricerca nella cronologia dei prestiti
    *        per matricola utente o per ISBN libro.
    */
    @FXML
    private void onRicercaPrestito(ActionEvent event) {
        try {
            if (vistaCronologia) {
                listaPrestiti.setAll(
                    prestitiService.ricercaPrestitiCronologia(
                        txtMatricola1.getText(),
                        textISBN.getText()
                    )
                );
            } else {
                listaPrestiti.setAll(
                    prestitiService.ricercaPrestitiAttivi(
                        txtMatricola1.getText(),
                        textISBN.getText()
                    )
                );
            }
        } catch (BibliotecaException e) {
            alertErrore(e.getMessage());
        }
    }
   
     /**
     * @brief Rimuove un prestito attivo dall'archivio utilizzando i dati inseriti nei campi testo (ISBN e matricola)
     */
    @FXML
    private void onRestituzioneLibro(ActionEvent event) {
        Prestito selezionato = prestitoTable.getSelectionModel().getSelectedItem();

        if (selezionato == null) {
            alertErrore("Seleziona un prestito dalla tabella.");
            return;
        }

        try {
            prestitiService.eliminaPrestitoAttivo(selezionato);
            listaPrestiti.setAll(prestitiService.visualizzaPrestitiAttivi());
            alertInfo("Libro restituito correttamente.");
        } catch (BibliotecaException e) {
            alertErrore(e.getMessage());
        }
    }
     /**
     * @brief Mostra l'intero elenco degli prestiti attivi presenti nell’archivio.
     */
    @FXML
    private void onVisualizzaPrestito(ActionEvent event) {
        vistaCronologia = false;
        listaPrestiti.setAll(prestitiService.visualizzaPrestitiAttivi());

    }
     /**
     * @brief Mostra l'intero elenco della cronologia dei prestiti nell’archivio.
     */
    @FXML
    private void onVisualizzaCronologia(ActionEvent event) {
        vistaCronologia = true;
        listaPrestiti.setAll(prestitiService.visualizzaCronologia());

    }

    // ---------------- ALERT ----------------

    private void alertInfo(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Info");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }

    private void alertErrore(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Errore");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }




    
}
