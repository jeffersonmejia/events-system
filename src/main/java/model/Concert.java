package model;

public class Concert extends Event implements InterfaceEvent {

  private String band, validationBand;

  public Concert(String band, String name, String date, String place, String type, double price) {
    super(name, date, place, type, price);
    this.band = band;
  }

  public String getBand() {
    return band;
  }

  public String getValidationBand() {
    return validationBand;
  }

  @Override
  public boolean validate() {
    isValidated = true;
    validateEvent();
    validationBand = "";
    if (band.isEmpty()) {
      validationBand = "Campo obligatorio*";
      isValidated = false;
    }
    return isValidated;
  }
}
