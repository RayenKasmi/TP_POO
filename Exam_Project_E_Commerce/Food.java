import java.util.ArrayList;

public class Food extends Product{
    String expDate;

    public Food(int idSeller, String name, String brand, double price, int quantity, ArrayList<PromoCode> listPromoCodes,String expDate) {
        super(idSeller, name, brand, price, quantity, listPromoCodes);
        this.expDate=expDate;
    }

    @Override
    public String toString() {
        return "Food: "+super.toString()+" |expDate= "+expDate+ " "+super.Rating()+"/★";
    }
}
