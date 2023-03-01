package presence;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import presence.authentication.Authenticate;
import presence.switcher.PresenceSwitcher;

import java.io.IOException;

public class AuthenticatePresence extends Authenticate {
    @FXML
    private Text Description;

    @FXML
    private Text Headline;

    @FXML
    private TextField userAddress;
    @FXML
    private TextField userPassword;

    @FXML
    public void initialize() {
        System.out.println("UM Presence by Cabrera, Aidre Love");
        DatabaseValidation();
    }

    @FXML
    void loginAuthenticate(ActionEvent event) throws IOException {
        signIn(userAddress.getText(), userPassword.getText());
        requestLogs(userAddress.getText(), true);
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainDashboard.fxml"));
//        Parent dashboardRoot = fxmlLoader.load();
//        Scene currentScene = Description.getScene();
//        currentScene.setRoot(dashboardRoot);
    }

    @FXML
    void registerAuthenticate(ActionEvent event) {
        register(userAddress.getText(), userPassword.getText());
    }

}