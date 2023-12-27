public class Book {
    protected static int bookNumber=0;
    protected int idBook;
    protected String title;
    protected String author;
    protected String publishDate;
    protected boolean isPremium;

    public Book(String title, String author, String publishDate, boolean isPremium) {
        System.out.println("Book "+title+" created successfully idBook is: "+bookNumber);
        this.idBook = bookNumber;
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.isPremium = isPremium;
        bookNumber++;
    }

    @Override
    public String toString() {
        return "idBook=" + idBook + " title= " + title + " author= " + author + " publishDate= " + publishDate + " isPremium= " + isPremium;
    }
}
