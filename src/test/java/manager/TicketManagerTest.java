package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import domain.InfoTicket;
import repository.TicketRepository;


import static org.junit.jupiter.api.Assertions.*;


public class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private InfoTicket first = new InfoTicket(1, 3436, "SVO", "KUF", 31);
    private InfoTicket second = new InfoTicket(2, 2138, "KUF", "VKO", 64);
    private InfoTicket third = new InfoTicket(3, 1487, "KUF", "VKO", 36);
    private InfoTicket fourth = new InfoTicket(4, 8954, "SVO", "KUF", 98);
    private InfoTicket fifth = new InfoTicket(5, 4779, "VKO", "KZN", 63);
    private InfoTicket sixth = new InfoTicket(6, 1636, "DME", "LED", 100);
    private InfoTicket seventh = new InfoTicket(7, 4990, "SVO", "KUF", 99);
    private InfoTicket eighth = new InfoTicket(8, 9000, "DME", "LED", 36);
    private InfoTicket ninth = new InfoTicket(9, 1687, "SVO", "KUF", 74);
    private InfoTicket tenth = new InfoTicket(10, 7777, "KUF", "VKO", 78);
    private InfoTicket eleventh = new InfoTicket(11, 9730, "KUF", "VKO", 109);
    private InfoTicket twelfth = new InfoTicket(12, 854, "SVO", "KUF", 95);
    private InfoTicket thirteenth = new InfoTicket(13, 1321, "SVO", "KUF", 765);
    private InfoTicket fourteenth = new InfoTicket(14, 5725, "KUF", "VKO", 94);
    private InfoTicket fifteenth = new InfoTicket(15, 65176, "KUF", "VKO", 23);


    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);
        manager.add(thirteenth);
        manager.add(fourteenth);
        manager.add(fifteenth);
    }

    @Test
    void shouldFindTicket() {
        InfoTicket[] actual = manager.findAll("SVO", "KUF");
        InfoTicket[] expected = new InfoTicket[]{twelfth, thirteenth, ninth, first, seventh, fourth};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldNotFindTicket() {
        InfoTicket[] actual = manager.findAll("DME", "KZN");
        InfoTicket[] expected = new InfoTicket[0];
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindTicketAndSortByPrice() {
        InfoTicket[] actual = manager.findAll("KUF", "VKO");
        InfoTicket[] expected = new InfoTicket[]{third, second, fourteenth, tenth, eleventh, fifteenth};
        assertArrayEquals(actual, expected);
    }
}