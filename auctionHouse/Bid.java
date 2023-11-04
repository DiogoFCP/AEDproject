package auctionHouse;

import java.io.Serializable;

/**
 * TODO
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public interface Bid extends Serializable {

    /**
     * TODO
     * @return the login of the user who made this bid.
     */
    String getBidderLogin();

    /**
     * TODO
     * @return the name of the user who made this bid.
     */
    String getBidderName();

    /**
     * TODO
     * @return the value of this bid.
     */
    int getBidValue();

    /**
     * TODO
     * @return the ID of the art bid on.
     */
    String getArtID();

    /**
     * TODO
     * @return the name of the art bid on.
     */
    String getArtName();

    /**
     * TODO
     */
    void removeBidFromUser();

    /**
     * TODO
     * @return
     */
    boolean isFailedBid();
}
