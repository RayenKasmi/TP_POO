import java.time.LocalDate;

public class PremiumTier implements Tiers{
    @Override
    public void borrowBook(User user, Library library, int idBook) {
        if(library.findBook(idBook)!=null)
        {
            Book book=library.findBook(idBook);
            if(user.numberBorrowedBooks>=5)
            {
                System.out.println("you can only borrow five books at a time please return atleast one book");
            }
            else{
                System.out.println("Successfully borrowed book!!!");
                user.numberBorrowedBooks++;
                user.borrowedBooks.add(book);
                library.removeBook(idBook);
                Bookings booking = new Bookings(user.idUser,idBook, LocalDate.now(),LocalDate.now().plusMonths(5));
                library.bookingsHistory.addBooking(booking);
            }
        }
        else{
            System.out.println("couldn't find book.");
        }
    }

    @Override
    public void study() {
        System.out.println("Studying..................:)");
    }
}
