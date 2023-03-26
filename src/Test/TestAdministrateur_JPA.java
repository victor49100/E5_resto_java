/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import Metier.Administrateur;
import Metier.Utilisateur;

/**
 *
 * @author acassard
 */
public class TestAdministrateur_JPA {
     public static void main(String[] args) {
        Administrateur admin = new Administrateur(Long.MIN_VALUE,"secret1","Admin1");
        Administrateur admin2 = new Administrateur(Long.MIN_VALUE, "secret2", "Admin2");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet2_Resto_JavaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(admin);
        em.persist(admin2);
        em.getTransaction().commit();
        Query q;
        
        System.out.println("\nTest de la méthode Administrateur.findAll");
        q = em.createNamedQuery("Administrateur.findAll");
        //System.out.println(q.getResultList());
        for (Object unResultat : q.getResultList()){
            System.out.println(unResultat);
        }
        
        System.out.println("\nTest de la méthode Administrateur.findByMdp");
        q = em.createNamedQuery("Administrateur.findByMdp");
        q.setParameter("mdpA", "secret1");
        //System.out.println(q.getResultList());
        for (Object unResultat : q.getResultList()){
            System.out.println(unResultat);
        }
        
        System.out.println("\nTest de la méthode Administrateur.findByConnexion");
        q = em.createNamedQuery("Administrateur.findByConnexion");
        q.setParameter("mdpA", "secret1");
        q.setParameter("pseudoA", "Admin1");
        //System.out.println(q.getResultList());
        for (Object unResultat : q.getResultList()){
            System.out.println(unResultat);
        }
     }
}
