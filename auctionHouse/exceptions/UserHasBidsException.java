package auctionHouse.exceptions;

public class UserHasBidsException extends Exception{

    private static final String MESSAGE = "Utilizador com propostas submetidas.";

    public String getMessage() { return MESSAGE; }
}
