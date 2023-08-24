package Lesson_4.Homework_4.TicketService.TicketProviders;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import Lesson_4.Homework_4.TicketService.ServiceException;
import Lesson_4.Homework_4.TicketService.Tickets.Ticket;

public class TicketProvider {

    // TODO:
    // fields not match with diagram
    protected String providerName;
    protected HashMap<Date, List<Ticket>> tickets;

    public TicketProvider(String name) {
        this.providerName = name;
        this.tickets = new HashMap<>();
    }

    public void updateTicketStatus(Ticket ticket) {
        ticket.isValid = true;
    }

    // TODO;
    // args not match with diagram
    public List<Ticket> getTicket(Date date) throws ServiceException{
        try{
            return tickets.get(date);
        } catch (NullPointerException e) {
            throw new ServiceException("have not this data.");
        }
    }

    // TODO:
    // Temporary method not match with diagram
    public void addTicket(List<Ticket> ticketList) {
        for (Ticket ticket : ticketList) {
            if (!this.tickets.containsKey(ticket.date))
                this.tickets.put(ticket.date, new ArrayList<>());
            this.tickets.get(ticket.date).add(ticket);
        }
    }
}
