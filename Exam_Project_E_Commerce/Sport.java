import java.util.ArrayList;

public class Sport extends Product{
    public Sport(int idSeller, String name, String brand, double price, int quantity, ArrayList<PromoCode> listPromoCodes) {
        super(idSeller, name, brand, price, quantity, listPromoCodes);
    }

    @Override
    public String toString() {
        return "Sport: "+super.toString()+" "+super.Rating()+"/★";
    }
}
