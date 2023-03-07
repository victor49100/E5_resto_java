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
import javax.persistence.Table;

/**
 *
 * @author afiolleau@jolsio.net
 */
@Entity
@Table(name = "utilisateur")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findByIdU", query = "SELECT u FROM Utilisateur u WHERE u.idU = :idU"),
    @NamedQuery(name = "Utilisateur.findByMailU", query = "SELECT u FROM Utilisateur u WHERE u.mailU = :mailU"),
    @NamedQuery(name = "Utilisateur.findByMdpU", query = "SELECT u FROM Utilisateur u WHERE u.mdpU = :mdpU"),
    @NamedQuery(name = "Utilisateur.findByPseudoU", query = "SELECT u FROM Utilisateur u WHERE u.pseudoU = :pseudoU")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idU")
    private Long idU;
    @Basic(optional = false)
    @Column(name = "mailU")
    private String mailU;
    @Column(name = "mdpU")
    private String mdpU;
    @Column(name = "pseudoU")
    private String pseudoU;
    @ManyToMany(mappedBy = "utilisateurCollection")
    private Collection<Resto> restoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<Critiquer> critiquerCollection;

    public Utilisateur(Long idU, String mailU, String mdpU, String pseudoU, Collection<Resto> restoCollection, Collection<Critiquer> critiquerCollection) {
        this.idU = idU;
        this.mailU = mailU;
        this.mdpU = mdpU;
        this.pseudoU = pseudoU;
        this.restoCollection = restoCollection;
        this.critiquerCollection = critiquerCollection;
    }

    public Utilisateur(Long idU, String mailU, String mdpU, String pseudoU){
        this.idU = idU;
        this.mailU = mailU;
        this.mdpU = mdpU;
        this.pseudoU = pseudoU;
    }
    
    public Utilisateur() {
    }

    public Utilisateur(Long idU) {
        this.idU = idU;
    }

    public Utilisateur(Long idU, String mailU) {
        this.idU = idU;
        this.mailU = mailU;
    }

    public Long getIdU() {
        return idU;
    }

    public void setIdU(Long idU) {
        this.idU = idU;
    }

    public String getMailU() {
        return mailU;
    }

    public void setMailU(String mailU) {
        this.mailU = mailU;
    }

    public String getMdpU() {
        return mdpU;
    }

    public void setMdpU(String mdpU) {
        this.mdpU = mdpU;
    }

    public String getPseudoU() {
        return pseudoU;
    }

    public void setPseudoU(String pseudoU) {
        this.pseudoU = pseudoU;
    }

    public Collection<Resto> getRestoCollection() {
        return restoCollection;
    }

    public void setRestoCollection(Collection<Resto> restoCollection) {
        this.restoCollection = restoCollection;
    }

    public Collection<Critiquer> getCritiquerCollection() {
        return critiquerCollection;
    }

    public void setCritiquerCollection(Collection<Critiquer> critiquerCollection) {
        this.critiquerCollection = critiquerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idU != null ? idU.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idU == null && other.idU != null) || (this.idU != null && !this.idU.equals(other.idU))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projet2_resto_java.Utilisateur[ idU=" + idU + " ]";
    }
    
}
