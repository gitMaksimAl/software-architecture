package Lesson_4.Homework_4.TicketService.TicketProviders;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import Lesson_4.Homework_4.TicketService.ContractException;
import Lesson_4.Homework_4.TicketService.Tickets.Ticket;

public class TicketProvider {

    protected String providerName;
    protected HashMap<Date, List<Ticket>> tickets;

    public TicketProvider(String name) {
        this.providerName = name;
        this.tickets = new HashMap<>();
    }

    public void updateTicketStatus(Ticket ticket) {
        ticket.isValid = true;
    }

    /**
     * return tickets list by date
     * @param date
     * @return
     * @throws ContractException
     */
    public List<Ticket> getTicket(Date date) throws ContractException{
        try{
            return tickets.get(date);
        } catch (NullPointerException e) {
            throw new ContractException("Have not this date.");
        }
    }

    /**
     * add one day tickets pack to provider
     * @param ticketList
     */
    public void addTicket(List<Ticket> ticketList) {
        Date date = ticketList.get(0).date;
        if (!this.tickets.containsKey(date))
            this.tickets.put(date, ticketList);
    }
}
