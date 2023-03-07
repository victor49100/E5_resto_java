/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author acassard
 */
@Entity
@Table(name = "administrateur")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({
    @NamedQuery(name = "Administrateur.findAll", query = "SELECT a FROM Administrateur a"),
    @NamedQuery(name = "Administrateur.findByMdp", query = "SELECT a FROM Administrateur a WHERE a.mdpU = :mdpU")
})
@PrimaryKeyJoinColumn(name = "adminId")
public class Administrateur extends Utilisateur implements Serializable  {        
    
    public Administrateur(Long idU, String mailU, String mdpU, String pseudoU){
        super(idU, mailU,mdpU,pseudoU);
    }
    
    public Administrateur(){
        
    }
}
