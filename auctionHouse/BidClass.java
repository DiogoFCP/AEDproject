package auctionHouse;

/**
 * TODO
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public class BidClass implements Bid{

    /**
     * Serial Version UID of the Class
     */
    static final long serialVersionUID = 0L;

    /**
     * TODO
     */
    private int value;

    /**
     * TODO
     */
    private User bidder;

    /**
     * TODO
     */
    private WorkOfArt art;

    /**
     * TODO
     * @param bidder
     * @param value
     * @param art
     */
    public BidClass(User bidder, int value, WorkOfArt art){
        this.value = value;
        this.bidder = bidder;
        this.art = art;
    }

    public String getBidderLogin() {
        return this.bidder.getLogin();
    }

    public String getBidderName() {
        return this.bidder.getName();
    }

    public int getBidValue() {
        return this.value;
    }

    public String getArtID() { return this.art.getArtID(); }

    public String getArtName() {
        return this.art.getName();
    }

    public void removeBidFromUser(){
        this.bidder.decNumbOfBids();
    }

    public boolean isFailedBid(){
        return value < 0;
    }
}
