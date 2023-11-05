package auctionHouse.exceptions;

/**
 * Exception thrown when a work of art being auction does not have any current bids.
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public class WorkHasNoBidsException extends Exception{

    private static final String MESSAGE = "Obra sem propostas.";

    public String getMessage() { return MESSAGE; }
}
