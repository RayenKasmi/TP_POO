import java.util.Scanner;

public class Admin {
    protected static int numberOfAdmins=0;
    protected int idAdmin;
    protected String password;
    protected String firstName;
    protected String LastName;

    public Admin(String passWord, String firstName, String lastName) {
        System.out.println("User: "+firstName+" "+lastName+" successfully created with id: "+numberOfAdmins);
        this.idAdmin = numberOfAdmins;
        this.password = passWord;
        this.firstName = firstName;
        LastName = lastName;
        numberOfAdmins++;
    }

    public void addUser(Library library)
    {
        library.addUser();
    }

    public void removeUser(Library library)
    {
        System.out.println("Enter the User id that you want to remove");
        Scanner scanner3 = new Scanner(System.in);
        int idUser = scanner3.nextInt();
        if(library.findUser(idUser)!=null)
        {
            library.removeUser(idUser);
            System.out.println("Successfully removed user!");
        }
        else{
            System.out.println("User not found.");
        }
    }

    @Override
    public String toString() {
        return "Admin: " +
                "idAdmin= " + idAdmin +
                " passWord= " + password +
                " firstName= " + firstName +
                " LastName= " + LastName;
    }
}
