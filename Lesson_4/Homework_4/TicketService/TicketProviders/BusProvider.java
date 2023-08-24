package Lesson_4.Homework_4.TicketService.TicketProviders;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import Lesson_4.Homework_4.TicketService.Tickets.BusTicket;
import Lesson_4.Homework_4.TicketService.Tickets.Ticket;

public class BusProvider extends TicketProvider{

    private HashMap<String, List<Date>> trips;

    public BusProvider(String name) {
        super(name);
        this.trips = new HashMap<>();
    }
    
    // TODO:
    // return type not match with diagram
    public void getTrips() {
        for (String trip : trips.keySet()) {
            System.out.println(trip);
            for (Date date : trips.get(trip)) {
                System.out.println(date.toString());
            }
        }
    }

    // TEMP
    public void updateTrips() {
        for (Date date : this.tickets.keySet()) {
            for (Ticket ticket : this.tickets.get(date)) {
                BusTicket ticket2 = (BusTicket)ticket;
                this.trips.put(ticket2.trip, new ArrayList<>());
                this.trips.get(ticket2.trip).add(ticket2.date);
            }
        }
    }
}
