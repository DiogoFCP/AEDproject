package auctionHouse;

/**
 * An artist is also a user but can add works of art and has an artistic name.
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public interface Artist extends User{

    /**
     * Gets the artistic name of the artist.
     * @return the artistic name of the artist.
     */
    String getArtisticName();

}
