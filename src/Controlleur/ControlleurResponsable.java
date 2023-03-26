/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlleur;

import Vue.VueResponsable;

/**
 *
 * @author acassard
 */
public class ControlleurResponsable {
    
    private VueResponsable vue;
    private ControlleurPrincipal ctrlP;
    
    public ControlleurResponsable(VueResponsable vue, ControlleurPrincipal ctrlP){
        this.ctrlP = ctrlP;
        this.vue = vue;
    }

    public VueResponsable getVue() {
        return vue;
    }

    public void setVue(VueResponsable vue) {
        this.vue = vue;
    }

    public ControlleurPrincipal getCtrlP() {
        return ctrlP;
    }

    public void setCtrlP(ControlleurPrincipal ctrlP) {
        this.ctrlP = ctrlP;
    }
    
}
