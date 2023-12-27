import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class ecommerce {
    protected ArrayList<Customer> listCustomers=new ArrayList<>();
    protected ArrayList<Admin> listAdmins=new ArrayList<>();
    protected Inventory inventory=new Inventory();
    protected Transactions transaction=new Transactions();
    LoginLogout loginLogout=new LoginLogout();
    Menu menu = new Menu();


    public Customer addCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        ArrayList<Payment> paymentMethods = new ArrayList<>();

        do {
            System.out.println("Select a payment method:");
            System.out.println("1. Cash");
            System.out.println("2. Credit Card");
            System.out.println("3. Paypal");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter cash balance: ");
                    double cashBalance = scanner.nextDouble();
                    scanner.nextLine();
                    paymentMethods.add(new Cash(cashBalance));
                    break;
                case 2:
                    System.out.print("Enter credit card number: ");
                    int creditCardNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter PIN: ");
                    int pin = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter credit card balance: ");
                    double creditCardBalance = scanner.nextDouble();
                    scanner.nextLine();
                    paymentMethods.add(new CreditCard(creditCardNumber, pin, creditCardBalance));
                    break;
                case 3:
                    System.out.print("Enter Paypal email: ");
                    String paypalEmail = scanner.nextLine();
                    System.out.print("Enter Paypal password: ");
                    String paypalPassword = scanner.nextLine();
                    System.out.print("Enter Paypal balance: ");
                    double paypalBalance = scanner.nextDouble();
                    scanner.nextLine();
                    paymentMethods.add(new Paypal(paypalEmail, paypalPassword, paypalBalance));
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3");
                    break;
            }
            System.out.print("Do you want to add another payment method? (true/false): ");
        } while (scanner.nextBoolean());
        Customer customer = new Customer(username, password, paymentMethods);
        listCustomers.add(customer);
        System.out.println(customer);
        //System.out.println("Customer added!");
        return customer;
    }

    public Admin addAdmin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Admin admin=new Admin(username,password);
        listAdmins.add(admin);
        return admin;
    }

    public void removeCustomer(int idCustomer) {
        Iterator<Customer> iterator = listCustomers.iterator();
        while (iterator.hasNext()) {
            Customer u = iterator.next();
            if (u.idCustomer == idCustomer) {
                iterator.remove();
                System.out.println("User: " + idCustomer + " removed successfully");
            }
        }
    }

    public Customer findCustomer(int idCustomer){
        for(Customer u:listCustomers)
        {
            if(u.idCustomer==idCustomer){
                return u;
            }
        }
        return null;
    }

    public Customer findCustomer(String username,String password){
        for(Customer u:listCustomers)
        {
            if((Objects.equals(u.password, password))&&(Objects.equals(u.username, username))){
                return u;
            }
        }
        return null;
    }

    public Admin findAdmin(String username,String password){
        for(Admin u:listAdmins)
        {
            if((Objects.equals(u.password, password))&&(Objects.equals(u.username, username))){
                return u;
            }
        }
        return null;
    }

    public void displayCustomers(){
        if(listCustomers.isEmpty())
            System.out.println("Empty");
        else
        {
            for (Customer customer : listCustomers) {
                System.out.println(customer);
                System.out.println();
            }
        }
    }

    public void displayAdmins(){
        if(listAdmins.isEmpty()) {
            System.out.println("Empty");
            System.out.println();
        }
        else
        {
            for (Admin admin: listAdmins) {
                System.out.println(admin);
            }
        }
    }
}
