package auctionHouse;

public class AuctionClass implements Auction{

    private final String auctionID;

    public AuctionClass(String auctionID){
        this.auctionID = auctionID;
    }

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
}
