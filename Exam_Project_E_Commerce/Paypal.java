public class Paypal implements Payment{
    protected String email;
    protected String password;
    protected double balance;

    public Paypal(String email, String password, double balance) {
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void add(double amount) {
        balance+=amount;
    }

    @Override
    public void remove(double amount) {
        balance-=amount;
    }

    @Override
    public String toString() {
        return "\nPaypal:" +
                "email= " + email+
                "| password= " + password+
                "| balance= " + balance;
    }
}
