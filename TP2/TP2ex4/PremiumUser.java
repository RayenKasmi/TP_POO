class PremiumUser implements User
{
    protected String UserName;
    protected Playlist pl;
    protected Playlist offlinePlaylist;
    PremiumUser(String a,String name){
        UserName=a;
        pl=new Playlist(name,this);
        offlinePlaylist=new Playlist(this);
    }

    @Override
    public void addToPlaylist(Song s) {
        pl.add(s);
    }

    @Override
    public void removeFromPlaylist(String SongName) {
        pl.remove(SongName);
    }
    @Override
    public void listen() {
        for(Song s : pl.ls){
            s.playSong();
        }
    }
    @Override
    public void sortPlaylist()
    {
        pl.sort();
        offlinePlaylist.sort();
    }
    public void listenOffline() {
        for(Song s : offlinePlaylist.ls){
            s.playSong();
        }
    }
    public void shuffle(int choice)
    {
        if(choice==0)
        {
            pl.shuffle();
        }
        else if(choice==1)
        {
            offlinePlaylist.shuffle();
        }
    }
    public void downloadOffline(Song s){
        System.out.println("downloading "+s.getName());
        offlinePlaylist.add(s);
    }
}
