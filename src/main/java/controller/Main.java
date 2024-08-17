package controller;

import controller.ControllerLogin;
import javax.swing.SwingUtilities;
import model.ModelAdmin;
import model.ModelLogin;
import org.bson.Document;
import view.ViewAdmin;
import view.ViewLogin;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
         Document document = new Document();
        ViewLogin viewLogin = new ViewLogin();
        ModelLogin modelLogin = new ModelLogin("", "", document);
        ControllerLogin controller = new ControllerLogin(viewLogin, modelLogin);
        controller.startView();
        
        
                });
        
    }
}
