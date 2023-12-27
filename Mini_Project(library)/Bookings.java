import java.time.LocalDate;

public class Bookings {
    protected static int numberOfBookings=0;
    protected int idBooking;
    protected int idUser;
    protected int idBook;
    protected LocalDate startDate;
    protected LocalDate endDate;

    public Bookings(int idUser, int idBook, LocalDate startDate, LocalDate endDate) {
        this.idBooking = numberOfBookings;
        this.idUser = idUser;
        this.idBook = idBook;
        this.startDate = startDate;
        this.endDate = endDate;
        numberOfBookings++;

    }

    @Override
    public String toString() {
        return  "idBooking= " + idBooking +
                "| idUser= " + idUser +
                "| idBook= " + idBook +
                "| startDate= " + startDate +
                "| endDate= " + endDate;
    }
}
