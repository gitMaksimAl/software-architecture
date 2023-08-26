package Lesson_4.Homework_4.TicketService.Tickets;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BusTicket extends Ticket {
    public String trip;
    public Date arrivalTime;

    public BusTicket(String provider, long rootNumber, double price, int place, Date date, String trip) {
        super(provider, rootNumber, price, place, date);
        this.trip = trip;
        this.arrivalTime = new Date();
        // arrival time = date.time + length(trip)
        this.arrivalTime.setTime(arrivalTime.getTime() + TimeUnit.HOURS.toHours(trip.length()));
    }

    public String getTrip() {
        return trip;
    }

    @Override
    public String toString() {
        return String.format(">>>%s<<<\n%s\n%d\nprice: %.2f\nplace: %d\n-----------",
            this.providerName,
            this.trip,
            this.rootNumber,
            this.price,
            this.place);
    }
}
