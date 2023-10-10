package Core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import Interfaces.iTicketRepo;
import Models.Customer;
import Models.Ticket;

public class TicketRepository implements iTicketRepo {

  private HashMap<Ticket, Customer> tickets;

  public TicketRepository() {
    this.tickets = new HashMap<>();
  }

  @Override
  public void createNewTicket(Ticket ticket) {
    tickets.putIfAbsent(ticket, null);
  }

  @Override
  public boolean updateTicket(Ticket ticket, Customer customer) {
    if (isTicketVacant(ticket)) {
      tickets.put(ticket, customer);
      System.out.println("Ticked was updated " + ticket + " " + customer);
      return true;
    } else

    {
      return false;
    }
  }

  @Override
  public boolean deleteTicket(Ticket ticket) {
    tickets.remove(ticket);
    System.out.println("Ticked was deleted " + ticket);
    return true;
  }

  @Override
  public Ticket findTicket(int numberOfTicket) {
    List<Ticket> tempList = showAllTickets();

    for (Ticket ticket : tempList) {
      if (ticket.getTicketNumber() == numberOfTicket) {
        return ticket;
      }
    }
    return null;
  }

  @Override
  public List<Ticket> showAllTickets() {
    List<Ticket> allTicketsList = new ArrayList<>();
    Set<Ticket> setKeys = tickets.keySet();
    allTicketsList.addAll(setKeys);
    return allTicketsList;
  }

  @Override
  public List<Ticket> showSelectedTickets(Customer customer) {
    List<Ticket> vacantTicketList = new ArrayList<>();

    for (HashMap.Entry<Ticket, Customer> entry : tickets.entrySet()) {
      if (entry.getValue().equals(customer)) {
        vacantTicketList.add(entry.getKey());
      }
    }
    return vacantTicketList;
  }

  @Override
  public boolean isTicketVacant(Ticket ticket) {
    if (tickets.get(ticket) == null) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (HashMap.Entry<Ticket, Customer> pair : tickets.entrySet()) {
      stringBuilder.append(String.format("%s : %s\n", pair.getKey(), pair.getValue()));
    }
    return stringBuilder.toString();
  }

  public HashMap<Ticket, Customer> getTickets() {
    return tickets;
  }

}
