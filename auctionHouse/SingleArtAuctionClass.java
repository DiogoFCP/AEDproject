package auctionHouse;

import auctionHouse.exceptions.BidBelowMinValueException;
import dataStructures.FindAndGetDoubleList;
import dataStructures.FindAndGetList;
import dataStructures.Iterator;

/**
 * An auction dedicated to a single work of art that resides inside an auction (implementation).
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public class SingleArtAuctionClass implements SingleArtAuction{

    static final long serialVersionUID = 0L;

    private WorkOfArt art;

    private int minimumBidRequired;

    private FindAndGetList<Bid> bidsList;

    public SingleArtAuctionClass(WorkOfArt art, int minimumBidRequired){
        this.art = art;
        art.addFromSelling();
        this.minimumBidRequired = minimumBidRequired;
        this.bidsList = new FindAndGetDoubleList<>();
    }

    public void addBid(User bidder, int value) throws BidBelowMinValueException {
        if(value < this.minimumBidRequired)
            throw new BidBelowMinValueException();
        bidsList.addLast(new BidClass(bidder, value, this.art ));
        bidder.incNumbOfBids();
    }

    public WorkOfArt getArt(){ return this.art; }

    public String getArtName(){
        return this.art.getName();
    }

    public boolean hasNoBids() {
        return this.bidsList.isEmpty();
    }

    public Bid getWinningBid() {
        if (hasNoBids())
            return new BidClass(null,-1,this.art);
        Iterator<Bid> it = getBidsIterator();
        Bid bid = bidsList.getFirst();
        while (it.hasNext()) {
            Bid toCheck = it.next();
            toCheck.removeBidFromUser();
            if (toCheck.getBidValue() > bid.getBidValue()) {
                bid = toCheck;
            }
        }
        this.art.updateHighestBid(bid.getBidValue());
        this.art.removeFromSelling();
        return bid;
    }

    public Iterator<Bid> getBidsIterator() {
        return this.bidsList.iterator();
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        SingleArtAuction other = (SingleArtAuction) obj;
        if (this.art == null) {
            return other.getArt() == null;
        } else return this.art.equals(other.getArt());
    }
}
