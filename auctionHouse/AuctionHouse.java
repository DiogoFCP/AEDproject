package auctionHouse;

import auctionHouse.exceptions.*;
import dataStructures.Iterator;

import java.io.Serializable;

public interface AuctionHouse extends Serializable {

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

    /**
     * Creates an auction, this auction has an auctionID (unique ID).
     * @param auctionID unique ID of the auction.
     * @throws AuctionAlreadyExistsException if an auction with the given ID already exists in the system.
     */
    void createAuction(String auctionID) throws AuctionAlreadyExistsException;

    /**
     * Adds a given work of art to a given auction and sets its lowest bid value.
     * @param auctionID the id of the auction where we are adding the work of art.
     * @param artID the id of the work of art we are adding to the auction.
     * @param lowestBid the lowest value the work of art can be sold in the system for.
     */
    void addWorkAuction(String auctionID, String artID, int lowestBid) throws AuctionDoesNotExistsException, ArtDoesNotExistException;

    /**
     * Adds a bid to a given work of art in a given auction, the bid is represented
     * by a value and login given by the user.
     * @param auctionID the id of the auction where the work of art that is being bid on.
     * @param artID the work of art that is being bid on.
     * @param login the login of the user that is bidding on the given work of at.
     * @param value the value being bid by the user.
     */
    void addBid(String auctionID, String artID, String login, int value) throws UserDoesNotExistException, AuctionDoesNotExistsException, ArtDoesNotExistInAuctionException, BidBelowMinValueException;

    /**
     * Closes the auction with the given auction ID.
     * @param auctionID the auction being closed.
     * @throws AuctionDoesNotExistsException if the auction does not exist in the system.
     */
    void closeAuction(String auctionID) throws AuctionDoesNotExistsException;

    /**
     * Lists all the works in the given auction.
     * @param auctionID the id of the auction the works are being listed.
     * @return An iterator with all the art works being listed.
     * @throws AuctionDoesNotExistsException if the auction does not exist.
     * @throws AuctionHasNoWorksException if the auction has no works registered.
     */
    Iterator<WorkOfArt> listAuctionWorks(String auctionID) throws AuctionDoesNotExistsException, AuctionHasNoWorksException;

    /**
     * Lists all the bids of a given work in a given auction.
     * @param auctionID the id of the auction that contains the given work.
     * @param artID the id of the work that contains the bids we want to list.
     * @return An iterator with all the bids being listed.
     * @throws AuctionDoesNotExistsException if the auction does not exist.
     * @throws ArtDoesNotExistInAuctionException if the art does not exist in the given auction.
     * @throws WorkHasNoBidsException if the given work in the given auction has no bids.
     */
    Iterator<Bid> listBidsWork(String auctionID, String artID) throws AuctionDoesNotExistsException, ArtDoesNotExistInAuctionException, WorkHasNoBidsException;

}
