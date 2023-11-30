package auctionHouse.exceptions;

/**
 * Exception thrown when the value of the bid being added is
 * below the minimum value required for the auction.
 *
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public class BidBelowMinValueException extends Exception {

    private static final String MESSAGE = "Valor proposto abaixo do valor minimo.";

    public String getMessage() {
        return MESSAGE;
    }
}
