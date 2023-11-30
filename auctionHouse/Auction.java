package auctionHouse;

import dataStructures.Dictionary;
import dataStructures.Iterator;

import java.io.Serializable;

/**
 * A system event identified by a unique ID, when created works of art
 * can be added to the auction, being able to then be auctioned and sold.
 *
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public interface Auction extends Serializable {

    /**
     * Gets the unique identifier of this auction.
     *
     * @return the unique identifier of this auction.
     */
    String getAuctionID();

    /**
     * Verifies if there is an art with the given ID being auctioned in this auction.
     *
     * @param artID the id of the art we are looking for.
     * @return true if there is an art with the given ID in this auction.
     */
    boolean hasWorkOfArt(String artID);

    /**
     * Verifies if the auction has no works of art registered.
     *
     * @return true if the auction has no works registered.
     */
    boolean hasNoWorks();

    /**
     * Verifies if the given work of art has no bids.
     *
     * @param workOfArt the work of art being verified for its bids.
     * @return true if the work of art given has no bids.
     */
    boolean workHasNoBids(WorkOfArt workOfArt);

    /**
     * Gets an iterator with all the art works in the auction.
     *
     * @return an iterator with all the art works in the auction.
     */
    Iterator<WorkOfArt> getWorksIterator();

    /**
     * Returns an iterator with all the bids of a given work.
     *
     * @param workOfArt the given work of art.
     * @return an iterator with all the bids on the given work.
     */
    Iterator<Bid> getWorksBidsIterator(WorkOfArt workOfArt);

    /**
     * Gets an iterator with all the winning bids in the auction once it is closed.
     *
     * @return an iterator with all the winning bids in the auction once it is closed.
     */
    Iterator<Bid> closeAllSingularAuctions(Dictionary<WorkOfArt, WorkOfArt> artsSoldSorted);

}
