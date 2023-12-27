public class Cash implements Payment{
    protected double balance;

    public Cash(double balance) {
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
        return "\nCash:" +
                " balance= " + balance;
    }
}
