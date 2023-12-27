import java.util.ArrayList;

public class Book extends Product{
    protected String author;

    public Book(int idSeller, String name, String brand, double price, int quantity, ArrayList<PromoCode> listPromoCodes,String author) {
        super(idSeller, name, brand, price, quantity, listPromoCodes);
        this.author =author;
    }

    @Override
    public String toString() {
        return "Book: "+super.toString()+" |author= "+author+" "+ super.Rating()+"/★";
    }
}
