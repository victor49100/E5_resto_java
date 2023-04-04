/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlleur;

import Vue.VueListeCritique;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.table.DefaultTableModel;
import Metier.Critiquer;
import Metier.Resto;
import Metier.Utilisateur;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;

/**
 *
 * @author Victor
 */
public class ControlleurListeCritique implements WindowListener, ActionListener {

    private Vue.VueListeCritique vue;
    private ControlleurPrincipal CtrlP;
    String dateStr1 = "";
    String dateStr2 = "";
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");

    public ControlleurListeCritique(VueListeCritique vue, ControlleurPrincipal CtrlP) {
        this.vue = vue;
        this.CtrlP = CtrlP;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        this.vue.getjButtonRetour().addActionListener(this);
        this.vue.getDate1();
        this.vue.getDate2();
        this.vue.getBoutonCommentaire().addActionListener(this);
        this.vue.getTest().addActionListener(this);

        //afficher les commentaires
        afficherLesAdresses();
    }

    public VueListeCritique getVue() {
        return vue;
    }

    private void afficherLesAdresses() {
        Query q;
        getVue().getModelCritique().setRowCount(0);
        String[] titresColonnes = {"Pseudo", "Resto", "Critique", "Note", "Date"};
        getVue().getModelCritique().setColumnIdentifiers(titresColonnes);
        List<Critiquer> critiquerResult = CtrlP.getEm().createNamedQuery("Critiquer.findAllOrderByDateDesc").getResultList();

        for (int i = 0; i < critiquerResult.size(); i++) {
            List<String> lignes = new ArrayList<>();

            String pseudo = critiquerResult.get(i).getUtilisateur().getPseudoU();
            String commentaire = critiquerResult.get(i).getCommentaire();
            Date dateCom = critiquerResult.get(i).getDate();
            String dateComStr = dateCom + "";
            String note = "NULL";
            if (critiquerResult.get(i).getNote() != null) {
                note = critiquerResult.get(i).getNote().toString();
            }
            String nomResto = critiquerResult.get(i).getResto().getNomR();
            lignes.add(pseudo);
            lignes.add(nomResto);
            lignes.add(commentaire);
            lignes.add(note);
            lignes.add(dateComStr);
            getVue().getModelCritique().addRow(lignes.toArray());
        }
    }

    private void afficherLesAdressesBetwenDate(Date dateDebut, Date dateFin) {
        Query q;
        getVue().getModelCritique().setRowCount(0);
        String[] titresColonnes = {"Pseudo", "Resto", "Critique", "Note", "Date"};
        getVue().getModelCritique().setColumnIdentifiers(titresColonnes);

        // Créer la requête nommée "Critiquer.findByDate" pour obtenir les commentaires triés par date
        q = CtrlP.getEm().createNamedQuery("Critiquer.findByDate");
        q.setParameter("dateDebut", dateDebut);
        q.setParameter("dateFin", dateFin);
        List<Critiquer> critiquerResult = q.getResultList();

        for (int i = 0; i < critiquerResult.size(); i++) {
            List<String> lignes = new ArrayList<>();

            String pseudo = critiquerResult.get(i).getUtilisateur().getPseudoU();
            String commentaire = critiquerResult.get(i).getCommentaire();
            Date dateCom = critiquerResult.get(i).getDate();
            String dateComStr = dateCom + "";
            String note = "NULL";
            if (critiquerResult.get(i).getNote() != null) {
                note = critiquerResult.get(i).getNote().toString();
            }
            String nomResto = critiquerResult.get(i).getResto().getNomR();
            lignes.add(pseudo);
            lignes.add(nomResto);
            lignes.add(commentaire);
            lignes.add(note);
            lignes.add(dateComStr);
            getVue().getModelCritique().addRow(lignes.toArray());
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

        if (e.getSource() == vue.getTest()) {

            dateStr1 = vue.getDateChooserCombo1().getText();
            dateStr2 = vue.getDateChooserCombo2().getText();
            Date date1;
            Date date2;
            try {
                date1 = formatter.parse(dateStr1);
                date2 = formatter.parse(dateStr2);
                this.vue.getDate1().setText(vue.getDateChooserCombo1().getText());
                this.vue.getDate2().setText(vue.getDateChooserCombo2().getText());
                afficherLesAdressesBetwenDate(date1, date2);
            } catch (ParseException ex) {
                Logger.getLogger(ControlleurListeCritique.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (e.getSource() == vue.getjButtonRetour()) {
            CtrlP.quitterVueCommentaire();
        }

        if (e.getSource() == vue.getBoutonCommentaire()) {
            afficherLesAdresses();
        }

    }

}
