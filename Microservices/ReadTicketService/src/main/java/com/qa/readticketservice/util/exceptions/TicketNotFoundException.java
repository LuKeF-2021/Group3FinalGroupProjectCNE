package com.qa.readticketservice.util.exceptions;

public class TicketNotFoundException extends RuntimeException{

    public TicketNotFoundException(String exception){
        super("Ticket not found with this id: " + exception);
    }

}
