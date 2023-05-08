/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;
import Metier.Administrateur;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import Metier.Critiquer;
import Metier.CritiquerPK;
/**
 *
 * @author afiolleau@jolsio.net
 */
public class TestCritiquer_JPA {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet2_Resto_JavaPU");
        EntityManager em = emf.createEntityManager();
        Query q;
        
        Critiquer critique = new Critiquer();
        List <Critiquer> list;
        System.out.println("TestUnitaire Critiquer JPA");
        
        
        System.out.println("\nTest de la méthode Critiquer.findAll");
        q = em.createNamedQuery("Critiquer.findAll");
        //System.out.println(q.getResultList());
        for (Object unResultat : q.getResultList()){
            System.out.println(unResultat);
        }
        
        
        
        System.out.println("\nTest de la méthode Critiquer.findByIdR");
        q = em.createNamedQuery("Critiquer.findByIdR");
        q.setParameter("idR",1);
        System.out.println(q.getResultList());
        
        
        
        System.out.println("\nTest de la méthode Critiquer.findByNote");
        q = em.createNamedQuery("Critiquer.findByNote");
        q.setParameter("note",1);
        System.out.println(q.getResultList());
        
        
        
        System.out.println("\nTest de la méthode Critiquer.findByCommentaire");
        q = em.createNamedQuery("Critiquer.findByCommentaire");
        q.setParameter("commentaire","bof.");
        System.out.println(q.getSingleResult());
        
        
        
        System.out.println("\nTest de la méthode Critiquer.findByIdU");
        em.getTransaction().begin();
        q = em.createNamedQuery("Critiquer.findByIdU");
        q.setParameter("idU",1);        
        System.out.println(q.getResultList());
        
        System.out.println("\nTest de la relation administrateur/critique");
        //Initialisation des variables                
        Query qAdmin = em.createQuery("SELECT a FROM Administrateur a WHERE a.idA = 1");        
        Query qCritique = em.createNamedQuery("Critiquer.findByCritiquerPk");
        qCritique.setParameter("idU",1);
        qCritique.setParameter("idR",7);
        Critiquer laCritique = (Critiquer)qCritique.getSingleResult();
        Administrateur admin1 = (Administrateur)qAdmin.getSingleResult();
        
        System.out.println("\nAjout d'une critique masquée à un administrateur");
        
        admin1.addCritiquer(laCritique);
        
        System.out.println("\nTest de la persistence, la critique devrait retourner un admin");        
        laCritique = (Critiquer)qCritique.getSingleResult();        
        admin1 = (Administrateur)qAdmin.getSingleResult();        
        System.out.println("Etat de l'admin après ajout = " + admin1.toString());
        System.out.println("Admin critique1 = " + laCritique.getAdministrateur().toString());
        
        System.out.println("\nSuppression d'une critique masquée liéé à un administrateur");        
        admin1.removeCritiquer(laCritique);
        
        System.out.println("\nTest de la persistence, la critique devrait avoir son champ admin égal à null"); 
        admin1 = (Administrateur)qAdmin.getSingleResult();
        laCritique = (Critiquer)qCritique.getSingleResult();
        String adminCritique;
        if (laCritique.getAdministrateur() == null){
            adminCritique = "vide";
        } else {
            adminCritique = "echec";
        }
        System.out.println("Etat de l'admin après suppression = " + admin1.toString());
        System.out.println("Admin critique1 = "+adminCritique);
        em.getTransaction().commit();
        
        
        
        
//        System.out.println("Suppression de l'ancien commentaire de test");
//        TypedQuery<Critiquer> typedQuery = (TypedQuery<Critiquer>) em.createNamedQuery("Critiquer.findByIdRAndIdU");
//        typedQuery.setParameter("idR",1);
//        typedQuery.setParameter("idU", 1);
//        if(typedQuery != null){
//        list = typedQuery.getResultList();
//        persist(em,list);
//        }

        
        
//        System.out.println("\nTest de l'insertion d'une critique");
//        System.out.println("Saisissez le commentaire : ");
//        critique.setCritiquerPK(new CritiquerPK(1,1));
//        critique.setCommentaire(sc.nextLine());
//        System.out.println(critique);
//        persist(em,critique);
//        System.out.println("Fin du test unitaire");
    }
    private static void lireLaListe(List<Critiquer> list){
        for(Critiquer c : list){
            System.out.println(c);
        }
    }
    
    private static void persist(EntityManager em,Object o){
        if(o instanceof Critiquer){
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
        }else if(o instanceof List) {
            em.getTransaction().begin();
            removeLaListe((List<Critiquer>) o,em);
            em.getTransaction().commit();
        }else{
            System.out.println("L'élément indiqué n'est pas persistable");
        }
    }
    private static void removeLaListe(List<Critiquer> list, EntityManager em){
        for(Critiquer c : list){
            em.remove(c);
        }
    }
}
