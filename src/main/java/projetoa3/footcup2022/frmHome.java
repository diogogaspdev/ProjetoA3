/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetoa3.footcup2022;

import javax.swing.ImageIcon;
import projetoa3.footcup2022.DAO.Usuario;
import projetoa3.footcup2022.Lib.Acesso;

/**
 *
 * @author digog
 */
public class frmHome extends javax.swing.JFrame {

    private Usuario usuario;

    public frmHome() {
        super("FootCup 2022 - Home Page");
        initComponents();
        preparaHome();
    }

    private void preparaHome() {
        usuario = Acesso.User;

        jlblUser.setText(jlblUser.getText().replace("$usr$", usuario.Nome));

        String imgPath = System.getProperty("user.dir") + "/src/main/java/projetoa3/footcup2022/Imagens/usr_";
        String usrIcon = "";
        String credito = "";
        switch (usuario.Nome) {
            case "admin":
                usrIcon = "admin.png";
                credito = "<a href=\"https://www.flaticon.com/br/autores/tanah-basah\" Icone criado por Tanah Basah</a>";
                break;
            default:
                usrIcon = "default.png";
                credito = "<a href=\"https://www.flaticon.com/br/autores/freepik\" Icone criado por Freepik</a>";
                break;
        }
        jlblUserIcon.setIcon(new ImageIcon(imgPath + usrIcon));
        jlblUserIcon.setToolTipText(credito);

        // Se o tipo de privilégio do usuário não for 0 significa que o mesmo não é adm,
        // portanto bloqueamos as funcionalidades de adm.
        if (usuario.TipoPrivilegio != 0) {
            jbtnCadUsuario.setVisible(false);
            jbtnVisualizarJogos.setVisible(false);
        }

        imgPath = System.getProperty("user.dir") + "/src/main/java/projetoa3/footcup2022/Imagens/";
        lblLogo.setIcon(new ImageIcon(imgPath + "logo.png"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jmitSimularFaseG = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jlblUser = new javax.swing.JLabel();
        jbtnVisualizarJogos = new javax.swing.JButton();
        jbtnVisualizarTimes = new javax.swing.JButton();
        jbtnVisualizarGrp = new javax.swing.JButton();
        jbtnSair = new javax.swing.JButton();
        jlblUserIcon = new javax.swing.JLabel();
        jbtnCadUsuario = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");
        jMenu1.setActionCommand("jbtnSimulacaoJogos");

        jmitSimularFaseG.setText("jMenuItem1");
        jMenu1.add(jmitSimularFaseG);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FootCup2022 - Home");
        setSize(new java.awt.Dimension(500, 500));

        jPanel1.setBackground(new java.awt.Color(42, 170, 56));

        jlblUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlblUser.setForeground(new java.awt.Color(255, 255, 255));
        jlblUser.setText("Bem vindo, $usr$!");

        jbtnVisualizarJogos.setText("Visualizar Jogos");
        jbtnVisualizarJogos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVisualizarJogosActionPerformed(evt);
            }
        });

        jbtnVisualizarTimes.setText("Visualizar Times");
        jbtnVisualizarTimes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVisualizarTimesActionPerformed(evt);
            }
        });

        jbtnVisualizarGrp.setText("Visualizar Grupos");
        jbtnVisualizarGrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVisualizarGrpActionPerformed(evt);
            }
        });

        jbtnSair.setText("Trocar Usuário");
        jbtnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSairActionPerformed(evt);
            }
        });

        jlblUserIcon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlblUserIcon.setForeground(new java.awt.Color(255, 255, 255));
        jlblUserIcon.setText("  ");
        jlblUserIcon.setToolTipText("<a href=\"https://www.flaticon.com/br/icones-gratis/admin\" title=\"admin ícones\">Icone criado por Tanah Basah - Flaticon</a>");

        jbtnCadUsuario.setText("Cadastrar Usuario");
        jbtnCadUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCadUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlblUserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnCadUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnVisualizarGrp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnVisualizarJogos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnVisualizarTimes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jlblUser))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jbtnSair)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jlblUserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnVisualizarTimes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnVisualizarGrp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jbtnCadUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnVisualizarJogos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(jbtnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        lblLogo.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLogo)
                .addGap(0, 354, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSairActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        frmLogin frm = new frmLogin();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_jbtnSairActionPerformed

    private void jbtnCadUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCadUsuarioActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        frmUsuario frm = new frmUsuario();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_jbtnCadUsuarioActionPerformed

    private void jbtnVisualizarTimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVisualizarTimesActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        frmTimes frm = new frmTimes();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_jbtnVisualizarTimesActionPerformed

    private void jbtnVisualizarGrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVisualizarGrpActionPerformed
        this.setVisible(false);
        frmGrupos frm = new frmGrupos();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_jbtnVisualizarGrpActionPerformed

    private void jbtnVisualizarJogosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVisualizarJogosActionPerformed
        // TODO add your handling code here:       
        this.setVisible(false);
        frmVisualizarJogos frm = new frmVisualizarJogos();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_jbtnVisualizarJogosActionPerformed

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
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnCadUsuario;
    private javax.swing.JButton jbtnSair;
    private javax.swing.JButton jbtnVisualizarGrp;
    private javax.swing.JButton jbtnVisualizarJogos;
    private javax.swing.JButton jbtnVisualizarTimes;
    private javax.swing.JLabel jlblUser;
    private javax.swing.JLabel jlblUserIcon;
    private javax.swing.JMenuItem jmitSimularFaseG;
    private javax.swing.JLabel lblLogo;
    // End of variables declaration//GEN-END:variables
}
