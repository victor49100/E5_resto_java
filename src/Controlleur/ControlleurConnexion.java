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
import Metier.Utilisateur;
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
            Query requette = this.ctrlP.getEm().createQuery("SELECT c FROM Utilisateur c WHERE c.mailU = \"alex.garat@gmail.com\"");
            Utilisateur Data = (Utilisateur) requette.getSingleResult();
            System.out.println(Data.getMdpU());
            System.out.println(vue.getjTextPassword().getPassword());
            System.out.println(Data.getMailU());
            if (vue.getjTextPassword().getPassword().equals(Data.getMdpU())) {
                System.out.println("mail existe");
                this.ctrlP.AfficheVueCritique();
            } else {
                System.out.println("mail existe pas");

            }

        }
        if (e.getSource() == vue.getNoLog()) {
            System.out.println("vue critique");
            this.ctrlP.AfficheVueCritique();
        }

    }

}
