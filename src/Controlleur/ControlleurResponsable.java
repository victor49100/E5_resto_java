/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlleur;

import Vue.VueResponsable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import Vue.VueConnexion;
import Controlleur.*;
import Metier.Administrateur;
import Metier.Responsable;
import java.awt.event.MouseEvent;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import java.util.List;

/**
 *
 * @author acassard
 */
public class ControlleurResponsable implements WindowListener, ActionListener {

    private VueResponsable vue;
    private ControlleurPrincipal ctrlP;

    public ControlleurResponsable(VueResponsable vue, ControlleurPrincipal ctrlP) {
        this.ctrlP = ctrlP;
        this.vue = vue;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        this.vue.getButtonMoyenne().addActionListener(this);
        //this.vue.getLabelMoyenne().addActionListener(this);
        this.vue.getListUtil().addActionListener(this);

    }

    public VueResponsable getVue() {
        return vue;
    }

    public void setVue(VueResponsable vue) {
        this.vue = vue;
    }

    public ControlleurPrincipal getCtrlP() {
        return ctrlP;
    }

    public void setCtrlP(ControlleurPrincipal ctrlP) {
        this.ctrlP = ctrlP;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

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
        if (e.getSource() == vue.getButtonMoyenne()) {
            System.out.println("test Moyenne");
        }
    }
}
