/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicity.ui;

import com.publicity.dao.SESSION;
import com.publicity.domain.Horario;
import com.publicity.service.DBService;
import com.publicity.ui.custom.ActivePanel;
import com.publicity.ui.custom.IconDefaultCellRender;
import com.publicity.ui.custom.RoundIcon;
import com.publicity.utils.ButtonIcon;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class HorarioDialog extends javax.swing.JDialog {

    /**
     * Creates new form HorarioDialog
     */
    public HorarioDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initForm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        startHourField = new javax.swing.JTextField();
        endHourField = new javax.swing.JTextField();
        sessionComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        activePanel = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        hoursTable = new javax.swing.JTable();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADMINISTRADOR DE HORARIOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del nuevo horario"));

        jLabel1.setText("Hora inicio:");

        jLabel2.setText("Hora fin:");

        jLabel3.setText("Session:");

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/publicity/resources/images/add.png"))); // NOI18N
        addButton.setMargin(new java.awt.Insets(0, 1, 0, 0));
        addButton.setMinimumSize(new java.awt.Dimension(33, 23));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/publicity/resources/images/clear.png"))); // NOI18N
        cancelButton.setMargin(new java.awt.Insets(0, 2, 0, 0));
        cancelButton.setMinimumSize(new java.awt.Dimension(33, 23));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        startHourField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startHourFieldMouseClicked(evt);
            }
        });
        startHourField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                startHourFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                startHourFieldKeyTyped(evt);
            }
        });

        endHourField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                endHourFieldMouseClicked(evt);
            }
        });
        endHourField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                endHourFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                endHourFieldKeyTyped(evt);
            }
        });

        jLabel4.setText("Activo:");

        activePanel.setMaximumSize(new java.awt.Dimension(100, 20));
        activePanel.setMinimumSize(new java.awt.Dimension(100, 20));

        javax.swing.GroupLayout activePanelLayout = new javax.swing.GroupLayout(activePanel);
        activePanel.setLayout(activePanelLayout);
        activePanelLayout.setHorizontalGroup(
            activePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        activePanelLayout.setVerticalGroup(
            activePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jCheckBox1.setText("Activo: ");
        jCheckBox1.setActionCommand("Activo: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(startHourField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(endHourField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sessionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(activePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(endHourField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sessionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(startHourField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(activePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        hoursTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Hora inicio", "Hora fin", "Session", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hoursTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hoursTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(hoursTable);
        hoursTable.getColumnModel().getColumn(0).setMinWidth(0);
        hoursTable.getColumnModel().getColumn(0).setPreferredWidth(0);
        hoursTable.getColumnModel().getColumn(0).setMaxWidth(0);

        closeButton.setText("Cerrar");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(closeButton)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closeButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_closeButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        adicionarHorario();
    }//GEN-LAST:event_addButtonActionPerformed

    private void startHourFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startHourFieldMouseClicked
        popup.show(startHourField, 0, startHourField.getHeight());
        timePanel.setComponent(startHourField);
    }//GEN-LAST:event_startHourFieldMouseClicked

    private void endHourFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_endHourFieldMouseClicked
        popup.show(endHourField, 0, endHourField.getHeight());
        timePanel.setComponent(endHourField);
    }//GEN-LAST:event_endHourFieldMouseClicked

    private void startHourFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_startHourFieldKeyTyped
        System.out.println(evt.getKeyCode());
        evt.consume();
        startHourFieldMouseClicked(null);
    }//GEN-LAST:event_startHourFieldKeyTyped

    private void endHourFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_endHourFieldKeyTyped
        evt.consume();
        endHourFieldMouseClicked(null);
    }//GEN-LAST:event_endHourFieldKeyTyped

    private void hoursTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hoursTableMouseClicked
        if (evt.getClickCount() == 2)
            cargarHorario();
    }//GEN-LAST:event_hoursTableMouseClicked

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        restablecerFormulario();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void startHourFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_startHourFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DOWN)
            startHourFieldMouseClicked(null);
    }//GEN-LAST:event_startHourFieldKeyPressed

    private void endHourFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_endHourFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DOWN)
            endHourFieldMouseClicked(null);
    }//GEN-LAST:event_endHourFieldKeyPressed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(HorarioDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HorarioDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HorarioDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HorarioDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HorarioDialog dialog = new HorarioDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel activePanel;
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JTextField endHourField;
    private javax.swing.JTable hoursTable;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox sessionComboBox;
    private javax.swing.JTextField startHourField;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JPopupMenu popup = new javax.swing.JPopupMenu();
    private TimePanel timePanel;
    
    private DBService dBService = new DBService();
    
    private Horario horario;
    private Integer filaSeleccionada;
    
    private void initForm() {
        setLocationRelativeTo(null); 
        timePanel = new TimePanel(popup);
        popup.add(timePanel);
        
        for (SESSION session : SESSION.values()) {
            sessionComboBox.addItem(session);
        }     
                      
        sessionComboBox.setPreferredSize(new Dimension(-1, 20));
                
        hoursTable.setDefaultRenderer(Object.class, new IconDefaultCellRender());
        
        activePanel.setLayout(new BorderLayout());
        activePanel.add(new ActivePanel(), BorderLayout.NORTH);
                
        cargarHorarios(); 
        
        horario = new Horario();
    }
         
    private void cargarHorarios() {
        try {
            List<Horario> horarios = dBService.obtenerHorarios();
            DefaultTableModel model = (DefaultTableModel) hoursTable.getModel();
            Icon icon = null;
            for (Horario horarioTemp : horarios) {
                if (horarioTemp.isActivo())
                    icon = new RoundIcon(3, RoundIcon.STYLE.GREEN);
                else
                    icon = new RoundIcon(3, RoundIcon.STYLE.RED);
                model.addRow(new Object[]{horarioTemp.getHorarioId(), horarioTemp.getHoraInicio(), horarioTemp.getHoraFin(), horarioTemp.getSession(), new javax.swing.JLabel(icon)});               
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de acceso a base de datos", JOptionPane.ERROR_MESSAGE);
        }     
    }
    
    private void cargarHorario() {
        int index = hoursTable.getSelectedRow();
        if (index != -1) {
            Long horarioId = (Long) hoursTable.getValueAt(index, 0);                        
            try {
                Horario horarioBuscado = dBService.obtenerHorarioPorId(horarioId);
                if (horarioBuscado != null) {  
                    actualizarFormulario(horarioBuscado);
                    filaSeleccionada = index;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de acceso a datos", JOptionPane.ERROR_MESSAGE);
            }     
        }
    }
    
    private void restablecerFormulario() {
        startHourField.setText("");
        endHourField.setText("");
        sessionComboBox.setSelectedItem(SESSION.MAÑANA);
       // enabledCheckBox.setSelected(true);
        filaSeleccionada = null;
        startHourField.requestFocus();
    }
    
    private void actualizarFormulario(Horario horario) {
        startHourField.setText(horario.getHoraInicio());
        endHourField.setText(horario.getHoraFin());
        sessionComboBox.setSelectedItem(horario.getSession());
       // enabledCheckBox.setSelected(horario.isActivo());
        this.horario = horario;
        startHourField.requestFocus();
    }
    
    private void adicionarHorario() {
        String horaInicio = startHourField.getText();
        String horaFin = endHourField.getText();
        SESSION session = (SESSION) sessionComboBox.getSelectedItem();   
        boolean activo = false;/*enabledCheckBox.isSelected();*/
        Horario nuevoHorario = new Horario(horaInicio, horaFin, session, activo);
        try {
            if (horario.getHorarioId() == null) {
                Long horarioId = dBService.adicionarHorario(nuevoHorario) + 1;                
                ((DefaultTableModel)hoursTable.getModel()).addRow(new Object[]{horarioId, horaInicio, horaFin, session, activo});                       
            } else {
                nuevoHorario.setHorarioId(horario.getHorarioId());
                dBService.editarHorario(nuevoHorario);
                actualizarHorario(nuevoHorario);
            }
            restablecerFormulario();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de acceso a base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void actualizarHorario(Horario horario) {
        DefaultTableModel model = (DefaultTableModel) hoursTable.getModel();
        model.setValueAt(horario.getHoraInicio(), filaSeleccionada, 1);
        model.setValueAt(horario.getHoraFin(), filaSeleccionada, 2);
        model.setValueAt(horario.getSession(), filaSeleccionada, 3);
        model.setValueAt(horario.isActivo(), filaSeleccionada, 4);
    }
                
}
