class FreeUser implements User
{
    protected String UserName;
    protected Playlist pl;
    FreeUser(String a,String name){
        UserName=a;
        pl=new Playlist(name,this);
    }

    @Override
    public void addToPlaylist(Song s) {
        if(pl.ls.size()>=5)
        {
            System.out.println("playlist full get premium for more storage");
        }
        else{
            pl.add(s);
        }
    }

    @Override
    public void removeFromPlaylist(String SongName) {
        pl.remove(SongName);
    }

    @Override
    public void sortPlaylist() {
        System.out.println("cant sort get premium");
    }

    @Override
    public void listen() {
        for(Song s : pl.ls){
            s.playSong();
            System.out.println("ad is playing............(get premium for no ads)");
        }
    }
}