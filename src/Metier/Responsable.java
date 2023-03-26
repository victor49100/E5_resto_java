/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author acassard
 */
@Entity
@Table(name = "responsable")
@NamedQueries({
    @NamedQuery(name = "Responsable.findAll", query = "SELECT r FROM Responsable r"),
    @NamedQuery(name = "Responsable.findByMdp", query = "SELECT r FROM Responsable r WHERE r.mdpA = :mdpA"),    
    @NamedQuery(name = "Responsable.findByConnexion", query = "SELECT r FROM Responsable r WHERE r.mdpA = :mdpA and r.pseudoA = :pseudoA"),
})
@DiscriminatorValue("responsable")
public class Responsable extends Administrateur implements Serializable {
    
    public Responsable(Long idU, String mdpU, String pseudoU){
        super(idU, mdpU, pseudoU);
    }
        
    public Responsable() {
        
    }
}
