package auctionHouse;

import auctionHouse.exceptions.*;
import dataStructures.DoubleList;
import dataStructures.List;

public class AuctionHouseSystem implements AuctionHouse{

    private List<User> userList;

    private List<WorkOfArt> artList;

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

    public void removeUser(String login) throws UserDoesNotExistException {
        if(!this.hasUser(login))
            throw new UserDoesNotExistException();
        // TODO outras exeçoes

        userList.remove(new UserClass(login, null, 0, null));

    }

    /**
     * Checks if there is a work of art with the given art ID in the system.
     * @param artID the same ID of the art (unique ID) we are looking for.
     * @return
     */
    private boolean hasArt(String artID){
        return artList.find(new WorkOfArtClass(artID, null, 0, null)) != -1;
    }

    // TODO implementar para fzr a exceçao em baixo.
    private boolean isArtist(String artistLogin){
        return user instanceof ArtistClass;
    }

    public void addWork(String artID, String artistLogin, int year, String artName) throws ArtAlreadyExistsException, UserDoesNotExistException {
        if(this.hasArt(artID))
            throw new ArtAlreadyExistsException();
        if(!this.hasUser(artistLogin))
            throw new UserDoesNotExistException();
        if()
            //TODO
    }


}
