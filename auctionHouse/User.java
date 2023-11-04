package auctionHouse;

import java.io.Serializable;

/**
 * TODO
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public interface User extends Serializable {

    /**
     * TODO
     * @return the login (unique ID) of the user.
     */
    String getLogin();

    /**
     * TODO
     * @return the full name of the user.
     */
    String getName();

    /**
     * TODO
     * @return the age of the user.
     */
    int getAge();

    /**
     * TODO
     * @return the email of the user.
     */
    String getEmail();

    /**
     * TODO
     */
    void incNumbOfBids();

    /**
     * TODO
     */
    void decNumbOfBids();

    /**
     * TODO
     * @return
     */
    boolean hasBids();

    /**
     * Compares both users based on their login (unique ID).
     * @param obj the other user.
     * @return true if they are the same user (same login ID).
     */
    boolean equals(Object obj);
}
