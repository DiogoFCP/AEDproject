package auctionHouse;

import auctionHouse.exceptions.InvalidAgeException;
import auctionHouse.exceptions.UserAlreadyExistsException;

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
}
