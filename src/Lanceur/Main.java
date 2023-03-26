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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet2_Resto_JavaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //controlleur Principal
        ControlleurPrincipal CtrlP = new ControlleurPrincipal();
        CtrlP.setEm(em);

        //Instancie les vues et Controlleurs
        VueConnexion VueMain = new VueConnexion();
        VueListeCritique vueCritique = new VueListeCritique();
        VueDate vueDate = new VueDate(vueCritique, true);
        VueResponsable vueResp = new VueResponsable();
        ControlleurConnexion CtrlMain = new ControlleurConnexion(VueMain, CtrlP);
        ControlleurListeCritique CtrlCritique = new ControlleurListeCritique(vueCritique, CtrlP);
        ControlleurDate CtrlDate = new ControlleurDate(vueDate, CtrlP);
        ControlleurResponsable CtrlResp = new ControlleurResponsable(vueResp, CtrlP);
        
        CtrlP.setCrtlCritique(CtrlCritique);
        CtrlP.setCtrlConnexion(CtrlMain);
        CtrlP.setCrtlControlleurDate(CtrlDate);
        CtrlP.setCtrlResp(CtrlResp);

        //affiche la vue 
        VueMain.setVisible(true);

        //creation des objets pour le test:
        
        

    }

}
