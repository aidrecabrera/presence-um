package presence;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardPresence implements Initializable {

    @FXML
    private Pane AttendancePane;

    @FXML
    private Pane CalendarPane;

    @FXML
    private Pane DashboardPane;

    @FXML
    private JFXComboBox<String> combobox1;

    @FXML
    void AttendanceBclicked(ActionEvent event) {

        AttendancePane.setVisible(true);
        DashboardPane.setVisible(false);
        CalendarPane.setVisible(false);

    }

    @FXML
    void CalendarBclicked(ActionEvent event) {
        AttendancePane.setVisible(false);
        DashboardPane.setVisible(false);
        CalendarPane.setVisible(true);
    }

    @FXML
    void DashboardBclicked(ActionEvent event) {

        AttendancePane.setVisible(false);
        DashboardPane.setVisible(true);
        CalendarPane.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String [] classes = {"Class 1", "Class 2", "Class 3", "Class 4","Class 5","Class 6"};
        combobox1.getItems().addAll(classes);
    }
}
