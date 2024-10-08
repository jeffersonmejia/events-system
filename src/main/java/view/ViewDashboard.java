package view;

public class ViewDashboard extends javax.swing.JFrame {

  public ViewDashboard() {
    initComponents();
    this.setLocationRelativeTo(null);
    this.setResizable(false);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    RadioBtnGroup = new javax.swing.ButtonGroup();
    PanelTitle = new javax.swing.JPanel();
    LabelTitle = new javax.swing.JLabel();
    BtnLogout = new javax.swing.JButton();
    PanelMain = new javax.swing.JPanel();
    LabelPackage = new javax.swing.JLabel();
    RadioFamily = new javax.swing.JRadioButton();
    RadioVIP = new javax.swing.JRadioButton();
    ComboGuests = new javax.swing.JComboBox<>();
    labelCantGuess = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    txtAreaPackage = new javax.swing.JTextArea();
    JScrollEvents = new javax.swing.JScrollPane();
    TableEvents = new javax.swing.JTable();
    TitleWelcome = new javax.swing.JLabel();
    CheckConfirm = new javax.swing.JCheckBox();
    LabelValidationGuests = new javax.swing.JLabel();
    LabelValidationConfirm = new javax.swing.JLabel();
    labelDni = new javax.swing.JLabel();
    LabelValidationPackage = new javax.swing.JLabel();
    TitleTable2 = new javax.swing.JLabel();
    jSeparator1 = new javax.swing.JSeparator();
    LabelValidationRow = new javax.swing.JLabel();
    PanelBtnEvents = new javax.swing.JPanel();
    BtnClear = new javax.swing.JButton();
    BtnSave = new javax.swing.JButton();
    PanelTickets = new javax.swing.JPanel();
    jScrollPane2 = new javax.swing.JScrollPane();
    tableGuests = new javax.swing.JTable();
    TitleEvents = new javax.swing.JLabel();
    labelValidationDelete = new javax.swing.JLabel();
    jSeparator2 = new javax.swing.JSeparator();
    TitleEvents1 = new javax.swing.JLabel();
    PanelBtnTickets = new javax.swing.JPanel();
    BtnEdit = new javax.swing.JButton();
    BtnDelete = new javax.swing.JButton();
    BtnBill = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    PanelTitle.setBackground(new java.awt.Color(255, 255, 255));

    LabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    LabelTitle.setText("GESTION EVENTOS");

    BtnLogout.setBackground(new java.awt.Color(245, 245, 245));
    BtnLogout.setText("Cerrar sesión");
    BtnLogout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    BtnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    BtnLogout.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        BtnLogoutActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout PanelTitleLayout = new javax.swing.GroupLayout(PanelTitle);
    PanelTitle.setLayout(PanelTitleLayout);
    PanelTitleLayout.setHorizontalGroup(
      PanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(PanelTitleLayout.createSequentialGroup()
        .addGap(30, 30, 30)
        .addComponent(LabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(BtnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(12, 12, 12))
    );
    PanelTitleLayout.setVerticalGroup(
      PanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(PanelTitleLayout.createSequentialGroup()
        .addGap(20, 20, 20)
        .addGroup(PanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelTitle)
          .addComponent(BtnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        .addContainerGap(20, Short.MAX_VALUE))
    );

    PanelMain.setBackground(new java.awt.Color(255, 255, 255));

    LabelPackage.setText("Paquete evento:");

    RadioFamily.setBackground(new java.awt.Color(255, 255, 255));
    RadioBtnGroup.add(RadioFamily);
    RadioFamily.setText("Familiar");

    RadioVIP.setBackground(new java.awt.Color(255, 255, 255));
    RadioBtnGroup.add(RadioVIP);
    RadioVIP.setText("VIP");
    RadioVIP.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        RadioVIPActionPerformed(evt);
      }
    });

    ComboGuests.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "1", "2", "3" }));

    labelCantGuess.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    labelCantGuess.setText("Cantidad de entradas");

    txtAreaPackage.setColumns(20);
    txtAreaPackage.setRows(5);
    txtAreaPackage.setDisabledTextColor(new java.awt.Color(204, 204, 204));
    jScrollPane1.setViewportView(txtAreaPackage);

    TableEvents.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "ID", "Nombre", "Fecha", "Lugar", "Banda", "Tipo", "Precio"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    JScrollEvents.setViewportView(TableEvents);
    if (TableEvents.getColumnModel().getColumnCount() > 0) {
      TableEvents.getColumnModel().getColumn(0).setResizable(false);
      TableEvents.getColumnModel().getColumn(1).setResizable(false);
      TableEvents.getColumnModel().getColumn(2).setResizable(false);
      TableEvents.getColumnModel().getColumn(3).setResizable(false);
      TableEvents.getColumnModel().getColumn(4).setResizable(false);
      TableEvents.getColumnModel().getColumn(5).setResizable(false);
      TableEvents.getColumnModel().getColumn(6).setResizable(false);
    }

    TitleWelcome.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    TitleWelcome.setText("Bienvenido, usuario");

    CheckConfirm.setBackground(new java.awt.Color(255, 255, 255));
    CheckConfirm.setText("Confirmar compra");

    LabelValidationGuests.setForeground(new java.awt.Color(255, 0, 0));
    LabelValidationGuests.setText(" ");

    LabelValidationConfirm.setForeground(new java.awt.Color(255, 0, 0));
    LabelValidationConfirm.setText(" ");

    LabelValidationPackage.setForeground(new java.awt.Color(255, 0, 0));
    LabelValidationPackage.setText(" ");

    TitleTable2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    TitleTable2.setText("Lista eventos");

    LabelValidationRow.setForeground(new java.awt.Color(255, 0, 0));
    LabelValidationRow.setText(" ");

    javax.swing.GroupLayout PanelMainLayout = new javax.swing.GroupLayout(PanelMain);
    PanelMain.setLayout(PanelMainLayout);
    PanelMainLayout.setHorizontalGroup(
      PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMainLayout.createSequentialGroup()
        .addGap(30, 30, 30)
        .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(PanelMainLayout.createSequentialGroup()
            .addComponent(TitleWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(labelDni, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(PanelMainLayout.createSequentialGroup()
            .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(LabelValidationGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(ComboGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(labelCantGuess, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(LabelValidationPackage, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(PanelMainLayout.createSequentialGroup()
                .addComponent(LabelPackage, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RadioFamily)
                .addGap(46, 46, 46)
                .addComponent(RadioVIP))
              .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(LabelValidationConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(CheckConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(26, 26, 26))
          .addGroup(PanelMainLayout.createSequentialGroup()
            .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(TitleTable2, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(JScrollEvents, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(LabelValidationRow, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 24, Short.MAX_VALUE))))
    );
    PanelMainLayout.setVerticalGroup(
      PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(PanelMainLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(TitleWelcome)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(5, 5, 5)
        .addComponent(TitleTable2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(JScrollEvents, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(labelDni)
        .addGap(4, 4, 4)
        .addComponent(LabelValidationRow)
        .addGap(12, 12, 12)
        .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(PanelMainLayout.createSequentialGroup()
            .addComponent(labelCantGuess)
            .addGap(16, 16, 16)
            .addComponent(ComboGuests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(4, 4, 4)
            .addComponent(LabelValidationGuests))
          .addGroup(PanelMainLayout.createSequentialGroup()
            .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(LabelPackage)
              .addComponent(RadioFamily)
              .addComponent(RadioVIP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(CheckConfirm))
            .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(PanelMainLayout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelValidationConfirm))
              .addGroup(PanelMainLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(12, 12, 12)
            .addComponent(LabelValidationPackage)))
        .addContainerGap())
    );

    PanelBtnEvents.setBackground(new java.awt.Color(255, 255, 255));

    BtnClear.setBackground(new java.awt.Color(245, 245, 245));
    BtnClear.setText("Limpiar");
    BtnClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    BtnClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    BtnSave.setBackground(new java.awt.Color(11, 87, 208));
    BtnSave.setForeground(new java.awt.Color(255, 255, 255));
    BtnSave.setText("Guardar");
    BtnSave.setBorderPainted(false);
    BtnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    javax.swing.GroupLayout PanelBtnEventsLayout = new javax.swing.GroupLayout(PanelBtnEvents);
    PanelBtnEvents.setLayout(PanelBtnEventsLayout);
    PanelBtnEventsLayout.setHorizontalGroup(
      PanelBtnEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(PanelBtnEventsLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(BtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(12, 12, 12))
    );
    PanelBtnEventsLayout.setVerticalGroup(
      PanelBtnEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(PanelBtnEventsLayout.createSequentialGroup()
        .addGap(12, 12, 12)
        .addGroup(PanelBtnEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(BtnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
          .addComponent(BtnClear, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        .addGap(12, 12, 12))
    );

    BtnSave.getAccessibleContext().setAccessibleDescription("");

    PanelTickets.setBackground(new java.awt.Color(255, 255, 255));

    tableGuests.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "ID", "Nombre", "N° Entradas", "Paquete"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane2.setViewportView(tableGuests);
    if (tableGuests.getColumnModel().getColumnCount() > 0) {
      tableGuests.getColumnModel().getColumn(0).setResizable(false);
      tableGuests.getColumnModel().getColumn(1).setResizable(false);
      tableGuests.getColumnModel().getColumn(2).setResizable(false);
      tableGuests.getColumnModel().getColumn(3).setResizable(false);
    }

    TitleEvents.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    TitleEvents.setText("Eventos ");

    labelValidationDelete.setForeground(new java.awt.Color(255, 0, 0));
    labelValidationDelete.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    labelValidationDelete.setText(" ");

    TitleEvents1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    TitleEvents1.setText("Eventos ");

    javax.swing.GroupLayout PanelTicketsLayout = new javax.swing.GroupLayout(PanelTickets);
    PanelTickets.setLayout(PanelTicketsLayout);
    PanelTicketsLayout.setHorizontalGroup(
      PanelTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(PanelTicketsLayout.createSequentialGroup()
        .addGap(12, 12, 12)
        .addGroup(PanelTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(PanelTicketsLayout.createSequentialGroup()
            .addGroup(PanelTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(TitleEvents1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(PanelTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(TitleEvents, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)))
            .addGap(0, 0, Short.MAX_VALUE))
          .addGroup(PanelTicketsLayout.createSequentialGroup()
            .addGroup(PanelTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(labelValidationDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
            .addContainerGap(12, Short.MAX_VALUE))))
    );
    PanelTicketsLayout.setVerticalGroup(
      PanelTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(PanelTicketsLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(TitleEvents)
        .addGap(6, 6, 6)
        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(6, 6, 6)
        .addComponent(TitleEvents1)
        .addGap(4, 4, 4)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelValidationDelete)
        .addGap(18, 18, 18))
    );

    PanelBtnTickets.setBackground(new java.awt.Color(255, 255, 255));

    BtnEdit.setBackground(new java.awt.Color(255, 255, 204));
    BtnEdit.setForeground(new java.awt.Color(102, 102, 0));
    BtnEdit.setText("Editar");
    BtnEdit.setBorderPainted(false);
    BtnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    BtnDelete.setBackground(new java.awt.Color(255, 234, 209));
    BtnDelete.setForeground(new java.awt.Color(153, 0, 51));
    BtnDelete.setText("Eliminar");
    BtnDelete.setBorderPainted(false);
    BtnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    BtnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        BtnDeleteActionPerformed(evt);
      }
    });

    BtnBill.setBackground(new java.awt.Color(245, 245, 245));
    BtnBill.setText("Ver factura");
    BtnBill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    BtnBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    BtnBill.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        BtnBillActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout PanelBtnTicketsLayout = new javax.swing.GroupLayout(PanelBtnTickets);
    PanelBtnTickets.setLayout(PanelBtnTicketsLayout);
    PanelBtnTicketsLayout.setHorizontalGroup(
      PanelBtnTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBtnTicketsLayout.createSequentialGroup()
        .addGap(12, 12, 12)
        .addComponent(BtnBill, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
        .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(BtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(12, 12, 12))
    );
    PanelBtnTicketsLayout.setVerticalGroup(
      PanelBtnTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(PanelBtnTicketsLayout.createSequentialGroup()
        .addGap(12, 12, 12)
        .addGroup(PanelBtnTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(BtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(BtnBill, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(12, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(12, 12, 12)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(PanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(PanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(PanelBtnEvents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(12, 12, 12)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(PanelBtnTickets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(PanelTickets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addContainerGap(12, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(12, 12, 12)
        .addComponent(PanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(12, 12, 12)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(PanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(PanelTickets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(PanelBtnTickets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(PanelBtnEvents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(12, 12, 12))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void BtnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLogoutActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_BtnLogoutActionPerformed

    private void RadioVIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioVIPActionPerformed
    // TODO add your handling code here:
    }//GEN-LAST:event_RadioVIPActionPerformed

  private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
// TODO add your handling code here:
  }//GEN-LAST:event_BtnDeleteActionPerformed

  private void BtnBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBillActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_BtnBillActionPerformed

  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(ViewDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(ViewDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(ViewDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(ViewDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new ViewDashboard().setVisible(true);
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  public javax.swing.JButton BtnBill;
  public javax.swing.JButton BtnClear;
  public javax.swing.JButton BtnDelete;
  public javax.swing.JButton BtnEdit;
  public javax.swing.JButton BtnLogout;
  public javax.swing.JButton BtnSave;
  public javax.swing.JCheckBox CheckConfirm;
  public javax.swing.JComboBox<String> ComboGuests;
  private javax.swing.JScrollPane JScrollEvents;
  public javax.swing.JLabel LabelPackage;
  private javax.swing.JLabel LabelTitle;
  public javax.swing.JLabel LabelValidationConfirm;
  public javax.swing.JLabel LabelValidationGuests;
  public javax.swing.JLabel LabelValidationPackage;
  public javax.swing.JLabel LabelValidationRow;
  private javax.swing.JPanel PanelBtnEvents;
  private javax.swing.JPanel PanelBtnTickets;
  private javax.swing.JPanel PanelMain;
  private javax.swing.JPanel PanelTickets;
  private javax.swing.JPanel PanelTitle;
  public javax.swing.ButtonGroup RadioBtnGroup;
  public javax.swing.JRadioButton RadioFamily;
  public javax.swing.JRadioButton RadioVIP;
  public javax.swing.JTable TableEvents;
  public javax.swing.JLabel TitleEvents;
  public javax.swing.JLabel TitleEvents1;
  private javax.swing.JLabel TitleTable2;
  public javax.swing.JLabel TitleWelcome;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JSeparator jSeparator2;
  private javax.swing.JLabel labelCantGuess;
  private javax.swing.JLabel labelDni;
  public javax.swing.JLabel labelValidationDelete;
  public javax.swing.JTable tableGuests;
  public javax.swing.JTextArea txtAreaPackage;
  // End of variables declaration//GEN-END:variables
}
