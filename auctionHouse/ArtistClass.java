package auctionHouse;

public class ArtistClass extends UserClass implements Artist{

    private final String artisticName;

    public ArtistClass(String login, String name, String artisticName, int age, String email) {
        super(login, name, age, email);
        this.artisticName = artisticName;
    }

    public String getArtisticName(){ return this.artisticName; }
}
