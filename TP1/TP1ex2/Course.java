public class Course {
    protected int courseId;
    protected String courseName;
    protected Instructor instructor;
    Course(int _courseId,String _courseName,Instructor _instructor)
    {
        courseId=_courseId;
        courseName=_courseName;
        instructor=_instructor;
    }
    public int getCourseId(){return(this.courseId);}
    public String getCourseName(){return (courseName);}
    public Instructor getInstructor(){return(instructor);}

    @Override
    public String toString() {
        return "\nCourse: " + "courseId=" + courseId + ", courseName='" + courseName  +  instructor ;
    }
}
