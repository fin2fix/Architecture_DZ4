package Core;

import Interfaces.iCashProvider;
import Interfaces.iTicketRepo;
import Models.Customer;
import Models.Ticket;

public class TicketProvider {

  private iTicketRepo repo;
  private iCashProvider cash;

  public TicketProvider(iTicketRepo repo, iCashProvider cash) {
    this.repo = repo;
    this.cash = cash;
  }

  public iTicketRepo getRepo() {
    return repo;
  }

  public iCashProvider getCash() {
    return cash;
  }

  public void buyTicket(int ticketNumber, Customer customer, long cardNumber) {
    Ticket ticket = repo.findTicket(ticketNumber);
    if (!ticket.isBooking() && repo.isTicketVacant(ticket) && cash.authorization(customer, cardNumber)) {
      ticket.setBooking(true);
      repo.updateTicket(ticket, customer);
      System.out.println("Ticket has been purchased");
    } else if (ticket.isBooking() || !repo.isTicketVacant(ticket)) {
      System.out.println("This ticket is already booked. Ticket purchase cancelled. Try another ticket!");
    } else {
      System.out.println("Ticket purchase cancelled. Try again later!");
    }
  }
}
