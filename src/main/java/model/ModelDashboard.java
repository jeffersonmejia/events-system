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

public class ModelDashboard extends Events {

  private String JSON_NAME, COLLECTION_NAME, COLLECTION_NAME_GUEST,
          validationGuests, validationPackage, validationConfirm,
          validationRow, dniData, nameData, validationUpdate;
  private Document document, update;
  //CONEXION DB
  private ConnectionDB connectionDB;
  //OBTENER EVENTOS DB
  private List<Document> resultsEvents, resultsGuests;
  private Object[] guestObject, eventObject;
  private List<Object[]> listGuests, listEvents;
  private boolean hasError;
  private int counterGuests, counterEvents, MAX_TICKETS;
  public String txtGuests, eventId, txtPackage;
  boolean confirm;
  int selectedRow;
  boolean isEdit;

  public ModelDashboard(String dniData, String nameData, Document document) {
    super(document);
    this.dniData = dniData;
    this.counterGuests = 0;
    this.counterEvents = 0;
    this.nameData = nameData;
    this.JSON_NAME = "Events.json";
    this.COLLECTION_NAME = "events";
    this.COLLECTION_NAME_GUEST = "guests";
    this.connectionDB = ConnectionDB.getInstance();
    this.document = new Document();
    this.update = new Document();
    this.resultsEvents = new ArrayList<>();
    this.listEvents = new ArrayList<>();
    this.eventObject = new Object[]{};
    this.hasError = false;
    this.validationUpdate = "";
    MAX_TICKETS = 5;
    //CREAR LOS EVENTOS
    this.createEventsFromJSON();
  }

  //GETTER/SETTER
  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  public void setTxtGuests(String txtGuests) {
    this.txtGuests = txtGuests;
  }

  public void setTxtPackage(String txtPackage) {
    this.txtPackage = txtPackage;
  }

  public void setConfirm(boolean confirm) {
    this.confirm = confirm;
  }

  public void setSelectedRow(int selectedRow) {
    this.selectedRow = selectedRow;
  }

  public void setIsEdit(boolean isEdit) {
    this.isEdit = isEdit;
  }

  public String getDniData() {
    return dniData;
  }

  public String getNameData() {
    return nameData;
  }

  public String getValidationUpdate() {
    return validationUpdate;
  }

  //INSERTAR EN TABLA DATOS DE GUESTSDB
  public List<Object[]> getDBGuests() {
    document = new Document();
    document.append("dniClient", dniData);
    listGuests = new ArrayList<>();
    counterGuests = 0;
    ConnectionDB.collectionName = COLLECTION_NAME_GUEST;
    ConnectionDB.getInstance();
    resultsGuests = connectionDB.readDocument(document);
    for (Document guest : resultsGuests) {
      //GUARDA PERSONAS EN OBJETO
      guestObject = new Object[]{
        guest.getString("eventId"),
        "Nombre evento",
        guest.getString("tickets"),
        guest.getString("package")
      };
      //GUARDA PERSONAS EN UNA LISTA
      listGuests.add(guestObject);
      counterGuests++;
    }
    return listGuests;
  }

  //ELIMINAR DE TABLE GUEST
  public void deleteGuests(String eventId) {
    document = new Document();
    validationUpdate = "";
    document.append("eventId", eventId);
    ConnectionDB.collectionName = COLLECTION_NAME_GUEST;
    ConnectionDB.getInstance();
    if (connectionDB.deleteDocument(document)) {
      validationUpdate = "Eliminado con éxito";
    } else {
      validationUpdate = "No se pudo eliminar";
    }
  }

