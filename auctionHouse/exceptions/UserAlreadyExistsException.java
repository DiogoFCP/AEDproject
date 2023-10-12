package auctionHouse.exceptions;

public class UserAlreadyExistsException extends Exception{

    private static final String MESSAGE = "Utilizador existente.";

    public String getMessage() { return MESSAGE; }
}
