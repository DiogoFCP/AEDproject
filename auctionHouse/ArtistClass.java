package auctionHouse;

import dataStructures.FindAndGetDoubleList;
import dataStructures.FindAndGetList;
import dataStructures.Iterator;

public class ArtistClass extends UserClass implements Artist{

    static final long serialVersionUID = 0L;

    private final String artisticName;
    private int numbOfWorksSelling;

    private FindAndGetList<WorkOfArt> artistWorks;

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
