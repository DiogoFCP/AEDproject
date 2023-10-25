package auctionHouse;

import dataStructures.DoubleList;
import dataStructures.FindAndGetDoubleList;
import dataStructures.FindAndGetList;
import dataStructures.List;

public class AuctionClass implements Auction{

    private final String auctionID;

    private final FindAndGetList<SingleArtAuction> artAuctionsList;

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
        return artAuctionsList.findAndGet(new SingleArtAuctionClass(workOfArt, 0)) != null;
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
}
