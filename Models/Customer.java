package Models;

import java.time.LocalDate;

public class Customer {

  private int id;
  private String name;
  private LocalDate dob;
  private static int countNumber;

  static {
    countNumber = 0;
  }

  {
    countNumber++;
  }

  public Customer(String name, LocalDate dob) {
    this.id = countNumber;
    this.name = name;
    this.dob = dob;
  }

  @Override
  public String toString() {
    return "Customer (id=" + id + ", name=" + name + ", DOB=" + dob + ") ";
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public LocalDate getDob() {
    return dob;
  }
}
