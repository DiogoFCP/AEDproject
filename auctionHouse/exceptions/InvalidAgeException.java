package auctionHouse.exceptions;

/**
 * TODO
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
public class InvalidAgeException extends Exception{

    private static final String MESSAGE = "Idade inferior a 18 anos.";

    public String getMessage(){ return MESSAGE; }
}
