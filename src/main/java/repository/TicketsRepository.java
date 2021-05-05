package repository;

import domain.InfoTickets;


public class TicketsRepository {
    private InfoTickets[] items = new InfoTickets[0];

    public void save(InfoTickets item) {
        int length = items.length + 1;
        InfoTickets[] tmp = new InfoTickets[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    // выдать все объекты
    public InfoTickets[] findAll() {
        return items;
    }

    // найти по id
    public InfoTickets findById(int id) {
        for (InfoTickets item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }


    // удалить по id
    public void removeById(int id) {
        int length = items.length - 1;
        InfoTickets[] tmp = new InfoTickets[length];
        int index = 0;
        for (InfoTickets item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
