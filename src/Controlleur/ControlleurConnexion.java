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
            Query requete = this.ctrlP.getEm().createNamedQuery("Administrateur.findByConnexion");
            try {
                requete.setParameter("pseudoA", login);
                //ont hash le mdp
                String MdpHash = HashToMd5(mdp);
                // on set le mdp dans le query
                requete.setParameter("mdpA", MdpHash);
                //ont test la corespondance
                if (requete.getSingleResult().getClass() == Administrateur.class) {
                    this.ctrlP.setAdminConnecte((Administrateur) requete.getSingleResult());
                    this.ctrlP.AfficheVueCritique();
                }
                if (requete.getSingleResult().getClass() == Responsable.class) {
                    this.ctrlP.setAdminConnecte((Responsable) requete.getSingleResult());
                    this.ctrlP.afficherVueResp();
                }

            } catch (Exception exception) {
            }

        }

    }

    public void HideLog() {
        vue.getjTextLogin().setText("");
        vue.getjTextPassword().setText("");
    }

    ;

    //methode de hash password en MD5
    private String HashToMd5(String passwordToHash) {
        try {
            // Création d'une instance du message digest MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Conversion de la chaîne de caractères en tableau de bytes
            byte[] passwordBytes = passwordToHash.getBytes();

            // Calcul du hash MD5
            byte[] hashBytes = md.digest(passwordBytes);

            // Conversion du hash en chaîne de caractères hexadécimaux
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            // Cette exception se produit si l'algorithme MD5 n'est pas supporté par la JVM
            e.printStackTrace();
            return null;
        }

    }

}
