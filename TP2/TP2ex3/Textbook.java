public class Textbook extends Book
{
    private String subject;
    private int nbpages;
    Textbook(String Auther, String Title, int YearOfPublication, String subject, int nbpages)
    {
        super(Auther,Title,YearOfPublication);
        this.subject = subject;
        this.nbpages = nbpages;
    }
    public void displayInformation()
    {
        System.out.println("Textbook: " + this.getTitle() + " written by " + this.getAuther() +
                " in " + this.getYearOfPublication() + " it talks about: " + getSubject() +
                " and is " + getNbpages()+" pages long" );
    }

    public String getSubject() {
        return subject;
    }
    public int getNbpages() {
        return nbpages;
    }
}
