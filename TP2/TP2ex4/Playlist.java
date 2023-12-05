import java.util.*;

class Playlist
{
    protected String name;
    protected List<Song> ls;
    protected User user;
    Playlist(User user){
        ls=new ArrayList<>();
        this.user = user;
    }
    Playlist(String name,User user)
    {
        this.name=name;
        this.user=user;
        ls=new ArrayList<>();
    }
    public void add(Song s)
    {
        ls.add(s);
    }
    public Song remove(String songName)
    {
        for(Song s : ls){
            if((Objects.equals(s.getName(), songName))){
                ls.remove(s);
                return(s);
            }
        }
        return null;
    }
    public void shuffle () {
        Collections.shuffle(ls);
        System.out.println();
    }
    public void sort(){
        Collections.sort(ls, Comparator.comparing(Song::getName));
    }
}