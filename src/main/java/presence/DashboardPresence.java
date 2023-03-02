package presence;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import presence.Database.Database;
import presence.dashboard.DashboardLoadCourses;
import presence.utilities.BasicFunctions;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class DashboardPresence implements Initializable {
    Database importData = new Database();
    @FXML
    private Pane AttendancePane;
    @FXML
    private Pane CalendarPane;
    @FXML
    private Pane DashboardPane;
    @FXML
    private JFXComboBox<String> combobox1;

    public DashboardPresence() throws IOException {
    }

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
    @FXML
    private JFXButton courseCardCCE107;
    @FXML
    private GridPane courseContainer;
    int row = 0;
    int col = 0;
    int counter = 0;
    String FilePath = "src/main/resources/course/courseList.csv";
    FileWriter File = new FileWriter(FilePath, true);
    BasicFunctions utilities = new BasicFunctions();
    DashboardLoadCourses CourseInformation = new DashboardLoadCourses("Hello", "Hello", "Hello");
    void initializeCourseCards() throws IOException {
        String acquiredLine;
        FileReader fileReader = new FileReader("src/main/resources/course/courseList.csv");
        BufferedReader ComponentLabelReader = new BufferedReader(fileReader);
        JFXButton originalButton = courseCardCCE107;
        String newLabel = "TEST";
        while ((acquiredLine = ComponentLabelReader.readLine()) != null) {
            JFXButton generatedButton = new JFXButton(acquiredLine);
            utilities.loadCourseValues(importData.getDatabaseCourseList());
            utilities.propertyDuplicator(courseCardCCE107, generatedButton, CourseInformation.getCourseCode(), CourseInformation.getCourseName(), CourseInformation.getCourseSched());
            courseContainer.add(generatedButton, col, row);
            ++counter;
            col++;
            if (col == 4) {
                col = 0;
                row++;
            }
            System.out.println("Course Loaded: " + acquiredLine);
        }
        courseContainer.layout();
    }
    void refreshCourseCard() {
        courseCardCCE107.setOnAction(event -> {
            counter += 1;
            String newLabel;
            try (BufferedReader ComponentLabelReader = Files.newBufferedReader(Paths.get("src/main/resources/course/courseList.csv"))) {
                newLabel = ComponentLabelReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            JFXButton newCourseCard = new JFXButton();
            utilities.propertyDuplicator(courseCardCCE107, newCourseCard, newLabel, newLabel, newLabel);
            System.out.println("New Course Generated!");
            courseContainer.add(newCourseCard, col, row);
            col++;
            if (col == 4) {
                col = 0;
                row++;
            }
        });
    }
    @FXML
    void initialize() throws IOException {
        initializeCourseCards();
    }
}
