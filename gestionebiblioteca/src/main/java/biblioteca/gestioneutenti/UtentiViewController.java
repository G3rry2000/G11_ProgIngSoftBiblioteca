
package biblioteca.gestioneutenti;

import biblioteca.gestioneeccezioni.BibliotecaException;
import biblioteca.gestioneeccezioni.CancellazionePrestitoAttivoException;
import biblioteca.gestioneeccezioni.DuplicatoException;
import biblioteca.gestioneeccezioni.UtenteNonTrovatoException;
import biblioteca.gestioneeccezioni.ValidazioneException;
import biblioteca.gestionelibri.Libro;
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
import java.util.Optional;
import java.util.Set;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
    
       private Integer matricolaOriginale;

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
        
         try {
        // Creazione oggetto libro
        Utente nuovo = new Utente(
            txtNome.getText(),
            txtCognome.getText(),
            Integer.parseInt(txtMatricola.getText()),
            txtEmail.getText()
        );

        // Aggiunta tramite service
        utenteService.registraUtente(nuovo);

        // Aggiorno tabella
        listaUtenti.setAll(utenteService.visualizzaUtenti());

        alertConferma("Utente aggiunto correttamente.");
        // Svuota i campi dopo l'inserimento
        txtNome.clear();
        txtCognome.clear();
        txtMatricola.clear();
        txtEmail.clear();

    } catch (ValidazioneException e) {
        alertErrore("Errore: " + e.getMessage());
    } catch( DuplicatoException e1){
        alertErrore("Errore: " + e1.getMessage());
    }
   }
    /**
     * @brief Rimuove un utente utilizzando i dati inseriti nei campi testo.
     */
    @FXML
    private void onRimuoviUtente(ActionEvent event) throws ValidazioneException {
        try {
        Utente selezionato = utenteTable.getSelectionModel().getSelectedItem();

        
        if (alertConfermaEliminazione()) {
            utenteService.eliminaUtente(selezionato);
            alertConferma("Utente eliminato con successo.");
            }
        listaUtenti.setAll(utenteService.visualizzaUtenti());

    } catch (CancellazionePrestitoAttivoException e) {
        alertErrore("Errore: " + e.getMessage());
    }
   }
     /**
     * @brief Esegue una ricerca utenti sui campi compilando cognome o matricola
     */
    @FXML
    private void onRicercaUtente(ActionEvent event) {
    String cognome = txtCognome.getText().trim();
    int matricola = Integer.parseInt(txtMatricola.getText());
    try{
        Set<Utente> risultati = utenteService.ricercaUtente(cognome, matricola);
        utenteTable.getItems().setAll(risultati);
        } catch (ValidazioneException e) {
        alertErrore("Errore: " + e.getMessage());
        }catch(UtenteNonTrovatoException e1){
         alertErrore("Errore: " + e1.getMessage());
        }
    }
    /**
     * @brief Mostra l'intero elenco degli utenti presenti nell’archivio.
     */
    @FXML
    private void onVisualizzaUtenti(ActionEvent event) {
         Set<Utente> tutti = utenteService.visualizzaUtenti();
        utenteTable.getItems().setAll(tutti);
    }
    
    private void onModificaNome(TableColumn.CellEditEvent<Utente, String> event) {
        
        Utente utente = event.getRowValue();
            String vecchioNome = utente.getNome();
            String nuovoNome = event.getNewValue();
    try {
        utente.setNome(nuovoNome);
        utenteService.modificaUtente(utente, matricolaOriginale != null ? matricolaOriginale : utente.getMatricola());
        listaUtenti.setAll(utenteService.visualizzaUtenti());
    } catch (BibliotecaException e) {
        // Ripristina il vecchio valore
        utente.setNome(vecchioNome);
        // Aggiorna la tabella graficamente
        utenteTable.refresh();
        alertErrore(e.getMessage());
    }
    }

    private void onModificaCognome(TableColumn.CellEditEvent<Utente, String> event) {
         
        Utente utente = event.getRowValue();
            String vecchioCognome = utente.getCognome();
            String nuovoCognome = event.getNewValue();
    try {
        utente.setCognome(nuovoCognome);
        utenteService.modificaUtente(utente, matricolaOriginale != null ? matricolaOriginale : utente.getMatricola());
        listaUtenti.setAll(utenteService.visualizzaUtenti());
    } catch (BibliotecaException e) {
        // Ripristina il vecchio valore
        utente.setNome(vecchioCognome);
        // Aggiorna la tabella graficamente
        utenteTable.refresh();
        alertErrore(e.getMessage());
    }
        
    }
    
    @FXML
    private void onOriginaleMatricola(TableColumn.CellEditEvent<Utente, Integer> event) {
        matricolaOriginale = event.getOldValue();
    }


    @FXML
    private void onModificaEmail(TableColumn.CellEditEvent<Utente, Integer> event) {
            Utente utente = event.getRowValue();
        int vecchiaMatricola = utente.getMatricola();
        int nuovaMatricola = event.getNewValue();
    try {
        utente.setMatricola(nuovaMatricola);
        utenteService.modificaUtente(utente, matricolaOriginale);
        listaUtenti.setAll(utenteService.visualizzaUtenti());
    } catch (BibliotecaException e) {
        // Ripristina il vecchio valore
        utente.setMatricola(vecchiaMatricola);
        // Aggiorna la tabella graficamente
        utenteTable.refresh();
        alertErrore(e.getMessage());
    } finally {
        matricolaOriginale = null;
    }
    }

    
    private void alertConferma(String messaggio) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operazione completata");
        alert.setHeaderText(null);
        alert.setContentText(messaggio);
        alert.showAndWait();
    }
     
    private void alertErrore(String messaggio) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText(null);
        alert.setContentText(messaggio);
        alert.showAndWait();
    }
    
    private boolean alertConfermaEliminazione() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conferma eliminazione");
        alert.setHeaderText("Sei sicuro?");
        alert.setContentText("Vuoi davvero eliminare questo utente?");

        Optional<ButtonType> result = alert.showAndWait();
        //verifica che sia stato premuto un pulsante e che sia il bottone ok
        return result.isPresent() && result.get() == ButtonType.OK;
    }

  

    

    


    
}
