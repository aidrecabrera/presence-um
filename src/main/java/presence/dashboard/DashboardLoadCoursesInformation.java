package presence.dashboard;

public class DashboardLoadCoursesInformation {
    private String courseCode;
    private String courseName;
    private String courseSched;

    public DashboardLoadCoursesInformation() {
    }

    public DashboardLoadCoursesInformation(String courseCode, String courseName, String courseSched) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseSched = courseSched;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseSched() {
        return courseSched;
    }
}
