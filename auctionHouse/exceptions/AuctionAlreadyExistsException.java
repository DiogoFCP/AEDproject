package auctionHouse.exceptions;

public class AuctionAlreadyExistsException extends Exception{

    private static final String MESSAGE = "Leilao existente.";

    public String getMessage() { return MESSAGE; }
}
