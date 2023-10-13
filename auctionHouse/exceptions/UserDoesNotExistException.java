package auctionHouse.exceptions;

public class UserDoesNotExistException extends Exception{

    private static final String MESSAGE = "Utilizador inexistente.";

    public String getMessage() { return MESSAGE; }
}
