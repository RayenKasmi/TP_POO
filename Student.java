public class Student {
    protected int studentId;
    protected String firstName;
    protected String lastName;
    protected Course[] courses;
    protected int nbcourse;
    public int getStudentId(){return(this.studentId);};
    public String getFirstName(){return(this.firstName);};
    public String getLastName(){return(this.lastName);};
    public Course[] getCourses(){return(this.courses);};
    public void enroll(Course c)
    {
        Course [] a=new Course[nbcourse+1];
        for(int i=0;i<nbcourse;i++)
            a[i]=courses[i];
        a[nbcourse]=c;
        courses=a;
    }
}
