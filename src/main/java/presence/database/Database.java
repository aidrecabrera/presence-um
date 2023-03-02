package presence.database;

public class Database {
    private String DatabaseAuthentication = "src/main/resources/database/DB_PRESENCE_USER_AUTH.csv";
    private String DatabaseCourseList = "src/main/resources/course/courseList.csv";
    private String DatabaseRequestLogs = "src/main/resources/database/PRESENCE_ACTIVITY_LOGS.csv";

    public Database() {
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
