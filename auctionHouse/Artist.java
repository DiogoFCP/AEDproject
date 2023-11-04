package auctionHouse;

import dataStructures.Iterator;

/**
 * TODO
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public interface Artist extends User{

    /**
     * TODO
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
     * TODO
     */
    void incSellingWorks();

    /**
     * TODO
     */
    void decSellingWorks();

    /**
     * TODO
     * @return
     */

    boolean hasWorksSelling();
    /**
     * Gives all the works the artist has, only is casted if hasWorks
     * @return Iterator copy of all works
     */
    Iterator<WorkOfArt> getWorkIterator();
}
