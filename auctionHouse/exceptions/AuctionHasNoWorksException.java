package auctionHouse.exceptions;

public class AuctionHasNoWorksException extends Exception{

    private static final String MESSAGE = "Leilao sem obras.";

    public String getMessage() { return MESSAGE; }
}
