import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public void EcommerceApplication(ecommerce ecommerce){
        Scanner scanner=new Scanner(System.in);
        int answer,answerCustomer,ansProduct,ansOffer,ansAdmin;
        TestFillInventory(ecommerce);
        //Menu Code
        do{
            System.out.println("Do you want to:");
            System.out.println("1/Login");
            System.out.println("2/Exit");
            answer=scanner.nextInt();
            scanner.nextLine();
            switch (answer){
                case 1:
                {
                    ecommerce.loginLogout.login(ecommerce);
                    if(ecommerce.loginLogout.customerLoggedIn)
                    {
                        System.out.println("Welcome "+ecommerce.loginLogout.currentCustomer.username+"!!!");
                        do {
                            System.out.println("Do you want to:");
                            System.out.println("1/Browse through all products");
                            System.out.println("2/Browse through products using filter");
                            System.out.println("3/Choose a product");
                            System.out.println("4/Your Offers");
                            System.out.println("5/Display shopping-carte");
                            System.out.println("6/Account Info");
                            System.out.println("7/Logout");
                            answerCustomer = scanner.nextInt();
                            scanner.nextLine();
                            switch (answerCustomer) {
                                case 1:
                                {
                                    ecommerce.inventory.displayAll();
                                    break;
                                }
                                case 2:
                                {
                                    ecommerce.inventory.displayFilter();
                                    break;
                                }
                                case 3:
                                {
                                    System.out.println("Please enter the id of the product you chose:");
                                    int idProduct=scanner.nextInt();
                                    scanner.nextLine();
                                    if(ecommerce.inventory.getProduct(idProduct)!=null)
                                    {
                                        Product product=ecommerce.inventory.getProduct(idProduct);
                                        System.out.println("Do you want to:");
                                        System.out.println("1/Add product to shopping-carte");
                                        System.out.println("2/Order the product");
                                        System.out.println("3/Give a review about the Product");
                                        System.out.println("4/Check Current reviews about the product");
                                        ansProduct=scanner.nextInt();
                                        scanner.nextLine();
                                        switch (ansProduct){
                                            case 1:
                                            {
                                                ecommerce.loginLogout.currentCustomer.addToShoppingCarte(ecommerce,idProduct);
                                                break;
                                            }
                                            case 2:
                                            {
                                                ecommerce.loginLogout.currentCustomer.finalizeOffer(ecommerce,idProduct);
                                                break;
                                            }
                                            case 3:
                                            {
                                                ecommerce.loginLogout.currentCustomer.leaveReview(ecommerce,idProduct);
                                                break;
                                            }
                                            case 4:
                                            {
                                                product.displayReviews();
                                                break;
                                            }
                                            default:
                                                System.out.println("Invalid Input");
                                                break;
                                        }
                                    }
                                    break;
                                }
                                case 4:
                                {
                                    do {
                                        System.out.println("Do you want to:");
                                        System.out.println("1/Add Offer");
                                        System.out.println("2/Remove Offer");
                                        System.out.println("3/Update Offer");
                                        System.out.println("4/Display Current Offers");
                                        System.out.println("5/Exit");
                                        ansOffer = scanner.nextInt();
                                        scanner.nextLine();
                                        switch (ansOffer)
                                        {
                                            case 1:
                                            {
                                                ecommerce.loginLogout.currentCustomer.putForSale(ecommerce);
                                                break;
                                            }
                                            case 2:
                                            {
                                                ecommerce.loginLogout.currentCustomer.removeOffer(ecommerce);
                                                break;
                                            }
                                            case 3:
                                            {
                                                ecommerce.loginLogout.currentCustomer.updateOffer(ecommerce);
                                                break;
                                            }
                                            case 4:
                                            {
                                                ecommerce.loginLogout.currentCustomer.displayOffers();
                                                break;
                                            }
                                            case 5:
                                                break;
                                            default:
                                                System.out.println("Invalid Input");

                                        }
                                    }while (ansOffer!=5);
                                    break;
                                }
                                case 5:
                                {
                                    ecommerce.loginLogout.currentCustomer.displayShoppingCarte();
                                    break;
                                }
                                case 6:
                                {
                                    System.out.println(ecommerce.loginLogout.currentCustomer);
                                    break;
                                }
                                case 7:
                                {
                                    ecommerce.loginLogout.logout();
                                    break;
                                }
                                default:
                                    System.out.println("Invalid Input");
                                    break;
                            }
                        }while(answerCustomer!=7);

                    }
                    else if(ecommerce.loginLogout.adminLoggedIn)
                    {
                        System.out.println("Welcome "+ecommerce.loginLogout.currentAdmin.username+"!!!");
                        do {
                            System.out.println("Do you want to:");
                            System.out.println("1/Ban a Customer");
                            System.out.println("2/Display Current Inventory");
                            System.out.println("3/Display Customer Accounts");
                            System.out.println("4/Display Admin Accounts");
                            System.out.println("5/Display Transactions");
                            System.out.println("6/Account Info");
                            System.out.println("7/Delete a Product");
                            System.out.println("8/Logout");
                            ansAdmin = scanner.nextInt();
                            scanner.nextLine();
                            switch (ansAdmin)
                            {
                                case 1:
                                    ecommerce.loginLogout.currentAdmin.removeCustomer(ecommerce);
                                    break;
                                case 2:
                                    ecommerce.inventory.displayAll();
                                    break;
                                case 3:
                                    ecommerce.displayCustomers();
                                    break;
                                case 4:
                                    ecommerce.displayAdmins();
                                    break;
                                case 5:
                                    ecommerce.transaction.displayOrders();
                                    break;
                                case 6:
                                    System.out.println(ecommerce.loginLogout.currentAdmin);
                                    break;
                                case 7:
                                {
                                    System.out.println("Enter the id of the product that you want to remove");
                                    int idProductDeleted=scanner.nextInt();
                                    scanner.nextLine();
                                    ecommerce.inventory.deleteProduct(idProductDeleted);
                                    break;
                                }
                                case 8:
                                    ecommerce.loginLogout.logout();
                                    break;
                                default:
                                    System.out.println("Invalid Input");
                                    break;
                            }
                        }while(ansAdmin!=8);
                    }
                    break;
                }
                case 2:
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }while(answer!=2);
    }
    public void TestFillInventory(ecommerce ecommerce){
        //adding tester_Customer with id=0
        ArrayList<Payment> paymentMethode=new ArrayList<>();
        Payment cash=new Cash(2000);
        Payment creditCard=new CreditCard(123456789,0000,2000000);
        paymentMethode.add(cash);
        paymentMethode.add(creditCard);
        ecommerce.listCustomers.add(new Customer("customer0","0000",paymentMethode));
        //filling inventory with products
        ecommerce.inventory.listProducts.add(new Electronics(0, "Laptop", "HP", 1200.0, 5, null));
        ecommerce.inventory.listProducts.add(new Car(0, "Sedan", "Toyota", 25000.0, 3, null, 50000));
        ecommerce.inventory.listProducts.add(new Sport(0, "Football", "Nike", 25.0, 50, createPromoCodes(30,80)));
        ecommerce.inventory.listProducts.add(new Game(0, "GTAVI", "Rockstar Games", 60.0, 20, null));
        ecommerce.inventory.listProducts.add(new Food(0, "Chocolate", "Maestro", 3.0, 100, createPromoCodes(10,20), "2023-12-31"));
        ecommerce.inventory.listProducts.add(new Clothes(0, "T-Shirt", "Adidas", 30.0, 10, null, "M", "Kids"));
        ecommerce.inventory.listProducts.add(new Electronics(0, "Smartphone", "Samsung", 800.0, 8, null));
        ecommerce.inventory.listProducts.add(new Car(0, "SUV", "Ford", 30000.0, 4, null, 60000));
        ecommerce.inventory.listProducts.add(new Sport(0, "Running Shoes", "New Balance", 80.0, 30, createPromoCodes(14,75)));
        ecommerce.inventory.listProducts.add(new Game(0, "RedDeadRedemption2", "Rockstar Games", 25.0, 15, createPromoCodes(30,10)));
        ecommerce.inventory.listProducts.add(new Food(0, "Fresh Fruits", "Local Farm", 15.0, 50, null, "2023-12-15"));
        ecommerce.inventory.listProducts.add(new Clothes(0, "Jeans", "Levi's", 50.0, 12, createPromoCodes(25,50), "L", "Female"));
        ecommerce.inventory.listProducts.add(new Electronics(0, "Headphones", "Sony", 100.0, 10, null));
        ecommerce.inventory.listProducts.add(new Car(0, "Convertible", "Chevrolet", 35000.0, 2, createPromoCodes(10,80), 70000));
        ecommerce.inventory.listProducts.add(new Sport(0, "Yoga Mat", "Liforme", 70.0, 25, null));
        ecommerce.inventory.listProducts.add(new Game(0, "GodOfWarRagnarok", "Santa Monica Studio", 20.0, 18, null));
        ecommerce.inventory.listProducts.add(new Food(0, "Canned Soup", "Campbell's", 2.0, 75, createPromoCodes(5,30), "2023-11-30"));
        ecommerce.inventory.listProducts.add(new Clothes(0, "Hoodie", "Calvin Klein", 60.0, 8, null, "S", "Male"));
        ecommerce.inventory.listProducts.add(new Electronics(0, "Smartwatch", "Garmin", 200.0, 7, createPromoCodes(20,40)));
        ecommerce.inventory.listProducts.add(new Car(0, "Truck", "Dodge", 40000.0, 3, null, 80000));
        ecommerce.inventory.listProducts.add(new Sport(0, "Basketball", "Spalding", 30.0, 20, null));
        ecommerce.inventory.listProducts.add(new Game(0, "SuperMario", "Nintendo", 50.0, 15, createPromoCodes(15,35)));
        ecommerce.inventory.listProducts.add(new Food(0, "Frozen Pizza", "DiGiorno", 5.0, 40, createPromoCodes(60,10), "2023-12-10"));
        ecommerce.inventory.listProducts.add(new Clothes(0, "Jacket", "The North Face", 120.0, 5, null, "L", "Male"));
        System.out.println("username=customer0 password=0000");
    }
    private static ArrayList<PromoCode> createPromoCodes(int discount1, int discount2) {
        ArrayList<PromoCode> promoCodes = new ArrayList<>();
        promoCodes.add(new PromoCode("TP_POO", discount1));
        promoCodes.add(new PromoCode("DUCK", discount2));
        return promoCodes;
    }
}

