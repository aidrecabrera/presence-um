package presence;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

public class DashboardPresence {
    @FXML
    private ImageView UM;

    @FXML
    void initialize() {
        UM.setSmooth(true);
    }
}
