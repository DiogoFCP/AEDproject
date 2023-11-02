package auctionHouse;

import auctionHouse.exceptions.BidBelowMinValueException;
import dataStructures.Iterator;

import java.io.Serializable;

public interface Auction extends Serializable {

    /**
     *
     * @return the unique identifier of this auction.
     */
    String getAuctionID();


    /**
     * Adds the work of art to the auction and sets the lowest bid it can sell for.
     * @param workOfArt the work of art being added.
     * @param lowestBid the lowest value the work of art can be sold for.
     */
    void addWork(WorkOfArt workOfArt, int lowestBid);

    /**
     * Verifies if there is an art with the given ID being auctioned in this auction.
     * @param artID the id of the art we are looking for.
     * @return true if there is an art with the given ID in this auction.
     */
    boolean hasWorkOfArt(String artID);

    /**
     * Adds a bid to an art auction going on in this auction with its corresponding value.
     * @param bidder the user who made the bid.
     * @param workOfArt the art being bid on.
     * @param value the value of the bid.
     */
    void addBid(User bidder, WorkOfArt workOfArt, int value) throws BidBelowMinValueException;

    /**
     *
     * @return true if the auction has no works registered.
     */
    boolean hasNoWorks();

    /**
     *
     * @return an iterator with all the art works in the auction.
     */
    Iterator<WorkOfArt> getWorksIterator();

    /**
     * Verifies if the given work of art has no bids.
     * @param workOfArt the work of art being verified for its bids.
     * @return true if the work of art given has no bids.
     */
    boolean workHasNoBids(WorkOfArt workOfArt);

    /**
     * Returns an iterator with all the bids of a given work.
     * @param workOfArt the given work of art.
     * @return an iterator with all the bids on the given work.
     */
    Iterator<Bid> getWorksBidsIterator(WorkOfArt workOfArt);

}
