import java.time.LocalDate;

public class StandardTier implements Tiers{
    @Override
    public void borrowBook(User user, Library library, int idBook) {
        if(library.findBook(idBook)!=null)
        {
            Book book=library.findBook(idBook);
            if(user.numberBorrowedBooks>=1)
            {
                System.out.println("you can only borrow one book at a time please return your book or get the premium membership for more books");
            }
            else if(book.isPremium)
            {
                System.out.println("The book thar you want to buy is for premium users only please upgrade your membership to get access to it");
            }
            else{
                System.out.println("Successfully borrowed book!!!");
                user.numberBorrowedBooks++;
                user.borrowedBooks.add(book);
                library.removeBook(idBook);
                Bookings booking = new Bookings(user.idUser,idBook, LocalDate.now(),LocalDate.now().plusMonths(1));
                library.bookingsHistory.addBooking(booking);
            }
        }
        else{
            System.out.println("couldn't find book.");
        }
    }

    @Override
    public void study() {
        System.out.println("Tables are only reserved for premium memberships");
    }
}
