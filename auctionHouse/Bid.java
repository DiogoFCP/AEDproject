package auctionHouse;

import java.io.Serializable;

/**
 * A bid that hold the value of the bid, the user who made the bid and the art.
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public interface Bid extends Serializable {

    /**
     * Gets the login of the user who made this bid.
     * @return the login of the user who made this bid.
     */
    String getBidderLogin();

    /**
     * Gets the name of the user who made this bid.
     * @return the name of the user who made this bid.
     */
    String getBidderName();

    /**
     * Gets the value of this bid.
     * @return the value of this bid.
     */
    int getBidValue();

    /**
     * Gets the ID of the art bid on.
     * @return the ID of the art bid on.
     */
    String getArtID();

    /**
     * Gets the name of the art bid on.
     * @return the name of the art bid on.
     */
    String getArtName();

    /**
     * Removes the bid from the bidder(User) of this bid.
     */
    void removeBidFromUser();

    /**
     * Used on dummy bids that are created when an art in an auction does not sell.
     * @return true if the art the bid contains failed (price==-1).
     */
    boolean isFailedBid();
}
