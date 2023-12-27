public interface Payment {
    public double getBalance();
    public void add(double amount);
    public void remove(double amount);

    public String toString();
}
