import java.time.LocalDate;
import java.util.Arrays;

import Core.CashProvider;
import Core.TicketProvider;
import Core.TicketRepository;
import Models.Customer;
import Models.Ticket;

public class start {

  public static void main(String[] args) {

    TicketRepository repos = new TicketRepository();

    for (int i = 0; i < 10; i++) {
      String place = "Section 0" + i;
      int price = i * 10 + 2000;
      repos.createNewTicket(new Ticket(place, price, LocalDate.of(2023, 12, 15)));
    }

    System.out.println("\n В текущей базе билетов имеются:");
    System.out.println(Arrays.asList(repos));

    TicketProvider yandexTicket = new TicketProvider(repos, new CashProvider("Sberbank-pay"));

    Customer customer1 = new Customer("Petr", LocalDate.of(1975, 02, 18));
    Customer customer2 = new Customer("Ivav", LocalDate.of(2001, 06, 05));
    Customer customer3 = new Customer("Andrey", LocalDate.of(1993, 11, 21));

    System.out.println("\n Первая покупка билетов");
    yandexTicket.buyTicket(4, customer1, 2134567);
    System.out.println("\n Вторая покупка билетов");
    yandexTicket.buyTicket(7, customer2, 1234567);
    System.out.println("\n Третья покупка билетов");
    yandexTicket.buyTicket(10, customer3, 7654321);
    System.out.println("\n Четвертая покупка билетов");
    yandexTicket.buyTicket(10, customer1, 2134567);

    System.out.println("\n После покупок текущее состояние базы билетов:");
    System.out.println(Arrays.asList(repos));
  }
}