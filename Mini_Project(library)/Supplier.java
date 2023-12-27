import java.util.Scanner;

public class Supplier {
    static int nbrSuppliers=0;
    protected int idSupplier;
    protected String name;

    public Supplier(String name) {
        this.idSupplier=nbrSuppliers;
        this.name =name;
        nbrSuppliers++;
    }

    void addBooks(Library library)
    {
        boolean t=true;
        Scanner scanner3 = new Scanner(System.in);
        while(t)
        {
            library.addBook();
            System.out.println("Do you want to add another book? (true/false)");
            t = scanner3.nextBoolean();
        }
        //scanner3.close();
    }
}
