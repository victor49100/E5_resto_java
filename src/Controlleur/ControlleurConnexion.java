/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import Vue.VueConnexion;
import Controlleur.*;
import Metier.Administrateur;
import java.awt.event.MouseEvent;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import java.util.List;

/**
 *
 * @author Victor
 */
public class ControlleurConnexion implements WindowListener, ActionListener {

    private VueConnexion vue;
    private ControlleurPrincipal ctrlP;

    public ControlleurConnexion(VueConnexion vue, ControlleurPrincipal ctrlP) {
        this.vue = vue;
        this.ctrlP = ctrlP;

        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        this.vue.getjTextLogin().addActionListener(this);
        this.vue.getjTextPassword().addActionListener(this);
        this.vue.getjButtonValider().addActionListener(this);
        this.vue.getNoLog().addActionListener(this);
        
    }

    public VueConnexion getVue() {
        return vue;
    }

    public void setVue(VueConnexion vue) {
        this.vue = vue;
    }
    
    public void mouseClicked(WindowEvent e) {
        
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.ctrlP.quitterApp();
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
        //action 
        if (e.getSource() == vue.getjButtonValider()) {
            String login = vue.getjTextLogin().getText();
            String mdp = String.valueOf(vue.getjTextPassword().getPassword());
            System.out.println(mdp);
            System.out.println(login);
            Query requete = this.ctrlP.getEm().createNamedQuery("Administrateur.findByConnexion");
            requete.setParameter("mdpA", mdp);
            requete.setParameter("pseudoA", login);
            try {
                Administrateur admin = (Administrateur) requete.getSingleResult();
                System.out.println("mail existe");
                this.ctrlP.AfficheVueCritique();                
            } catch (Exception exception) {
                System.out.println("Oups pas d'admin");
            }

        }
        if (e.getSource() == vue.getNoLog()) {
            System.out.println("vue critique");
            this.ctrlP.AfficheVueCritique();
        }

    }

}
