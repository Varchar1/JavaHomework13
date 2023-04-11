import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Moscow",
            "St Petersburg",
            3500,
            12_00,
            14_30
    );
    Ticket ticket2 = new Ticket("St Petersburg",
            "Kaliningrad",
            3000,
            15_00,
            17_00
    );
    Ticket ticket3 = new Ticket("Moscow",
            "Sochi",
            5000,
            9_00,
            13_10
    );
    Ticket ticket4 = new Ticket("Moscow",
            "Sochi",
            4500,
            10_00,
            14_00
    );
    Ticket ticket5 = new Ticket("Moscow",
            "Sochi",
            4500,
            9_00,
            13_10
    );
    @Test
    public void compareToTest() {
         AviaSouls manager = new AviaSouls();

         manager.add(ticket1);
         manager.add(ticket2);
         manager.add(ticket3);
         manager.add(ticket4);
         manager.add(ticket5);

         Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};
         Arrays.sort(tickets);

         Ticket[] expected = {ticket2, ticket1, ticket4, ticket5, ticket3};
         Ticket[] actual = tickets;
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchTest() {
        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket4, ticket5, ticket3};
        Ticket[] actual = manager.search("Moscow", "Sochi");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void noSearchTest() {
        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Moscow", "Penza");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void comparatorTest() {
        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(tickets, comparator);

        Ticket[] expected = {ticket2, ticket1, ticket4, ticket3, ticket5};
        Ticket[] actual = tickets;
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchAndSortByTest() {
        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4, ticket3, ticket5};
        Ticket[] actual = manager.searchAndSortBy("Moscow", "Sochi", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void noSearchAndSortByTest() {
        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("Moscow", "Penza", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
