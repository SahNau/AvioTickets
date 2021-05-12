package repository;

import domain.InfoTicket;


public class TicketRepository {
    private InfoTicket[] items = new InfoTicket[0];

    public void save(InfoTicket item) {
        int length = items.length + 1;
        InfoTicket[] tmp = new InfoTicket[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    // выдать все объекты
    public InfoTicket[] findAll() {
        return items;
    }

    // найти по id
    public InfoTicket findById(int id) {
        for (InfoTicket item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }


    // удалить по id
    public void removeById(int id) {
        int length = items.length - 1;
        InfoTicket[] tmp = new InfoTicket[length];
        int index = 0;
        for (InfoTicket item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
