package auctionHouse;

import auctionHouse.exceptions.BidBelowMinValueException;
import dataStructures.*;

/**
 * A system event identified by a unique ID, when created works of art
 * can be added to the auction, being able to then be auctioned and sold.
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
class AuctionClass implements Auction{


    /*              Instance Variables               */


    /**
     * Serial Version UID of the Class
     */
    static final long serialVersionUID = 0L;

    /**
     * Unique identifier of the auction.
     */
    private final String auctionID;

    /**
     * A collection of structures that represent a single
     * art being auctioned inside this auction.
     */
    private final FindAndGetList<SingleArtAuction> artAuctionsList;


    /*              Constructors Methods               */


    /**
     * Constructor of the AuctionClass that initializes all the variables.
     * @param auctionID the unique ID of the auction.
     */
    public AuctionClass(String auctionID){
        this.auctionID = auctionID;
        this.artAuctionsList = new FindAndGetDoubleList<>();
    }


    /*              Private Methods               */


    /**
     * Checks if there is a single art auction in this auction with the given work of art.
     * @param workOfArt the work of art we are looking for in a single art auction.
     * @return true if the art exists in the auction
     */
    private boolean hasSingularArtAuction(WorkOfArt workOfArt){
        return this.findSingularArtAuction(workOfArt) != null;
    }

    /**
     * Finds the singular art in this auction with the given work of art.
     * @param workOfArt the work of art we are looking for in a single art auction.
     * @return wanted singular art auction.
     */
    private SingleArtAuction findSingularArtAuction(WorkOfArt workOfArt){
        return artAuctionsList.findAndGet(new SingleArtAuctionClass(workOfArt, 0));
    }


    /*              Protected Methods               */


    /**
     * Adds the work of art to the auction and sets the lowest bid it can sell for.
     * @param workOfArt the work of art being added.
     * @param minimumBidRequired the lowest value the work of art can be sold for.
     */
    protected void addWork(WorkOfArt workOfArt, int minimumBidRequired) {
        if(!this.hasSingularArtAuction(workOfArt))
            artAuctionsList.addLast(new SingleArtAuctionClass(workOfArt, minimumBidRequired));
    }

    /**
     * Adds a bid to an art auction going on in this auction with its corresponding value.
     * @param bidder the user who made the bid.
     * @param workOfArt the art being bid on.
     * @param value the value of the bid.
     */
    protected void addBid(User bidder, WorkOfArt workOfArt, int value) throws BidBelowMinValueException {
        ((SingleArtAuctionClass)this.findSingularArtAuction(workOfArt))
                .addBid(bidder, value);
    }


    /*              Public Methods               */


    public String getAuctionID() {
        return this.auctionID;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        Auction other = (Auction) obj;
        if (this.auctionID == null) {
            return other.getAuctionID() == null;
        } else return this.auctionID.equals(other.getAuctionID());
    }

    public boolean hasWorkOfArt(String artID){
        return this.hasSingularArtAuction(new WorkOfArtClass(artID, null, 0, null));
    }

    public boolean hasNoWorks(){ return artAuctionsList.isEmpty(); }

    public Iterator<WorkOfArt> getWorksIterator() {
        Iterator<SingleArtAuction> it = artAuctionsList.iterator();
        List<WorkOfArt> tmpList = new DoubleList<>();
        while(it.hasNext())
            tmpList.addLast(it.next().getArt());
        return tmpList.iterator();
    }

    public boolean workHasNoBids(WorkOfArt workOfArt){
        return findSingularArtAuction(workOfArt).hasNoBids();
    }

    public Iterator<Bid> getWorksBidsIterator(WorkOfArt workOfArt) {
        return findSingularArtAuction(workOfArt).getBidsIterator();
    }

    public Iterator<Bid> closeAllSingularAuctions(Dictionary<WorkOfArt, WorkOfArt> artsSoldSorted){
        List<Bid> winners = new DoubleList<>();
        Iterator<SingleArtAuction> it = artAuctionsList.iterator();
        while (it.hasNext()){
            winners.addLast(
                    ((SingleArtAuctionClass)it.next()).
                            getWinningBid(artsSoldSorted));
        }
        return winners.iterator();
    }
}
