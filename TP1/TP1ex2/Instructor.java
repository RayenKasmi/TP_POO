public class Instructor {
    protected int instructorId;
    protected String firstName;
    protected String lastName;

    public Instructor(int _instructorId, String _firstName, String _lastName) {
        instructorId = _instructorId;
        firstName = _firstName;
        lastName = _lastName;
    }

    public int getInstructorId(){return(this.instructorId);}
    public String getFirstName(){return (this.firstName);}
    public String getLastName(){return(this.lastName);}

    @Override
    public String toString() {
        return "\nInstructor: " + "instructorId=" + instructorId + ", firstName='" + firstName + ", lastName='" + lastName;
    }
}
