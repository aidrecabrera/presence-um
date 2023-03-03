package presence.utilities;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class BasicFunctions {
    public void setPropertyNewMeetingCell(VBox vBox) {
        vBox.setAlignment(Pos.CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);
        GridPane.setRowIndex(vBox, 1);

        MenuButton statusMark = new MenuButton();
        statusMark.setId("STATUS_MARK");
        statusMark.setAlignment(Pos.CENTER);
        statusMark.setContentDisplay(ContentDisplay.CENTER);
        statusMark.setText("Mark");
        MenuItem presentItem = new MenuItem("Present");
        MenuItem absentItem = new MenuItem("Absent");
        MenuItem excusedItem = new MenuItem("Excused");
        statusMark.getItems().addAll(presentItem, absentItem, excusedItem);
        vBox.getChildren().add(statusMark);
    }
    public void setPropertyNewBindMeetingColumn(VBox meetingColumn) {
        meetingColumn.setPrefHeight(200.0);
        meetingColumn.setPrefWidth(100.0);

        GridPane attendanceMeetingColumn = new GridPane();
        attendanceMeetingColumn.setGridLinesVisible(true);
        attendanceMeetingColumn.setPrefWidth(110.0);

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(Priority.SOMETIMES);
        columnConstraints.setMaxWidth(125.0);
        columnConstraints.setMinWidth(125.0);
        columnConstraints.setPrefWidth(125.0);
        attendanceMeetingColumn.getColumnConstraints().add(columnConstraints);

        RowConstraints rowConstraints1 = new RowConstraints();
        rowConstraints1.setMaxHeight(150.0);
        rowConstraints1.setMinHeight(150.0);
        rowConstraints1.setPrefHeight(150.0);
        rowConstraints1.setVgrow(Priority.SOMETIMES);
        RowConstraints rowConstraints2 = new RowConstraints();
        rowConstraints2.setMaxHeight(150.0);
        rowConstraints2.setMinHeight(150.0);
        rowConstraints2.setPrefHeight(150.0);
        rowConstraints2.setVgrow(Priority.SOMETIMES);
        attendanceMeetingColumn.getRowConstraints().addAll(rowConstraints1, rowConstraints2);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(83.0);
        hBox.setSpacing(3.0);
        attendanceMeetingColumn.add(hBox, 0, 0);

        Label meetingDate = new Label();
        meetingDate.setId("MEETING_DATE");
        meetingDate.setText("Meeting_Date");
        Font font = new Font("System Bold", 12.0);
        meetingDate.setFont(font);
        hBox.getChildren().add(meetingDate);

        meetingColumn.getChildren().add(attendanceMeetingColumn);
    }
    public void createStudentHBox(HBox hbox, String studentName, String studentOverall, String studentTotal) {
        hbox.setId("STUDENT_REFERENCE");
        hbox.setFillHeight(false);
        hbox.setPrefHeight(150.0);
        hbox.setPrefWidth(405.0);
        hbox.setPadding(new Insets(0, 0, 0, 0));
        hbox.getStyleClass().add("student-hbox");

        HBox childHBox1 = new HBox();
        childHBox1.setAlignment(Pos.CENTER);
        childHBox1.setPrefHeight(100.0);
        childHBox1.setPrefWidth(307.0);
        childHBox1.getStyleClass().add("child-hbox1");
        childHBox1.setPadding(new Insets(0, 0, 0, 15.0));

        Label label = new Label();
        label.setId("STUDENT_NAME");
        label.setAlignment(Pos.CENTER);
        label.setPrefHeight(100.0);
        label.setPrefWidth(243.0);
        label.setText("STUDENT_NAME");
        label.getStyleClass().add("student-name");

        childHBox1.getChildren().addAll(label);

        HBox childHBox2 = new HBox();
        childHBox2.setAlignment(Pos.CENTER);
        childHBox2.setPrefHeight(100.0);
        childHBox2.setPrefWidth(83.0);
        childHBox2.setSpacing(3.0);
        childHBox2.getStyleClass().add("child-hbox2");

        Label overallLabel = new Label();
        overallLabel.setId("STUDENT_OVERALL");
        overallLabel.setText("100");
        overallLabel.setFont(new Font("System Bold", 12.0));
        overallLabel.getStyleClass().add("student-overall");

        Label slashLabel = new Label();
        slashLabel.setText("/");
        slashLabel.setFont(new Font("System Bold", 12.0));
        slashLabel.getStyleClass().add("student-slash");

        Label totalLabel = new Label();
        totalLabel.setText("100");
        totalLabel.setFont(new Font("System Bold", 12.0));
        totalLabel.getStyleClass().add("student-total");

        childHBox2.getChildren().addAll(overallLabel, slashLabel, totalLabel);

        hbox.getChildren().addAll(childHBox1, childHBox2);
    }

    public void courseCardPropertySetter(JFXButton newComponent, String CourseCode, String CourseSubject, String CourseSchedule) {
        newComponent.setAlignment(Pos.CENTER);
        newComponent.setContentDisplay(ContentDisplay.CENTER);
        newComponent.setPrefHeight(138.75);
        newComponent.setPrefWidth(310);
        newComponent.setStyle("-fx-background-color: #d3f36b; -fx-background-radius: 15; -fx-background-radius: 15;");
        newComponent.setText(" ");

        VBox newVBox = new VBox();
        newVBox.setAlignment(Pos.CENTER);
        newVBox.setPrefHeight(102.0);
        newVBox.setPrefWidth(267.0);

        HBox newHBox1 = new HBox();
        newHBox1.setAlignment(Pos.CENTER_LEFT);
        newHBox1.setPrefHeight(100.0);
        newHBox1.setPrefWidth(200.0);
        Label newCourseCode = new Label(CourseCode);
        newHBox1.getChildren().add(newCourseCode);

        HBox newHBox2 = new HBox();
        newHBox2.setAlignment(Pos.CENTER_LEFT);
        newHBox2.setPrefHeight(100.0);
        newHBox2.setPrefWidth(200.0);
        Label newCourseName = new Label(CourseSubject);
        newCourseName.setFont(new Font(29.0));
        newHBox2.getChildren().add(newCourseName);

        HBox newHBox3 = new HBox();
        newHBox3.setAlignment(Pos.CENTER_LEFT);
        newHBox3.setPrefHeight(100.0);
        newHBox3.setPrefWidth(200.0);
        Label newCourseSched = new Label(CourseSchedule);
        newHBox3.getChildren().add(newCourseSched);

        newVBox.getChildren().add(newHBox1);
        newVBox.getChildren().add(newHBox2);
        newVBox.getChildren().add(newHBox3);

        newComponent.setGraphic(newVBox);
    }
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