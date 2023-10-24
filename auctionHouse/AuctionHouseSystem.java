package auctionHouse;

import auctionHouse.exceptions.*;
import dataStructures.DoubleList;
import dataStructures.List;

public class AuctionHouseSystem implements AuctionHouse{

    private List<User> userList;

    private List<WorkOfArt> artList;

    private List<Auction> auctionList;

    public AuctionHouseSystem(){
        userList = new DoubleList<>();
        artList = new DoubleList<>();
    }

    /**
     * Checks if there is a user with the given login in the system.
     * @param login the same login (unique ID) as the user we are looking for.
     * @return true if the user already exists in the system.
     */
    private boolean hasUser(String login){
        return userList.find(new UserClass(login, null, 0, null)) != -1;
    }

    /**
     * Finds the user with the given ID
     * @pre hasUser = true
     * @param userID name of the user we want to find
     * @return wanted user
     */
    private User findUser(String userID){
        return userList.get(userList.find(new UserClass(userID, null, 0, null)));
        // TODO refazer em uma interface nova e classe nova de list
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
        // TODO outras exeçoes

        userList.remove(new UserClass(login, null, 0, null));

    }

    /**
     * Checks if there is a work of art with the given art ID in the system.
     * @param artID the same ID of the art (unique ID) we are looking for.
     * @return true if the art exists
     */
    private boolean hasArt(String artID){
        return artList.find(new WorkOfArtClass(artID, null, 0, null)) != -1;
    }

    /**
     * Checks if there is an auction with the given auction ID in the system.
     * @param auctionID the same ID of the auction (unique ID) we are looking for.
     * @return true if the auction exists.
     */
    private boolean hasAuction(String auctionID) {
        return auctionList.find(new AuctionClass(auctionID)) != -1;
    }

    /**
     * Finds the art with the given name
     * @pre hasArt = true
     * @param artName name of the art we want to find
     * @return wanted art
     */
    private WorkOfArt findArt(String artName){
        return artList.get(artList.find(new WorkOfArtClass(artName, null, 0, null)));
    }

    private boolean isArtist(String artistLogin){
        return findUser(artistLogin) instanceof ArtistClass;
    }

    public void addWork(String artID, String artistLogin, int year, String artName) throws ArtAlreadyExistsException, UserDoesNotExistException, ArtistDoesNotExistException {
        if(this.hasArt(artID))
            throw new ArtAlreadyExistsException();
        if(!this.hasUser(artistLogin))
            throw new UserDoesNotExistException();
        if(isArtist(artistLogin))
            throw new ArtistDoesNotExistException();
        artList.addLast(new WorkOfArtClass(artID, artistLogin, year, artName));
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

    public void createAuction(String auctionID){
        if(this.hasAuction(auctionID))
            throw new AuctionAlreadyExistsException();
    }

}
