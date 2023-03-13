package presence.backend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import presence.API_Utilities;
import presence.authentication.Authenticate;

import java.io.IOException;

import static presence.API_Utilities.validateEntry;

public class AuthenticatePresence extends Authenticate{
    static API_Utilities utilities = new API_Utilities();
    @FXML
    private Text Description;
    @FXML
    private Text Headline;
    @FXML
    private TextField userAddress;
    @FXML
    private TextField userPassword;

    DashboardPresence dashboardPresence = new DashboardPresence();

    public AuthenticatePresence() throws IOException {
    }

    @FXML
    public void initialize() throws IOException {
        System.out.println("UM Presence by Cabrera, Aidre Love");
        DatabaseValidation();
    }
    @FXML
    void loginAuthenticate(ActionEvent event) throws IOException {
        boolean loginValid = validateEntry(userAddress.getText(), userPassword.getText());
        if (loginValid) {
            if (signIn(userAddress.getText(), userPassword.getText())) {
                utilities.PresenceSwitchScene("/presence/MainDashboard.fxml", Description);
            }
        }
    }
    @FXML
    void registerAuthenticate(ActionEvent event) {
        boolean loginValid = validateEntry(userAddress.getText(), userPassword.getText());
        if (loginValid) {
            register(userAddress.getText(), userPassword.getText());
        }
    }
}