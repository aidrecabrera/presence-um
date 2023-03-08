package presence.dashboard;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import presence.API_Database;
import presence.API_Utilities;
import presence.HomeTab;
import presence.backend.AttendancePresence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public abstract class DashboardBindCourses {
    public API_Database importData = new API_Database();
    API_Utilities utilities = new API_Utilities();
    private String bindCourseCode;
    private String bindCourseName;
    private String bindCourseSchedule;
    int row = 0;
    int col = 0;
    int counter = 0;
    public void setBindCourseCode(String bindCourseCode) {
        this.bindCourseCode = bindCourseCode;
    }
    public void setBindCourseName(String bindCourseName) {
        this.bindCourseName = bindCourseName;
    }
    public void setBindCourseSchedule(String bindCourseSchedule) {
        this.bindCourseSchedule = bindCourseSchedule;
    }
    private HashMap<String, String> CourseList = new HashMap<>();

    public HashMap<String, String> getCourseList() {
        return CourseList;
    }

    public void bindCourseCard(GridPane embedContainer, SplitPane rightPane, Label header) throws IOException {
        String rowCourseInformation;
        FileReader fileReader = new FileReader(importData.getDatabaseCourseList());
        BufferedReader ComponentLabelReader = new BufferedReader(fileReader);
        ComponentLabelReader.readLine();

        RowConstraints rowConstraints = new RowConstraints(141.25);
        embedContainer.getRowConstraints().add(rowConstraints);
        while ((rowCourseInformation = ComponentLabelReader.readLine()) != null) {
            JFXButton newCourseCard = new JFXButton();
            String[] courseInformationArray = rowCourseInformation.split(",");
            DashboardLoadCourses course = new DashboardLoadCourses(courseInformationArray[0], courseInformationArray[1], courseInformationArray[2]);
            setBindCourseCode(course.getCourseCode());
            setBindCourseName(course.getCourseName());
            setBindCourseSchedule(course.getCourseSched());
            CourseList.put(course.getCourseCode(), course.getCourseName());
            utilities.courseCardPropertySetter(newCourseCard, bindCourseCode, bindCourseName, bindCourseSchedule);
            newCourseCard.setOnAction(event -> {
                try {
                    Stage popupStage = new Stage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("CourseTemplate.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    popupStage.setScene(scene);
                    popupStage.show();
                    newCourseCard.setUserData(course.getCourseCode() + course.getCourseName() + course.getCourseSched());
                    System.out.println("Button ID: " + newCourseCard.getId());
                    Label newLabel = new Label(newCourseCard.getId());
                    AttendancePresence attendancePresence = new AttendancePresence();
                    attendancePresence.setCOURSE(newLabel);
                    attendancePresence.setCourse(newCourseCard.getId());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            embedContainer.add(newCourseCard, col, row);
            ++counter;
            ++col;
            if (col == 3) {
                col = 0;
                row++;
                embedContainer.getRowConstraints().add(rowConstraints);
            }
            System.out.println("Course Code: " + bindCourseCode + " | Course Subject: " + bindCourseName + " | Course Schedule: " + bindCourseSchedule);
        }
    }
    public void refreshCourseCard(GridPane courseContainer) {
        counter += 1;
        try (BufferedReader ComponentLabelReader = Files.newBufferedReader(Paths.get("src/main/resources/course/courseList.csv"))) {
            String newLabel = ComponentLabelReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JFXButton newCourseCard = new JFXButton();
        utilities.courseCardPropertySetter(newCourseCard, bindCourseCode, bindCourseName, bindCourseSchedule);
        System.out.println("New Course Generated!");
        courseContainer.add(newCourseCard, col, row);
        col++;
        if (col == 3) {
            col = 0;
            row++;
        }
    }
}
