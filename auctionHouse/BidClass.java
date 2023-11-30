package auctionHouse;

/**
 * A bid that hold the value of the bid, the user who made the bid and the art.
 *
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
class BidClass implements Bid {


    /*              Instance Variables               */


    /**
     * Serial Version UID of the Class
     */
    static final long serialVersionUID = 0L;

    /**
     * The value of the bid.
     */
    private int value;

    /**
     * The User that made the bid.
     */
    private User bidder;

    /**
     * The Art being bid on.
     */
    private WorkOfArt art;


    /*              Constructors Methods               */


    /**
     * Constructor of the BidClass that initializes all the variables.
     *
     * @param bidder the user who made the bid.
     * @param value  the value of the bid.
     * @param art    the art being bid on.
     */
    public BidClass(User bidder, int value, WorkOfArt art) {
        this.value = value;
        this.bidder = bidder;
        this.art = art;
    }


    /*              Protected Methods               */


    /**
     * Removes the bid from the bidder(User) of this bid.
     */
    protected void removeBidFromUser() {
        ((UserClass) this.bidder).decNumbOfBids();
    }


    /*              Public Methods               */


    public String getBidderLogin() {
        return this.bidder.getLogin();
    }

    public String getBidderName() {
        return this.bidder.getName();
    }

    public int getBidValue() {
        return this.value;
    }

    public String getArtID() {
        return this.art.getArtID();
    }

    public String getArtName() {
        return this.art.getName();
    }

    public boolean isFailedBid() {
        return value < 0;
    }

    public WorkOfArt getArt() {
        return this.art;
    }
}
