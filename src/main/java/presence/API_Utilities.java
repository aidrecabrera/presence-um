package presence;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import presence.attendance.AttendanceFunction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class API_Utilities {
    public String generateDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd yyyy - (hh:mm a)");
        String today = now.format(formatter);
        return today;
    }
    public Node generateMeetingHeader(GridPane gridPan, String MeetingDateID) {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(125);
        hBox.setSpacing(3.0);

        Label meetingDate = new Label();
        meetingDate.setId(MeetingDateID);
        meetingDate.setText(MeetingDateID);
        Font font = new Font("System Bold", 12.0);
        meetingDate.setFont(font);
        hBox.getChildren().add(meetingDate);
        return hBox;
    }
    public void setPropertyNewMeetingCell(VBox vBox, String MarkID, String MarkStudent, String MeetingStatus, int ColumnHeader) throws FileNotFoundException {
        vBox.setAlignment(Pos.CENTER);
        vBox.setPrefHeight(100.0);
        vBox.setPrefWidth(125);
        GridPane.setRowIndex(vBox, 1);

        MenuButton statusMark = new MenuButton();
        statusMark.setId(MarkStudent);
        statusMark.setAlignment(Pos.CENTER);
        statusMark.setContentDisplay(ContentDisplay.CENTER);

        String CellStatus = MeetingStatus;
        if (CellStatus != "NULL") {
            statusMark.setText(MeetingStatus);
        } else if (CellStatus == "NULL") {
            CellStatus = "Mark";
            statusMark.setText(CellStatus);
        }

        MenuItem presentItem = new MenuItem("Present");
        MenuItem absentItem = new MenuItem("Absent");
        MenuItem excusedItem = new MenuItem("Excused");

        AttendanceFunction attendanceFunction = new AttendanceFunction();
        presentItem.setOnAction(event -> {
            statusMark.setText("Present");
            String statusStudent = "Present";
            try {
                attendanceFunction.attendanceEditor(MarkID, MarkStudent, statusStudent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        absentItem.setOnAction(event -> {
            statusMark.setText("Absent");
            String statusStudent = "Absent";
            try {
                attendanceFunction.attendanceEditor(MarkID, MarkStudent, statusStudent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        excusedItem.setOnAction(event -> {
            statusMark.setText("Excused");
            String statusStudent = "Excused";
            try {
                attendanceFunction.attendanceEditor(MarkID, MarkStudent, statusStudent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        statusMark.getItems().addAll(presentItem, absentItem, excusedItem);
        vBox.getChildren().add(statusMark);
    }

    public void setPropertyNewBindMeetingColumn(VBox meetingColumn) {
        meetingColumn.setPrefHeight(200);
        meetingColumn.setPrefWidth(100.0);

        GridPane attendanceMeetingColumn = new GridPane();
        attendanceMeetingColumn.setGridLinesVisible(true);
        attendanceMeetingColumn.setPrefWidth(100);

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(Priority.SOMETIMES);
        columnConstraints.setMaxWidth(125.0);
        columnConstraints.setMinWidth(125.0);
        columnConstraints.setPrefWidth(125.0);
        attendanceMeetingColumn.getColumnConstraints().add(columnConstraints);

        RowConstraints rowConstraints1 = new RowConstraints();
        rowConstraints1.setMaxHeight(200);
        rowConstraints1.setMinHeight(200);
        rowConstraints1.setPrefHeight(200);
        rowConstraints1.setVgrow(Priority.ALWAYS);
        RowConstraints rowConstraints2 = new RowConstraints();
        rowConstraints2.setMaxHeight(200);
        rowConstraints2.setMinHeight(200);
        rowConstraints2.setPrefHeight(200);
        rowConstraints2.setVgrow(Priority.ALWAYS);
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
    String[] sampleArray = {"Student 1", "Student 2", "Student 3", "Student 4", "Student 5", "Student 6"};
    public void createStudentHBox(HBox hbox, String studentName, String studentOverall, String studentTotal) {
        hbox.setId("STUDENT_REFERENCE");
        hbox.setFillHeight(false);
        hbox.setPrefHeight(100);
        hbox.setPrefWidth(250);
        hbox.setPadding(new Insets(0, 0, 0, 0));
        hbox.getStyleClass().add("student-hbox");

        HBox childHBox1 = new HBox();
        childHBox1.setAlignment(Pos.CENTER);
        childHBox1.setPrefHeight(100.0);
        childHBox1.setPrefWidth(307.0);
        childHBox1.getStyleClass().add("child-hbox1");
        childHBox1.setPadding(new Insets(0, 0, 0, 15.0));

        Label label = new Label();
        label.setId(studentName);
        label.setAlignment(Pos.CENTER);
        label.setPrefHeight(100.0);
        label.setPrefWidth(187);
        label.setText(studentName);
        label.getStyleClass().add(studentName);

        childHBox1.getChildren().addAll(label);

        hbox.getChildren().addAll(childHBox1);
    }
    public void courseCardPropertySetter(JFXButton newComponent, String CourseCode, String CourseSubject, String CourseSchedule) {
        newComponent.setId(CourseCode);

        newComponent.setAlignment(Pos.CENTER);
        newComponent.setContentDisplay(ContentDisplay.CENTER);
        newComponent.setPrefHeight(200);
        newComponent.setPrefWidth(334.333333);
        newComponent.setStyle("-fx-background-color: #76b0ff; -fx-background-radius: 15; -fx-background-radius: 15;");
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
        newCourseCode.setTextFill(Paint.valueOf("000000FF"));
        newHBox1.getChildren().add(newCourseCode);

        HBox newHBox2 = new HBox();
        newHBox2.setAlignment(Pos.CENTER_LEFT);
        newHBox2.setPrefHeight(100.0);
        newHBox2.setPrefWidth(200.0);
        Label newCourseName = new Label(CourseSubject);
        newCourseName.setTextFill(Paint.valueOf("000000FF"));
        newCourseName.setFont(new Font(29.0));
        newHBox2.getChildren().add(newCourseName);

        HBox newHBox3 = new HBox();
        newHBox3.setAlignment(Pos.CENTER_LEFT);
        newHBox3.setPrefHeight(100.0);
        newHBox3.setPrefWidth(200.0);
        Label newCourseSched = new Label(CourseSchedule);
        newCourseSched.setTextFill(Paint.valueOf("000000FF"));
        newHBox3.getChildren().add(newCourseSched);

        newVBox.getChildren().add(newHBox1);
        newVBox.getChildren().add(newHBox2);
        newVBox.getChildren().add(newHBox3);

        newComponent.setGraphic(newVBox);
    }


    public void PresenceSwitchScene(String fxmlLocation, Node sceneComponent) throws IOException {
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