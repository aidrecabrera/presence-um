package presence;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class DashboardHome {
    @FXML
    private Pane DashboardPane;
    @FXML
    private GridPane courseContainer;
    @FXML
    private Label DashboardHeader;
    Database importData = new Database();
    public void initialize() throws IOException {
        loadDashboardCourses((SplitPane) DashboardPane.getParent());
    }
    public void loadDashboardCourses(SplitPane splitPane) throws IOException {
        String FilePath = importData.getDatabaseCourseList();
        DashboardBindCourses courseBinder = new DashboardBindCourses();
        courseBinder.bindCourseCard(courseContainer, splitPane, DashboardHeader);
    }
}
