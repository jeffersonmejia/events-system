package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.ModelLogin;
import model.ModelRegister;
import org.bson.Document;
import view.ViewLogin;
import view.ViewRegister;

public class ControllerRegister implements ActionListener {

  private String txtDni, txtName, txtLastname, txtDate, registerMessage;
  //REGISTER
  private ModelRegister modelRegister;
  private ViewRegister viewRegister;
  //LOGIN
  private ModelLogin modelLogin;
  private ViewLogin viewLogin;
  private ControllerLogin controllerLogin;
  private Document document;

  public ControllerRegister(ViewRegister viewRegister,
          ModelRegister modelRegister) {
    //REGISTER
    this.viewRegister = viewRegister;
    this.modelRegister = modelRegister;
    txtDni = txtName = txtLastname = txtDate = "";
    registerMessage = "";
    document = new Document();
  }

  public void startView() {
    //EVENTOS
    viewRegister.btnBack.addActionListener(this);
    viewRegister.btnClear.addActionListener(this);
    viewRegister.btnRegister.addActionListener(this);
    //MUESTRA INTERFAZ
    viewRegister.setVisible(true);
  }

  public void btnBackClicked() {
    //LOGIN
    this.viewLogin = new ViewLogin();
    this.modelLogin = new ModelLogin("", "", document);
    this.controllerLogin = new ControllerLogin(viewLogin, modelLogin);
    viewRegister.setVisible(false);
    controllerLogin.startView();
  }

  public void btnClearClicked() {
    //CAMPOS
    viewRegister.txtName.setText("");
    viewRegister.txtDate.setText("");
    viewRegister.txtDni.setText("");
    viewRegister.txtLastname.setText("");
    //VALIDACIONES
    viewRegister.labelValidationDate.setText("");
    viewRegister.labelValidationName.setText("");
    viewRegister.labelValidationLastname.setText("");
    viewRegister.labelValidationDni.setText("");
  }

  public void btnRegisterClicked() {
    txtDni = txtName = txtLastname = txtDate = "";
    registerMessage = "";
    //RESETEAR VALIDACIONES
    viewRegister.labelValidationDate.setText(" ");
    viewRegister.labelValidationName.setText(" ");
    viewRegister.labelValidationLastname.setText(" ");
    viewRegister.labelValidationDni.setText(" ");
    txtDni = viewRegister.txtDni.getText();
    txtName = viewRegister.txtName.getText();
    txtLastname = viewRegister.txtLastname.getText();
    txtDate = viewRegister.txtDate.getText();
    if (modelRegister.validationFields(txtDni,
            txtName, txtLastname, txtDate)) {
      viewRegister.labelValidationDate
              .setText(modelRegister.getValidationDate());
      viewRegister.labelValidationName
              .setText(modelRegister.getValidationName());
      viewRegister.labelValidationLastname
              .setText(modelRegister.getValidationLastname());
      viewRegister.labelValidationDni
              .setText(modelRegister.getValidationDni());
    } else {
      if (modelRegister.registerUser(txtDni,
              txtName, txtName, txtDate)) {
        registerMessage = "Registro éxitoso\n";
        registerMessage += "Usuario/clave: " + txtDni;
        JOptionPane.showMessageDialog(null, registerMessage);
        viewRegister.setVisible(false);
        btnBackClicked();
      } else {
        registerMessage = "No se ha podido registar\n";
        JOptionPane.showMessageDialog(null, registerMessage);
      }
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == viewRegister.btnBack) {
      btnBackClicked();
    }
    if (e.getSource() == viewRegister.btnClear) {
      btnClearClicked();
    }
    if (e.getSource() == viewRegister.btnRegister) {
      btnRegisterClicked();
    }
  }
}
