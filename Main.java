import java.io.*;
import java.util.Scanner;

import auctionHouse.*;
import auctionHouse.exceptions.*;
import constants.*;
import dataStructures.Entry;
import dataStructures.Iterator;

/**
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public class Main {

    /**
     * Name of the file where all the data from the system is stored.
     */
    private static final String DATA_FILE = "auctionHouseData.dat";

    public static void main(String[] args) {
        AuctionHouse ah = load();
        Scanner in = new Scanner(System.in);
        String cmd = in.next().toUpperCase();
        while (!cmd.equals(Commands.QUIT)) {
            switch (cmd) {
                case Commands.ADD_USER -> addUser(ah, in);
                case Commands.ADD_ARTIST -> addArtist(ah, in);
                case Commands.REMOVE_USER -> removeUser(ah, in);
                case Commands.ADD_WORK -> addWork(ah, in);
                case Commands.INFO_USER -> infoUser(ah, in);
                case Commands.INFO_ARTIST -> infoArtist(ah, in);
                case Commands.INFO_WORK -> infoWork(ah, in);
                case Commands.CREATE_AUCTION -> createAuction(ah, in);
                case Commands.ADD_WORK_AUCTION -> addWorkAuction(ah, in);
                case Commands.BID -> bid(ah, in);
                case Commands.CLOSE_AUCTION -> closeAuction(ah, in);
                case Commands.LIST_AUCTION_WORKS -> listAuctionWorks(ah, in);
                case Commands.LIST_ARTIST_WORKS -> listArtistWorks(ah, in);
                case Commands.LIST_BIDS_WORK -> listBidsWork(ah, in);
                case Commands.LIST_WORKS_BY_VALUE -> listWorksByValue(ah, in);
                default -> System.out.println(Prints.UNKNOWN_CMD);
            }
            System.out.println();
            cmd = in.next().toUpperCase();
        }
        System.out.println();
        System.out.println(Prints.EXIT);
        save(ah);
    }

    /**
     * Adds a new base user to the system, this user
     * has a login (unique ID), name, age and email.
     * @param ah the system interface.
     * @param in the input scanner.
     */
    private static void addUser(AuctionHouse ah, Scanner in){
        String login = in.next();
        String name = in.nextLine().trim();
        int age = in.nextInt();
        String email = in.nextLine().trim();
        System.out.println();
        try{
            ah.addUser(login, name, age, email);
            System.out.println(Prints.USER_REGISTERED);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        } catch (UserAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds a new artist user to the system, this artist
     * has a login (unique ID), name, artistic name, age and email.
     * @param ah the system interface.
     * @param in the input scanner.
     */
    private static void addArtist(AuctionHouse ah, Scanner in){
        String login = in.next();
        String name = in.nextLine().trim();
        String artisticName = in.nextLine();
        int age = in.nextInt();
        String email = in.nextLine().trim();
        System.out.println();
        try{
            ah.addArtist(login, name, artisticName, age, email);
            System.out.println(Prints.ARTIST_REGISTERED);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        } catch (UserAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Removes a user with the given login from the system, if the user
     * is an artist also removes all the works the artist created.
     * @param ah the system interface.
     * @param in the input scanner.
     */
    private static void removeUser(AuctionHouse ah, Scanner in){
        String login = in.next();
        System.out.println();
        try{
            ah.removeUser(login);
            System.out.println(Prints.USER_REMOVED);
        } catch (UserHasBidsException e) {
            System.out.println(e.getMessage());
        } catch (ArtistHasAuctionedArtException e) {
            System.out.println(e.getMessage());
        } catch (UserDoesNotExistException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds a work of art to the system, with a given art ID, login of the artist,
     * the year the art was created and the name of the art.
     * @param ah the system interface.
     * @param in the input scanner.
     */
    private static void addWork(AuctionHouse ah, Scanner in){
        String artID = in.next();
        String artistLogin = in.next();
        int year = in.nextInt();
        String name = in.nextLine().trim();
        System.out.println();
        try{
            ah.addWork(artID, artistLogin, year, name);
            System.out.println(Prints.ART_REGISTERED);
        } catch (ArtAlreadyExistsException e) {
            System.out.println(e.getMessage());
        } catch (ArtistDoesNotExistException e) {
            System.out.println(e.getMessage());
        } catch (UserDoesNotExistException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Lists all the known info about a user that exists in the system.
     * @param ah the system interface.
     * @param in the input scanner.
     */
    private static void infoUser(AuctionHouse ah, Scanner in){
        String login = in.next();
        System.out.println();
        try{
            User u = ah.getUser(login);
            System.out.printf(Prints.INFO_USER, u.getLogin(), u.getName(), u.getAge(), u.getEmail());
        } catch (UserDoesNotExistException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Lists all the known info about an artist that exists in the system.
     * @param ah the system interface.
     * @param in the input scanner.
     */
    private static void infoArtist(AuctionHouse ah, Scanner in){
        String login = in.next();
        System.out.println();
        try{
            Artist a = ah.getArtist(login);
            System.out.printf(Prints.INFO_ARTIST, a.getLogin(), a.getName(), a.getArtisticName(), a.getAge(), a.getEmail());
        } catch (ArtistDoesNotExistException e) {
            System.out.println(e.getMessage());
        } catch (UserDoesNotExistException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Lists all the known info about a work of art that exists in the system.
     * @param ah the system interface.
     * @param in the input scanner.
     */
    private static void infoWork(AuctionHouse ah, Scanner in){
        String artID = in.next();
        System.out.println();
        try{
            WorkOfArt w = ah.getWorkOfArt(artID);
            System.out.printf(Prints.INFO_WORK, w.getArtID(), w.getName(), w.getYear(), w.getHighestBid(), w.getAuthorLogin(), w.getAuthorName());
        } catch (ArtDoesNotExistException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a new auction in the system with the given auction ID.
     * @param ah the system interface.
     * @param in the input scanner.
     */
    private static void createAuction(AuctionHouse ah, Scanner in){
        String auctionID = in.next();
        System.out.println();
        try{
            ah.createAuction(auctionID);
            System.out.println(Prints.AUCTION_REGISTERED);
        } catch (AuctionAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds a work of art to a given auction in the system.
     * @param ah the system interface.
     * @param in the input scanner.
     */
    private static void addWorkAuction(AuctionHouse ah, Scanner in){
        String auctionID = in.next();
        String artID = in.next();
        int lowestBid = in.nextInt();
        System.out.println();
        try{
            ah.addWorkAuction(auctionID, artID, lowestBid);
            System.out.println(Prints.WORK_ADDED_TO_AUCTION);
        } catch (AuctionDoesNotExistsException e) {
            System.out.println(e.getMessage());
        } catch (ArtDoesNotExistException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds a bid to a given work of art in a given auction in the system.
     * @param ah the system interface.
     * @param in the input scanner.
     */
    private static void bid(AuctionHouse ah, Scanner in){
        String auctionID = in.next();
        String artID = in.next();
        String login = in.next();
        int value = in.nextInt();
        System.out.println();
        try{
            ah.addBid(auctionID, artID, login, value);
            System.out.println(Prints.BID_ADDED);
        } catch (BidBelowMinValueException e) {
            System.out.println(e.getMessage());
        } catch (ArtDoesNotExistInAuctionException e) {
            System.out.println(e.getMessage());
        } catch (AuctionDoesNotExistsException e) {
            System.out.println(e.getMessage());
        } catch (UserDoesNotExistException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Closes the auction deciding the winners of said auction and lists
     * the status of every single art piece in the said auction.
     * @param ah the system interface.
     * @param in the input scanner.
     */
    private static void closeAuction(AuctionHouse ah, Scanner in){
        String auctionID = in.next();
        System.out.println();
        try{
            Iterator<Bid> it = ah.closeAuction(auctionID);
            System.out.println(Prints.CLOSE_AUCTION_HEADER);
            while(it.hasNext()){
                Bid b = it.next();
                if(b.isFailedBid())
                    System.out.printf(Prints.NOT_SOLD_ART_LISTING, b.getArtID(), b.getArtName());
                else
                    System.out.printf(Prints.SOLD_ART_LISTING, b.getArtID(), b.getArtName(),
                            b.getBidderLogin(), b.getBidderName(), b.getBidValue());
            }
        } catch (AuctionDoesNotExistsException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Lists all the works of art in a given auction.
     * @param ah the system interface.
     * @param in the input scanner.
     */
    private static void listAuctionWorks(AuctionHouse ah, Scanner in){
        String auctionID = in.next();
        System.out.println();
        try{
            Iterator<WorkOfArt> it = ah.listAuctionWorks(auctionID);
            while (it.hasNext()){
                WorkOfArt a = it.next();
                System.out.printf(Prints.AUCTION_WORKS_LISTING, a.getArtID(), a.getName(),
                        a.getYear(), a.getHighestBid(), a.getAuthorLogin(), a.getAuthorName());
            }
        } catch (AuctionHasNoWorksException e) {
            System.out.println(e.getMessage());
        } catch (AuctionDoesNotExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Lists all the art works an artist has added to the system.
     * @param ah the system interface.
     * @param in the input scanner.
     */
    private static void listArtistWorks(AuctionHouse ah, Scanner in){
        String artistLogin = in.next();
        System.out.println();
        try{
            Iterator<Entry<String, WorkOfArt>> it = ah.listArtistWorks(artistLogin);
            while(it.hasNext()){
                WorkOfArt a = it.next().getValue();
                System.out.printf(Prints.ARTIST_WORKS_LISTING, a.getArtID(), a.getName(),
                        a.getYear(), a.getHighestBid());
            }
        } catch (UserDoesNotExistException e) {
            System.out.println(e.getMessage());
        } catch (ArtistDoesNotExistException e) {
            System.out.println(e.getMessage());
        } catch (ArtistHasNoWorksException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Lists all the bids associated to a given work in a given auction.
     * @param ah the system interface.
     * @param in the input scanner.
     */
    private static void listBidsWork(AuctionHouse ah, Scanner in){
        String auctionID = in.next();
        String artID = in.next();
        System.out.println();
        try{
            Iterator<Bid> it = ah.listBidsWork(auctionID, artID);
            while(it.hasNext()){
                Bid b = it.next();
                System.out.printf(Prints.BIDS_WORK_LISTING, b.getBidderLogin(),
                        b.getBidderName(), b.getBidValue());
            }
        } catch (ArtDoesNotExistInAuctionException e) {
            System.out.println(e.getMessage());
        } catch (AuctionDoesNotExistsException e) {
            System.out.println(e.getMessage());
        } catch (WorkHasNoBidsException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Lists all the works in the system by descending order of the highest bid value of
     * the works that already have been sold.
     * @param ah the system interface.
     * @param in the input scanner.
     */
    private static void listWorksByValue(AuctionHouse ah, Scanner in){
        System.out.println();
        try{
            Iterator<Entry<WorkOfArt, WorkOfArt>> it = ah.listWorksByValue();
            while(it.hasNext()){
                WorkOfArt a = it.next().getValue();
                System.out.printf(Prints.WORKS_BY_VALUE_LISTING, a.getArtID(), a.getName(), a.getYear(),
                        a.getHighestBid(), a.getAuthorLogin(), a.getAuthorName());
            }
        } catch (NoSoldArtsException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Saves the auction house system, writing in the file that is going to store it.
     * @param ah the system interface.
     */
    private static void save(AuctionHouse ah) {
        try{
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(DATA_FILE));
            file.writeObject(ah);
            file.flush();
            file.close();
        } catch (IOException ignored) {
        }
    }

    /**
     * Loads the auction house system, reading from the file that stores it.
     * If it is the first execution of the program it creates a new auction house system.
     */
    private static AuctionHouse load() {
        try {
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(DATA_FILE));
            AuctionHouse ah = (AuctionHouse) file.readObject();
            file.close();
            return ah;
        } catch (IOException e) {
            return new AuctionHouseSystem();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
