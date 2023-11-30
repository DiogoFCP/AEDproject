package auctionHouse;

import auctionHouse.exceptions.*;
import dataStructures.*;

/**
 * Implementation of the Auction House System that manages all the required
 * operations for the program to function.
 *
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public class AuctionHouseSystem implements AuctionHouse {


    /*              Instance Variables               */


    /**
     * Serial Version UID of the Class
     */
    static final long serialVersionUID = 0L;


    /**
     * A collection of all the users in the system (Users and Artists(also Users))
     * with the login of the user as the key.
     */
    private final Dictionary<String, User> userMap;

    /**
     * A collection of all the works of art in the system,
     * with the artID of the art as a key.
     */
    private final Dictionary<String, WorkOfArt> artMap;

    /**
     * A collection of all the auctions in the system,
     * with the auctionID of the auction as a key.
     */
    private final Dictionary<String, Auction> auctionMap;

    /**
     * A collection of all the sold arts in the system,
     * always sorted by the compareTo of the WorkOfArtClass.
     * uses the own object as the key to be able to be sorted
     * by more criteria than just the artID.
     */
    private final Dictionary<WorkOfArt, WorkOfArt> artsSoldSorted;


    /*              Constructors Methods               */


    /**
     * Constructor of the AuctionHouseSystem that
     * initializes its data structures and variables.
     */
    public AuctionHouseSystem() {
        userMap = new SepChainHashTable<>();
        artMap = new SepChainHashTable<>();
        auctionMap = new SepChainHashTable<>();
        artsSoldSorted = new AVLTree<>();
    }


    /*              Private Methods               */


    /**
     * Converts the id given to a key used on the
     * datastructures that use keys such as Dictionary.
     * Since the id aBc is equal in the system to AbC
     * it converts all ids to uppercase so aBc and AbC
     * refer to the same value in the system.
     *
     * @param id the id being converted.
     * @return the id in a key form (in upper case).
     */
    private String convertToKey(String id) {
        return id.toUpperCase();
    }

    /**
     * Finds the user with the given ID
     *
     * @param userID name of the user we want to find
     * @return wanted user
     */
    private UserClass findUser(String userID) {
        return (UserClass) userMap.find(convertToKey(userID));
    }

    /**
     * Finds the art with the given name
     *
     * @param artID id of the art we want to find
     * @return wanted art
     */
    private WorkOfArtClass findArt(String artID) {
        return (WorkOfArtClass) artMap.find(convertToKey(artID));
    }

    /**
     * Finds the auction with the given name
     *
     * @param auctionID name of the auction we want to find
     * @return wanted auction
     */
    private AuctionClass findAuction(String auctionID) {
        return (AuctionClass) auctionMap.find(convertToKey(auctionID));
    }

    /**
     * Verifies if the given user corresponds to an instance of the artist class.
     *
     * @param user the user of the artist we are verifying.
     * @return true if the user corresponds to an instance of an artist class.
     */
    private boolean isArtist(User user) {
        return user instanceof ArtistClass;
    }

    /**
     * Removes all the works of art in the system created by the given artist.
     *
     * @param artist the artist that created all the works of art being removed.
     */
    private void removeWorksOfArtist(ArtistClass artist) {
        Iterator<Entry<String, WorkOfArt>> it = artist.getWorkIterator();
        //Can't use the key of the entry (String) because it's the art name and not the ID.
        while (it.hasNext()) {
            WorkOfArtClass art = (WorkOfArtClass) it.next().getValue();
            this.artMap.remove(convertToKey(art.getArtID()));
            this.artsSoldSorted.remove(art);
        }
    }


    /*              Public Methods               */


    public void addUser(String login, String name, int age, String email)
            throws InvalidAgeException, UserAlreadyExistsException {
        if (age < 18)
            throw new InvalidAgeException();
        if (this.findUser(login) != null)
            throw new UserAlreadyExistsException();
        userMap.insert(convertToKey(login), new UserClass(login, name, age, email));
    }

    public void addArtist(String login, String name, String artisticName, int age, String email)
            throws InvalidAgeException, UserAlreadyExistsException {
        if (age < 18)
            throw new InvalidAgeException();
        if (this.findUser(login) != null)
            throw new UserAlreadyExistsException();
        userMap.insert(convertToKey(login), new ArtistClass(login, name, artisticName, age, email));
    }

    public void removeUser(String login)
            throws UserDoesNotExistException, UserHasBidsException, ArtistHasAuctionedArtException {
        UserClass user = this.findUser(login);
        if (user == null)
            throw new UserDoesNotExistException();
        if (user.hasBids())
            throw new UserHasBidsException();
        if (user instanceof ArtistClass artist && artist.hasWorks()) {
            if (artist.hasWorksSelling())
                throw new ArtistHasAuctionedArtException();
            this.removeWorksOfArtist(artist);
        }
        userMap.remove(convertToKey(login));
    }

    public void addWork(String artID, String artistLogin, int year, String artName)
            throws ArtAlreadyExistsException, UserDoesNotExistException, ArtistDoesNotExistException {
        if (this.findArt(artID) != null)
            throw new ArtAlreadyExistsException();
        UserClass user = this.findUser(artistLogin);
        if (user == null)
            throw new UserDoesNotExistException();
        if (!this.isArtist(user))
            throw new ArtistDoesNotExistException();
        ArtistClass author = (ArtistClass) user;
        WorkOfArtClass workToAdd = new WorkOfArtClass(artID, author, year, artName);
        artMap.insert(convertToKey(artID), workToAdd);
        author.addWork(workToAdd);
    }

    public User getUser(String userLogin) throws UserDoesNotExistException {
        User user = this.findUser(userLogin);
        if (user == null)
            throw new UserDoesNotExistException();
        return user;
    }

    public Artist getArtist(String userLogin)
            throws UserDoesNotExistException, ArtistDoesNotExistException {
        User user = this.findUser(userLogin);
        if (user == null)
            throw new UserDoesNotExistException();
        else if (!this.isArtist(user))
            throw new ArtistDoesNotExistException();
        return (Artist) user;
    }

    public WorkOfArt getWorkOfArt(String workID)
            throws ArtDoesNotExistException {
        WorkOfArt art = findArt(workID);
        if (art == null)
            throw new ArtDoesNotExistException();
        return art;
    }

    public void createAuction(String auctionID)
            throws AuctionAlreadyExistsException {
        Auction auction = findAuction(auctionID);
        if (auction != null)
            throw new AuctionAlreadyExistsException();
        auctionMap.insert(convertToKey(auctionID), new AuctionClass(auctionID));
    }

    public void addWorkAuction(String auctionID, String artID, int lowestBid)
            throws AuctionDoesNotExistsException, ArtDoesNotExistException {
        AuctionClass auction = this.findAuction(auctionID);
        if (auction == null)
            throw new AuctionDoesNotExistsException();
        WorkOfArt art = this.findArt(artID);
        if (art == null)
            throw new ArtDoesNotExistException();
        auction.addWork(art, lowestBid);
    }

    public void addBid(String auctionID, String artID, String login, int value)
            throws UserDoesNotExistException, AuctionDoesNotExistsException,
            ArtDoesNotExistInAuctionException, BidBelowMinValueException {
        User user = this.findUser(login);
        if (user == null)
            throw new UserDoesNotExistException();
        AuctionClass auction = this.findAuction(auctionID);
        if (auction == null)
            throw new AuctionDoesNotExistsException();
        if (!auction.hasWorkOfArt(artID))
            throw new ArtDoesNotExistInAuctionException();
        auction.addBid(user, this.findArt(artID), value);
    }

    public Iterator<Bid> closeAuction(String auctionID)
            throws AuctionDoesNotExistsException {
        Auction auction = this.findAuction(auctionID);
        if (auction == null)
            throw new AuctionDoesNotExistsException();

        Iterator<Bid> it = auction.closeAllSingularAuctions(this.artsSoldSorted);

        auctionMap.remove(convertToKey(auctionID));
        return it;
    }

    public Iterator<WorkOfArt> listAuctionWorks(String auctionID)
            throws AuctionDoesNotExistsException, AuctionHasNoWorksException {
        Auction auction = findAuction(auctionID);
        if (auction == null)
            throw new AuctionDoesNotExistsException();
        if (auction.hasNoWorks())
            throw new AuctionHasNoWorksException();
        return auction.getWorksIterator();
    }

    public Iterator<Entry<String, WorkOfArt>> listArtistWorks(String artistID)
            throws UserDoesNotExistException, ArtistDoesNotExistException, ArtistHasNoWorksException {
        User user = this.findUser(artistID);
        if (user == null)
            throw new UserDoesNotExistException();
        if (!this.isArtist(user))
            throw new ArtistDoesNotExistException();
        ArtistClass artist = (ArtistClass) user;
        if (!artist.hasWorks())
            throw new ArtistHasNoWorksException();
        return artist.getWorkIterator();
    }

    public Iterator<Bid> listBidsWork(String auctionID, String artID)
            throws AuctionDoesNotExistsException, ArtDoesNotExistInAuctionException, WorkHasNoBidsException {
        Auction auction = this.findAuction(auctionID);
        if (auction == null)
            throw new AuctionDoesNotExistsException();
        if (!auction.hasWorkOfArt(artID))
            throw new ArtDoesNotExistInAuctionException();
        WorkOfArt workOfArt = this.findArt(artID);
        if (auction.workHasNoBids(workOfArt))
            throw new WorkHasNoBidsException();
        return auction.getWorksBidsIterator(workOfArt);
    }

    public Iterator<Entry<WorkOfArt, WorkOfArt>> listWorksByValue()
            throws NoSoldArtsException {
        if (artsSoldSorted.isEmpty())
            throw new NoSoldArtsException();
        return artsSoldSorted.iterator();
    }
}
