package auctionHouse;

import dataStructures.Iterator;

import java.io.Serializable;

/**
 * An auction dedicated to a single work of art that resides inside an auction.
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public interface SingleArtAuction extends Serializable {

    /**
     * Gets the object of the art being auctioned in this single art auction.
     * @return the art being auctioned on this single art auction.
     */
    WorkOfArt getArt();

    /**
     * Verifies if the there are no bids in this single art auction.
     * @return true if there are no bids in this single art auction.
     */
    boolean hasNoBids();

    /**
     * Gets an iterator with all the bids of this single art auction.
     * @return an iterator with all the bids of this single art auction.
     */
    Iterator<Bid> getBidsIterator();
}
