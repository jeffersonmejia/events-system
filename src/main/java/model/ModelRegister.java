package model;

import model.ConnectionDB;
import org.bson.Document;

public class ModelRegister {

    private String validationDni, validationName,
            validationLastname, validationDate;
    private boolean hasError;
    public ConnectionDB connectionDB;
    public Document document;
    private String COLLECTION_NAME;

    //CONSTRUCTOR
    public ModelRegister(String validationDni, String validationName,
            String validationLastname, String validationDate) {
        this.validationDni = validationDni;
        this.validationName = validationName;
        this.validationLastname = validationLastname;
        this.validationDate = validationDate;
        COLLECTION_NAME = "users";
        ConnectionDB.collectionName = COLLECTION_NAME;
        connectionDB = ConnectionDB.getInstance();
        document = new Document();
        hasError = false;
    }

    //GETTER
    public String getValidationDni() {
        return validationDni;
    }

    public String getValidationName() {
        return validationName;
    }

    public String getValidationLastname() {
        return validationLastname;
    }

    public String getValidationDate() {
        return validationDate;
    }

    //METODOS PROPIOS
    //CREATE
    public boolean registerUser(String dni, String name,
            String lastname, String date) {
        document = new Document();
        //CREANDO DOCUMENTO
        document.append("user", dni);
        document.append("password", dni);
        document.append("dni", dni);
        document.append("name", name);
        document.append("lastname", lastname);
        document.append("date", date);
        //INSERTA DOCUMENTO
        return connectionDB.createDocument(document);
    }

    //READ
    public boolean userExists(String user) {
        document = new Document();
        //DOCUMENTO A CONSULTAR
        document.append("user", user);
        return !connectionDB.readDocument(document).isEmpty();
    }

    public boolean validationFields(String txtDni, String txtName,
            String txtLastname, String txtDate) {
        hasError = false;
        //RESETEA VALIDACIONES
        validationDate = validationDni = validationLastname = validationName = "";
        if (txtName.isEmpty()) {
            validationName = "*Campo obligatorio";
            hasError = true;
        }
        if (txtLastname.isEmpty()) {
            validationLastname = "*Campo obligatorio";
            hasError = true;
        }
        if (txtDate.isEmpty()) {
            validationDate = "*Campo obligatorio";
            hasError = true;
            //VALIDA FECHA dd/mm/aaaa
        } else if (!txtDate
                .matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")) {
            validationDate = "Formato inválido: dd/mm/aaaa";
            hasError = true;
        }
        if (txtDni.isEmpty()) {
            validationDni = "*Campo obligatorio";
            hasError = true;
        } else if (txtDni.length() != 10) {
            validationDni = "Cédula 10 dígitos";
            hasError = true;
        } else if (userExists(txtDni)) {
            validationDni = "Cédula ya registrada";
            hasError = true;
        }
        return hasError;
    }
}
