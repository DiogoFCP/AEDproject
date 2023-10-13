package auctionHouse.exceptions;

public class ArtistDoesNotExistException extends Exception{
    private static final String MESSAGE = "Artista inexistente.";

    public String getMessage(){ return MESSAGE; }
}
