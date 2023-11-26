package auctionHouse.auction;

import auctionHouse.art.WorkOfArt;
import auctionHouse.art.WorkOfArtClass;
import auctionHouse.users.User;
import auctionHouse.exceptions.BidBelowMinValueException;
import dataStructures.*;

/**
 * A system event identified by a unique ID, when created works of art
 * can be added to the auction, being able to then be auctioned and sold.
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public class AuctionClass implements Auction{

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

    /**
     * Constructor of the AuctionClass that initializes all the variables.
     * @param auctionID the unique ID of the auction.
     */
    public AuctionClass(String auctionID){
        this.auctionID = auctionID;
        this.artAuctionsList = new FindAndGetDoubleList<>();
    }

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

    public String getAuctionID() {
        return this.auctionID;
    }

    public void addWork(WorkOfArt workOfArt, int minimumBidRequired) {
        if(!this.hasSingularArtAuction(workOfArt))
            artAuctionsList.addLast(new SingleArtAuctionClass(workOfArt, minimumBidRequired));
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

    public void addBid(User bidder, WorkOfArt workOfArt, int value) throws BidBelowMinValueException {
        this.findSingularArtAuction(workOfArt).addBid(bidder, value);
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

    public Iterator<Bid> closeAllSingularAuctions(){
        List<Bid> winners = new DoubleList<>();
        Iterator<SingleArtAuction> it = artAuctionsList.iterator();
        while (it.hasNext()){
            winners.addLast(it.next().getWinningBid());
        }
        return winners.iterator();
    }
}
