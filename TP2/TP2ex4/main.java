
public class Main {
    public static void main(String[] args) {
        System.out.println("Creating artists...");
        Artist artist1 = new Artist("Ed Sheeran", "Ed Sheeran");
        Artist artist2 = new Artist("Michael Jackson", "Michael Jackson");
        Artist artist3 = new Artist("Adele Laurie Blue Adkings", "Adele");
        Artist artist4 = new Artist("Freddie Mercury", "Queen");
        Artist artist5 = new Artist("ABBA", "ABBA");
        Artist artist6 = new Artist("Gordon Mathew", "sting");
        Artist artist7 = new Artist("Abel Makkonen", "The Weekend");
        System.out.println(artist1);
        System.out.println(artist2);
        System.out.println(artist3);
        System.out.println(artist4);
        System.out.println(artist5);
        System.out.println(artist6);
        System.out.println(artist7);

        System.out.println("\nCreating albums");
        Album album1 = new Album("Album1", artist1);
        Album album2 = new Album("Album2", artist2);

        Song song1 = new Song("Shape of You", "The club isn't the best place to find a lover...", artist1, 4);
        Song song2 = new Song("Billie Jean", "She was more like a beauty queen from a movie scene...", artist2, 4);
        Song song3 = new Song("Someone Like You", "Never mind, I'll find someone like you...", artist3, 5);
        Song song4 = new Song("Bohemian Rhapsody", "Is this the real life? Is this just fantasy?...", artist4, 6);
        Song song5 = new Song("Dancing Queen", "You can dance, you can jive, having the time of your life...", artist5, 4);
        Song song6 = new Song("Shape of My Heart", "He deals the cards as a meditation...", artist6, 4);
        Song song7 = new Song("Blinding Lights", "I said, ooh, I'm blinded by the lights...", artist7, 3);

        System.out.println("\naddding songs to albums");
        album1.add(song1);
        album1.add(song3);
        album1.add(song4);
        album2.add(song5);
        album2.add(song6);

        artist1.add(album1);
        artist1.add(album2);
        System.out.println("the artist " +artist1 +" has the following albums");
        artist1.list();

        System.out.println("creating users");
        FreeUser freeUser = new FreeUser("UserFree", "FreeUserPlaylist");
        PremiumUser premiumUser = new PremiumUser("UserPremium", "PremiumUserPlaylist");

        System.out.println(freeUser);
        System.out.println(premiumUser);

        freeUser.addToPlaylist(song1);
        freeUser.addToPlaylist(song2);
        freeUser.addToPlaylist(song3);
        freeUser.addToPlaylist(song4);
        freeUser.addToPlaylist(song5);
        freeUser.addToPlaylist(song6);

        System.out.println("\nFreeUser Playlist:");
        freeUser.listen();
        System.out.println("\nremoving song from userplaylist...");
        freeUser.removeFromPlaylist("Shape of You");

        System.out.println("\nFreeUser Playlist after removing Shape of You:");
        freeUser.listen();

        System.out.println("\nusers playlist after sorting");
        freeUser.sortPlaylist();
        freeUser.listen();
        // Test playlist operations for PremiumUser
        premiumUser.addToPlaylist(song1);
        premiumUser.addToPlaylist(song2);
        premiumUser.addToPlaylist(song3);
        premiumUser.addToPlaylist(song4);
        premiumUser.addToPlaylist(song5);
        premiumUser.addToPlaylist(song6);
        premiumUser.addToPlaylist(song7);

        System.out.println("\nPremiumUser Playlist:");
        premiumUser.listen();

        premiumUser.removeFromPlaylist("Blinding Lights");

        System.out.println("\nPremiumUser Playlist after removing Blinding Lights:");
        premiumUser.listen();

        premiumUser.sortPlaylist();
        System.out.println("\nPremiumUser Playlist after sorting:");
        premiumUser.listen();

        premiumUser.downloadOffline(song1);
        premiumUser.downloadOffline(song2);
        premiumUser.downloadOffline(song3);

        System.out.println("\nPremiumUser Offline Playlist:");
        premiumUser.listenOffline();

        // Test shuffle for PremiumUser
        premiumUser.shuffle(1);
        System.out.println("\nPremiumUser Offline Playlist shuffled:");
        premiumUser.listenOffline();
    }
}
