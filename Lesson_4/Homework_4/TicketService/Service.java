package Lesson_4.Homework_4.TicketService;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Lesson_4.Homework_4.TicketService.TicketProviders.BusProvider;
import Lesson_4.Homework_4.TicketService.Tickets.BusTicket;
import Lesson_4.Homework_4.TicketService.Tickets.Ticket;

public class Service {
    
    static String PROVIDER_NAME = "AvtoTrans";
    static long START_TICKET_NUMBER = 111111111;
    static int START_PLACE_NUMBER = 1;
    static String TRIP1 = "Sankt-Petersburg - Vladivostok";
    static String TRIP2 = "Yalta - Vologda";
    static String TRIP3 = "Orenburg - Taganrog";

    public static void ticketCreate(List<Ticket> pack, Date date, String trip) {
        try {
            for (int i = 0; i < 10; i++)
            pack.add(new BusTicket(PROVIDER_NAME,
                START_TICKET_NUMBER++,
                12.99,
                START_PLACE_NUMBER++,
                date,
                trip));
            Thread.sleep(1000);
            System.out.print('.');
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted.....");
        }
    }

    public static long getCardNumber(Scanner scanner) throws ContractException{
        System.out.println("Please enter card number for authentification.");
        try {
            return scanner.nextLong();
        } catch (InputMismatchException serv) {
            throw new ContractException("This card doesn`t exist.");
        } catch (NoSuchElementException | IllegalStateException ex) {
            System.err.println("Input not valid.");
            return -1;
        }
    }

    public static void getDocument(Customer user, Scanner scanner) {
        try {
            System.out.println(String.format("Please enter your first name, "
                + "last name, document ID on each line."));
                user.addDocument(scanner.nextLine(),
                    scanner.nextLine(),
                    scanner.nextLong());
        } catch (InputMismatchException l) {
            System.err.println("Wrong document ID");
        } catch (NoSuchElementException | IllegalStateException e) {
            System.err.println("Input error");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Ticket> ticketPack = new ArrayList<>();
        List<Ticket> ticketPack2 = new ArrayList<>();
        List<Ticket> ticketPack3 = new ArrayList<>();

        // tickets creating
        //region
        System.out.println("\033[H\033[2J");
        System.out.print("Please wait tickets are being created...");
        Date today = new Date(System.currentTimeMillis());
        Service.ticketCreate(ticketPack, today, TRIP1);
        Date today2 = new Date(System.currentTimeMillis());
        Service.ticketCreate(ticketPack2, today2, TRIP2);
        Date today3 = new Date(System.currentTimeMillis());
        Service.ticketCreate(ticketPack3, today3, TRIP3);
        System.out.println("\033[H\033[2J");
        //endregion


        BusProvider avtoTrans = new BusProvider(PROVIDER_NAME);
        Customer user = new Customer("Arseni", 123456789);

        // put tickets and trips info
        //region
        avtoTrans.addTicket(ticketPack);
        avtoTrans.addTicket(ticketPack2);
        avtoTrans.addTicket(ticketPack3);
        avtoTrans.updateTrips();
        //endregion

        // show trips and choice one
        //region
        avtoTrans.getTrips();
        List<Ticket> availableTickets = new ArrayList<>();
        System.out.println("\nPlease choice trip.(Copy/Paste)");
        String trip = new String();
        String tripDate = new String();
        try {
            trip = scanner.nextLine();
            System.out.println("\nPlease choice date of trip.(Copy/Paste)");
            tripDate = scanner.nextLine();
            System.out.println("\033[H\033[2J");
            if (tripDate.equals(today.toString()))
                availableTickets = user.search(today, avtoTrans);
            else if (tripDate.equals(today2.toString()))
                availableTickets = user.search(today2, avtoTrans);
            else if (tripDate.equals(today3.toString()))
                availableTickets = user.search(today3, avtoTrans);
            else System.err.println("Wrong choice.");
        } catch (NoSuchElementException | IllegalArgumentException e) {
            System.err.println("Choice trip. Input error.");
        }
        //endregion

        // choice ticket
        //region
        String ticketNumber = new String();
        System.out.println("\nPlease choice ticket(by number).");
        try {
            ticketNumber = scanner.nextLine();
            for (Ticket ticket : availableTickets) {
                if (ticket.rootNumber == Long.parseLong(ticketNumber)) {
                    Service.getDocument(user, scanner);
                    user.cash.autorization(Service.getCardNumber(scanner));
                    if (user.buyTicket(ticket))
                        avtoTrans.updateTicketStatus(trip,
                        ticket,
                        user.getDocument(0));
                    break;
                }
            }
            System.out.println("\033[H\033[2J");
            System.out.println(String.format("Your ticket:\n%s",
                user.tickets.get(0)));
        } catch (ContractException serv) {
            System.out.println(serv.getMessage());
        } catch (NoSuchElementException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (IndexOutOfBoundsException out) {
            System.err.println("Wrong ticket number.");
        }
        //endregion

        scanner.close();
    }
}
