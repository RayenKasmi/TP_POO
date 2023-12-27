import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Customer {
    static int numberCustomers;
    protected int idCustomer;
    protected String username;
    protected String password;
    ArrayList<Product> offers = new ArrayList<>();
    ArrayList<Product> shoppingCarte = new ArrayList<>();
    ArrayList<Order> listOrders = new ArrayList<>();
    ArrayList<Payment> paymentMethods=new ArrayList<>();

    public Customer(String username, String password,ArrayList<Payment> paymentMethods) {
        this.idCustomer = numberCustomers;
        this.username = username;
        this.password = password;
        this.paymentMethods = paymentMethods;
        numberCustomers++;
    }

    public void putForSale(ecommerce ecommerce){
        ecommerce.inventory.addProduct(idCustomer);
        offers.add(ecommerce.inventory.getProduct(Product.numberProducts-1));
    }

    public void updateOffer(ecommerce ecommerce){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the id of the product that you want to update:");
        int idProduct=scanner.nextInt();
        scanner.nextLine();
        ecommerce.inventory.updateProduct(idCustomer,idProduct);
    }

    public void removeOffer(ecommerce ecommerce,int idProduct,int quantity){
        ecommerce.inventory.getProduct(idProduct).quantity-=quantity;
        if(ecommerce.inventory.getProduct(idProduct).quantity==0)
            offers.remove(ecommerce.inventory.deleteProduct(idProduct));
    }

    public void removeOffer(ecommerce ecommerce){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the id of the product that you want to delete:");
        int idProduct=scanner.nextInt();
        scanner.nextLine();
        offers.remove(ecommerce.inventory.deleteProduct(idCustomer,idProduct));
    }

    public void addToShoppingCarte(ecommerce ecommerce,int idProduct)
    {
        shoppingCarte.add(ecommerce.inventory.getProduct(idProduct));
        System.out.println("Product added!!");
    }

    public void removeFromShoppingCarte(ecommerce ecommerce,int idProduct)
    {
        Product product=ecommerce.inventory.getProduct(idProduct);
        if(product!=null) {
            shoppingCarte.remove(product);
        }
    }

    public void displayOffers()
    {
        System.out.println("Your Offers:");
        for(Product product:offers)
        {
            System.out.println(product);
        }
    }

    public void displayShoppingCarte()
    {
        System.out.println("Your shopping carte: ");
        for(Product product:shoppingCarte)
        {
            System.out.println(product);
        }
    }

    public void finalizeOffer(ecommerce ecommerce,int idProduct)
    {
        Scanner scanner = new Scanner(System.in);
        /*System.out.println("Enter the id of the product that you want to buy:");
        int idProduct=scanner.nextInt();
        scanner.nextLine();*/
        Product product=ecommerce.inventory.getProduct(idProduct);
        if(product==null)
            return;
        System.out.println("please enter the quantity of the product that you want to buy");
        int quantity=scanner.nextInt();
        scanner.nextLine();
        if(product.quantity<quantity)
        {
            System.out.println("There is a short of stock please lower the quantity or wait until product is back in stock");
            return;
        }
        System.out.println("please chose a form of Payment:");
        System.out.println("1/Cash");
        System.out.println("2/CreditCard");
        System.out.println("3/Paypal");
        int answer=scanner.nextInt();
        scanner.nextLine();
        Payment paymentMode=null;
        double discountPromoCode=0.0;
        switch (answer){
            case 1:
            {
                for(Payment payment:paymentMethods)
                    if(payment instanceof Cash) {
                        paymentMode=payment;
                    }
                break;
            }
            case 2:
            {
                for(Payment payment:paymentMethods)
                    if(payment instanceof CreditCard) {
                        System.out.println("Congratulation by choosing the creditCard option you got a 10% discount!!!");
                        discountPromoCode=0.1;
                        paymentMode=payment;
                    }
                break;
            }
            case 3:
            {
                for(Payment payment:paymentMethods)
                    if(payment instanceof Paypal) {
                        paymentMode=payment;
                    }
                break;
            }
            default:
                System.out.println("choice not available please enter number corresponding to one of the choices given!");
                return;
        }
        if(paymentMode==null)
        {
            System.out.println("You don't have that type of payment");
            return;
        }
        if(product.listPromoCodes!=null)
        {
            System.out.println("Here is a list of promoCodes that you can apply:");
            product.displayPromoCodes();
            System.out.println("Please enter the code of a promoCode of your choice");
            String code = scanner.nextLine();
            for(PromoCode promoCode: product.listPromoCodes)
            {
                if(Objects.equals(promoCode.code, code)) {
                    discountPromoCode += promoCode.Discount / 100.0;
                    System.out.println("Coupon applied your new price is " + product.price * quantity * (1 - discountPromoCode));
                }
            }
        }
        if(paymentMode.getBalance()<product.price*quantity*(1-discountPromoCode))
        {
            System.out.println("Insufficient balance");
            return;
        }
        //Money transaction
        Customer seller=ecommerce.findCustomer(product.idSeller);
        paymentMode.remove(product.price*quantity*(1-discountPromoCode));
        boolean sellerGotMoney=false;
        for(Payment paymentModeSeller:seller.paymentMethods)
        {
            if((paymentMode instanceof Cash )&&(paymentModeSeller instanceof Cash))
            {
                paymentModeSeller.add(product.price*quantity*(1-discountPromoCode));
                sellerGotMoney=true;
                break;
            }
            if((paymentMode instanceof Paypal )&&(paymentModeSeller instanceof Paypal))
            {
                paymentModeSeller.add(product.price*quantity*(1-discountPromoCode));
                sellerGotMoney=true;
                break;
            }
            if((paymentMode instanceof CreditCard)&&(paymentModeSeller instanceof CreditCard))
            {
                paymentModeSeller.add(product.price*quantity*(1-discountPromoCode));
                sellerGotMoney=true;
                break;
            }
        }
        if(!sellerGotMoney)
        {
            seller.paymentMethods.get(0).add(product.price*quantity*(1-discountPromoCode));
            sellerGotMoney=true;
        }
        //removing  bought quantity from offer
        seller.removeOffer(ecommerce,idProduct,quantity);
        this.removeFromShoppingCarte(ecommerce,idProduct);
        //adding order to transaction record
        Order order = new Order(idCustomer,idProduct,quantity,product.price);
        ecommerce.transaction.addOrder(order);
        listOrders.add(order);
        System.out.println("Your order is on it's way!");
    }

    public void leaveReview(ecommerce ecommerce,int idProduct)
    {
        ecommerce.inventory.getProduct(idProduct).AddReview(username);
    }

    @Override
    public String toString() {
        return "Customer:" +
                "idCustomer= " + idCustomer +
                "| username= " + username +
                "| password= " + password +
                "\n| offers= " + offers +
                "\n| shoppingCarte= " + shoppingCarte +
                "\n| list orders= " + listOrders +
                "\n| paymentMethods= " + paymentMethods;
    }
}
