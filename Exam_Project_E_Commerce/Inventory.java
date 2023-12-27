import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class Inventory {
    ArrayList<Product> listProducts=new ArrayList<>();

    public void addProduct(int idSeller)
    {
        Scanner scanner = new Scanner(System.in);
        Product product;
        ArrayList<PromoCode> listPromoCodes=new ArrayList<>();
        System.out.println("Enter the type of your Product:");
        System.out.println("1/Electronics");
        System.out.println("2/Car");
        System.out.println("3/Sport");
        System.out.println("4/Games");
        System.out.println("5/Food");
        System.out.println("6/Clothes");
        int value = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter product brand: ");
        String productBrand = scanner.nextLine();
        System.out.print("Enter product price: ");
        double productPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter product quantity: ");
        int productQuantity = scanner.nextInt();
        scanner.nextLine();

        System.out.println("do you want to add a PromoCode?(true/false)");
        boolean answer=scanner.nextBoolean();
        scanner.nextLine();
        while(answer)
        {
            System.out.println("Enter the code: ");
            String code=scanner.nextLine();
            System.out.println("Enter the percentage of the discount(between 0 and 100): ");
            int discount=scanner.nextInt();
            scanner.nextLine();
            PromoCode promoCode=new PromoCode(code,discount);
            listPromoCodes.add(promoCode);
            System.out.println("do you want to add another PromoCode?(true/false)");
            answer=scanner.nextBoolean();
            scanner.nextLine();
        }
        switch (value){
            case 1:
            {
                product=new Electronics(idSeller,productName,productBrand,productPrice,productQuantity,listPromoCodes);
                break;
            }
            case 2:
            {
                System.out.print("Enter car mileage: ");
                int mileage = scanner.nextInt();
                scanner.nextLine();
                product=new Car(idSeller,productName,productBrand,productPrice,productQuantity,listPromoCodes,mileage);
                break;
            }
            case 3:
            {
                product=new Sport(idSeller,productName,productBrand,productPrice,productQuantity,listPromoCodes);
                break;
            }
            case 4:
            {
                product=new Game(idSeller,productName,productBrand,productPrice,productQuantity,listPromoCodes);
                break;
            }
            case 5:
            {
                System.out.print("Enter foods expiration Date: ");
                String expDate = scanner.nextLine();
                product=new Food(idSeller,productName,productBrand,productPrice,productQuantity,listPromoCodes,expDate);
                break;
            }
            case 6:
            {
                System.out.print("Enter size of the clothing(XS/S/M/L/XL/XXL...): ");
                String size = scanner.nextLine();
                System.out.print("Enter type of the clothing (Male/Female/Kids): ");
                String type = scanner.nextLine();
                product = new Clothes(idSeller,productName,productBrand,productPrice,productQuantity,listPromoCodes,size,type);
                break;
            }
            default:
                product=null;
                break;
        }
        if(product!=null)
            listProducts.add(product);

    }

    public Product deleteProduct(int idSeller,int idProduct)
    {
        Iterator<Product> iterator = listProducts.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if ((product.idProduct==idProduct)&&(product.idSeller==idSeller)) {
                iterator.remove();
                System.out.println("Product: " + idProduct + " removed successfully");
                return product;
            }
            else if(product.idProduct == idProduct)
            {
                System.out.println("Unable to remove product (this isn't your product)");
                return null;
            }
        }
        System.out.println("Couldn't find your product");
        return null;
    }
    public Product deleteProduct(int idProduct)
    {
        Iterator<Product> iterator = listProducts.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.idProduct==idProduct) {
                iterator.remove();
                System.out.println("Product: " + idProduct + " removed successfully");
                return product;
            }
        }
        System.out.println("Couldn't find your product");
        return null;
    }
    public Product getProduct(int idProduct)
    {
        for (Product product : listProducts) {
            if (product.idProduct == idProduct) {
                return product;
            }
        }
        System.out.println("Couldn't find your product");
        return null;
    }

    public void updateProduct(int idSeller, int idProduct) {
        for (Product product : listProducts) {
            if ((product.idProduct == idProduct) && (product.idSeller == idSeller)) {
                int value;
                Scanner scanner = new Scanner(System.in);
                do {
                    System.out.println("What do you want to change:");
                    System.out.println("1/ProductName");
                    System.out.println("2/ProductBrand");
                    System.out.println("3/ProductPrice");
                    System.out.println("4/ProductQuantity");
                    System.out.println("5/AddPromoCode");
                    System.out.println("6/Exit");
                    value = scanner.nextInt();
                    scanner.nextLine();

                    switch (value) {
                        case 1:
                        {
                            System.out.print("Enter product name: ");
                            product.name = scanner.nextLine();
                            break;
                        }
                        case 2:
                        {
                            System.out.print("Enter product brand: ");
                            product.brand= scanner.nextLine();
                            break;
                        }
                        case 3:
                        {
                            System.out.print("Enter product price: ");
                            product.price = scanner.nextDouble();
                            scanner.nextLine();
                            break;
                        }
                        case 4:
                        {
                            System.out.print("Enter product quantity: ");
                            product.quantity = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        }
                        case 5:
                        {
                            boolean answer = true;
                            while (answer) {
                                System.out.println("Enter the code: ");
                                String code = scanner.nextLine();
                                System.out.println("Enter the percentage of the discount(between 0 and 100): ");
                                int discount = scanner.nextInt();
                                scanner.nextLine();
                                PromoCode promoCode = new PromoCode(code, discount);
                                product.listPromoCodes.add(promoCode);
                                System.out.println("do you want to add another PromoCode?(true/false)");
                                answer = scanner.nextBoolean();
                            }
                            break;
                        }
                        case 6:
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                            break;
                    }
                } while (value != 6);
                System.out.println("Product: " + idProduct + " updated successfully");
                return;
            } else if (product.idProduct == idProduct) {
                System.out.println("Unable to update product (this isn't your product)");
                return;
            }
        }
        System.out.println("Couldn't find your product");
    }

    public void displayAll()
    {
        for(Product product:listProducts)
        {
            System.out.println(product);
        }
    }

    public void displayFilter()
    {
        Scanner scanner = new Scanner(System.in);
        boolean lowerPriceGiven=false,upperPriceGiven=false,sizeGiven=false,typeGiven=false,mileageGiven=false;
        int upperMileage=0;
        double upperPrice=0.0,lowerPrice=0.0;
        String size="";
        String type="";
        System.out.println("Chose a type:");
        System.out.println("1/Electronics");
        System.out.println("2/Car");
        System.out.println("3/Sport");
        System.out.println("4/Games");
        System.out.println("5/Food");
        System.out.println("6/Clothes");
        int value = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Do you want to also filter by a minimum price?(true/false)");
        lowerPriceGiven=scanner.nextBoolean();
        if(lowerPriceGiven)
        {
            System.out.println("Enter minimum price: ");
            lowerPrice=scanner.nextDouble();
            scanner.nextLine();
        }
        System.out.println("Do you want to also filter by a maximum price?(true/false)");
        upperPriceGiven=scanner.nextBoolean();
        if(upperPriceGiven)
        {
            System.out.println("Enter maximum price: ");
            upperPrice=scanner.nextDouble();
            scanner.nextLine();
        }
        if(value==2)
        {
            System.out.println("Do you want to also filter by mileage?(true/false)");
            mileageGiven=scanner.nextBoolean();
            if(mileageGiven)
            {
                System.out.println("Enter maximum mileage");
                upperMileage=scanner.nextInt();
                scanner.nextLine();
            }
        }
        if(value==6){
            System.out.println("Do you want to also filter by size?(true/false)");
            sizeGiven=scanner.nextBoolean();
            scanner.nextLine();
            if(sizeGiven)
            {
                System.out.print("Enter size of the clothing(XS/S/M/L/XL/XXL...): ");
                size = scanner.nextLine();
            }
            System.out.println("Do you want to also filter by cloathing type?(true/false)");
            typeGiven=scanner.nextBoolean();
            scanner.nextLine();
            if(typeGiven)
            {
                System.out.print("Enter type of the clothing (Male/Female/Kids): ");
                type = scanner.nextLine();
            }
        }
        for(Product product : listProducts)
        {
            boolean testMileage=true;
            boolean testClothes=true;
            //test only for Cars
            if((value==2)&&(check(product,value)))
                testMileage=((!mileageGiven)||(((Car)product).mileage<=upperMileage));
            //test only for Clothes
            if((value==6)&&(check(product,value)))
                testClothes=(((!sizeGiven)||Objects.equals(((Clothes) product).size, size))&&((!typeGiven)||Objects.equals(((Clothes) product).type, type)));

            if((check(product,value))&&((!lowerPriceGiven)||(product.price>=lowerPrice))&&((!upperPriceGiven)||(product.price<=upperPrice))&&testMileage&&testClothes)
                System.out.println(product);
        }
    }

    public boolean check(Product product,int value)
    {
        return switch (value) {
            case 1 -> product instanceof Electronics;
            case 2 -> product instanceof Car;
            case 3 -> product instanceof Sport;
            case 4 -> product instanceof Game;
            case 5 -> product instanceof Food;
            case 6 -> product instanceof Clothes;
            default -> false;
        };
    }
}
