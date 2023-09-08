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

    //purchased tickets are saved by the customer
    public boolean buyTicket(Ticket ticket) {
        try {
            if (!ticket.isValid && cash.getMoney(ticket.price)) {
                this.tickets.add(ticket);
                return true;
            } else return false;
        } catch (ContractException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    /**
     * search for a ticket by date at the provider
     * @param date
     * @param provider
     * @return list of available tickets
     */
    public List<Ticket> search(Date date, TicketProvider provider) {
        List<Ticket> availableTickets = new ArrayList<>();
        try {
            availableTickets = provider.getTicket(date);
            for (Ticket ticket : availableTickets) {
                System.out.println(ticket);
            }
        } catch (ContractException e) {
            System.out.println(e.getMessage());
        } return availableTickets;
    }

    public void addDocument(String name, String lname, long number) {
        this.documents.add(new Document(name, lname, number));
    }

    public Document getDocument(int n) {
        return documents.get(n);
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.name, this.cash);
    }
}