package Lesson_4.Homework_4.TicketService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    
    public static void main(String[] args) {
        List<Ticket> ticketPack = new ArrayList<>();
        List<Ticket> ticketPack2 = new ArrayList<>();
        List<Ticket> ticketPack3 = new ArrayList<>();

        // tickets creating
        //region
        System.err.println("\033[H\033[2J");
        System.out.print("Please wait tickets are being created...");
        Date today = new Date(System.currentTimeMillis());
        Service.ticketCreate(ticketPack, today, TRIP1);
        Date today2 = new Date(System.currentTimeMillis());
        Service.ticketCreate(ticketPack2, today2, TRIP2);
        Date today3 = new Date(System.currentTimeMillis());
        Service.ticketCreate(ticketPack3, today3, TRIP3);
        System.err.println("\033[H\033[2J");
        //endregion


        BusProvider avtoTrans = new BusProvider(PROVIDER_NAME);
        Customer user = new Customer("Arseni", 123456789);
        Date curDate = new Date();

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
        System.out.println("\nPlease choice date of trip.(Copy/Paste)");
        String date = new String();
        try (Scanner scanner = new Scanner(System.in)) {
            date = scanner.nextLine();
            if (date.equals(today.toString())) {
                user.search(today, avtoTrans);
                curDate = today;
            } else if (date.equals(today2.toString())) {
                user.search(today2, avtoTrans);
                curDate = today2;
            } else if (date.equals(today3.toString())) {
                user.search(today3, avtoTrans);
                curDate = today3;
            } else System.out.println("Wrong choice.");
        } catch (NoSuchElementException | IllegalArgumentException e) {
            System.out.println("Wrong input.");
        }
        //endregion

        // choice ticket
        //region
        System.out.println("\nPlease choice ticket(by number).");
        try (Scanner scanner = new Scanner(System.in)) {
            date = scanner.nextLine();
            avtoTrans.getTicket(curDate)
            user.buyTicket
        } catch (NoSuchElementException | IllegalArgumentException e) {
            System.out.println("Wrong input.");
        }

    }
}
