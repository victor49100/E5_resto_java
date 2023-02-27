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
        
        System.out.println("Salut la team !");
        //controlleur Principal
        ControlleurPrincipal CtrlP = new ControlleurPrincipal();

        //Instancie les vues et Controlleurs
        VueConnexion VueMain = new VueConnexion();
        VueListeCritique vueCritique = new VueListeCritique();
        ControlleurConnexion CtrlMain = new ControlleurConnexion(VueMain, CtrlP);
        ControlleurListeCritique CtrlCritique = new ControlleurListeCritique(vueCritique, CtrlP);
        
        CtrlP.setCrtlCritique(CtrlCritique);
        CtrlP.setCtrlConnexion(CtrlMain);
        CtrlP.setEm(em);

        //affiche la vue 
        VueMain.setVisible(true);

        //creation des objets pour le test:
        
        

    }

}
