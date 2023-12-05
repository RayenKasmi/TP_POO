import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Artist
{
    protected String Name;
    protected String ArtistName;
    protected List<Album> la;
    Artist(String Name,String artistName)
    {
        this.Name = Name;
        this.ArtistName=artistName;
        la=new ArrayList<>();
    }
    public void add(Album a)
    {
        la.add(a);
    }
    public Album remove(String name,Artist artist)
    {
        for(Album a : la){
            if((Objects.equals(a.AlbumName, name))&&(this.equals(artist))){
                la.remove(a);
                return(a);
            }
        }
        return null;
    }
    public boolean equals(Artist artist)
    {
        return((Objects.equals(this.ArtistName, artist.ArtistName))&&(Objects.equals(this.Name, artist.Name)));
    }
    public void list ()
    {
        for(Album a :la)
        {
            System.out.println(a);
            a.list();
        }
    }
    public String toString(){
        return "name "+Name+" artist name "+ArtistName;
    }
}