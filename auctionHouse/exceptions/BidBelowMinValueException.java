package auctionHouse.exceptions;

public class BidBelowMinValueException extends Exception{

    private static final String MESSAGE = "Valor proposto abaixo do valor minimo.";

    public String getMessage() { return MESSAGE; }
}
