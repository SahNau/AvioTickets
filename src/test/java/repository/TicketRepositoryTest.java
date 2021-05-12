package repository;

import manager.TicketManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import domain.InfoTicket;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class TicketRepositoryTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private InfoTicket first = new InfoTicket(1, 3436, "SVO", "KUF", 31);
    private InfoTicket second = new InfoTicket(2, 2138, "KUF", "VKO", 64);
    private InfoTicket third = new InfoTicket(3, 1487, "KUF", "KZN", 36);
    private InfoTicket fourth = new InfoTicket(4, 8954, "DME", "VKO", 98);
    private InfoTicket fifth = new InfoTicket(5, 4779, "VKO", "KZN", 63);
    private InfoTicket sixth = new InfoTicket(6, 1636, "DME", "LED", 100);
    private InfoTicket seventh = new InfoTicket(7, 4990, "SVO", "KUF", 99);
    private InfoTicket eighth = new InfoTicket(8, 9000, "DME", "LED", 36);
    private InfoTicket ninth = new InfoTicket(9, 1687, "DME", "LED", 74);
    private InfoTicket tenth = new InfoTicket(10, 7777, "KUF", "VKO", 78);


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
        InfoTicket[] actual = repository.findAll();
        InfoTicket[] expected = new InfoTicket[]{third, sixth, ninth, second, first, fifth, seventh, tenth, fourth, eighth};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
}
