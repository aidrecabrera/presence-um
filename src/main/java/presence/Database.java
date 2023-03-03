package presence;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class Database {
    private String DatabaseAuthentication = "src/main/resources/database/DB_PRESENCE_USER_AUTH.csv";
    private String DatabaseCourseList = "src/main/resources/course/courseList.csv";
    private String DatabaseRequestLogs = "src/main/resources/database/PRESENCE_ACTIVITY_LOGS.csv";

    private Parent DatabaseGetFXML;

    public Database() {
    }

    public Parent getDatabaseGetFXML() {
        return DatabaseGetFXML;
    }

    public void setDatabaseGetFXML(String databaseGetFXML) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(databaseGetFXML));
        Parent newView = loader.load();
        DatabaseGetFXML = newView;
    }

    public String getDatabaseAuthentication() {
        return DatabaseAuthentication;
    }

    public void setDatabaseAuthentication(String databaseAuthentication) {
        DatabaseAuthentication = databaseAuthentication;
    }

    public String getDatabaseCourseList() {
        return DatabaseCourseList;
    }

    public void setDatabaseCourseList(String databaseCourseList) {
        DatabaseCourseList = databaseCourseList;
    }

    public String getDatabaseRequestLogs() {
        return DatabaseRequestLogs;
    }

    public void setDatabaseRequestLogs(String databaseRequestLogs) {
        DatabaseRequestLogs = databaseRequestLogs;
    }
}
