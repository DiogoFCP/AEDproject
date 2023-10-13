package auctionHouse;

import auctionHouse.exceptions.*;
import dataStructures.DoubleList;
import dataStructures.List;

public class AuctionHouseSystem implements AuctionHouse{

    private List<User> userList;

    public AuctionHouseSystem(){
        userList = new DoubleList<>();
    }

    /**
     * Checks if the given user already exists in the system.
     * @param user a user with at least the same login (unique ID) as the user we are looking for.
     * @return true if the user already exists in the system.
     */
    private boolean hasUser(User user){
        return userList.find(user) != -1;
    }

    public void addUser(String login, String name, int age, String email) throws InvalidAgeException, UserAlreadyExistsException {
        if(age < 18)
            throw new InvalidAgeException();
        User user = new UserClass(login, name, age, email);
        if(this.hasUser(user))
            throw new UserAlreadyExistsException();
        userList.addLast(user);
    }

    public void addArtist(String login, String name, String artisticName, int age, String email) throws InvalidAgeException, UserAlreadyExistsException {
        if(age < 18)
            throw new InvalidAgeException();
        User artist = new ArtistClass(login, name, artisticName, age, email);
        if(this.hasUser(artist))
            throw new UserAlreadyExistsException();
        userList.addLast(artist);
    }

    public void removeUser(String login) throws


}
