/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlleur;

import Vue.VueListeCritique;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor
 */
public class ControlleurListeCritique implements WindowListener, ActionListener{
    
    private Vue.VueListeCritique vue;
    private ControlleurPrincipal CtrlP;
    

    public ControlleurListeCritique(VueListeCritique vue, ControlleurPrincipal CtrlP) {
        this.vue = vue;
        this.CtrlP = CtrlP;
        // le contrôleur écoute la vue
         this.vue.addWindowListener(this);
         this.vue.getjButtonRetour().addActionListener(this);
         //afficher les commentaires
         afficherLesAdresses();
    }
    
    
        
    public VueListeCritique getVue() {
        return vue;
    }
    
    private void afficherLesAdresses() {
        getVue().getModelCritique().setRowCount(0);
        String[] titresColonnes = {"Critique", "Pseudo", "Note","Resto"};
        getVue().getModelCritique().setColumnIdentifiers(titresColonnes);
        String[] lignes = new String[4];
        for (int i = 0; i<40; i++) {
            String ereLigne = "<html><p>Critique  "+ String.valueOf(i) + "</p>";
            lignes[0] = ereLigne +"<p>Test Skip</p></html>";
            lignes[1] = "Pseudo maquette "+ String.valueOf(i);
            lignes[2] = "Note maquette "+ String.valueOf(i);
            lignes[3] = "Resto maquette "+ String.valueOf(i);
            getVue().getModelCritique().addRow(lignes);
        }
        }
    
        
    
    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        CtrlP.quitterVueCommentaire();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vue.getjButtonRetour()){
            CtrlP.quitterVueCommentaire();
            
        }
    }
    
}
