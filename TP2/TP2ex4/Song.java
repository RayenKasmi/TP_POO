public class Song {
    private String Name;
    private String Lyrics;
    private Artist artist;
    private int size;
    Song(String Name, String Lyrics, Artist artist, int size){
        this.Name=Name;
        this.Lyrics=Lyrics;
        this.artist = artist;
        this.size = size;
    }
    public void playSong()
    {
        System.out.println("♪♪♪♪♪♪"+Lyrics+"♪♪♪♪♪♪");
    }
    public String getName()
    {
        return Name;
    }
    public int getSongLength()
    {
        return Lyrics.length();
    }
    public Artist getArtist() {
        return artist;
    }
    public float getSize() {
        return size;
    }
    public String toString()
    {
        return "Song name: "+Name+" Song Lyrics: "+Lyrics +" "+getSongLength() +" words in "+getSize()+"seconds";
    }

}