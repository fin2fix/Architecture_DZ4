package Interfaces;

import Models.Customer;

public interface iCashProvider {

  boolean authorization(Customer customer, long cardNumber);

}
