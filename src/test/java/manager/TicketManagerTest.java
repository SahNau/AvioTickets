package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import domain.InfoTickets;
import repository.TicketsRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class TicketManagerTest {
    private TicketsRepository repository = new TicketsRepository();
    private TicketManager manager = new TicketManager(repository);

    private InfoTickets first = new InfoTickets(1, 3436, "SVO", "KUF", 31);
    private InfoTickets second = new InfoTickets(2, 2138, "KUF", "VKO", 64);
    private InfoTickets third = new InfoTickets(3, 1487, "KUF", "KZN", 36);
    private InfoTickets fourth = new InfoTickets(4, 8954, "DME", "VKO", 98);
    private InfoTickets fifth = new InfoTickets(5, 4779, "VKO", "KZN", 63);
    private InfoTickets sixth = new InfoTickets(6, 1636, "DME", "LED", 100);
    private InfoTickets seventh = new InfoTickets(7, 4990, "SVO", "KUF", 99);
    private InfoTickets eighth = new InfoTickets(8, 9000, "DME", "LED", 36);
    private InfoTickets ninth = new InfoTickets(9, 1687, "DME", "LED", 74);
    private InfoTickets tenth = new InfoTickets(10, 7777, "KUF", "VKO", 78);


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
    }

    @Test
    void shouldFindAllAndSort() {
        InfoTickets[] actual = repository.findAll();
        InfoTickets[] expected = new InfoTickets[]{third, sixth, ninth, second, first, fifth, seventh, tenth, fourth, eighth};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTicket() {
        InfoTickets[] actual = manager.findAll("SVO", "KUF");
        InfoTickets[] expected = new InfoTickets[]{first, seventh};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldNotFindTicket() {
        InfoTickets[] actual = manager.findAll("DME", "KZN");
        InfoTickets[] expected = new InfoTickets[0];
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindTicketAndSortByPrice() {
        InfoTickets[] actual = manager.findAll("KUF", "VKO");
        InfoTickets[] expected = new InfoTickets[]{second, tenth};
        assertArrayEquals(actual, expected);
    }
}