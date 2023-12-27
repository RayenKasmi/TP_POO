import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    static int numberAdmins;
    protected int idAdmin;
    protected String username;
    protected String password;

    public Admin(String username, String password) {
        this.idAdmin = numberAdmins;
        this.username = username;
        this.password = password;
        numberAdmins++;
    }

    public void removeCustomer(ecommerce ecommerce)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the id of the person that you want to remove:");
        int idCustomer=scanner.nextInt();
        scanner.nextLine();
        ecommerce.removeCustomer(idCustomer);
    }
    @Override
    public String toString() {
        return "Admin:" +
                "idAdmin= " + idAdmin +
                "| username= " + username +
                "| password= " + password ;
    }
}
