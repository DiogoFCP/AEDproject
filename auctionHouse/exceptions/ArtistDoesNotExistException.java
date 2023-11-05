package auctionHouse.exceptions;

/**
 * Exception thrown when an artist does not exist in the system.
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public class ArtistDoesNotExistException extends Exception{
    private static final String MESSAGE = "Artista inexistente.";

    public String getMessage(){ return MESSAGE; }
}
