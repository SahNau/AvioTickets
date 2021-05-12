package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class InfoTicket implements Comparable<InfoTicket> {
    private int id;
    private int price;
    private String airportDeparture;
    private String airportArrival;
    private int travelTime;


    // через генерейт написать сотрировку по цене
    @Override
    public int compareTo(InfoTicket o) {
        return this.price - o.price;
    }

    // Как осуществлять проверку на соответсвие продукта поиск.запросу от куда вылетел и куда
    public boolean matches(String from, String to) {
        return airportDeparture.equalsIgnoreCase(from) && airportArrival.equalsIgnoreCase(to);
    }
}
