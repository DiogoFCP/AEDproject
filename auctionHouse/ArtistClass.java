package auctionHouse;

import dataStructures.*;

/**
 * An artist is also a user but can add works of art and has an artistic name.
 *
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
class ArtistClass extends UserClass implements Artist {


    /*              Instance Variables              */


    /**
     * Serial Version UID of the Class
     */
    static final long serialVersionUID = 0L;

    /**
     * The artistic name of the artist.
     */
    private final String artisticName;

    /**
     * The number of works of art being currently sold.
     */
    private int numbOfWorksSelling;

    /**
     * A collection of all the works done by the artist.
     * The key is the name of the art and the value is the art.
     */
    private Dictionary<String, WorkOfArt> artistWorks;


    /*              Constructors Methods               */


    /**
     * Constructor of the class ArtistClass, that initializes its variables.
     *
     * @param login        the login of the artist.
     * @param name         the name of the artist.
     * @param artisticName the artistic name of the artist.
     * @param age          the age of the artist.
     * @param email        the email of the artist.
     */
    public ArtistClass(String login, String name, String artisticName, int age, String email) {
        super(login, name, age, email);
        this.artisticName = artisticName;
        this.numbOfWorksSelling = 0;
        artistWorks = new AVLTree<>();
    }


    /*              Protected Methods               */


    /**
     * Adds a work of art in the system to the respective artist
     * @param workOfArt work of art that exists in the system
     */
    protected void addWork(WorkOfArt workOfArt) {
        artistWorks.insert(workOfArt.getName(), workOfArt);
    }

    /**
     * Checks if the artists has art works in his name
     * @return true if it has worksOfArt
     */
    protected boolean hasWorks() {
        return !artistWorks.isEmpty();
    }

    /**
     * Increments the number of works from this artist being sold.
     */
    protected void incSellingWorks() {
        numbOfWorksSelling++;
    }

    /**
     * Decrements the number of works from this artist being sold.
     */
    protected void decSellingWorks() {
        numbOfWorksSelling--;
    }

    /**
     * Verifies if the artist has works being sold or not.
     * @return true if the artist has works being sold.
     */
    protected boolean hasWorksSelling() {
        return numbOfWorksSelling > 0;
    }

    /**
     * Gives all the works the artist has and its corresponding
     * names as the key to the value.
     * Only is cast if hasWorks.
     *
     * @return Iterator copy of all works
     */
    protected Iterator<Entry<String, WorkOfArt>> getWorkIterator() {
        return artistWorks.iterator();
    }


    /*              Public Methods               */


    public String getArtisticName() {
        return this.artisticName;
    }

}
