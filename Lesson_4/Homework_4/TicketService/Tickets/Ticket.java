package Lesson_4.Homework_4.TicketService.Tickets;

import java.util.Date;

public class Ticket {

    public String providerName;
    public long rootNumber;
    public double price;
    public int place;
    public Date date;
    // ticket is valid if sold
    public boolean isValid;

    public Ticket(String provider, long number, double price, int place, Date date) {
        this.providerName = provider;
        this.rootNumber = number;
        this.price = price;
        this.date = date;
        this.place = place;
        this.isValid = false;
    }

    @Override
    public String toString() {
        return String.format(">>>%s<<<\n%d\nprice: %.2f\nplace: %d\n-----------",
            this.providerName,
            this.rootNumber,
            this.price,
            this.place);
    }
}
