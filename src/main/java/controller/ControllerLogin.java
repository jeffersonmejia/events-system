package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import model.ModelAdmin;
import model.ModelDashboard;
import model.ModelLogin;
import model.ModelRegister;
import org.bson.Document;
import view.ViewAdmin;
import view.ViewDashboard;
import view.ViewLogin;
import view.ViewRegister;

public class ControllerLogin implements ActionListener {

  //MV: LOGIN
  private final ModelLogin modelLogin;
  private final ViewLogin viewLogin;
  //MVC: REGISTER
  private final ModelRegister modelRegister;
  private final ViewRegister viewRegister;
  private final ControllerRegister controllerRegister;
  //MVC: DASHBOARD
  private ModelDashboard modelDashboard;
  private ViewDashboard viewDashboard;
  private ControllerDashboard controllerDashboard;
  //MVC: ADMIN
  private ModelAdmin modelAdmin;
  private ViewAdmin viewAdmin;
  private ControllerAdmin controllerAdmin;
  //ATRIBUTOS GENERALES
  private String txtPassword, txtUser;
  private List<String> listUser = new ArrayList<>();
  Document document;

  public ControllerLogin(ViewLogin viewLogin, ModelLogin modelLogin) {
    //LOGIN
    this.viewLogin = viewLogin;
    this.modelLogin = modelLogin;
    //DASHBOARD
    viewDashboard = new ViewDashboard();
    //REGISTER
    document = new Document();
    modelRegister = new ModelRegister("", "", "", "");
    viewRegister = new ViewRegister();
    controllerRegister = new ControllerRegister(viewRegister, modelRegister);
    modelLogin.createAdminAccess();
  }

  public void startView() {
    viewLogin.btnExit.addActionListener(this);
    viewLogin.btnLogin.addActionListener(this);
    viewLogin.btnRegister.addActionListener(this);
    viewLogin.setVisible(true);
  }

  public void btnExitClicked() {
    System.exit(0);
  }

  public void btnLoginClicked() {
    //RESETEA VALIDACIONES
    viewLogin.labelValidationPassword.setText(" ");
    viewLogin.labelValidationUser.setText(" ");
    //OBTIENE DATOS POR TECLADO
    txtUser = viewLogin.txtUser.getText();
    txtPassword = new String(viewLogin.txtPassword.getPassword());
    //VALIDA CAMPOS
    modelLogin.setTxtPassword(txtPassword);
    modelLogin.setTxtUser(txtUser);
    if (modelLogin.validationFields()) {
      viewLogin.labelValidationUser
              .setText(modelLogin.getValidationUser());
      viewLogin.labelValidationPassword
              .setText(modelLogin.getValidationPassword());
      //CAMPOS VALIDADOS
    } else {
      //CIERRA INTERFAZ ACTUAL
      viewLogin.setVisible(false);
      //APLICAR STRATEGY AQUÍ
      if (txtUser.equals("admin") && txtPassword.equals("admin")) {
        modelAdmin = new ModelAdmin("", "", "", "", "");
        viewAdmin = new ViewAdmin();
        controllerAdmin = new ControllerAdmin(modelAdmin, viewAdmin);
        controllerAdmin.startView();
      } else {
        modelLogin.setDni(txtUser);
        modelLogin.queryDniName();
        //ABRE INTERFAZ DASHBOARD
        viewDashboard = new ViewDashboard();
        modelDashboard = new ModelDashboard(modelLogin.getDniData(), modelLogin.getUserData(), document);
        controllerDashboard = new ControllerDashboard(viewDashboard, modelDashboard);
        controllerDashboard.startView();
      }
    }
  }

  public void btnRegisterClicked() {
    //CIERRA INTERFAZ LOGIN
    viewLogin.setVisible(false);
    //ABRE INTERFAZ REGISTER
    controllerRegister.startView();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == viewLogin.btnExit) {
      btnExitClicked();
    }
    if (e.getSource() == viewLogin.btnLogin) {
      btnLoginClicked();
    }
    if (e.getSource() == viewLogin.btnRegister) {
      btnRegisterClicked();
    }
  }
}
