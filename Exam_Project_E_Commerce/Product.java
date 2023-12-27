import java.util.ArrayList;
import java.util.Scanner;

public abstract class Product {
    static int numberProducts=0;
    protected int idProduct;
    protected int idSeller;
    protected String name;
    protected String brand;
    protected double price;
    protected int quantity;
    protected ArrayList<PromoCode> listPromoCodes=new ArrayList<>();
    protected ArrayList<Reviews> listReviews=new ArrayList<>();

    public Product(int idSeller, String name, String brand, double price, int quantity, ArrayList<PromoCode> listPromoCodes) {
        System.out.println("Product added successfully product id: "+numberProducts);
        this.idProduct=numberProducts;
        this.idSeller = idSeller;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.listPromoCodes = listPromoCodes;
        numberProducts++;
    }

    @Override
    public String toString() {
        return  "idProduct= " + idProduct +
                " |name= " + name +
                " |brand= " + brand +
                " |price= " + price +
                " |quantity= " + quantity;
    }

    public void displayReviews(){
        if(listReviews.isEmpty())
            System.out.println("There are no reviews of this product");
        else
            for(Reviews reviews:listReviews)
            {
                System.out.println(reviews);
            }
    }

    public void displayPromoCodes(){
        if(listPromoCodes.isEmpty())
            System.out.println("There are no PromoCodes for this product");
        else
            for (PromoCode promoCode : listPromoCodes)
            {
                System.out.println(promoCode);
            }
    }

    public String Rating(){
        if(listReviews.isEmpty())
            return "not available";
        else{
            double finalrating=0.0;
            for(Reviews review:listReviews)
            {
                finalrating+=review.rating;
            }
            finalrating/=listReviews.size();
            return String.valueOf(finalrating);
        }
    }

    public void AddReview(String nameReviewer)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your review: ");
        String review = scanner.nextLine();
        Double rating;
        do {
            System.out.print("Enter your rating between 0 and 5 stars: ");
            rating = scanner.nextDouble();
            scanner.nextLine();
        }while((rating<0.0)||(5.0<rating));
        Reviews Review=new Reviews(nameReviewer,review,rating);
        listReviews.add(Review);
    }

}
