package model;

public abstract class Event {

  protected String name, date, place, type,
          validationName, validationDate,
          validationPlace, validationType,
          validationPrice;

  protected double price;
  protected boolean isValidated;

  public Event(String name, String date, String place, String type, double price) {
    this.name = name;
    this.date = date;
    this.place = place;
    this.type = type;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public String getDate() {
    return date;
  }

  public String getPlace() {
    return place;
  }

  public String getType() {
    return type;
  }

  public double getPrice() {
    return price;
  }

  public boolean isIsValidated() {
    return isValidated;
  }

  public String getValidationName() {
    return validationName;
  }

  public String getValidationDate() {
    return validationDate;
  }

  public String getValidationPlace() {
    return validationPlace;
  }

  public String getValidationType() {
    return validationType;
  }

  public String getValidationPrice() {
    return validationPrice;
  }

  public boolean validateEvent() {
    isValidated = true;
    validationName = validationDate = validationPlace = " ";
    validationType = validationPrice = " ";
    if (name.isEmpty()) {
      validationName = "Campo obligatorio*";
      isValidated = false;
    }
    if (date.isEmpty()) {
      validationDate = "Campo obligatorio*";
      isValidated = false;
    } else if (!date.matches("^(0[1-9]|[12][0-9]|3[01])\\/(0[1-9]|1[0-2])\\/\\d{4}$")) {
      validationDate = "Formato: dd/mm/aaaa";
      isValidated = false;
    }
    if (place.isEmpty()) {
      validationPlace = "Campo obligatorio*";
      isValidated = false;
    }
    if (type.isEmpty()) {
      validationType = "Campo obligatorio*";
      isValidated = false;
    }
    if (price < 15 || price > 80) {
      validationPrice = "Precio válido: 15-80";
      isValidated = false;
    }
    return isValidated;
  }

  public abstract boolean validate();
}
