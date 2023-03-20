/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vue;

import Metier.Critiquer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import javax.swing.JTextField;

/**
 *
 * @author Victor
 */
public class VueListeCritique extends javax.swing.JFrame {

    private DefaultTableModel modelCritique;
    private Critiquer critiquer = new Critiquer();
    /**
     * Creates new form VueListeCritique
     */
    public VueListeCritique() {
        initComponents();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        modelCritique = new DefaultTableModel();
        jTableCritiques.setModel(modelCritique);
        jTableCritiques.setRowHeight(40);

    }
    


    public DefaultTableModel getModelCritique() {
        return this.modelCritique;
    }

    public JButton getjButtonRetour() {
        return jButtonRetour;
    }

    public JButton getjButtonDate1() {
        return jButtonDate1;
    }

    public JButton getjButtonDate2() {
        return jButtonDate2;
    }

    public void setjButtonDate1(JButton jButtonDate1) {
        this.jButtonDate1 = jButtonDate1;
    }

    public void setjButtonDate2(JButton jButtonDate2) {
        this.jButtonDate2 = jButtonDate2;
    }
       
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabelTitre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCritiques = new javax.swing.JTable();
        jButtonRetour = new javax.swing.JButton();
        jButtonDate1 = new javax.swing.JButton();
        jButtonDate2 = new javax.swing.JButton();
        jLabelFiltre = new javax.swing.JLabel();
        jLabelDu = new javax.swing.JLabel();
        jLabelAu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitre.setFont(new java.awt.Font("Ubuntu Mono", 0, 24)); // NOI18N
        jLabelTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitre.setText("Les Critiques");
        jLabelTitre.setAutoscrolls(true);
        jLabelTitre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTableCritiques.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableCritiques);

        jButtonRetour.setText("Retour");

        jButtonDate1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButtonDate2.setMaximumSize(new java.awt.Dimension(83, 25));
        jButtonDate2.setMinimumSize(new java.awt.Dimension(83, 25));
        jButtonDate2.setPreferredSize(new java.awt.Dimension(83, 25));

        jLabelFiltre.setText("Filtrer les avis par date:");

        jLabelDu.setText("Du");

        jLabelAu.setText("Au");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButtonRetour)
                .addGap(78, 78, 78)
                .addComponent(jLabelTitre, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabelDu)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jLabelAu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelFiltre)
                        .addGap(150, 150, 150))))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTitre)
                            .addComponent(jButtonRetour))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelFiltre)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonDate2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDate1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDu)
                            .addComponent(jLabelAu))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VueListeCritique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VueListeCritique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VueListeCritique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VueListeCritique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VueListeCritique().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonDate1;
    private javax.swing.JButton jButtonDate2;
    private javax.swing.JButton jButtonRetour;
    private javax.swing.JLabel jLabelAu;
    private javax.swing.JLabel jLabelDu;
    private javax.swing.JLabel jLabelFiltre;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCritiques;
    // End of variables declaration//GEN-END:variables
}
