import java.util.Scanner;

public class LoginLogout {
    Customer currentCustomer;
    Admin currentAdmin;
    boolean customerLoggedIn;
    boolean adminLoggedIn;

    LoginLogout(){
        currentCustomer=null;
        currentAdmin=null;
        customerLoggedIn=false;
        adminLoggedIn=false;
    }

    public void login(ecommerce ecommerce){
        Scanner scanner=new Scanner(System.in);
        do{
            System.out.println("1/Create Account");
            System.out.println("2/Log in to existing account");
            int answer=scanner.nextInt();
            scanner.nextLine();
            if(answer==1)
            {
                System.out.println("Are you a:");
                System.out.println("1/Customer");
                System.out.println("2/Admin");
                int answer1=scanner.nextInt();
                scanner.nextLine();
                if(answer1==1)
                {
                    currentCustomer=ecommerce.addCustomer();
                    customerLoggedIn=true;
                }
                else if(answer1==2)
                {
                    currentAdmin=ecommerce.addAdmin();
                    adminLoggedIn=true;
                }
                else
                    System.out.println("Invalid input");
            }
            else if(answer==2)
            {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                currentCustomer=ecommerce.findCustomer(username,password);
                if(currentCustomer!=null)
                    customerLoggedIn=true;
                else{
                    currentAdmin=ecommerce.findAdmin(username,password);
                    if(currentAdmin!=null)
                        adminLoggedIn=true;
                }
                if(!(customerLoggedIn||adminLoggedIn))
                    System.out.println("Couldn't find account please verify your user name and password");
            }
            else {
                System.out.println("Invalid input");
            }

        }while(!(customerLoggedIn||adminLoggedIn));
        //System.out.println("Login successful");
    }

    public void logout(){
        if(customerLoggedIn)
        {
            currentCustomer=null;
            customerLoggedIn=false;
        }
        if(adminLoggedIn)
        {
            currentAdmin=null;
            adminLoggedIn=false;
        }
    }
}
