/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet2_resto_java.modele.metier;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author afiolleau@jolsio.net
 */
@Entity
@Table(name = "typesResto")
@NamedQueries({
    @NamedQuery(name = "TypesResto.findAll", query = "SELECT t FROM TypesResto t"),
    @NamedQuery(name = "TypesResto.findByIdTC", query = "SELECT t FROM TypesResto t WHERE t.idTC = :idTC"),
    @NamedQuery(name = "TypesResto.findByLibelleTC", query = "SELECT t FROM TypesResto t WHERE t.libelleTC = :libelleTC")})
public class TypesResto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTC")
    private Long idTC;
    @Basic(optional = false)
    @Column(name = "libelleTC")
    private String libelleTC;
    @ManyToMany(mappedBy = "typesRestoCollection")
    private Collection<Resto> restoCollection;

    public TypesResto() {
    }

    public TypesResto(Long idTC) {
        this.idTC = idTC;
    }

    public TypesResto(Long idTC, String libelleTC) {
        this.idTC = idTC;
        this.libelleTC = libelleTC;
    }

    public Long getIdTC() {
        return idTC;
    }

    public void setIdTC(Long idTC) {
        this.idTC = idTC;
    }

    public String getLibelleTC() {
        return libelleTC;
    }

    public void setLibelleTC(String libelleTC) {
        this.libelleTC = libelleTC;
    }

    public Collection<Resto> getRestoCollection() {
        return restoCollection;
    }

    public void setRestoCollection(Collection<Resto> restoCollection) {
        this.restoCollection = restoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTC != null ? idTC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypesResto)) {
            return false;
        }
        TypesResto other = (TypesResto) object;
        if ((this.idTC == null && other.idTC != null) || (this.idTC != null && !this.idTC.equals(other.idTC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projet2_resto_java.TypesResto[ idTC=" + idTC + " ]";
    }
    
}
