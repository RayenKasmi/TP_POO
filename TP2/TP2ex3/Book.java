public class Book {
    protected String Auther;
    protected String Title;
    protected int YearOfPublication;
    Book(String Auther,String Title,int YearOfPublication)
    {
        this.Auther=Auther;
        this.Title=Title;
        this.YearOfPublication=YearOfPublication;
    }
    public String getTitle(){return Title;}
    public String getAuther(){return Auther;}
    public int getYearOfPublication(){return YearOfPublication;}
    public void displayInformation(){
        System.out.println("Book: "+this.getTitle()+" written by: "+this.getAuther()+" in the year "+this.getYearOfPublication());
    }
}