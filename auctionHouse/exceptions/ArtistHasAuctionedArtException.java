package auctionHouse.exceptions;

public class ArtistHasAuctionedArtException extends Exception {

    private static final String MESSAGE = "Artista com obras em leilao.";

    public String getMessage() { return MESSAGE; }
}
