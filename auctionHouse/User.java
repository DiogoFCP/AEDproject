package auctionHouse;

public interface User {

    /**
     *
     * @return the login (unique ID) of the user.
     */
    String getLogin();

    /**
     * Compares both users based on their login (unique ID).
     * @param obj the other user.
     * @return true if they are the same user (same login ID).
     */
    boolean equals(Object obj);
}
