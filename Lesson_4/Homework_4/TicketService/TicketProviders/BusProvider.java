package Lesson_4.Homework_4.TicketService.TicketProviders;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import Lesson_4.Homework_4.TicketService.ContractException;
import Lesson_4.Homework_4.TicketService.Document;
import Lesson_4.Homework_4.TicketService.Tickets.BusTicket;
import Lesson_4.Homework_4.TicketService.Tickets.Ticket;

public class BusProvider extends TicketProvider{

    private HashMap<String, HashMap<Date, List<Document>>> trips;

    public BusProvider(String name) {
        super(name);
        this.trips = new HashMap<>();
    }
    
    public void getTrips() {
        for (String trip : trips.keySet()) {
            System.out.println(trip);
            for (Date date : trips.get(trip).keySet()) {
                System.out.println(date.toString());
            }
        }
    }

    /**
     * updating information about bus routes for tickets available from the provider
     */
    public void updateTrips() {
        try {
            for (Date date : this.tickets.keySet()) {
                for (Ticket ticket : this.tickets.get(date)) {
                    BusTicket ticket2 = (BusTicket)ticket;
                    if (!this.trips.containsKey(ticket2.trip))
                        this.trips.put(ticket2.trip, new HashMap<Date, List<Document>>());
                    if (!this.trips.get(ticket2.trip).containsKey(date))
                        this.trips.get(ticket2.trip).put(date, new ArrayList<>());
                }
            }
        } catch (NullPointerException nul) {
            System.err.println("Provider have not available tickets");
        }
    }

    /**
     * update ticket status to sold and add document to trip list
     * @param trip
     * @param ticket
     * @param document
     * @throws ContractException
     */
    public void updateTicketStatus(String trip, Ticket ticket, Document document) throws ContractException{
        if (!ticket.isValid) {
            ticket.isValid = true;
            try {
                this.trips.get(trip).get(ticket.date).add(document);
            } catch (NullPointerException nul) {
                throw new ContractException("Have not this trip or date.");
            }
        } else throw new ContractException("Ticket sold.");
    }
}
