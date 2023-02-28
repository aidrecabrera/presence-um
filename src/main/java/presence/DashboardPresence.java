package presence;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class DashboardPresence {
    @FXML
    private ImageView UM;

    @FXML
    void initialize() {
        UM.setSmooth(true);
    }
}
