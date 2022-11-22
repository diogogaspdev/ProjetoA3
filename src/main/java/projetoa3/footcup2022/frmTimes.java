/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetoa3.footcup2022;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projetoa3.footcup2022.DAO.Time;

/**
 *
 * @author Lucas Parra
 */
public class frmTimes extends javax.swing.JFrame {

    /**
     * Creates new form frmTimes
     */
    public frmTimes() {
        initComponents();

        for (Enumeration<AbstractButton> buttons = rbtnGrpContinente.getElements(); buttons.hasMoreElements();) {
            AbstractButton btn = buttons.nextElement();
            btn.setActionCommand(btn.getText());
        }
    }

    private String imgPath = System.getProperty("user.dir") + "/src/main/java/projetoa3/footcup2022/Imagens/Times/";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbtnGrpContinente = new javax.swing.ButtonGroup();
        jPanel8 = new javax.swing.JPanel();
        jbtnVoltar = new javax.swing.JButton();
        jtabMenu = new javax.swing.JTabbedPane();
        jpnlVisualizarTime = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableTime = new javax.swing.JTable();
        jpnlCrud = new javax.swing.JPanel();
        jlblBandeira = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jtxtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcboGrupo = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        rbtnAmerica = new javax.swing.JRadioButton();
        rbtnAfrica = new javax.swing.JRadioButton();
        rbtnEuropa = new javax.swing.JRadioButton();
        rbtnAsia = new javax.swing.JRadioButton();
        rbtnOceania = new javax.swing.JRadioButton();
        jlblIdTime = new javax.swing.JLabel();
        jtxtIdTime = new javax.swing.JSpinner();
        jbtnConfirmar = new javax.swing.JButton();
        jbtnLimpar = new javax.swing.JButton();
        jbtnDeletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel8.setBackground(new java.awt.Color(42, 170, 56));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnVoltar.setText("Voltar");
        jbtnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVoltarActionPerformed(evt);
            }
        });
        jPanel8.add(jbtnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 96, 30));

        jpnlVisualizarTime.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jpnlVisualizarTimeComponentShown(evt);
            }
        });

        jtableTime.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Grupo", "Continente"
            }
        ));
        jtableTime.setRowHeight(30);
        jtableTime.setShowGrid(false);
        jtableTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableTimeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtableTime);

        javax.swing.GroupLayout jpnlVisualizarTimeLayout = new javax.swing.GroupLayout(jpnlVisualizarTime);
        jpnlVisualizarTime.setLayout(jpnlVisualizarTimeLayout);
        jpnlVisualizarTimeLayout.setHorizontalGroup(
            jpnlVisualizarTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlVisualizarTimeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnlVisualizarTimeLayout.setVerticalGroup(
            jpnlVisualizarTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlVisualizarTimeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtabMenu.addTab("Visualizar Times", jpnlVisualizarTime);

        jlblBandeira.setIcon(new javax.swing.ImageIcon("D:\\lp_dir\\USJT\\2022_2\\ProjetoA3\\src\\main\\java\\projetoa3\\footcup2022\\Imagens\\Times\\time_default.png")); // NOI18N
        jlblBandeira.setText(" ");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nome do time");

        jLabel2.setText("Grupo do time");

        jcboGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "A", "B", "C", "D", "E" }));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Continente"));

        rbtnGrpContinente.add(rbtnAmerica);
        rbtnAmerica.setText("América");

        rbtnGrpContinente.add(rbtnAfrica);
        rbtnAfrica.setText("África");

        rbtnGrpContinente.add(rbtnEuropa);
        rbtnEuropa.setText("Europa");

        rbtnGrpContinente.add(rbtnAsia);
        rbtnAsia.setText("Ásia");

        rbtnGrpContinente.add(rbtnOceania);
        rbtnOceania.setText("Oceania");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(rbtnAmerica)
                .addGap(18, 18, 18)
                .addComponent(rbtnAfrica)
                .addGap(18, 18, 18)
                .addComponent(rbtnAsia)
                .addGap(18, 18, 18)
                .addComponent(rbtnEuropa)
                .addGap(18, 18, 18)
                .addComponent(rbtnOceania)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnAmerica)
                    .addComponent(rbtnAfrica)
                    .addComponent(rbtnAsia)
                    .addComponent(rbtnOceania)
                    .addComponent(rbtnEuropa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jlblIdTime.setText("Id do time");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblIdTime)
                            .addComponent(jtxtIdTime, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jtxtNome))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jcboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jlblIdTime))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jtxtIdTime))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jbtnConfirmar.setText("Confirmar");
        jbtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnConfirmarActionPerformed(evt);
            }
        });

        jbtnLimpar.setText("Limpar");
        jbtnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLimparActionPerformed(evt);
            }
        });

        jbtnDeletar.setText("Deletar");
        jbtnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlCrudLayout = new javax.swing.GroupLayout(jpnlCrud);
        jpnlCrud.setLayout(jpnlCrudLayout);
        jpnlCrudLayout.setHorizontalGroup(
            jpnlCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlCrudLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpnlCrudLayout.createSequentialGroup()
                .addGroup(jpnlCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlCrudLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jlblBandeira, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnlCrudLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jbtnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnlCrudLayout.setVerticalGroup(
            jpnlCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlCrudLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlblBandeira, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpnlCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jtabMenu.addTab("Add/Edit Time", jpnlCrud);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtabMenu)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtabMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean Consiste() {
        boolean mRetorno = true;

        if (jtxtNome.getText().isBlank()) {
            mRetorno = false;
        }

        mRetorno = false;
        for (Enumeration<AbstractButton> buttons = rbtnGrpContinente.getElements(); buttons.hasMoreElements();) {
            AbstractButton btn = buttons.nextElement();
            if (btn.isSelected()) {
                mRetorno = true;
            }
        }

        if (jcboGrupo.getSelectedItem().toString().isBlank()) {
            mRetorno = false;
        }

        return mRetorno;
    }

    private void jbtnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVoltarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        frmLogin frm = new frmLogin();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_jbtnVoltarActionPerformed

    private void jbtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnConfirmarActionPerformed
        // TODO add your handling code here:

        //JOptionPane.showMessageDialog(null, bandeira);
        if (Consiste()) {
            String continente = rbtnGrpContinente.getSelection().getActionCommand();
            String bandeira = jlblBandeira.getIcon().toString();
            bandeira = bandeira.substring(bandeira.lastIndexOf("\\") + 1);

            Time oTime = new Time();
            oTime.Nome = jtxtNome.getText();
            oTime.Grupo = jcboGrupo.getSelectedItem().toString();
            oTime.Continente = continente;
            oTime.Bandeira = bandeira;

            try {
                oTime.Incluir();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else {
            JOptionPane.showMessageDialog(null, "não consiste");
        }
    }//GEN-LAST:event_jbtnConfirmarActionPerformed

    private void jbtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLimparActionPerformed
        // TODO add your handling code here:
        jtxtNome.setText("");
        //jcboGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "A", "B", "C", "D", "E" }));
        jcboGrupo.setSelectedIndex(0);
        rbtnGrpContinente.clearSelection();

        String usrIcon = "time_default.png";
        String credito = "<a href=\"https://www.flaticon.com/free-icons/pennant\" Created by itim2101 - Flaticon</a>";
        jlblBandeira.setIcon(new ImageIcon(imgPath + usrIcon));
        jlblBandeira.setToolTipText(credito);
    }//GEN-LAST:event_jbtnLimparActionPerformed

    private void jbtnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeletarActionPerformed
        // TODO add your handling code here:

        Time oTime = new Time();
        try {
            oTime.Deletar((int) jtxtIdTime.getValue());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jbtnDeletarActionPerformed

    private void jpnlVisualizarTimeComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jpnlVisualizarTimeComponentShown
        // TODO add your handling code here:
        ArrayList<Time> lTimes = null;

        try {
            lTimes = new Time().Listar();

            DefaultTableModel model = (DefaultTableModel) jtableTime.getModel();
            model.setNumRows(0);

            for (Time time : lTimes) {
                model.addRow(new Object[]{
                    //retorna os dados da tabela do BD, cada campo e um coluna.
                    time.Id,
                    time.Nome,
                    time.Grupo,
                    time.Continente
                });
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jpnlVisualizarTimeComponentShown

    private void jtableTimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableTimeMouseClicked
        // TODO add your handling code here:
        int row = jtableTime.rowAtPoint(evt.getPoint());
        int col = jtableTime.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 0) {
            //JOptionPane.showMessageDialog(null, jtableTime.getValueAt(row, col));
            
            jtabMenu.setSelectedIndex(1);
            jtxtIdTime.setValue(jtableTime.getValueAt(row, 0));
            jtxtNome.setText(jtableTime.getValueAt(row, 1).toString());
            jcboGrupo.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jtableTimeMouseClicked

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
            java.util.logging.Logger.getLogger(frmTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTimes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnConfirmar;
    private javax.swing.JButton jbtnDeletar;
    private javax.swing.JButton jbtnLimpar;
    private javax.swing.JButton jbtnVoltar;
    private javax.swing.JComboBox<String> jcboGrupo;
    private javax.swing.JLabel jlblBandeira;
    private javax.swing.JLabel jlblIdTime;
    private javax.swing.JPanel jpnlCrud;
    private javax.swing.JPanel jpnlVisualizarTime;
    private javax.swing.JTabbedPane jtabMenu;
    private javax.swing.JTable jtableTime;
    private javax.swing.JSpinner jtxtIdTime;
    private javax.swing.JTextField jtxtNome;
    private javax.swing.JRadioButton rbtnAfrica;
    private javax.swing.JRadioButton rbtnAmerica;
    private javax.swing.JRadioButton rbtnAsia;
    private javax.swing.JRadioButton rbtnEuropa;
    private javax.swing.ButtonGroup rbtnGrpContinente;
    private javax.swing.JRadioButton rbtnOceania;
    // End of variables declaration//GEN-END:variables
}
