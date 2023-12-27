import java.util.ArrayList;

public class Car extends Product{
    protected int mileage;

    public Car(int idSeller, String name, String brand, double price, int quantity, ArrayList<PromoCode> listPromoCodes,int mileage){
        super(idSeller, name, brand, price, quantity, listPromoCodes);
        this.mileage=mileage;
    }

    @Override
    public String toString() {
        return "Car: "+super.toString()+" |mileage= "+mileage+" "+ super.Rating()+"/★";
    }
}
