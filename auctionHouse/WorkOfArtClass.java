package auctionHouse;

public class WorkOfArtClass implements WorkOfArt {

    static final long serialVersionUID = 0L;

    private final String artID;

    // TODO guardar em obj author ou o login do author?
    private Artist author;

    private final int year;

    private final String name;

    private int highestBid;

    public WorkOfArtClass(String artID, Artist author, int year, String name){
        this.artID = artID;
        this.author = author;
        this.year = year;
        this.name = name;
        this.highestBid = 0;
    }

    public String getArtID(){
        return this.artID;
    }

    public String getAuthorLogin(){
        return this.author.getLogin();
    }

    public String getAuthorName(){
        return this.author.getName();
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
