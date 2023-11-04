package auctionHouse;

import java.io.Serializable;

/**
 * TODO
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public interface WorkOfArt extends Serializable {

    /**
     * TODO
     * @return the art id.
     */
    String getArtID();

    /**
     * TODO
     * @return the login of the author.
     */
    String getAuthorLogin();

    /**
     * TODO
     * @return the name of the author.
     */

    String getAuthorName();

    /**
     * TODO
     * @return the year of release.
     */
    int getYear();

    /**
     * TODO
     * @return the name of the art.
     */
    String getName();

    /**
     * TODO
     * @return highest bid the art went for.
     */
    int getHighestBid();

    /**
     * TODO
     */
    void removeFromSelling();

    /**
     * TODO
     */
    void addFromSelling();

    /**
     * Updates the highest bid value of the art if the given
     * value is bigger than the highest bid of the art.
     * @param value the value being verified.
     */
    void updateHighestBid(int value);
}
