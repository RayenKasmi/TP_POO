public class Novel extends Book
{
    private String type;
    private int nbpages;
    private boolean bestseller;
    Novel(String Auther, String Title, int YearOfPublication, String type, int nbpages, boolean bestseller)
    {
        super(Auther,Title,YearOfPublication);
        this.type = type;
        this.nbpages = nbpages;
        this.bestseller = bestseller;
    }
    public void displayInformation()
    {
        System.out.println("Novel: "+this.getTitle()+" written by "+this.getAuther()+" in "+
                this.getYearOfPublication()+ " about " + getType() + " and is "
                +getNbpages()+ " pages long");
    }

    public String getType() {
        return type;
    }

    public int getNbpages() {
        return nbpages;
    }

    public boolean isBestseller() {
        return bestseller;
    }
}
