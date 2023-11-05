package auctionHouse;

import auctionHouse.exceptions.*;
import dataStructures.*;

/**
 * Implementation of the Auction House System that manages all the required
 * operations for the program to function.
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public class AuctionHouseSystem implements AuctionHouse{

    /**
     * Serial Version UID of the Class
     */
    static final long serialVersionUID = 0L;

    /**
     * A collection of all the users in the system (Users and Artists(also Users)).
     */
    private final FindAndGetList<User> userList;

    /**
     * A collection of all the works of art in the system.
     */
    private final FindAndGetList<WorkOfArt> artList;

    /**
     * A collection of all the auctions in the system.
     */
    private final FindAndGetList<Auction> auctionList;

    /**
     * Constructor of the AuctionHouseSystem that
     * initializes its data structures and variables.
     */
    public AuctionHouseSystem(){
        userList = new FindAndGetDoubleList<>();
        artList = new FindAndGetDoubleList<>();
        auctionList = new FindAndGetDoubleList<>();
    }

    /**
     * Checks if there is a user with the given login in the system.
     * @param login the same login (unique ID) as the user we are looking for.
     * @return true if the user already exists in the system.
     */
    private boolean hasUser(String login){
        return this.findUser(login) != null;
    }

    /**
     * Finds the user with the given ID
     * @param userID name of the user we want to find
     * @return wanted user
     */
    private User findUser(String userID){
        return userList.findAndGet(new UserClass(userID, null, 0, null));
    }

    /**
     * Removes all the works of art in the system created by the given artist.
     * @param artist the artist that created all the works of art being removed.
     */
    private void removeWorksOfArtist(Artist artist){
        Iterator<WorkOfArt> it = artist.getWorkIterator();
        while(it.hasNext())
            this.artList.remove(it.next());
    }

    /**
     * Checks if there is a work of art with the given art ID in the system.
     * @param artID the same ID of the art (unique ID) we are looking for.
     * @return true if the art exists
     */
    private boolean hasArt(String artID){
        return findArt(artID) != null;
    }

    /**
     * Checks if there is an auction with the given auction ID in the system.
     * @param auctionID the same ID of the auction (unique ID) we are looking for.
     * @return true if the auction exists.
     */
    private boolean hasAuction(String auctionID) {
        return findAuction(auctionID) != null;
    }

    /**
     * Finds the art with the given name
     * @param artName name of the art we want to find
     * @return wanted art
     */
    private WorkOfArt findArt(String artName){
        return artList.findAndGet(new WorkOfArtClass(artName, null, 0, null));
    }

    /**
     * Finds the auction with the given name
     * @param auctionID name of the auction we want to find
     * @return wanted auction
     */
    private Auction findAuction(String auctionID){
        return auctionList.findAndGet(new AuctionClass(auctionID));
    }

    /**
     * Verifies if the given artist login corresponds to a user in the system that is an instance of the artist class.
     * @param artistLogin the login of the artist we are verifying.
     * @return true if the login corresponds to an instance of an artist class.
     */
    private boolean isArtist(String artistLogin){
        return findUser(artistLogin) instanceof ArtistClass;
    }

    public void addUser(String login, String name, int age, String email) throws InvalidAgeException, UserAlreadyExistsException {
        if(age < 18)
            throw new InvalidAgeException();
        if(this.hasUser(login))
            throw new UserAlreadyExistsException();
        userList.addLast(new UserClass(login, name, age, email));
    }

    public void addArtist(String login, String name, String artisticName, int age, String email) throws InvalidAgeException, UserAlreadyExistsException {
        if(age < 18)
            throw new InvalidAgeException();
        if(this.hasUser(login))
            throw new UserAlreadyExistsException();
        userList.addLast(new ArtistClass(login, name, artisticName, age, email));
    }

    public void removeUser(String login) throws UserDoesNotExistException, UserHasBidsException, ArtistHasAuctionedArtException {
        if(!this.hasUser(login))
            throw new UserDoesNotExistException();
        User user = this.findUser(login);
        if(user.hasBids())
            throw new UserHasBidsException();
        if (user instanceof Artist artist && ((Artist) user).hasWorks()) {
            if(artist.hasWorksSelling())
                throw new ArtistHasAuctionedArtException();
            this.removeWorksOfArtist(artist);
        }
        userList.remove(user);
    }

    public void addWork(String artID, String artistLogin, int year, String artName) throws ArtAlreadyExistsException, UserDoesNotExistException, ArtistDoesNotExistException {
        if(this.hasArt(artID))
            throw new ArtAlreadyExistsException();
        if(!this.hasUser(artistLogin))
            throw new UserDoesNotExistException();
        if(!isArtist(artistLogin))
            throw new ArtistDoesNotExistException();
        Artist author = (Artist) this.findUser(artistLogin);
        WorkOfArt workToAdd = new WorkOfArtClass(artID, author, year, artName);
        artList.addLast(workToAdd);
        author.addWork(workToAdd);
    }

    public User getUser(String userLogin) throws UserDoesNotExistException{
        if (!hasUser(userLogin))
            throw new UserDoesNotExistException();
        return findUser(userLogin);
    }

    public Artist getArtist(String userLogin) throws UserDoesNotExistException, ArtistDoesNotExistException{
        if (!this.hasUser(userLogin))
            throw new UserDoesNotExistException();
        else if (!this.isArtist(userLogin))
            throw new ArtistDoesNotExistException();
        return (Artist)findUser(userLogin);
    }

    public WorkOfArt getWorkOfArt(String workID) throws ArtDoesNotExistException{
        if (!this.hasArt(workID))
            throw new ArtDoesNotExistException();
        return findArt(workID);
    }

    public void createAuction(String auctionID) throws AuctionAlreadyExistsException {
        if(this.hasAuction(auctionID))
            throw new AuctionAlreadyExistsException();
        auctionList.addLast(new AuctionClass(auctionID));
    }

    public void addWorkAuction(String auctionID, String artID, int lowestBid) throws AuctionDoesNotExistsException, ArtDoesNotExistException {
        if(!this.hasAuction(auctionID))
            throw new AuctionDoesNotExistsException();
        if(!this.hasArt(artID))
            throw new ArtDoesNotExistException();
        Auction auction = this.findAuction(auctionID);
        auction.addWork(this.getWorkOfArt(artID), lowestBid);
    }

    public void addBid(String auctionID, String artID, String login, int value) throws UserDoesNotExistException, AuctionDoesNotExistsException, ArtDoesNotExistInAuctionException, BidBelowMinValueException {
        if(!this.hasUser(login))
            throw new UserDoesNotExistException();
        if(!this.hasAuction(auctionID))
            throw new AuctionDoesNotExistsException();
        Auction auction = this.findAuction(auctionID);
        if(!auction.hasWorkOfArt(artID))
            throw new ArtDoesNotExistInAuctionException();
        auction.addBid(this.findUser(login), this.findArt(artID), value);
    }

    public Iterator<Bid> closeAuction(String auctionID) throws AuctionDoesNotExistsException {
        if(!this.hasAuction(auctionID))
            throw new AuctionDoesNotExistsException();
        Auction auction = this.findAuction(auctionID);
        this.auctionList.remove(auction);
        return auction.closeAllSingularAuctions();
    }

    public Iterator<WorkOfArt> listAuctionWorks(String auctionID) throws AuctionDoesNotExistsException, AuctionHasNoWorksException {
        if(!this.hasAuction(auctionID))
            throw new AuctionDoesNotExistsException();
        Auction auction = findAuction(auctionID);
        if(auction.hasNoWorks())
            throw new AuctionHasNoWorksException();
        return auction.getWorksIterator();
    }

    public Iterator<Bid> listBidsWork(String auctionID, String artID) throws AuctionDoesNotExistsException, ArtDoesNotExistInAuctionException, WorkHasNoBidsException {
        if(!this.hasAuction(auctionID))
            throw new AuctionDoesNotExistsException();
        Auction auction = this.findAuction(auctionID);
        if(!auction.hasWorkOfArt(artID))
            throw new ArtDoesNotExistInAuctionException();
        WorkOfArt workOfArt = this.findArt(artID);
        if(auction.workHasNoBids(workOfArt))
            throw new WorkHasNoBidsException();
        return auction.getWorksBidsIterator(workOfArt);
    }
}
