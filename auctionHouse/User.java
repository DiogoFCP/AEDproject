package auctionHouse;

import java.io.Serializable;

/**
 * A collector who can bid on arts that are in auctions.
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public interface User extends Serializable {

    /**
     * Gets the login (unique ID) of the user.
     * @return the login (unique ID) of the user.
     */
    String getLogin();

    /**
     * Gets the full name of the user.
     * @return the full name of the user.
     */
    String getName();

    /**
     * Gets the age of the user.
     * @return the age of the user.
     */
    int getAge();

    /**
     * Gets the email of the user.
     * @return the email of the user.
     */
    String getEmail();

    /**
     * Compares both users based on their login (unique ID).
     * @param obj the other user.
     * @return true if they are the same user (same login ID).
     */
    boolean equals(Object obj);

    /**
     * Verifies if the user has made any bids.
     * @return true if the user made any bids.
     */
    boolean hasBids();
}
