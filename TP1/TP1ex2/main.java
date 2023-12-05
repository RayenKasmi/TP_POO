public class Main {
    public static void main(String[] args) {
        Instructor i=new Instructor(1234,"Jacob","Brown");
        Instructor i1=new Instructor(5678,"Jason","Green");
        Course c=new Course(5678,"Maths",i);
        Course c1=new Course(3024,"Physics",i1);
        Student s=new Student(9,"Jimmy","Johnson");
        s.enroll(c);
        s.enroll(c1);
        System.out.println(s);
    }
}
