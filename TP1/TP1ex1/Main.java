public class Main {
    public static void main(String[] args) {

        BankAccount a=new BankAccount(3000,"mohamed",300);
        BankAccount b=new BankAccount(2020,"hmed",20000);
        a.afficher();
        b.afficher();
        a.withdraw(1000);
        a.afficher();
        a.deposit(10000);
        a.afficher();
        b.withdraw(2000);
        b.afficher();
    }
}