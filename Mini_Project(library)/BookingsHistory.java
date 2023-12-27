import java.util.ArrayList;

public class BookingsHistory
{
    ArrayList<Bookings> listBookings=new ArrayList<>();

    public void addBooking(Bookings b){
        listBookings.add(b);
    }

    public void display()
    {
        for(Bookings booking :listBookings)
        {
            System.out.println(booking.toString());
        }
    }
}
