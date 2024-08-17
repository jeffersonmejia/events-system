package model;

public class Party extends Event implements InterfaceEvent {

  public Party(String name, String date, String place, String type, double price) {
    super(name, date, place, type, price);
  }

  @Override
  public boolean validate() {
    return validateEvent();
  }
}
