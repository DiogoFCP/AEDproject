package auctionHouse;

import auctionHouse.exceptions.BidBelowMinValueException;
import dataStructures.Iterator;

import java.io.Serializable;

/**
 * An auction dedicated to a single work of art that resides inside an auction.
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public interface SingleArtAuction extends Serializable {

    /**
     * Adds a bid to this current single art auction with
     * the user that is bidding on the art and the value of the bid
     * @param bidder the user bidding on the art.
     * @param value the value being bid on the art.
     */
    void addBid(User bidder, int value) throws BidBelowMinValueException;

    /**
     * gives the art name of the auction
     * @return art name
     */
    String getArtName();

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
     * Decides and gets the winning bid in this single art auction.
     * @return the winning bid in this single art auction.
     */
    Bid getWinningBid();

    /**
     * Gets an iterator with all the bids of this single art auction.
     * @return an iterator with all the bids of this single art auction.
     */
    Iterator<Bid> getBidsIterator();
}
