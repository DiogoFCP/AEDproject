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
     * Removes the user from the system.
     * @param login the unique id that represents the user.
     * @throws UserDoesNotExistException if the user does not exist in the system.
     * @throws UserHasBidsException if the users currently has bids in the system.
     * @throws ArtistHasAuctionedArtException if the user is an artist and has currently auctioned art.
     */
    void removeUser(String login) throws UserDoesNotExistException, UserHasBidsException, ArtistHasAuctionedArtException;

    /**
     * Adds a new work of art to the system, this art
     * has a artID (unique ID), name of the creator, year and name.
     * @param artID identifier (unique ID) of the art.
     * @param artistLogin login of the creator of the art.
     * @param year year of release of the art.
     * @param artName the name of the work of art.
     * @throws ArtAlreadyExistsException if the art already exists in the system.
     * @throws UserDoesNotExistException if the user does not exist in the system.
     * @throws ArtistDoesNotExistException if the given user is not an artist in the system.
     */
    void addWork(String artID, String artistLogin, int year, String artName) throws ArtAlreadyExistsException, UserDoesNotExistException, ArtistDoesNotExistException;

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
