package auctionHouse;

public class WorkOfArtClass implements WorkOfArt {

    private String artID;

    // TODO guardar em obj author ou o login do author?
    private Artist author;

    private int year;

    private String name;

    public WorkOfArtClass(String artID, Artist author, int year, String name){
        this.artID = artID;
        this.author = author;
        this.year = year;
        this.name = name;
    }
}
