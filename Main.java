import java.util.Scanner;

import auctionHouse.AuctionHouse;
import auctionHouse.AuctionHouseSystem;
import auctionHouse.exceptions.InvalidAgeException;
import auctionHouse.exceptions.UserAlreadyExistsException;
import constants.*;

/**
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public class Main {

    private static final String DATA_FILE = "storedQueue.dat";

    public static void main(String[] args) {
        AuctionHouse ah = new AuctionHouseSystem();
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
                //case Commands.LIST_ARTIST_WORKS -> listArtistWorks(ah, in);
                case Commands.LIST_BIDS_WORK -> listBidsWork(ah, in);
                //case Commands.LIST_WORKS_BY_VALUE -> listWorksByValue(ah, in);
                default -> System.out.println(Prints.UNKNOWN_CMD);
            }
            System.out.println();
            cmd = in.next().toUpperCase();
        }
        System.out.println();
        System.out.println(Prints.EXIT);
        save();
    }

    /**
     * Adds a new base user to the system, this user
     * has a login (unique ID), name, age and email.
     * @param ah the system interface.
     * @param in the input scanner.
     */
    private static void addUser(AuctionHouse ah, Scanner in){
        String login = in.next();
        String name = in.nextLine();
        int age = in.nextInt();
        String email = in.nextLine();
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
        String name = in.nextLine();
        String artisticName = in.nextLine();
        int age = in.nextInt();
        String email = in.nextLine();
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
     *
     * @param ah
     * @param in
     */
    private static void removeUser(AuctionHouse ah, Scanner in){
        //TODO
    }

    /**
     *
     * @param ah
     * @param in
     */
    private static void addWork(AuctionHouse ah, Scanner in){
        //TODO
    }

    /**
     *
     * @param ah
     * @param in
     */
    private static void infoUser(AuctionHouse ah, Scanner in){
        //TODO
    }

    /**
     *
     * @param ah
     * @param in
     */
    private static void infoArtist(AuctionHouse ah, Scanner in){
        //TODO
    }

    /**
     *
     * @param ah
     * @param in
     */
    private static void infoWork(AuctionHouse ah, Scanner in){
        //TODO
    }

    /**
     *
     * @param ah
     * @param in
     */
    private static void createAuction(AuctionHouse ah, Scanner in){
        //TODO
    }

    /**
     *
     * @param ah
     * @param in
     */
    private static void addWorkAuction(AuctionHouse ah, Scanner in){
        //TODO
    }

    /**
     *
     * @param ah
     * @param in
     */
    private static void bid(AuctionHouse ah, Scanner in){
        //TODO
    }

    /**
     *
     * @param ah
     * @param in
     */
    private static void closeAuction(AuctionHouse ah, Scanner in){
        //TODO
    }

    /**
     *
     * @param ah
     * @param in
     */
    private static void listAuctionWorks(AuctionHouse ah, Scanner in){
        //TODO
    }

    /**
     *
     * @param ah
     * @param in
     */
    private static void listArtistWorks(AuctionHouse ah, Scanner in){
        // SECOND PART
    }

    /**
     *
     * @param ah
     * @param in
     */
    private static void listBidsWork(AuctionHouse ah, Scanner in){
        //TODO
    }

    /**
     *
     * @param ah
     * @param in
     */
    private static void listWorksByValue(AuctionHouse ah, Scanner in){
        // SECOND PART
    }

    /**
     *
     */
    private static void save() {
        //TODO
    }

    /**
     *
     */
    private static void load() {
        //TODO
    }
}
