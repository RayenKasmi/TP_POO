import java.util.ArrayList;

public class Electronics extends Product{
    public Electronics(int idSeller, String name, String brand, double price, int quantity, ArrayList<PromoCode> listPromoCodes) {
        super(idSeller, name, brand, price, quantity, listPromoCodes);
    }

    @Override
    public String toString() {
        return "Electronics: "+super.toString()+" "+super.Rating()+"/★";
    }
}
