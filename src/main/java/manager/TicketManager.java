package manager;

import domain.InfoTickets;
import repository.TicketsRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketsRepository repository;

    public TicketManager() {
    }

    public void add(InfoTickets infoTickets) {
        repository.save(infoTickets);
    }

    public TicketManager(TicketsRepository repository) {
        this.repository = repository;
    }

    public InfoTickets[] findAll(String from, String to) {
        InfoTickets[] result = new InfoTickets[0];
        for (InfoTickets infoTicket : repository.findAll()) {
            if (infoTicket.matches(from, to)) {
                InfoTickets[] tmp = new InfoTickets[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = infoTicket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
