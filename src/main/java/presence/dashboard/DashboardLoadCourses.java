package presence.dashboard;

public class DashboardLoadCourses {
    private String courseCode;
    private String courseName;
    private String courseSched;

    public DashboardLoadCourses() {
    }

    public DashboardLoadCourses(String courseCode, String courseName, String courseSched) {
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
