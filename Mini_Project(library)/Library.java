import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class Library {
    protected ArrayList<User> listUsers=new ArrayList<>();
    protected ArrayList<Admin> listAdmins=new ArrayList<>();
    protected ArrayList<Book> listBooks=new ArrayList<>();
    protected BookingsHistory bookingsHistory=new BookingsHistory();
    protected Menu menu= new Menu();

    User addUser(){
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter the first name of the user: ");
        String firstName = scanner1.nextLine();
        System.out.print("Enter the last name of the user: ");
        String lastName = scanner1.nextLine();
        String tierString;
        do {
            System.out.print("Enter the tier of the user(standard/premium): ");
            tierString = scanner1.nextLine();
        }while((!Objects.equals(tierString, "standard"))&&(!Objects.equals(tierString, "premium")));
        Tiers tier;
        if(Objects.equals(tierString, "standard"))
            tier=new StandardTier();
        else{
            tier=new PremiumTier();
        }
        User user = new User(firstName, lastName, tier);
        listUsers.add(user);
        //scanner1.close();
        return user;
    }

    User findUser(int idUser){
        for(User u:listUsers)
        {
            if(u.idUser==idUser){
                return u;
            }
        }
        return null;
    }

    User removeUser(int idUser) {
        Iterator<User> iterator = listUsers.iterator();
        while (iterator.hasNext()) {
            User u = iterator.next();
            if (u.idUser == idUser) {
                listBooks.addAll(u.borrowedBooks);
                System.out.println("Returned borrowed books");
                iterator.remove();
                System.out.println("User: " + idUser + " removed successfully");
                return u;
            }
        }
        return null;
    }

    void addBook(){
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter the title of the book: ");
        String title = scanner1.nextLine();
        System.out.print("Enter the author of the book: ");
        String author = scanner1.nextLine();
        System.out.print("Enter the publish date of the book: ");
        String publishDate = scanner1.nextLine();
        System.out.print("Is the book premium? (true/false): ");
        boolean isPremium = scanner1.nextBoolean();
        Book newBook=new Book(title,author,publishDate,isPremium);
        listBooks.add(newBook);
        System.out.println("Book has been added thank you!!");
        //scanner1.close();
    }

    Book removeBook(int idBook) {
        Iterator<Book> iterator = listBooks.iterator();
        while (iterator.hasNext()) {
            Book b = iterator.next();
            if (b.idBook == idBook) {
                iterator.remove();
                System.out.println("Book: " + idBook + " removed successfully");
                return b;
            }
        }
        return null;
    }

    Book findBook(int idBook){
        for(Book b:listBooks)
        {
            if(b.idBook==idBook)
            {
                return b;
            }
        }
        return null;
    }

    Admin addAdmin()
    {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter the first name of the Admin: ");
        String firstName = scanner1.nextLine();
        System.out.print("Enter the last name of the Admin: ");
        String lastName = scanner1.nextLine();
        System.out.println("Enter password");
        String password = scanner1.nextLine();
        Admin admin = new Admin(password,firstName,lastName);
        listAdmins.add(admin);
        return admin;
    }

    Admin findAdmin(int idAdmin,String password){
        for(Admin admin:listAdmins)
        {
            if((admin.idAdmin==idAdmin)&&(Objects.equals(admin.password, password))){
                return admin;
            }
        }
        return null;
    }

    public void displayUsers()
    {
        for(User user : listUsers)
        {
            System.out.println(user.toString());
        }
    }

    public void displayBooks()
    {
        for(Book book : listBooks)
        {
            System.out.println(book.toString());
        }
    }

    public void displayAdmins (){
        for(Admin admin : listAdmins){
            System.out.println(admin.toString());
        }

    }

    public void displayBookings(){
        bookingsHistory.display();
    }
}