package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.ModelDashboard;
import model.ModelLogin;
import org.bson.Document;
import view.ViewDashboard;
import view.ViewLogin;

public class ControllerDashboard implements ActionListener {
  //ATRIBUTOS GENERALES

  private final ViewDashboard viewDashboard;
  private final ModelDashboard modelDashboard;
  private List<Object[]> listEvents, listGuests;
  private String TxtDni, txtGuests, txtPackage,
          txtEventType, eventId, eventIdOld;
  private boolean confirm, isEdit;
  private int counterEvents, counterGuests, selectedRow;
  private DefaultTableModel tableGuestsModel,
          tableEventsModel;
  private ModelLogin modelLogin;
  private ViewLogin viewLogin;
  private Document document;
  private ControllerLogin controllerLogin;
  //CONSTRUCTOR

  public ControllerDashboard(ViewDashboard viewDashboard,
          ModelDashboard modelDashboard) {
    this.viewDashboard = viewDashboard;
    this.modelDashboard = modelDashboard;
    this.listEvents = new ArrayList<>();
    this.listGuests = new ArrayList<>();
    this.counterEvents = 0;
    this.eventId = "";
    this.counterGuests = 0;
    this.tableGuestsModel = (DefaultTableModel) viewDashboard.tableGuests.getModel();
    this.tableEventsModel = (DefaultTableModel) viewDashboard.TableEvents.getModel();
    this.selectedRow = 0;
    document = new Document();
    this.modelLogin = new ModelLogin("", "", document);
    this.viewLogin = new ViewLogin();
    this.isEdit = false;
  }
  //INICIA VISTA

  public void startView() {
    insertEvents();
    //EVENTOS
    viewDashboard.BtnSave.addActionListener(this);
    viewDashboard.BtnLogout.addActionListener(this);
    viewDashboard.BtnClear.addActionListener(this);
    viewDashboard.BtnDelete.addActionListener(this);
    viewDashboard.txtAreaPackage.setEnabled(false);
    viewDashboard.BtnEdit.addActionListener(this);
    insertGuests();
    viewDashboard.TitleWelcome
            .setText("Bienvenido, "
                    + modelDashboard.getNameData());
    viewDashboard.TitleEvents
            .setText("Cliente: "
                    + modelDashboard.getDniData());
    setupRadioButtonListeners();
    viewDashboard.setVisible(true);
  }
  //MÉT. PROPIOS

  public void insertGuests() {
    //LIMPIA LA TABLA ANTES DE INGRESAR DATO NUEVOS
    tableGuestsModel.setRowCount(0);
    counterGuests = 0;
    listGuests = modelDashboard.getDBGuests();
    for (Object[] guest : listGuests) {
      tableGuestsModel.insertRow(counterGuests, guest);
      counterGuests++;
    }
  }

  public void insertEvents() {
    counterEvents = 0;
    //EVENTOS DB
    listEvents = modelDashboard.readEventsDB();
    for (Object[] event : listEvents) {
      tableEventsModel.insertRow(counterEvents, event);
      counterEvents++;
    }
  }
  //EVENTOS

  public void btnSaveClicked() {
    txtGuests = "";
    txtPackage = "";
    txtEventType = "";
    confirm = viewDashboard.CheckConfirm.isSelected();
    if (!isEdit) {
      selectedRow = -1;
    }
    if (viewDashboard.TableEvents.getSelectedRow() != -1) {
      selectedRow = viewDashboard.TableEvents.getSelectedRow();
    }
    viewDashboard.LabelValidationPackage.setText(" ");
    viewDashboard.LabelValidationGuests.setText(" ");
    viewDashboard.LabelValidationConfirm.setText(" ");
    viewDashboard.LabelValidationRow.setText(" ");
    if (viewDashboard.ComboGuests.getSelectedIndex() > 0) {
      if (viewDashboard.ComboGuests.getSelectedItem() != null) {
        txtGuests = (String) viewDashboard.ComboGuests.getSelectedItem();
      }
    }
    if (viewDashboard.RadioFamily.isSelected()) {
      txtPackage = viewDashboard.RadioFamily.getText();
    }
    if (viewDashboard.RadioVIP.isSelected()) {
      txtPackage = viewDashboard.RadioVIP.getText();
    }
    if (modelDashboard.getTypePackageDescription(txtPackage) != null) {
      viewDashboard.txtAreaPackage.setText(modelDashboard
              .getTypePackageDescription(txtPackage));
    }
    modelDashboard.setTxtGuests(txtGuests);
    modelDashboard.setConfirm(confirm);
    modelDashboard.setIsEdit(isEdit);
    modelDashboard.setSelectedRow(selectedRow);
    modelDashboard.setTxtPackage(txtPackage);
    if (modelDashboard.validationFields()) {
      viewDashboard.LabelValidationPackage
              .setText(modelDashboard.getValidationPackage());
      viewDashboard.LabelValidationGuests
              .setText(modelDashboard.getValidationGuests());
      viewDashboard.LabelValidationConfirm
              .setText(modelDashboard.getValidationConfirm());
      viewDashboard.LabelValidationRow
              .setText(modelDashboard.getValidationRow());
    } else {
      eventId = (String) tableEventsModel.getValueAt(selectedRow, 0);
      if (!isEdit) {
        modelDashboard.setEventId(eventId);
        modelDashboard.save();
      } else {
        modelDashboard.update(eventIdOld, txtGuests, txtPackage);
        isEdit = false;
        viewDashboard.BtnEdit.setText("Editar");
        eventId = "";
        viewDashboard.BtnSave.setText("Registrar");
        viewDashboard.TableEvents.setEnabled(true);
        viewDashboard.LabelValidationRow.setText(" ");
      }
      viewDashboard.LabelValidationConfirm
              .setText(modelDashboard.getValidationConfirm());
      insertGuests();
      viewDashboard.labelValidationDelete.setText(" ");
      btnClearClicked(false);
    }
  }

