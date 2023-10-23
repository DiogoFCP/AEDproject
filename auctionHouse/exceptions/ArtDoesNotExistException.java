package auctionHouse.exceptions;

public class ArtDoesNotExistException extends Exception{
    private static final String MESSAGE = "Obra inexistente.";

    public String getMessage(){ return MESSAGE; }
}
