package auctionHouse;

import java.io.Serializable;

/**
 * A work of art created by an artist in the system,
 * identified by a unique identifier (artID).
 *
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public interface WorkOfArt extends Serializable, Comparable<WorkOfArt> {

    /**
     * Gets the art id.
     *
     * @return the art id.
     */
    String getArtID();

    /**
     * Gets the login of the author.
     *
     * @return the login of the author.
     */
    String getAuthorLogin();

    /**
     * Gets the name of the author.
     *
     * @return the name of the author.
     */

    String getAuthorName();

    /**
     * Gets the year of release.
     *
     * @return the year of release.
     */
    int getYear();

    /**
     * Gets the name of the art.
     *
     * @return the name of the art.
     */
    String getName();

    /**
     * Gets the highest bid the art went for.
     *
     * @return highest bid the art went for.
     */
    int getHighestBid();
}
