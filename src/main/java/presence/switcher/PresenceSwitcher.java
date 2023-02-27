package presence.switcher;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class PresenceSwitcher {

    public void PresenceSwitchScene(String fxmlLocation, Scene sceneComponent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlLocation));
        Parent dashboardRoot = fxmlLoader.load();
        Scene currentScene = sceneComponent;
        currentScene.setRoot(dashboardRoot);
    }

}
