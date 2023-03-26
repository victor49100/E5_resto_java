/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import Metier.Responsable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author acassard
 */
public class TestResponsable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Responsable resp1 = new Responsable(Long.MIN_VALUE,"secret1","resp1");
        Responsable resp2 = new Responsable(Long.MIN_VALUE, "secret2", "resp2");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet2_Resto_JavaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(resp1);
        em.persist(resp2);
        em.getTransaction().commit();
        Query q;
        
        System.out.println("\nTest de la méthode Responsable.findAll");
        q = em.createNamedQuery("Responsable.findAll");
        //System.out.println(q.getResultList());
        for (Object unResultat : q.getResultList()){
            System.out.println(unResultat);
        }
        
        System.out.println("\nTest de la méthode Responsable.findByMdp");
        q = em.createNamedQuery("Responsable.findByMdp");
        q.setParameter("mdpA", "secret1");
        //System.out.println(q.getResultList());
        for (Object unResultat : q.getResultList()){
            System.out.println(unResultat);
        }
    }
    
}
