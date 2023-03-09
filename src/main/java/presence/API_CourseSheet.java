package presence;

public class API_CourseSheet {

    private static API_CourseSheet instance;
    private String courseSheet;

    private API_CourseSheet() {
        // Private constructor to prevent instantiation
    }

    public static API_CourseSheet getInstance() {
        if(instance == null) {
            instance = new API_CourseSheet();
        }
        return instance;
    }

    public String getCourseSheet() {
        return courseSheet;
    }

    public void setCourseSheet(String courseCode, String courseSubject) {
        this.courseSheet = "src/main/resources/attendance/" + courseCode + "_" + courseSubject + "_ATTENDANCE_SHEET.csv";
    }
}