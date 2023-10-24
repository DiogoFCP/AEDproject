package auctionHouse;

public class WorkOfArtClass implements WorkOfArt {

    private String artID;

    // TODO guardar em obj author ou o login do author?
    private String author;

    private int year;

    private String name;

    private int highestBid;

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
}
