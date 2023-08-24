package Lesson_4.Homework_4.TicketService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Lesson_4.Homework_4.TicketService.TicketProviders.TicketProvider;
import Lesson_4.Homework_4.TicketService.Tickets.Ticket;

/**
 * Customer
 */
public class Customer {

    private static int serial = 1;
    public int id;
    public String name;
    public List<Ticket> tickets;
    public CashProvider cash;
    private List<Document> documents;

    public Customer(String name, long cardNumber) {
        this.id = serial++;
        this.name = name;
        this.cash = new CashProvider(cardNumber);
        this.tickets = new ArrayList<>();
        this.documents = new ArrayList<>();
    }

    public boolean buyTicket(Ticket ticket) {
        try {
            if (!ticket.isValid && cash.getMoney(ticket.price)) {
                tickets.add(ticket);
                return true;
            } else return false;
        } catch (ServiceException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    // TODO:
    // return type not match with diagram
    public void search(Date date, TicketProvider provider) {
        try {
            for (Ticket ticket : provider.getTicket(date)) {
                System.out.println(ticket);
                this.tickets.add(ticket);
            }
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addDocument(String name, String lname, long number) {
        this.documents.add(new Document(name, lname, number));
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.name, this.cash);
    }
}