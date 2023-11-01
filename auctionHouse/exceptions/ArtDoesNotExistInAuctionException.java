package auctionHouse.exceptions;

public class ArtDoesNotExistInAuctionException extends Exception{
    private static final String MESSAGE = "Obra inexistente no leilao.";

    public String getMessage(){ return MESSAGE; }
}
