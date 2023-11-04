package auctionHouse;

public class BidClass implements Bid{

    static final long serialVersionUID = 0L;

    private int value;

    private User bidder;

    private WorkOfArt art;

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
