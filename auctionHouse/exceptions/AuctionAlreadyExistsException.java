package auctionHouse.exceptions;

/**
 * Exception thrown when an auction already exists in the system.
 *
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public class AuctionAlreadyExistsException extends Exception {

    private static final String MESSAGE = "Leilao existente.";

    public String getMessage() {
        return MESSAGE;
    }
}
