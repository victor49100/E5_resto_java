/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Lanceur;

import Controlleur.*;
import Vue.*;
import Metier.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.WindowConstants;

/*
 * @author Victor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //entity manager
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet2_Resto_JavaPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            ControlleurPrincipal CtrlP = new ControlleurPrincipal();
            CtrlP.setEm(em);
            VueConnexion VueMain = new VueConnexion();
            VueListeCritique vueCritique = new VueListeCritique();
            VueResponsable vueResp = new VueResponsable();
            ControlleurConnexion CtrlMain = new ControlleurConnexion(VueMain, CtrlP);
            ControlleurListeCritique CtrlCritique = new ControlleurListeCritique(vueCritique, CtrlP);
            ControlleurResponsable CtrlResp = new ControlleurResponsable(vueResp, CtrlP);

            CtrlP.setCrtlCritique(CtrlCritique);
            CtrlP.setCtrlConnexion(CtrlMain);
            CtrlP.setCtrlResp(CtrlResp);

            //affiche la vue 
            VueMain.setVisible(true);

        } catch (Exception e) {
            System.out.println("Problème de connexion au Serveur !");
            System.out.println(e);
        }

        //controlleur Principal
        //Instancie les vues et Controlleurs
        //creation des objets pour le test:
    }

}
