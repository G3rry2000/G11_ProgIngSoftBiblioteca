package biblioteca;

import biblioteca.gestionelibri.ArchivioLibri;
import biblioteca.gestioneutenti.ArchivioUtenti;
import biblioteca.gestioneprestiti.ArchivioCronologiaPrestiti;
import biblioteca.gestioneprestiti.ArchivioPrestitiAttivi;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

/**
 * @class Main
 * @brief Classe principale dell'applicazione Biblioteca.
 * 
 * Estende {@link Application} e rappresenta il punto di avvio dell'applicazione
 * JavaFX. Si occupa di caricare la scena iniziale
 * dalla vista FXML {@code HomeView.fxml} e di mostrare la finestra principale.
 * 
 * L'applicazione utilizza {@link FXMLLoader} per caricare la GUI e
 * {@link Stage} per visualizzare la finestra principale.
 */
public class Main extends Application {
    public static ArchivioLibri archivioLibri;
    public static ArchivioUtenti archivioUtenti;
    public static ArchivioPrestitiAttivi archivioPrestitiAttivi;
    public static ArchivioCronologiaPrestiti archivioCronologia;
    /**
     * @brief Inizializza e mostra l'interfaccia grafica principale.
     *
     * Metodo richiamato automaticamente dal framework JavaFX all'avvio
     * dell'applicazione. Carica la vista principale tramite
     * {@code HomeView.fxml}, crea la scena associata e visualizza la finestra.
     *
     * @param primaryStage La finestra principale dell'applicazione.
     * @throws IOException Se il file FXML non può essere caricato correttamente.
     *
     * @pre primaryStage != null
     * @post La finestra principale è visibile e contiene la scena caricata da {@code HomeView.fxml}.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        archivioLibri = new ArchivioLibri("libri.csv");
        archivioUtenti = new ArchivioUtenti("utenti.csv");
        archivioPrestitiAttivi = new ArchivioPrestitiAttivi("prestitiAttivi.csv");
        //archivioCronologia = new ArchivioCronologiaPrestiti("cronologia.csv");
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/HomeView.fxml"));
        
        Scene scene = new Scene(loader.load());

        primaryStage.setTitle("Biblioteca - Home");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    /**
     * @brief Metodo di avvio dell'applicazione.
     * 
     * Questo metodo è il punto di ingresso della JVM. Richiama {@link #launch(String...)} 
     * per avviare l'applicazione JavaFX.
     * 
     * @param args Argomenti da linea di comando
     */
    public static void main(String[] args) {
        launch(args);
    }
}

