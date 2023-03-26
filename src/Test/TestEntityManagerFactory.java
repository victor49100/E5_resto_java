/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;
import javax.persistence.Persistence;
/**
 *
 * @author Victor
 */
public class TestEntityManagerFactory {
    public static void main (String[] arg){
        Persistence.createEntityManagerFactory("Projet2_Resto_JavaPU");
    }
}
