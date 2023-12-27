import java.util.ArrayList;

public class Clothes extends Product{
    protected String size;
    protected String type;

    public Clothes(int idSeller, String name, String brand, double price, int quantity, ArrayList<PromoCode> listPromoCodes,String size,String type) {
        super(idSeller, name, brand, price, quantity, listPromoCodes);
        this.size=size;
        this.type=type;
    }

    @Override
    public String toString() {
        return "Clothes: "+super.toString()+" |type= "+type+" |size= "+size+" "+ super.Rating()+"/★";
    }
}
