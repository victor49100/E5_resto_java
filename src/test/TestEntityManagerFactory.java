/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import javax.persistence.Persistence;
/**
 *
 * @author acassard
 */
public class TestEntityManagerFactory {
    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("Projet2_Resto_JavaPU");
    }   
}
