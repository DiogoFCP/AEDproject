package auctionHouse;

import auctionHouse.exceptions.BidBelowMinValueException;
import dataStructures.Dictionary;
import dataStructures.FindAndGetDoubleList;
import dataStructures.FindAndGetList;
import dataStructures.Iterator;

/**
 * An auction dedicated to a single work of art that resides inside an auction (implementation).
 *
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
class SingleArtAuctionClass implements SingleArtAuction {


    /*              Instance Variables               */


    /**
     * Serial Version UID of the Class
     */
    static final long serialVersionUID = 0L;

    /**
     * The art being sold in this single art auction.
     */
    private WorkOfArt art;

    /**
     * The minimum value to bid on this art.
     */
    private int minimumBidRequired;

    /**
     * A collect with all the bids on this art.
     */
    private FindAndGetList<Bid> bidsList;


    /*              Constructors Methods               */


    /**
     * Creates this single art auction initializing its variables and incrementing
     * the art sold counter.
     *
     * @param art                the art being bid on.
     * @param minimumBidRequired the minimum value to bid on the art.
     */
    public SingleArtAuctionClass(WorkOfArt art, int minimumBidRequired) {
        this.art = art;
        // This if condition is strictly necessary in our implementation, so as when a dummy SingleArtAuction
        // is created, the minimum bid is controlled as a negative integer, so the selling counter on the WorkOfArt
        // class does not increment by mistake.
        if (minimumBidRequired >= 0)
            ((WorkOfArtClass) this.art).addFromSelling();
        this.minimumBidRequired = minimumBidRequired;
        this.bidsList = new FindAndGetDoubleList<>();
    }


    /*              Protected Methods               */


    /**
     * Decides and gets the winning bid in this single art auction.
     * Adds the art sold to the artsSoldSorted Collection in the System.
     * If the art already exists in the collection updates it with the new sold value.
     *
     * @return the winning bid in this single art auction.
     */
    protected Bid getWinningBid(Dictionary<WorkOfArt, WorkOfArt> artsSoldSorted) {
        WorkOfArtClass art = ((WorkOfArtClass) this.art);
        if (hasNoBids()) {
            art.removeFromSelling();
            return new BidClass(null, -1, this.art);
        }
        Iterator<Bid> it = getBidsIterator();
        BidClass bid = (BidClass) bidsList.getFirst();
        while (it.hasNext()) {
            BidClass toCheck = (BidClass) it.next();
            toCheck.removeBidFromUser();
            if (toCheck.getBidValue() > bid.getBidValue()) {
                bid = toCheck;
            }
        }
        if (artsSoldSorted.find(this.art) != null)
            artsSoldSorted.remove(this.art);

        art.updateHighestBid(bid.getBidValue());
        art.removeFromSelling();
        artsSoldSorted.insert(art, art);
        return bid;
    }

    /**
     * Adds a bid to this current single art auction with
     * the user that is bidding on the art and the value of the bid
     *
     * @param bidder the user bidding on the art.
     * @param value  the value being bid on the art.
     */
    protected void addBid(User bidder, int value) throws BidBelowMinValueException {
        if (value < this.minimumBidRequired)
            throw new BidBelowMinValueException();
        bidsList.addLast(new BidClass(bidder, value, this.art));
        ((UserClass) bidder).incNumbOfBids();
    }


    /*              Public Methods               */


    public WorkOfArt getArt() {
        return this.art;
    }

    public boolean hasNoBids() {
        return this.bidsList.isEmpty();
    }

    public Iterator<Bid> getBidsIterator() {
        return this.bidsList.iterator();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        SingleArtAuction other = (SingleArtAuction) obj;
        if (this.art == null) {
            return other.getArt() == null;
        } else return this.art.equals(other.getArt());
    }
}
