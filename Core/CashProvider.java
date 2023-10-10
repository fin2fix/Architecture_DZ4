package Core;

import Interfaces.iCashProvider;
import Models.Customer;

public class CashProvider implements iCashProvider {

  private String name;
  private boolean isAuthorization;

  public CashProvider(String name) {
    this.name = name;
    isAuthorization = false;
  }

  @Override
  public boolean authorization(Customer customer, long cardNumber) {
    if (cardNumber > 2000000) {
      System.out.println("Card and customer are authorized. The transfer of funds has been completed");
      this.isAuthorization = true;
      return true;
    } else {
      System.out.println("Card and/or customer are NOT authorized");
      this.isAuthorization = false;
      return false;
    }
  }

  @Override
  public String toString() {
    return "Provider name " + name + " isAuthorization status = " + isAuthorization + " ";
  }

  public boolean isAuthorization() {
    return isAuthorization;
  }

}
