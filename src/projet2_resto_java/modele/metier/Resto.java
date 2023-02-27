/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet2_resto_java.modele.metier;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
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
@Table(name = "resto")
@NamedQueries({
    @NamedQuery(name = "Resto.findAll", query = "SELECT r FROM Resto r"),
    @NamedQuery(name = "Resto.findByIdR", query = "SELECT r FROM Resto r WHERE r.idR = :idR"),
    @NamedQuery(name = "Resto.findByNomR", query = "SELECT r FROM Resto r WHERE r.nomR = :nomR"),
    @NamedQuery(name = "Resto.findByNumAdrR", query = "SELECT r FROM Resto r WHERE r.numAdrR = :numAdrR"),
    @NamedQuery(name = "Resto.findByVoieAdrR", query = "SELECT r FROM Resto r WHERE r.voieAdrR = :voieAdrR"),
    @NamedQuery(name = "Resto.findByCpR", query = "SELECT r FROM Resto r WHERE r.cpR = :cpR"),
    @NamedQuery(name = "Resto.findByVilleR", query = "SELECT r FROM Resto r WHERE r.villeR = :villeR"),
    @NamedQuery(name = "Resto.findByLatitudeDegR", query = "SELECT r FROM Resto r WHERE r.latitudeDegR = :latitudeDegR"),
    @NamedQuery(name = "Resto.findByLongitudeDegR", query = "SELECT r FROM Resto r WHERE r.longitudeDegR = :longitudeDegR")})
public class Resto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idR")
    private Long idR;
    @Column(name = "nomR")
    private String nomR;
    @Column(name = "numAdrR")
    private String numAdrR;
    @Column(name = "voieAdrR")
    private String voieAdrR;
    @Column(name = "cpR")
    private String cpR;
    @Column(name = "villeR")
    private String villeR;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitudeDegR")
    private Float latitudeDegR;
    @Column(name = "longitudeDegR")
    private Float longitudeDegR;
    @Lob
    @Column(name = "descR")
    private String descR;
    @Lob
    @Column(name = "horairesR")
    private String horairesR;
    @JoinTable(name = "liaisontypes", joinColumns = {
        @JoinColumn(name = "idResto", referencedColumnName = "idR")}, inverseJoinColumns = {
        @JoinColumn(name = "idTypes", referencedColumnName = "idTC")})
    @ManyToMany
    private Collection<TypesResto> typesRestoCollection;
    @JoinTable(name = "aimer", joinColumns = {
        @JoinColumn(name = "idR", referencedColumnName = "idR")}, inverseJoinColumns = {
        @JoinColumn(name = "idU", referencedColumnName = "idU")})
    @ManyToMany
    private Collection<Utilisateur> utilisateurCollection;
    @OneToMany(mappedBy = "idR")
    private Collection<Photo> photoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resto")
    private Collection<Critiquer> critiquerCollection;

    public Resto() {
    }

    public Resto(Long idR) {
        this.idR = idR;
    }

    public Long getIdR() {
        return idR;
    }

    public void setIdR(Long idR) {
        this.idR = idR;
    }

    public String getNomR() {
        return nomR;
    }

    public void setNomR(String nomR) {
        this.nomR = nomR;
    }

    public String getNumAdrR() {
        return numAdrR;
    }

    public void setNumAdrR(String numAdrR) {
        this.numAdrR = numAdrR;
    }

    public String getVoieAdrR() {
        return voieAdrR;
    }

    public void setVoieAdrR(String voieAdrR) {
        this.voieAdrR = voieAdrR;
    }

    public String getCpR() {
        return cpR;
    }

    public void setCpR(String cpR) {
        this.cpR = cpR;
    }

    public String getVilleR() {
        return villeR;
    }

    public void setVilleR(String villeR) {
        this.villeR = villeR;
    }

    public Float getLatitudeDegR() {
        return latitudeDegR;
    }

    public void setLatitudeDegR(Float latitudeDegR) {
        this.latitudeDegR = latitudeDegR;
    }

    public Float getLongitudeDegR() {
        return longitudeDegR;
    }

    public void setLongitudeDegR(Float longitudeDegR) {
        this.longitudeDegR = longitudeDegR;
    }

    public String getDescR() {
        return descR;
    }

    public void setDescR(String descR) {
        this.descR = descR;
    }

    public String getHorairesR() {
        return horairesR;
    }

    public void setHorairesR(String horairesR) {
        this.horairesR = horairesR;
    }

    public Collection<TypesResto> getTypesRestoCollection() {
        return typesRestoCollection;
    }

    public void setTypesRestoCollection(Collection<TypesResto> typesRestoCollection) {
        this.typesRestoCollection = typesRestoCollection;
    }

    public Collection<Utilisateur> getUtilisateurCollection() {
        return utilisateurCollection;
    }

    public void setUtilisateurCollection(Collection<Utilisateur> utilisateurCollection) {
        this.utilisateurCollection = utilisateurCollection;
    }

    public Collection<Photo> getPhotoCollection() {
        return photoCollection;
    }

    public void setPhotoCollection(Collection<Photo> photoCollection) {
        this.photoCollection = photoCollection;
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
        hash += (idR != null ? idR.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resto)) {
            return false;
        }
        Resto other = (Resto) object;
        if ((this.idR == null && other.idR != null) || (this.idR != null && !this.idR.equals(other.idR))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projet2_resto_java.Resto[ idR=" + idR + " ]";
    }
    
}
