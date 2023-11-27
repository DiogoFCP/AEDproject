package auctionHouse.exceptions;

/**
 * Exception thrown when there are no arts sold in the system.
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public class NoSoldArtsException extends Exception{
    private static final String MESSAGE = "Nao existem obras ja vendidas em leilao.";

    public String getMessage() { return MESSAGE; }
}
