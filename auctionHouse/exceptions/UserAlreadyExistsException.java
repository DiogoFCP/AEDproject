package auctionHouse.exceptions;

/**
 * TODO
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public class UserAlreadyExistsException extends Exception{

    private static final String MESSAGE = "Utilizador existente.";

    public String getMessage() { return MESSAGE; }
}
