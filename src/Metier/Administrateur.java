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
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author acassard
 */
@Entity
@Table(name = "administrateur")
@NamedQueries({
    //affichage moyenne
    @NamedQuery(name = "Administrateur.findAll", query = "SELECT a FROM Administrateur a"),
    @NamedQuery(name = "Administrateur.findByMdp", query = "SELECT a FROM Administrateur a WHERE a.mdpA = :mdpA"),    
    @NamedQuery(name = "Administrateur.findByConnexion", query = "SELECT a FROM Administrateur a WHERE a.mdpA = :mdpA and a.pseudoA = :pseudoA"),
})
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="role")
public class Administrateur implements Serializable  {        
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    
    @Column(name = "idA")
    private Long idA;
    
    @Column(name = "mdpA")
    private String mdpA;
    
    @Column(name = "pseudoA")
    private String pseudoA;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="idA")
    private Collection<Critiquer> critiquerCollection;

    public Administrateur(Long idU, String mdpU, String pseudoU, Collection<Critiquer> critiquerCollection) {
        this.idA = idU;
        this.mdpA = mdpU;
        this.pseudoA = pseudoU;        
        this.critiquerCollection = critiquerCollection;
    }

    public Administrateur(Long idU, String mdpU, String pseudoU){
        this.idA = idU;
        this.mdpA = mdpU;
        this.pseudoA = pseudoU;
    }
    
    public Administrateur() {
    }

    public Administrateur(Long idU) {
        this.idA = idU;
    }   

    public Long getIdA() {
        return idA;
    }

    public void setIdA(Long idA) {
        this.idA = idA;
    }

    public String getMdpA() {
        return mdpA;
    }

    public void setMdpA(String mdpA) {
        this.mdpA = mdpA;
    }

    public String getPseudoA() {
        return pseudoA;
    }

    public void setPseudoA(String pseudoA) {
        this.pseudoA = pseudoA;
    }

    public Collection<Critiquer> getCritiquerCollection() {
        return critiquerCollection;
    }

    public void setCritiquerCollection(Collection<Critiquer> critiquerCollection) {
        this.critiquerCollection = critiquerCollection;
    }
    
    public void addCritiquer(Critiquer laCritique) {
        laCritique.setAdministrateur(this);
        this.critiquerCollection.add(laCritique);
    }
    
    public void removeCritiquer(Critiquer laCritique) {
        laCritique.setAdministrateur(null);
        this.critiquerCollection.remove(laCritique);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idA != null ? idA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrateur)) {
            return false;
        }
        Administrateur other = (Administrateur) object;
        if ((this.idA == null && other.idA != null) || (this.idA != null && !this.idA.equals(other.idA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String returnString = getClass().getName() + "[ idU=" + idA + ", CritiquerCollection=";
        for(Critiquer laCritique : this.critiquerCollection){
            returnString += laCritique.toString();
        }
        returnString += "]";
        return returnString;       
    }  
}
