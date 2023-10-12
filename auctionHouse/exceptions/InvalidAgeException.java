package auctionHouse.exceptions;

public class InvalidAgeException extends Exception{

    private static final String MESSAGE = "Idade inferior a 18 anos.";

    public String getMessage(){ return MESSAGE; }
}
