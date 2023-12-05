import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Album
{
    protected String AlbumName;
    protected List<Song> ls;
    protected Artist artist;
    Album(String AlbumName,Artist artist)
    {
        this.AlbumName=AlbumName;
        this.artist=artist;
        ls=new ArrayList<>();
    }
    public void add(Song s)
    {
        ls.add(s);
    }
    public Song remove(String name,Artist artist)
    {
        for(Song s : ls){
            if((Objects.equals(s.getName(), name))&&(s.getArtist().equals(artist))){
                ls.remove(s);
                return(s);
            }
        }
        return null;
    }
    public void list ()
    {
        for(Song s :ls)
        {
            System.out.println(s);
        }
    }
    @Override
    public String toString() {
        return "Album name: "+ AlbumName;
    }
}