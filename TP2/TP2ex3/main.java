public class Main {
    public static void main(String[] args) {
        // Creating a library
        Library myLibrary = new Library();

        // Adding three books to the library
        Book book1 = new Textbook("KounouzNajeh", "CollectionPilot", 2008, "Math", 120);
        Book book2 = new Novel("PeterBuffet", "Life Is What You Make It", 2010, "Life", 300, false);
        Book book3 = new Novel("Yuval Noah", "A Brief History of Humankind", 2014, "non-fiction", 816, true);

        myLibrary.add(book1);
        myLibrary.add(book2);
        myLibrary.add(book3);

        // Displaying the initial list of books in the library
        System.out.println("Initial List of Books in the Library:");
        myLibrary.list();
        System.out.println();

        // Creating a student and a teacher
        Student student = new Student("John", "Smith", "23/10/2023", "23/10/2028");
        System.out.println(student);
        Teacher teacher = new Teacher("Bobby", "Brown", "Science", "12/11/2023", "12/11/2033");
        System.out.println(teacher);

        // Students and teachers borrowing books
        student.borrowBook(myLibrary, "CollectionPilot", "KounouzNajeh");
        teacher.borrowBook(myLibrary, "Life Is What You Make It", "PeterBuffet");

        // Displaying the list of books after borrowing
        System.out.println("\nList of Books in the Library after Borrowing:");
        myLibrary.list();
        System.out.println();

        // Students and teachers returning books
        student.returnBook(myLibrary);
        teacher.returnBook(myLibrary);

        // Displaying the list of books after returning
        System.out.println("\nList of Books in the Library after Returning:");
        myLibrary.list();
        System.out.println();

        // Teacher writing a book and donating it to the library
        teacher.writeBook("NewBook", myLibrary);
        System.out.println("Teacher wrote a novel and donated it to the library.");
        System.out.println("\nList of Books in the Library after adding book:");
        myLibrary.list();
        System.out.println();

        // Student donating a book to the library
        Book newBook = new Novel("Malcolm Gladwell", "Outliers", 2008, "non-fiction", 315, true);
        student.donateBook(myLibrary, newBook);
        System.out.println("Student donated a notebook to the library.");

        // Displaying the final list of books in the library
        System.out.println("\nFinal List of Books in the Library:");
        myLibrary.list();
    }
}
