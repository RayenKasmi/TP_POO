public class BankAccount
{
    protected int accountNumber;
    protected String accountHolderName;
    protected int balance;
    public BankAccount ()
    {
        this.balance=2000;
        this.accountHolderName="Hamadi";
        this.accountNumber=135564;
    }
    public BankAccount (int x,String ch,int y)
    {
        this.balance=y;
        this.accountHolderName=ch;
        this.accountNumber=x;
    }
    public int getAccountNumber(){return(this.accountNumber);};
    public String getAccountHolderName(){return(this.accountHolderName);};
    public int getBalance(){return(this.balance);};
    public void deposit(int amount)
    {
        this.balance+=amount;
    }
    public void withdraw(int amount)
    {
        this.balance-=amount;
    }
    public void afficher()
    {
        System.out.println(" nom: "+this.getAccountHolderName() + "\n acc number: " + this.getAccountNumber() + "\n balance: "+ this.getBalance());
    }
}
