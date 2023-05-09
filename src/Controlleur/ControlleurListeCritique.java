/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlleur;

import Metier.Administrateur;
import Vue.VueListeCritique;
import Vue.CustomCellRenderer;
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
import Metier.CritiquerPK;
import Metier.Resto;
import Metier.Utilisateur;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.swing.table.TableColumn;

/**
 *
 * @author Victor
 */
public class ControlleurListeCritique implements WindowListener, ActionListener {

    private Vue.VueListeCritique vue;
    private ControlleurPrincipal CtrlP;
    String dateStr1 = "";
    String dateStr2 = "";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
    private CritiquerPK lesIdCritiques[];

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
        this.vue.getjButtonMasquer().addActionListener(this);
        this.vue.getJbuttonDemasquer().addActionListener(this);

        //afficher les commentaires
        afficherLesCritiques();
    }

    public VueListeCritique getVue() {
        return vue;
    }

    private void afficherLesCritiques() {
        Query q;
        this.vue.getModelCritique().setRowCount(0);        
        String[] titresColonnes = {"Pseudo", "Resto", "Critique", "Note", "Date", "Hidden"};        
        this.vue.getModelCritique().setColumnIdentifiers(titresColonnes);                                
        List<Critiquer> critiquerResult = CtrlP.getEm().createNamedQuery("Critiquer.findAllOrderByDateDesc").getResultList();
        this.lesIdCritiques = new CritiquerPK[critiquerResult.size()];

        for (int i = 0; i < critiquerResult.size(); i++) {
            this.lesIdCritiques[i] = critiquerResult.get(i).getCritiquerPK();
            Object[] lignes = new Object[6];           
            String pseudo = critiquerResult.get(i).getUtilisateur().getPseudoU();
            String commentaire = critiquerResult.get(i).getCommentaire();            
            String dateComStr = sdf.format(critiquerResult.get(i).getDate());
            String note = "NULL";
            if (critiquerResult.get(i).getNote() != null) {
                note = critiquerResult.get(i).getNote().toString();
            }
            String nomResto = critiquerResult.get(i).getResto().getNomR();              
            lignes[0] = pseudo;
            lignes[1] = nomResto;
            lignes[2] = commentaire;
            lignes[3] = note;
            lignes[4] = dateComStr;            
            if (critiquerResult.get(i).getAdministrateur() != null){
                lignes[5] = "masqué";
            }
            getVue().getModelCritique().addRow(lignes);
            
        }
        this.vue.getjTableCritiques().getColumnModel().getColumn(5).setWidth(0);
        this.vue.getjTableCritiques().getColumnModel().getColumn(5).setMinWidth(0);
        this.vue.getjTableCritiques().getColumnModel().getColumn(5).setMaxWidth(0);        
    }

    private void afficherLesCritiquesBetweenDate(Date dateDebut, Date dateFin) {
        Query q;      
        getVue().getModelCritique().setRowCount(0);        

        // Créer la requête nommée "Critiquer.findByDate" pour obtenir les commentaires triés par date
        q = CtrlP.getEm().createNamedQuery("Critiquer.findByDate");
        q.setParameter("dateDebut", dateDebut);
        q.setParameter("dateFin", dateFin);
        List<Critiquer> critiquerResult = q.getResultList();
        this.lesIdCritiques = new CritiquerPK[critiquerResult.size()];

        for (int i = 0; i < critiquerResult.size(); i++) {
            this.lesIdCritiques[i] = critiquerResult.get(i).getCritiquerPK();
            Object[] lignes = new Object[6];
            String pseudo = critiquerResult.get(i).getUtilisateur().getPseudoU();
            String commentaire = critiquerResult.get(i).getCommentaire();
            String dateComStr = sdf.format(critiquerResult.get(i).getDate());
            String note = "NULL";
            if (critiquerResult.get(i).getNote() != null) {
                note = critiquerResult.get(i).getNote().toString();
            }
            String nomResto = critiquerResult.get(i).getResto().getNomR();            
            lignes[0] = pseudo;
            lignes[1] = nomResto;
            lignes[2] = commentaire;
            lignes[3] = note;
            lignes[4] = dateComStr;
            if (critiquerResult.get(i).getAdministrateur() != null){
                lignes[5] = "masqué";
            }
            getVue().getModelCritique().addRow(lignes);            
        }
    }
    
    private void masquerLaCritique(CritiquerPK laCritiquePK) {
        Query q = CtrlP.getEm().createNamedQuery("Critiquer.findByCritiquerPk");
        q.setParameter("idU", laCritiquePK.getIdU());
        q.setParameter("idR", laCritiquePK.getIdR());
        Critiquer laCritique = (Critiquer)q.getSingleResult(); 
        Administrateur adminConnecte = this.CtrlP.getAdminConnecte();
        this.CtrlP.getEm().refresh(adminConnecte);                                                  
        adminConnecte.addCritiquer(laCritique);                                                     
        this.CtrlP.getEm().getTransaction().commit();
        this.vue.getModelCritique().setValueAt("masqué", this.vue.getjTableCritiques().getSelectedRow(), 5); //ajoute l'atribut "masqué" dans une 5 collone invisible
        this.vue.getjTableCritiques().revalidate();
        this.vue.getjTableCritiques().repaint();
        this.CtrlP.getEm().getTransaction().begin(); 
    }
    
    private void demasquerLaCritique(CritiquerPK laCritiquePK){
        Query q = CtrlP.getEm().createNamedQuery("Critiquer.findByCritiquerPk");
        q.setParameter("idU", laCritiquePK.getIdU());
        q.setParameter("idR", laCritiquePK.getIdR());
        Critiquer laCritique = (Critiquer)q.getSingleResult();
        Administrateur adminConnecte = this.CtrlP.getAdminConnecte();
        this.CtrlP.getEm().refresh(adminConnecte);                                                     
        adminConnecte.removeCritiquer(laCritique);                                       
        this.CtrlP.getEm().getTransaction().commit();
        this.vue.getModelCritique().setValueAt(null, this.vue.getjTableCritiques().getSelectedRow(), 5);
        this.vue.getjTableCritiques().revalidate();
        this.vue.getjTableCritiques().repaint();
        this.CtrlP.getEm().getTransaction().begin();
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
                afficherLesCritiquesBetweenDate(date1, date2);
            } catch (ParseException ex) {
                Logger.getLogger(ControlleurListeCritique.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (e.getSource() == vue.getjButtonRetour()) {
            CtrlP.quitterVueCommentaire();
        }

        if (e.getSource() == vue.getBoutonCommentaire()) {
            afficherLesCritiques();
        }
        
        if (e.getSource() == vue.getjButtonMasquer()) {
            if (this.vue.getjTableCritiques().getSelectedRow() != -1){
                CritiquerPK laCritiquerPK = this.lesIdCritiques[this.vue.getjTableCritiques().getSelectedRow()];                
                masquerLaCritique(laCritiquerPK);
            }
        }
        
        if (e.getSource() == vue.getJbuttonDemasquer()) {
            if (this.vue.getjTableCritiques().getSelectedRow() != -1){
                CritiquerPK laCritiquerPK = this.lesIdCritiques[this.vue.getjTableCritiques().getSelectedRow()];
                demasquerLaCritique(laCritiquerPK);                
            }
        }

    }

}
