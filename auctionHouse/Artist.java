package auctionHouse;

import dataStructures.Iterator;

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

    /**
     * Adds a work of art in the system to the respective artist
     * @param workOfArt work of art that exists in the system
     */
    void addWork(WorkOfArt workOfArt);


    /**
     * Checks if the artists has art works in his name
     * @return true if it has worksOfArt
     */
    boolean hasWorks();

    /**
     * Increments the number of works from this artist being sold.
     */
    void incSellingWorks();

    /**
     * Decrements the number of works from this artist being sold.
     */
    void decSellingWorks();

    /**
     * Verifies if the artist has works being sold or not.
     * @return true if the artist has works being sold.
     */

    boolean hasWorksSelling();
    /**
     * Gives all the works the artist has.
     * Only is cast if hasWorks.
     * @return Iterator copy of all works
     */
    Iterator<WorkOfArt> getWorkIterator();
}
