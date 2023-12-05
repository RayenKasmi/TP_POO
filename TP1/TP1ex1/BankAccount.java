public class BankAccount
{
    protected int accountNumber;
    protected String accountHolderName;
    protected int balance;
    public BankAccount ()
    {
        this.balance=0;
        this.accountHolderName="";
        this.accountNumber=0;
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
        System.out.println("adding "+amount+" to "+getAccountHolderName()+"'s account");
    }
    public void withdraw(int amount)
    {
        this.balance-=amount;
        System.out.println("removing "+amount+" from "+getAccountHolderName()+"'s account");
    }
    public void afficher()
    {
        System.out.println(" nom: "+this.getAccountHolderName() + "\n acc number: " + this.getAccountNumber() + "\n balance: "+ this.getBalance());
        System.out.println("-------------------------------------------------");
    }
}
