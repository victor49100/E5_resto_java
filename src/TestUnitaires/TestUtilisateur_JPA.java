/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestUnitaires;

import Metier.Administrateur;
import Metier.Utilisateur;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author acassard
 */
public class TestUtilisateur_JPA {
    public static void main(String[] args) {
        Utilisateur util = new Utilisateur(Long.MIN_VALUE, "util1@test.com", "secretUtil", "util1");
        Utilisateur util2 = new Utilisateur(Long.MIN_VALUE, "util2@test.com", "secretUtil2", "util2");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet2_Resto_JavaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(util);
        em.persist(util2);
        em.getTransaction().commit();
        Query q;
        
        System.out.println("\nTest de la méthode Utilisateur.findAll");
        q = em.createNamedQuery("Utilisateur.findAll");
        //System.out.println(q.getResultList());
        for (Object unResultat : q.getResultList()){
            System.out.println(unResultat);
        }
        
        System.out.println("\nTest de la méthode Utilisateur.findByMdpU");
        q = em.createNamedQuery("Utilisateur.findByMdpU");
        q.setParameter("mdpU", "secretUtil");
        //System.out.println(q.getResultList());
        for (Object unResultat : q.getResultList()){
            System.out.println(unResultat);
        }
     }
}
