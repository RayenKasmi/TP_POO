public class CreditCard implements Payment{
    protected int creditCardNumber;
    protected int pin;
    protected double balance;

    public CreditCard(int creditCardNumber,int pin, double balance) {
        this.creditCardNumber = creditCardNumber;
        this.pin=pin;
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
        return "\nCreditCard: " +
                "creditCardNumber= " + creditCardNumber +
                "| pin= " + pin +
                "| balance= " + balance;
    }
}
