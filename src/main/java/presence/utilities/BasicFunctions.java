package presence.utilities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class BasicFunctions {
    public void PresenceSwitchScene(String fxmlLocation, Text sceneComponent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlLocation));
        Parent dashboardRoot = fxmlLoader.load();
        Scene currentScene = sceneComponent.getScene();
        currentScene.setRoot(dashboardRoot);
    }
    public static boolean validateEntry(String userAddress, String userPassword) {
        boolean valid = false;
        if (userAddress.isBlank() && userPassword.isBlank()) {
            System.out.println("Empty Email Address and Password");
        } else if (userAddress.isBlank()) {
            System.out.println("Empty Email Address");
        } else if (userPassword.isBlank()) {
            System.out.println("Empty Password");
        } else {
            System.out.println("Logging in...");
            valid = true;
        }
        return valid;
    }
    public static String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        return dtf.format(now);
    }
    public String removeFirstChar(String s){
        return s.substring(1);
    }
}    