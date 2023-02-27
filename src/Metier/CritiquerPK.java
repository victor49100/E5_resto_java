/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author afiolleau@jolsio.net
 */
@Embeddable
public class CritiquerPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idR")
    private long idR;
    @Basic(optional = false)
    @Column(name = "idU")
    private long idU;

    public CritiquerPK() {
    }

    public CritiquerPK(long idR, long idU) {
        this.idR = idR;
        this.idU = idU;
    }

    public long getIdR() {
        return idR;
    }

    public void setIdR(long idR) {
        this.idR = idR;
    }

    public long getIdU() {
        return idU;
    }

    public void setIdU(long idU) {
        this.idU = idU;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idR;
        hash += (int) idU;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CritiquerPK)) {
            return false;
        }
        CritiquerPK other = (CritiquerPK) object;
        if (this.idR != other.idR) {
            return false;
        }
        if (this.idU != other.idU) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projet2_resto_java.CritiquerPK[ idR=" + idR + ", idU=" + idU + " ]";
    }
    
}
