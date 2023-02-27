/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "critiquer")
@NamedQueries({
    @NamedQuery(name = "Critiquer.findAll", query = "SELECT c FROM Critiquer c"),
    @NamedQuery(name = "Critiquer.findByIdR", query = "SELECT c FROM Critiquer c WHERE c.critiquerPK.idR = :idR"),
    @NamedQuery(name = "Critiquer.findByNote", query = "SELECT c FROM Critiquer c WHERE c.note = :note"),
    @NamedQuery(name = "Critiquer.findByCommentaire", query = "SELECT c FROM Critiquer c WHERE c.commentaire = :commentaire"),
    @NamedQuery(name = "Critiquer.findByIdU", query = "SELECT c FROM Critiquer c WHERE c.critiquerPK.idU = :idU")})
public class Critiquer implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CritiquerPK critiquerPK;
    @Column(name = "note")
    private Integer note;
    @Column(name = "commentaire")
    private String commentaire;
    @JoinColumn(name = "idR", referencedColumnName = "idR", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Resto resto;
    @JoinColumn(name = "idU", referencedColumnName = "idU", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;

    public Critiquer() {
    }

    public Critiquer(CritiquerPK critiquerPK) {
        this.critiquerPK = critiquerPK;
    }

    public Critiquer(long idR, long idU) {
        this.critiquerPK = new CritiquerPK(idR, idU);
    }

    public CritiquerPK getCritiquerPK() {
        return critiquerPK;
    }

    public void setCritiquerPK(CritiquerPK critiquerPK) {
        this.critiquerPK = critiquerPK;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Resto getResto() {
        return resto;
    }

    public void setResto(Resto resto) {
        this.resto = resto;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (critiquerPK != null ? critiquerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Critiquer)) {
            return false;
        }
        Critiquer other = (Critiquer) object;
        if ((this.critiquerPK == null && other.critiquerPK != null) || (this.critiquerPK != null && !this.critiquerPK.equals(other.critiquerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projet2_resto_java.Critiquer[ critiquerPK=" + critiquerPK + " ]";
    }
    
}
