package model;

import model.ConnectionDB;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class ModelLogin extends Events {

    private String validationUser, validationPassword;
    private boolean hasError;
    public ConnectionDB connectionDB;
    private String COLLECTION_NAME;
    private List<Document> results;
    private List<String> listUser;
    private String userData, dniData;
    private String txtUser, txtPassword, dni;

    public ModelLogin(String validationUser, String validationPassword, Document document) {
        super(document);
        COLLECTION_NAME = "users";
        ConnectionDB.collectionName = COLLECTION_NAME;
        connectionDB = ConnectionDB.getInstance();
        results = new ArrayList<>();
        this.validationUser = validationUser;
        this.validationPassword = validationPassword;
        hasError = true;
    }

    //SETTER/GETTER
    public String getValidationUser() {
        return validationUser;
    }

    //PARA USAR EN TEST UNITARIOS
    public ConnectionDB getConnectionDB() {
        return connectionDB;
    }

    public void setConnectionDB(ConnectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    public String getValidationPassword() {
        return validationPassword;
    }

    public String getUserData() {
        return userData;
    }

    public String getDniData() {
        return dniData;
    }

    public void setTxtUser(String txtUser) {
        this.txtUser = txtUser;
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword = txtPassword;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    //METODOS PROPIOS
    public boolean userExists(String user) {
        document = new Document();
        //DOCUMENTO A CONSULTAR
        document.append("user", user);
        return !connectionDB.readDocument(document).isEmpty();
    }

    public void createAdminAccess() {
        document = new Document("user", "admin");
        document.append("password", "admin");
        results = connectionDB.readDocument(document);
        if (results.isEmpty()) {
            connectionDB.createDocument(document);
        }
    }

    public void queryDniName() {
        userData = dniData = "";
        results = new ArrayList<>();
        listUser = new ArrayList<>();
        document = new Document();
        document.append("dni", dni);
        results = connectionDB.readDocument(document);
        for (Document user : results) {
            dniData = (String) user.getString("dni");
            userData = (String) user.getString("name");

        }
    }

    public boolean passwordExists(String user, String password) {
        document = new Document();
        //DOCUMENTO A CONSULTAR
        document.append("user", user);
        document.append("password", password);
        return !connectionDB.readDocument(document).isEmpty();
    }

    @Override
    public boolean validationFields() {
        hasError = false;
        validationPassword = " ";
        validationUser = " ";
        if (txtUser.length() == 0) {
            validationUser = "*Campo obligatorio";
            hasError = true;
        } else if (!userExists(txtUser)) {
            validationUser = "El usuario no existe";
            hasError = true;
        }
        if (txtPassword.length() == 0) {
            validationPassword = "*Campo obligatorio";
            hasError = true;
        } else if (!passwordExists(txtUser, txtPassword)) {
            validationPassword = "La contraseña no coincide";
            hasError = true;
        }
        return hasError;
    }
}
