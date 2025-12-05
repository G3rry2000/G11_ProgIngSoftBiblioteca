package biblioteca;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
/**
 * @brief Classe principale dell'applicazione Biblioteca.
 * 
 * Questa classe estende {@link Application} e rappresenta il punto di ingresso
 * dell'applicazione JavaFX. Si occupa di caricare la scena iniziale
 * dalla vista FXML {@code HomeView.fxml} e di mostrare la finestra principale.
 * 
 * L'applicazione utilizza {@link FXMLLoader} per caricare la GUI e
 * {@link Stage} per visualizzare la finestra principale.
 */
public class Main extends Application {
     /**
     * @brief Metodo principale per avviare l'interfaccia grafica.
     * 
     * Questo metodo viene chiamato automaticamente da JavaFX al lancio dell'applicazione.
     * Carica la vista principale {@code HomeView.fxml} e la mostra nella finestra principale.
     * 
     * @param primaryStage La finestra principale dell'applicazione
     * @throws IOException Se si verifica un errore durante il caricamento della FXML
     * @post La finestra principale viene visualizzata con la scena caricata da {@code HomeView.fxml}
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
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

