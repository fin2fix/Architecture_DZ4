package Interfaces;

import java.util.List;

import Models.Customer;
import Models.Ticket;

public interface iTicketRepo {

  void createNewTicket(Ticket ticket);

  boolean isTicketVacant(Ticket ticket);

  boolean updateTicket(Ticket ticket, Customer customer);

  boolean deleteTicket(Ticket ticket);

  Ticket findTicket(int numberOfTicket);

  List<Ticket> showAllTickets();

  List<Ticket> showSelectedTickets(Customer customer);
}
