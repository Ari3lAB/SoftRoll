/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Ariel AB
 */
public class Caja {
    
    float saldoInicial;
    float saldoActual;
    float saldoCierre;
    boolean cajaAbierta;

    public boolean isCajaAbierta() {
        return cajaAbierta;
    }

    public void setCajaAbierta(boolean cajaAbierta) {
        this.cajaAbierta = cajaAbierta;
    }
    

    public Caja(float saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Caja(float saldoInicial, boolean cajaAbierta) {
        this.saldoInicial = saldoInicial;
        this.cajaAbierta = cajaAbierta;
    }

    public Caja(float saldoInicial, float saldoActual, boolean cajaAbierta) {
        this.saldoInicial = saldoInicial;
        this.saldoActual = saldoActual;
        this.cajaAbierta = cajaAbierta;
    }

    public Caja(boolean cajaAbierta) {
        this.cajaAbierta = cajaAbierta;
    }

    public float getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(float saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public float getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(float saldoActual) {
        this.saldoActual = saldoActual;
    }

    public float getSaldoCierre() {
        return saldoCierre;
    }

    public void setSaldoCierre(float saldoCierre) {
        this.saldoCierre = saldoCierre;
    }

}
