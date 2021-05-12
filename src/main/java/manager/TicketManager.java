package manager;

import domain.InfoTicket;
import repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager() {
    }

    public void add(InfoTicket infoTicket) {
        repository.save(infoTicket);
    }

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public InfoTicket[] findAll(String from, String to) {
        InfoTicket[] result = new InfoTicket[0];
        for (InfoTicket infoTicket : repository.findAll()) {
            if (infoTicket.matches(from, to)) {
                InfoTicket[] tmp = new InfoTicket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = infoTicket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
