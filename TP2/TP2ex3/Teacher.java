public class Teacher extends Person implements LibraryUser{
    private String field;
    protected LibraryCard c;
    Teacher(String firstname, String lastname, String field,String cd,String ed)
    {
        super(firstname,lastname);
        this.field = field;
        this.c=new LibraryCard(cd,ed,"TeacherCard");
    }
    @Override
    public void borrowBook(Library lb, String title, String author) {
        this.BookInPocession=lb.remove(title,author);
    }
    @Override
    public void returnBook(Library lb) {
        lb.add(getBookInPocession());
        BookInPocession=null;
    }
    public String getField() {
        return field;
    }
    public void writeBook(String title,Library lb){
        lb.add(new Textbook(getFirst_name()+" "+getLast_name(),title,2023,field,250));
    }

    @Override
    public String toString() {
        return "Teacher:" +
                c +
                " field='" + field +
                ", first_name='" + first_name +
                ", last_name='" + last_name;
    }
}