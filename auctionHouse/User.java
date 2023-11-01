package auctionHouse;

import java.io.Serializable;

public interface User extends Serializable {

    /**
     *
     * @return the login (unique ID) of the user.
     */
    String getLogin();

    /**
     *
     * @return the full name of the user.
     */
    String getName();

    /**
     *
     * @return the age of the user.
     */
    int getAge();

    /**
     *
     * @return the email of the user.
     */
    String getEmail();

    /**
     * Compares both users based on their login (unique ID).
     * @param obj the other user.
     * @return true if they are the same user (same login ID).
     */
    boolean equals(Object obj);
}
