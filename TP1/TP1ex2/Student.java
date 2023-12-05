import java.util.ArrayList;

public class Student {
    protected int studentId;
    protected String firstName;
    protected String lastName;
    protected ArrayList<Course> arr_course;
    protected int nbcourse;
    Student(int _studentId,String _firstName,String _lastName)
    {
        studentId=_studentId;
        firstName=_firstName;
        lastName=_lastName;
        arr_course=new ArrayList<>();
        nbcourse=0;
    }
    public int getStudentId(){return(this.studentId);};
    public String getFirstName(){return(this.firstName);};
    public String getLastName(){return(this.lastName);};
    public  ArrayList<Course> getCourses(){return(this.arr_course);};
    public void enroll(Course c)
    {
        arr_course.add(c);
        nbcourse++;
    }

    @Override
    public String toString() {
        return "Student:" + "studentId=" + studentId + ", firstName='" + firstName  + ", lastName='" +
                lastName +  "\nlist of courses:" + arr_course + ", nbcourse=" + nbcourse ;
    }
}
