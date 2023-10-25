package auctionHouse;

public interface Bid {

    /**
     *
     * @return the login of the user who made this bid.
     */
    String getBidderLogin();

    /**
     *
     * @return the name of the user who made this bid.
     */
    String getBidderName();

    /**
     *
     * @return the value of this bid.
     */
    int getBidValue();

    /**
     *
     * @return the ID of the art bid on.
     */
    String getArtID();

    /**
     *
     * @return the name of the art bid on.
     */
    String getArtName();
}
