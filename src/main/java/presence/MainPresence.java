package presence;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presence.backend.AuthenticatePresence;

import java.io.IOException;

public class MainPresence extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
        FXMLLoader fxmlLoader = new FXMLLoader(MainPresence.class.getResource("MainPresenceUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setTitle("Presence");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        AuthenticatePresence authenticatePresence = new AuthenticatePresence();
        launch();
    }
}