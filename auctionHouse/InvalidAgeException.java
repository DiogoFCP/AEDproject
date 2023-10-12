package auctionHouse;

public class InvalidAgeException extends Exception{

    private static final String MESSAGE = "Idade inferior a 18 anos.\n";

    public String getMessage(){ return MESSAGE; }
}
