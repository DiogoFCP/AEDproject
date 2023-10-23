package auctionHouse;

import auctionHouse.exceptions.*;

public interface AuctionHouse {

    /**
     * Adds a new base user to the system, this user
     * has a login (unique ID), name, age and email.
     * @param login unique identifier of the user.
     * @param name name of the user (can have spaces).
     * @param age age of the user.
     * @param email email of the user, also unique.
     * @throws InvalidAgeException if the users age is below 18.
     * @throws UserAlreadyExistsException if the user already exists in the system.
     */
    void addUser(String login, String name, int age, String email) throws InvalidAgeException, UserAlreadyExistsException;

    /**
     * Adds a new artist user to the system, this artist
     * has a login (unique ID), name, artistic name, age and email.
     * @param login unique identifier of the artist.
     * @param name name of the artist (can have spaces).
     * @param artisticName artistic name of the artist (can have spaces).
     * @param age age of the artist.
     * @param email email of the artist, also unique.
     * @throws InvalidAgeException if the artists age is below 18.
     * @throws UserAlreadyExistsException if the artist already exists in the system.
     */
    void addArtist(String login, String name, String artisticName, int age, String email) throws InvalidAgeException, UserAlreadyExistsException;

    /**
     * Gives the object of a user with the given ID
     * @param userLogin ID of the user to search for
     * @return the User object of given ID
     * @throws UserDoesNotExistException if the User does not exist
     */
    User getUser(String userLogin) throws UserDoesNotExistException;

    /**
     * Gives the object of an artist with the given ID
     * @param userLogin ID of the artist to search for
     * @return the Artist object of given ID
     * @throws UserDoesNotExistException if the User does not exist
     * @throws ArtistDoesNotExistException if the User is not an Artist
     */
    Artist getArtist(String userLogin) throws UserDoesNotExistException, ArtistDoesNotExistException;

    /**
     * Gives the object of a work of art with the given ID
     * @param workID ID of the art to search for
     * @return the WorkOfArt object of given ID
     * @throws ArtDoesNotExistException if the art does not exist
     */
    WorkOfArt getWorkOfArt(String workID) throws ArtDoesNotExistException;
}
