package Models;

import java.time.LocalDate;

public class Ticket {

  private int ticketNumber;
  private String place;
  private int price;
  private LocalDate date;
  private boolean isBooking;
  private static int countNumber;

  static {
    countNumber = 0;
  }

  {
    countNumber++;
  }

  public Ticket(String place, int price, LocalDate date) {
    this.ticketNumber = countNumber;
    this.place = place;
    this.price = price;
    this.date = date;
    this.isBooking = false;
  }

  @Override
  public String toString() {
    return "Ticket (N " + ticketNumber + ", place=" + place + ", price=" + price + ", date=" + date
        + ", isBooked=" + isBooking + ") ";
  }

  @Override
  public boolean equals(Object obj) {
    if (((Ticket) obj).getTicketNumber() == this.ticketNumber) {
      return true;
    }
    return false;
  }

  public int getTicketNumber() {
    return ticketNumber;
  }

  public String getPlace() {
    return place;
  }

  public int getPrice() {
    return price;
  }

  public LocalDate getDate() {
    return date;
  }

  public boolean isBooking() {
    return isBooking;
  }

  public void setBooking(boolean isBooking) {
    this.isBooking = isBooking;
  }
}
