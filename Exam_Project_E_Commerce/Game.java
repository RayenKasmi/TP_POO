import java.util.ArrayList;

public class Game extends Product{
    public Game(int idSeller, String name, String brand, double price, int quantity, ArrayList<PromoCode> listPromoCodes) {
        super(idSeller, name, brand, price, quantity, listPromoCodes);
    }
    @Override
    public String toString() {
        return "Game: "+super.toString()+" "+super.Rating()+"/★";
    }
}
