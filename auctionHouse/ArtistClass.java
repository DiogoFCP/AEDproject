package auctionHouse;

import dataStructures.FindAndGetDoubleList;
import dataStructures.FindAndGetList;
import dataStructures.Iterator;

/**
 * An artist is also a user but can add works of art and has an artistic name.
 *
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public class ArtistClass extends UserClass implements Artist {

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
     */
    private FindAndGetList<WorkOfArt> artistWorks;

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
        artistWorks = new FindAndGetDoubleList<>();
    }

    public String getArtisticName() {
        return this.artisticName;
    }

    public void addWork(WorkOfArt workOfArt) {
        artistWorks.addLast(workOfArt);
    }

    public boolean hasWorks() {
        return !artistWorks.isEmpty();
    }

    public void incSellingWorks() {
        numbOfWorksSelling++;
    }

    public void decSellingWorks() {
        numbOfWorksSelling--;
    }

    public boolean hasWorksSelling() {
        return numbOfWorksSelling > 0;
    }

    public Iterator<WorkOfArt> getWorkIterator() {
        return artistWorks.iterator();
    }
}
