/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet2_resto_java.modele.metier;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author afiolleau@jolsio.net
 */
@Entity
@Table(name = "photo")
@NamedQueries({
    @NamedQuery(name = "Photo.findAll", query = "SELECT p FROM Photo p"),
    @NamedQuery(name = "Photo.findByIdP", query = "SELECT p FROM Photo p WHERE p.idP = :idP"),
    @NamedQuery(name = "Photo.findByCheminP", query = "SELECT p FROM Photo p WHERE p.cheminP = :cheminP")})
public class Photo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idP")
    private Long idP;
    @Column(name = "cheminP")
    private String cheminP;
    @JoinColumn(name = "idR", referencedColumnName = "idR")
    @ManyToOne
    private Resto idR;

    public Photo() {
    }

    public Photo(Long idP) {
        this.idP = idP;
    }

    public Long getIdP() {
        return idP;
    }

    public void setIdP(Long idP) {
        this.idP = idP;
    }

    public String getCheminP() {
        return cheminP;
    }

    public void setCheminP(String cheminP) {
        this.cheminP = cheminP;
    }

    public Resto getIdR() {
        return idR;
    }

    public void setIdR(Resto idR) {
        this.idR = idR;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idP != null ? idP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Photo)) {
            return false;
        }
        Photo other = (Photo) object;
        if ((this.idP == null && other.idP != null) || (this.idP != null && !this.idP.equals(other.idP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projet2_resto_java.Photo[ idP=" + idP + " ]";
    }
    
}
