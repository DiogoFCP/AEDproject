package auctionHouse;

import dataStructures.FindAndGetDoubleList;
import dataStructures.FindAndGetList;

/**
 * An auction dedicated to a single work of art that resides inside an auction (implementation).
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public class SingleArtAuctionClass implements SingleArtAuction{

    private WorkOfArt art;

    private int minimumBidRequired;

    private FindAndGetList<Bid> bidsList;

    public SingleArtAuctionClass(WorkOfArt art, int minimumBidRequired){
        this.art = art;
        this.minimumBidRequired = minimumBidRequired;
        this.bidsList = new FindAndGetDoubleList<>();
    }

    public void addBid(User bidder, int value) {
        if(value < this.minimumBidRequired)
            bidsList.addLast(new BidClass(bidder, value, this.art ));
        // TODO acabar isto...
    }

    public WorkOfArt getArt(){ return this.art; }

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
