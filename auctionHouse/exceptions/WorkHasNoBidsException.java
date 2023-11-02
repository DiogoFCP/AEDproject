package auctionHouse.exceptions;

public class WorkHasNoBidsException extends Exception{

    private static final String MESSAGE = "Obra sem propostas.";

    public String getMessage() { return MESSAGE; }
}
