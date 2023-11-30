package auctionHouse.exceptions;

/**
 * Exception thrown when an artist has works of art being auctioned in an auction.
 *
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public class ArtistHasAuctionedArtException extends Exception {

    private static final String MESSAGE = "Artista com obras em leilao.";

    public String getMessage() {
        return MESSAGE;
    }
}
