package auctionHouse.exceptions;

public class ArtAlreadyExistsException extends Exception{
        private static final String MESSAGE = "Obra existente.";

        public String getMessage(){ return MESSAGE; }
}
