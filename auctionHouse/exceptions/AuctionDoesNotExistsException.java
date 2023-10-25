package auctionHouse.exceptions;

public class AuctionDoesNotExistsException extends Exception{

    private static final String MESSAGE = "Leilao inexistente.";

    public String getMessage() { return MESSAGE; }
}
