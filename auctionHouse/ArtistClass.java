package auctionHouse;

import dataStructures.FindAndGetDoubleList;
import dataStructures.FindAndGetList;
import dataStructures.Iterator;

/**
 * TODO
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public class ArtistClass extends UserClass implements Artist{

    /**
     * Serial Version UID of the Class
     */
    static final long serialVersionUID = 0L;

    /**
     * TODO
     */
    private final String artisticName;

    /**
     * TODO
     */
    private int numbOfWorksSelling;

    /**
     * TODO
     */
    private FindAndGetList<WorkOfArt> artistWorks;

    /**
     * TODO
     * @param login
     * @param name
     * @param artisticName
     * @param age
     * @param email
     */
    public ArtistClass(String login, String name, String artisticName, int age, String email) {
        super(login, name, age, email);
        this.artisticName = artisticName;
        this.numbOfWorksSelling = 0;
        artistWorks = new FindAndGetDoubleList<>();
    }

    public String getArtisticName(){ return this.artisticName; }

    public void addWork(WorkOfArt workOfArt){
        artistWorks.addLast(workOfArt);
    }

    public boolean hasWorks(){
        return !artistWorks.isEmpty();
    }

    public void incSellingWorks(){
        numbOfWorksSelling++;
    }

    public void decSellingWorks(){
        numbOfWorksSelling--;
    }

    public boolean hasWorksSelling(){
        return numbOfWorksSelling > 0;
    }

    public Iterator<WorkOfArt> getWorkIterator(){
        return artistWorks.iterator();
    }
}
