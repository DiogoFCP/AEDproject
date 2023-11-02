package auctionHouse;

import java.io.Serializable;

public interface WorkOfArt extends Serializable {

    /**
     *
     * @return the art id.
     */
    String getArtID();

    /**
     *
     * @return the login of the author.
     */
    String getAuthorLogin();

    /**
     *
     * @return the name of the author.
     */

    String getAuthorName();

    /**
     *
     * @return the year of release.
     */
    int getYear();

    /**
     *
     * @return the name of the art.
     */
    String getName();

    /**
     *
     * @return highest bid the art went for.
     */
    int getHighestBid();
}