  public void btnLogoutClicked() {
    this.controllerLogin
            = new ControllerLogin(viewLogin, modelLogin);
    viewDashboard
            .setVisible(false);
    controllerLogin.startView();
  }

  public void btnDeleteClicked() {
    viewDashboard.labelValidationDelete.setText(" ");
    selectedRow = viewDashboard.tableGuests.getSelectedRow();
    if (selectedRow != -1) {
      eventId = (String) tableGuestsModel
              .getValueAt(selectedRow, 1);
      //ELIMINAR EN LA BASE DE DATOS
      modelDashboard.deleteGuests(eventId);
      insertGuests();
      //LIMPIA MENSAJE DE VALIDACION
      viewDashboard.labelValidationDelete
              .setText(modelDashboard.getValidationUpdate());
      eventId = "";
    } else {
      viewDashboard.labelValidationDelete
              .setText("*Seleccione una fila");
    }
  }

  public void btnEditClicked() {
    if (viewDashboard.BtnEdit.getText().equals("Cancelar")) {
      isEdit = false;
      viewDashboard.BtnEdit.setText("Editar");
      viewDashboard.tableGuests.clearSelection();
    }
    viewDashboard.labelValidationDelete
            .setText(" ");
    selectedRow = viewDashboard.tableGuests.getSelectedRow();
    if (selectedRow != -1) {
      isEdit = true;
      viewDashboard.BtnEdit.setText("Cancelar");
      eventIdOld
              = (String) tableGuestsModel.getValueAt(selectedRow, 1);
      viewDashboard.BtnSave
              .setText("Actualizar");
      viewDashboard.TableEvents
              .setEnabled(false);
      viewDashboard.LabelValidationRow
              .setText("Recuerda que no puedes actualizar el ID evento");
    } else {
      viewDashboard.labelValidationDelete
              .setText("*Seleccione una fila");
    }
  }

  public void btnClearClicked(boolean clearLastMessage) {
    //LIMPIA CAMPOS
    viewDashboard.ComboGuests.setSelectedIndex(0);
    viewDashboard.RadioBtnGroup.clearSelection();
    viewDashboard.CheckConfirm.setSelected(false);
    viewDashboard.txtAreaPackage.setText("");
    viewDashboard.TableEvents.clearSelection();
    //LIMPIA VALIDACIONES
    viewDashboard.LabelValidationPackage.setText(" ");
    viewDashboard.LabelValidationGuests.setText(" ");
    if (clearLastMessage) {
      viewDashboard.LabelValidationConfirm.setText(" ");
    }
    viewDashboard.LabelValidationRow.setText(" ");
    viewDashboard.labelValidationDelete.setText(" ");
  }
  //PARA QUE SE MUESTRE EN TEXTAREA

  public void setupRadioButtonListeners() {
    viewDashboard.RadioFamily.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        viewDashboard.txtAreaPackage
                .setText(modelDashboard
                        .getTypePackageDescription("Familiar"));
      }
    });
    viewDashboard.RadioVIP.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        viewDashboard.txtAreaPackage
                .setText(modelDashboard
                        .getTypePackageDescription("VIP"));
      }
    });
  }
  //GESTOR EVENTOS

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == viewDashboard.BtnSave) {
      btnSaveClicked();
    }
    if (e.getSource() == viewDashboard.BtnLogout) {
      btnLogoutClicked();
    }
    if (e.getSource() == viewDashboard.BtnClear) {
      btnClearClicked(true);
    }
    if (e.getSource() == viewDashboard.BtnDelete) {
      btnDeleteClicked();
    }
    if (e.getSource() == viewDashboard.BtnEdit) {
      btnEditClicked();
    }
  }
}
