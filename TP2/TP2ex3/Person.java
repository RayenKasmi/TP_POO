public class Person
{
    protected String first_name;
    protected String last_name;
    protected Book BookInPocession;
    Person(String first_name,String last_name)
    {
        this.first_name=first_name;
        this.last_name=last_name;
        BookInPocession=null;
    }
    String getFirst_name() {
        return first_name;
    }
    String getLast_name(){
        return  last_name;
    }
    Book getBookInPocession(){
        return BookInPocession;
    }
}