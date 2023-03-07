package presence;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import presence.dashboard.DashboardBindCourses;

import java.io.IOException;

public class HomeTab extends DashboardBindCourses {
    @FXML
    private Pane DashboardPane;
    @FXML
    private GridPane courseContainer;
    @FXML
    private Label DashboardHeader;

    public void initialize() throws IOException {
        loadDashboardCourses((SplitPane) DashboardPane.getParent());
    }
    public void loadDashboardCourses(SplitPane splitPane) throws IOException {
        String FilePath = importData.getDatabaseCourseList();
        bindCourseCard(courseContainer, splitPane, DashboardHeader);
    }
}
