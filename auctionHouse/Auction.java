package auctionHouse;

public interface Auction {

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
}
