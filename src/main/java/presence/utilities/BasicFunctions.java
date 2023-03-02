package presence.utilities;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class BasicFunctions {

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