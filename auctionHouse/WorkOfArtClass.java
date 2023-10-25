package auctionHouse;

public class WorkOfArtClass implements WorkOfArt {

    private final String artID;

    // TODO guardar em obj author ou o login do author?
    private final String author;

    private final int year;

    private final String name;

    private int highestBid;

    //private int lowestBid; // TODO guardar isto em cada Single art auction em vez de cada art ja q pd haver a 2 leiloes da msm art com lowestBids diferentes!

    public WorkOfArtClass(String artID, String author, int year, String name){
        this.artID = artID;
        this.author = author;
        this.year = year;
        this.name = name;
        this.highestBid = 0;
    }

    public String getArtID(){
        return this.artID;
    }

    public String getAuthor(){
        return this.author;
    }

    public int getYear(){
        return this.year;
    }

    public String getName(){
        return this.name;
    }

    public int getHighestBid(){
        return this.highestBid;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        WorkOfArt other = (WorkOfArt) obj;
        if (this.artID == null) {
            return other.getArtID() == null;
        } else return this.artID.equals(other.getArtID());
    }


}
