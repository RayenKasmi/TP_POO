
public class Student extends Person implements LibraryUser{
    protected LibraryCard c;
    Student(String firstname,String lastname,String cd,String ed)
    {
        super(firstname,lastname);
        this.c=new LibraryCard(cd,ed,"StudentCard");
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
    public void donateBook(Library lb, Book b) {
        lb.add(b);
    }

    @Override
    public String toString() {
        return "Student:" + c +
                ", first_name='" + first_name +
                ", last_name='" + last_name;
    }
}