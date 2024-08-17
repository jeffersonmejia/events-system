package model;

import model.ConnectionDB;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ModelAdmin {

  private final String COLLECTION_NAME = "events", JSON_NAME = "events.json";
  private String id = "";
  private final ConnectionDB connectionDB;
  private List<Document> resultsEvents;
  private Document docEvent = new Document(), docEventOld = new Document();
  private Party party;
  private Concert concert;
  private double priceEvent;
  private boolean isDigitNumber = false;

  //CONSTRUCTOR
  public ModelAdmin(String string, String string1, String string2, String string3, String string4) {
    connectionDB = ConnectionDB.getInstance();
    ConnectionDB.collectionName = COLLECTION_NAME;
  }

  // LEE JSON E INSERTA EN DB
  public void readEventsJSON() {
    JSONParser parser = new JSONParser();
    try (FileReader reader = new FileReader(JSON_NAME)) {
      JSONArray eventsArray = (JSONArray) parser.parse(reader);
      for (Object eventObjectJSON : eventsArray) {
        JSONObject event = (JSONObject) eventObjectJSON;
        docEvent = new Document()
                .append("id", event.get("id"))
                .append("name", event.get("name"))
                .append("date", event.get("date"))
                .append("place", event.get("place"))
                .append("band", event.get("band"))
                .append("type", event.get("type"))
                .append("price", event.get("price"));
      }
    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
  }

  // VERIFICA QUE LA DB NO ESTÉ VACÍA
  public boolean eventsExists() {
    Document document = new Document();
    return !connectionDB.readDocument(document).isEmpty();
  }

  // CREA EVENTOS DE .JSON, CUANDO LA DB ESTÁ VACÍA
  public void createEventsFromJSON() {
    if (!eventsExists()) {
      readEventsJSON();
    }
  }

  // OBTIENE EVENTOS DESDE DB
  public List<Object[]> readEventsDB() {
    List<Object[]> listEvents = new ArrayList<>();
    Document document = new Document();
    resultsEvents = connectionDB.readDocument(document);
    for (Document event : resultsEvents) {
      Object[] eventObject = new Object[]{
        event.getString("id"),
        event.getString("name"),
        event.getString("date"),
        event.getString("place"),
        event.getString("band"),
        event.getString("type"),
        event.getString("price")
      };
      listEvents.add(eventObject);
    }
    return listEvents;
  }

  //VALIDA CAMPOS
  public boolean validate(String name, String date, String place, String band, String type, String price, boolean isConcert) {
    priceEvent = 0;
    isDigitNumber = price.matches("^\\d+(\\.\\d+)?$");
    if (isDigitNumber) {
      priceEvent = Double.parseDouble(price);
    }
    if (isConcert) {
      concert = new Concert(band, name, date, place, type, priceEvent);
      //VALIDA CONCIERTO
      return concert.validate();
    }
    party = new Party(name, date, place, type, priceEvent);
    //VALIDA FIESTA
    return party.validate();
  }

  //SETTER/GETTER
  public Party getParty() {
    return party;
  }

  public Concert getConcert() {
    return concert;
  }

  // AGREGA/ACTUALIZA EVENTO
  public boolean saveEvent(String idSelected, boolean isConcert, boolean isEdit) {
    docEvent = new Document();
    if (isEdit) {
      docEventOld = new Document("id", idSelected);
    } else {
      //GENERA ID: TOTAL LIBROS + 1
      id = String.valueOf(connectionDB.readDocument(docEvent).size());
      docEvent.append("id", id);
    }
    if (isConcert) {
      docEvent.append("name", concert.getName());
      docEvent.append("date", concert.getDate());
      docEvent.append("place", concert.getPlace());
      docEvent.append("band", concert.getBand());
      docEvent.append("type", concert.getType());
      docEvent.append("price", String.valueOf(concert.getPrice()));
    } else {
      docEvent.append("name", party.getName());
      docEvent.append("date", party.getDate());
      docEvent.append("place", party.getPlace());
      docEvent.append("type", party.getType());
      docEvent.append("band", "N/A");
      docEvent.append("price", String.valueOf(party.getPrice()));
    }
    if (isEdit) {
      return connectionDB.updateDocument(docEventOld, docEvent);
    }
    return connectionDB.createDocument(docEvent);
  }

  // ELIMINA EVENTO
  public void deleteEvent(String id) {
    Document query = new Document("id", id);
    connectionDB.deleteDocument(query);
  }
}
