import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library
{
    protected List<Book> lbook;
    Library()
    {
        lbook=new ArrayList<>();
    }
    public void add(Book b)
    {
        if(b!=null)
            lbook.add(b);
    }
    public Book remove(String title,String author)
    {
        for(Book b:lbook){
            if((Objects.equals(b.getAuther(), author))&&(Objects.equals(b.getTitle(), title))){
                lbook.remove(b);
                return(b);
            }
        }
        return null;
    }
    public void list()
    {
        for(Book book: lbook)
        {
            book.displayInformation();
        }
    }
}