  //CREATE
  public void readEventsJSON() {
    JSONParser parser = new JSONParser();
    try (FileReader reader = new FileReader(JSON_NAME)) {
      JSONArray eventsArray = (JSONArray) parser.parse(reader);
      ConnectionDB.collectionName = COLLECTION_NAME;
      ConnectionDB.getInstance();
      for (Object eventObject : eventsArray) {
        JSONObject event = (JSONObject) eventObject;
        document = new Document();
        document.append("id", event.get("id"));
        document.append("name", event.get("name"));
        document.append("date", event.get("date"));
        document.append("place", event.get("place"));
        document.append("band", event.get("band"));
        document.append("type", event.get("type"));
        connectionDB.createDocument(document);
      }
    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
  }

  //READ
  public boolean eventsExists() {
    document = new Document();
    //VERIFICAR SI HAY EVENTOS CREADOS
    ConnectionDB.collectionName = COLLECTION_NAME;
    ConnectionDB.getInstance();
    return !connectionDB.readDocument(document).isEmpty();
  }

  public void createEventsFromJSON() {
    if (!eventsExists()) {
      readEventsJSON();
    }
  }

  //READ
  public List<Object[]> readEventsDB() {
    document = new Document();
    counterEvents = 0;
    ConnectionDB.collectionName = COLLECTION_NAME;
    ConnectionDB.getInstance();
    resultsEvents = connectionDB.readDocument(document);
    for (Document event : resultsEvents) {
      //GUARDA EVENTOS EN OBJETO
      eventObject = new Object[]{
        event.getString("id"),
        event.getString("name"),
        event.getString("date"),
        event.getString("place"),
        event.getString("band"),
        event.getString("type"),
        event.getString("price")

      };
      //GUARDA EVENTOS EN UNA LISTA
      listEvents.add(eventObject);
      counterEvents++;
    }
    return listEvents;
  }

  //READ
  public boolean userExists(String user) {
    document = new Document();
    //DOCUMENTO A CONSULTAR
    document.append("user", user);
    ConnectionDB.collectionName = COLLECTION_NAME;
    ConnectionDB.getInstance();
    return !connectionDB.readDocument(document).isEmpty();
  }

  //GETTER
  public String getValidationRow() {
    return validationRow;
  }

  public String getValidationGuests() {
    return validationGuests;
  }

  public String getValidationPackage() {
    return validationPackage;
  }

  public String getValidationConfirm() {
    return validationConfirm;
  }

  //GUARDAR EN BD DATOS
  public void save() {
    resultsGuests = new ArrayList<>();
    document = new Document();
    document.append("dniClient", dniData);
    ConnectionDB.collectionName = COLLECTION_NAME_GUEST;
    ConnectionDB.getInstance();
    resultsGuests = connectionDB.readDocument(document);
    if (resultsGuests.size() != MAX_TICKETS) {
      document = new Document();
      document.append("eventId", eventId);
      document.append("dniClient", dniData);
      document.append("tickets", txtGuests);
      document.append("package", txtPackage);
      ConnectionDB.collectionName = COLLECTION_NAME_GUEST;
      ConnectionDB.getInstance();
      if (connectionDB.createDocument(document)) {
        validationConfirm = "Entradas guardadas con éxito";
      } else {
        validationConfirm = "Entradas no guardadas";
      }
    } else {
      validationConfirm = "Límite alcanzado, máx: " + MAX_TICKETS;
    }
  }

  public void update(String eventId, String txtGuests, String txtPackage) {
    //ANTERIOR
    document = new Document();
    document.append("eventId", eventId);
    //NUEVO
    update = new Document();
    update.append("eventId", eventId);
    update.append("dniClient", dniData);
    update.append("tickets", txtGuests);
    update.append("package", txtPackage);
    ConnectionDB.collectionName = COLLECTION_NAME_GUEST;
    ConnectionDB.getInstance();
    if (connectionDB.updateDocument(document, update)) {
      validationConfirm = "Entradas actualizadas con éxito";
    } else {
      validationConfirm = "Entradas no actualizadas";
    }
  }

  public String getTypePackageDescription(String packageName) {
    if (packageName.equals("Familiar")) {
      return "4 entradas generales al concierto\n"
              + "Asientos juntos\n"
              + "4 bebidas gratis";
    }
    if (packageName.equals("VIP")) {
      return "Entrada VIP al concierto\n"
              + "Asiento en primera fila\n"
              + "Estacionamiento VIP";
    }
    return null;
  }

  @Override
  public boolean validationFields() {
    hasError = false;
    validationGuests = validationPackage
            = validationConfirm = validationRow = " ";
    if (txtGuests.length() == 0) {
      validationGuests = "*Campo obligatorio";
      hasError = true;
    }
    if (txtPackage.length() == 0) {
      validationPackage = "*Campo obligatorio";
      hasError = true;
    }
    if (!confirm) {
      validationConfirm = "*Campo obligatorio";
      hasError = true;
    }
    if (selectedRow == -1 && !isEdit) {
      validationRow = "*Seleccione una fila";
      hasError = true;
    }
    return hasError;
  }
}
