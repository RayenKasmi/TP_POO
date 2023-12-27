import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class User {
    protected static int numberOfUsers;
    protected int idUser;
    protected String firstName;
    protected String LastName;
    protected Tiers tier;
    protected int numberBorrowedBooks=0;
    protected ArrayList<Book> borrowedBooks=new ArrayList<>();

    public User(String firstName, String lastName, Tiers tier) {
        System.out.println("User: "+firstName+" "+lastName+" successfully created with id: "+numberOfUsers);
        this.idUser = numberOfUsers;
        this.firstName = firstName;
        LastName = lastName;
        this.tier = tier;
        numberOfUsers++;
    }

    public void borrowBook(Library library){
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter the id of the book that you want to borrow:");
        int idBook = scanner2.nextInt();
        tier.borrowBook(this,library,idBook);
        //scanner2.close();

    }

    public void study(){
        tier.study();
    }

    public void returnBook(Library library) {
        boolean found = false;
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter the id of the book that you want to return:");
        int idBook = scanner2.nextInt();
        Iterator<Book> iterator = borrowedBooks.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.idBook == idBook) {
                found = true;
                library.listBooks.add(book);
                iterator.remove();
                numberBorrowedBooks--;
                System.out.println("Book returned successfully");
            }
        }

        if (!found) {
            System.out.println("Couldn't find the book.");
        }
        // scanner2.close();
    }

    public void donateBook(Library library)
    {
        library.addBook();
    }

    void upgradeTier()
    {
        if(tier instanceof PremiumTier)
        {
            System.out.println("you already have premium");
        }
        else{
            tier=new PremiumTier();
            System.out.println("upgraded successfully");
        }
    }

    void downgradeTier()
    {
        if(tier instanceof StandardTier)
        {
            System.out.println("you are already a standard user");
        }
        else{
            tier=new StandardTier();
            System.out.println("downgraded successfully");
        }
    }

    @Override
    public String toString() {
        return "User:" +
                "idUser=" + idUser +
                " firstName= " + firstName +
                " LastName='" + LastName +
                " tier= " + tier +
                " numberBorrowedBooks= " + numberBorrowedBooks +
                " \nborrowedBooks= " + borrowedBooks;
    }
}
