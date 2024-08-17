package controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import model.ModelAdmin;
import model.ModelLogin;
import org.bson.Document;
import view.ViewAdmin;
import view.ViewLogin;

public class ControllerAdmin implements ActionListener, ItemListener {

  private final ModelAdmin modelAdmin;
  private final ViewAdmin viewAdmin;
  private ModelLogin modelLogin;
  private ViewLogin viewLogin;
  private ControllerLogin controllerLogin;
  private final DefaultTableModel tableEventsModel;
  private String name, date, place, band, type, price,
          idSelected;
  private boolean isConcert = false, isEdit = false;
  private int selectedRow = 0;

  public ControllerAdmin(ModelAdmin modelAdmin, ViewAdmin viewAdmin) {
    this.modelAdmin = modelAdmin;
    this.viewAdmin = viewAdmin;
    tableEventsModel = (DefaultTableModel) viewAdmin.TableEvents.getModel();
    name = date = place = band = type = "";
  }

  public void startView() {
    viewAdmin.RbConcert.setSelected(true);
    viewAdmin.BtnBack.addActionListener(this);
    viewAdmin.BtnDelete.addActionListener(this);
    viewAdmin.BtnEdit.addActionListener(this);
    viewAdmin.BtnSave.addActionListener(this);
    viewAdmin.RbConcert.addItemListener(this);
    viewAdmin.RbParty.addItemListener(this);
    modelAdmin.createEventsFromJSON();
    insertEvents();
    viewAdmin.setVisible(true);
  }

  private void insertEvents() {
    tableEventsModel.setRowCount(0);
    List<Object[]> listEvents = modelAdmin.readEventsDB();
    for (Object[] event : listEvents) {
      tableEventsModel.addRow(event);
    }
  }

  private void btnBackClicked() {
    modelLogin = new ModelLogin("", "", new Document());
    viewLogin = new ViewLogin();
    controllerLogin = new ControllerLogin(viewLogin, modelLogin);
    viewAdmin.setVisible(false);
    controllerLogin.startView();
  }

  private void btnSaveClicked() {
    name = date = place = band = type = "";
    name = viewAdmin.TextName.getText();
    date = viewAdmin.TextDate.getText();
    place = viewAdmin.TextPlace.getText();
    band = viewAdmin.TextBand.getText();
    price = viewAdmin.TextPrice.getText();
    isConcert = viewAdmin.RbConcert.isSelected();
    type = isConcert ? "Concert" : "Party";
    viewAdmin.LabelName.setText(" ");
    viewAdmin.LabelDate.setText(" ");
    viewAdmin.LabelPlace.setText(" ");
    viewAdmin.LabelBand.setText(" ");
    viewAdmin.LabelPrice.setText(" ");
    viewAdmin.LbValidationAdd.setText(" ");
    if (!modelAdmin.validate(name, date, place, band, type, price, isConcert)) {
      if (isConcert) {
        viewAdmin.LabelName.setText(modelAdmin.getConcert().getValidationName());
        viewAdmin.LabelDate.setText(modelAdmin.getConcert().getValidationDate());
        viewAdmin.LabelPlace.setText(modelAdmin.getConcert().getValidationPlace());
        viewAdmin.LabelBand.setText(modelAdmin.getConcert().getValidationBand());
        viewAdmin.LabelPrice.setText(modelAdmin.getConcert().getValidationPrice());
      } else {
        viewAdmin.LabelName.setText(modelAdmin.getParty().getValidationName());
        viewAdmin.LabelDate.setText(modelAdmin.getParty().getValidationDate());
        viewAdmin.LabelPlace.setText(modelAdmin.getParty().getValidationPlace());
        viewAdmin.LabelPrice.setText(modelAdmin.getParty().getValidationPrice());
      }
    } else {

      if (modelAdmin.saveEvent(idSelected, isConcert, isEdit)) {
        viewAdmin.LbValidationAdd.setText(isEdit ? "Actualizado" : "Guardado");
      }
      if (isEdit) {
        viewAdmin.BtnSave.setText("Guardar");
      }
      viewAdmin.TextName.setText("");
      viewAdmin.TextDate.setText("");
      viewAdmin.TextPlace.setText("");
      viewAdmin.TextBand.setText("");
      viewAdmin.TextPrice.setText("");
      viewAdmin.RbConcert.setSelected(true);
      isEdit = false;
      insertEvents();
    }
  }

  private void btnEditClicked() {
    selectedRow = viewAdmin.TableEvents.getSelectedRow();
    viewAdmin.LbValidationTable.setText(" ");
    viewAdmin.BtnSave.setText("Actualizar");
    if (selectedRow != -1) {
      idSelected = (String) tableEventsModel.getValueAt(selectedRow, 0);
      viewAdmin.TextName.setText((String) tableEventsModel.getValueAt(selectedRow, 1));
      viewAdmin.TextDate.setText((String) tableEventsModel.getValueAt(selectedRow, 2));
      viewAdmin.TextPlace.setText((String) tableEventsModel.getValueAt(selectedRow, 3));
      viewAdmin.TextPrice.setText((String) tableEventsModel.getValueAt(selectedRow, 6));
      type = (String) tableEventsModel.getValueAt(selectedRow, 5);
      if (type.equals("concierto")) {
        viewAdmin.RbConcert.setSelected(true);
        viewAdmin.TextBand.setText((String) tableEventsModel.getValueAt(selectedRow, 4));
      } else {
        viewAdmin.RbParty.setSelected(true);
      }
      isEdit = true;
    } else {
      viewAdmin.LbValidationTable.setText("Selecciona un evento");
    }
  }

  private void btnDeleteClicked() {
    selectedRow = viewAdmin.TableEvents.getSelectedRow();
    viewAdmin.LbValidationTable.setText(" ");
    if (selectedRow != -1) {
      idSelected = (String) tableEventsModel.getValueAt(selectedRow, 0);
      modelAdmin.deleteEvent(idSelected);
      insertEvents();
    } else {
      viewAdmin.LbValidationTable.setText("Selecciona un evento");
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == viewAdmin.BtnBack) {
      btnBackClicked();
    } else if (e.getSource() == viewAdmin.BtnSave) {
      btnSaveClicked();
    } else if (e.getSource() == viewAdmin.BtnEdit) {
      btnEditClicked();
    } else if (e.getSource() == viewAdmin.BtnDelete) {
      btnDeleteClicked();
    }
  }

  @Override
  public void itemStateChanged(ItemEvent e) {
    if (e.getStateChange() == ItemEvent.SELECTED) {
      JRadioButton selectedButton = (JRadioButton) e.getSource();
      if (selectedButton == viewAdmin.RbConcert) {
        viewAdmin.TextBand.setEnabled(true);
        viewAdmin.TextBand.setText("");
      }

      if (selectedButton == viewAdmin.RbParty) {
        viewAdmin.TextBand.setText("N/A");
        viewAdmin.TextBand.setEnabled(false);
      }
    }
  }
}
