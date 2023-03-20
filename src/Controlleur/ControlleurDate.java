/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlleur;

import Vue.VueDate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import Controlleur.ControlleurListeCritique;
import java.util.Date;
/**
 *
 * @author Victor
 */
public class ControlleurDate implements WindowListener, ActionListener {

    private VueDate vue;
    private ControlleurPrincipal ctrlP;
    private ControlleurListeCritique crtlLc;
    
    public Date date1;
    public Date date2;

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }
    
    public ControlleurDate(VueDate vue, ControlleurPrincipal ctrlP) {
        this.vue = vue;
        this.ctrlP = ctrlP;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);    
        this.vue.getJbuttonOk().addActionListener(this);
        //this.vue.getjCalendarDate().addPropertyChangeListener(listener);

    }

    public VueDate getVue() {
        return vue;
    }

    public void setVue(VueDate vue) {
        this.vue = vue;
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
        if (e.getSource() == vue.getJbuttonOk()) {
               ctrlP.cacheVueDate();               
        }

    }
}
