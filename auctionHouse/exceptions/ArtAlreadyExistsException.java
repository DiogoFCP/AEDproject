package auctionHouse.exceptions;

/**
 * Exception thrown when a work of art already exists in the system.
 *
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public class ArtAlreadyExistsException extends Exception {
    private static final String MESSAGE = "Obra existente.";

    public String getMessage() {
        return MESSAGE;
    }
}
