package presence.dashboard;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import presence.database.Database;
import presence.utilities.BasicFunctions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DashboardBindCourses {
    Database importData = new Database();
    BasicFunctions utilities = new BasicFunctions();
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
    public void bindCourseCard(GridPane embedContainer) throws IOException {
        String rowCourseInformation;
        FileReader fileReader = new FileReader(importData.getDatabaseCourseList());
        BufferedReader ComponentLabelReader = new BufferedReader(fileReader);
        ComponentLabelReader.readLine();

        RowConstraints rowConstraints = new RowConstraints(141.25);
        embedContainer.getRowConstraints().add(rowConstraints);

        while ((rowCourseInformation = ComponentLabelReader.readLine()) != null) {
            JFXButton newCourseCard = new JFXButton();
            String[] courseInformationArray = rowCourseInformation.split(",");

            DashboardLoadCoursesInformation course = new DashboardLoadCoursesInformation(courseInformationArray[0], courseInformationArray[1], courseInformationArray[2]);
            setBindCourseCode(course.getCourseCode());
            setBindCourseName(course.getCourseName());
            setBindCourseSchedule(course.getCourseSched());
            utilities.courseCardPropertySetter(newCourseCard, bindCourseCode, bindCourseName, bindCourseSchedule);
            newCourseCard.setOnAction(event -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("newView.fxml"));
                    Parent newView = loader.load();
                    Node rightSide = splitPane.getItems().get(1);
                    splitPane.getItems().set(1, newView);
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
