public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library();

        Book book1 = new Textbook("KounouzNajeh", "CollectionPilot", 2008, "Math", 120);
        Book book2 = new Novel("PeterBuffet", "Life Is What You Make It", 2010, "Life", 300, false);
        Book book3 = new Novel("Yuval Noah", "A Brief History of Humankind", 2014, "non-fiction", 816, true);

        myLibrary.add(book1);
        myLibrary.add(book2);
        myLibrary.add(book3);

        System.out.println("Initial List of Books in the Library:");
        myLibrary.list();
        System.out.println();

        Student student = new Student("John", "Smith", "23/10/2023", "23/10/2028");
        System.out.println(student);
        Teacher teacher = new Teacher("Bobby", "Brown", "Science", "12/11/2023", "12/11/2033");
        System.out.println(teacher);

        student.borrowBook(myLibrary, "CollectionPilot", "KounouzNajeh");
        teacher.borrowBook(myLibrary, "Life Is What You Make It", "PeterBuffet");

        System.out.println("\nList of Books in the Library after Borrowing:");
        myLibrary.list();
        System.out.println();

        student.returnBook(myLibrary);
        teacher.returnBook(myLibrary);

        System.out.println("\nList of Books in the Library after Returning:");
        myLibrary.list();
        System.out.println();

        teacher.writeBook("NewBook", myLibrary);
        System.out.println("Teacher wrote a novel and donated it to the library.");
        System.out.println("\nList of Books in the Library after adding book:");
        myLibrary.list();
        System.out.println();

        Book newBook = new Novel("Malcolm Gladwell", "Outliers", 2008, "non-fiction", 315, true);
        student.donateBook(myLibrary, newBook);
        System.out.println("Student donated a notebook to the library.");

        System.out.println("\nFinal List of Books in the Library:");
        myLibrary.list();
    }
}
