package auctionHouse;

/**
 * TODO
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public class WorkOfArtClass implements WorkOfArt {

    /**
     * Serial Version UID of the Class
     */
    static final long serialVersionUID = 0L;

    /**
     * TODO
     */
    private final String artID;

    /**
     * TODO
     */
    private Artist author;

    /**
     * TODO
     */
    private final int year;

    /**
     * TODO
     */
    private final String name;

    /**
     * TODO
     */
    private int highestBid;

    /**
     * TODO
     * @param artID
     * @param author
     * @param year
     * @param name
     */
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

    public void removeFromSelling(){
        this.author.decSellingWorks();
    }

    public void addFromSelling(){
        if(this.author != null) //TODO EXPLAIN WHY THIS IF!!!!
            this.author.incSellingWorks();
    }

    public void updateHighestBid(int value){
        if(value > this.highestBid)
            this.highestBid = value;
    }
}
