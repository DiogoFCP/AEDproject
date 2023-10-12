package auctionHouse;

public class UserAlreadyExistsException extends Exception{

    private static final String MESSAGE = "Utilizador existente\n";

    public String getMessage() { return MESSAGE; }
}
