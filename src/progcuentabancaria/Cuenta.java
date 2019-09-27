/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progcuentabancaria;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Cuenta {

    private String nombreTitular;
    private double saldo;

    public Cuenta(String nombreTitular) {

        this.nombreTitular = nombreTitular;
    }

    public Cuenta(String nombreTitular, double saldo) {

        this.nombreTitular = nombreTitular;
        this.saldo = saldo;
    }
    /**
     * 
     * @param cantidad es de tipo double es ingresada por consola
     * @return se retorna saldo
     */
    public double ingresar(double cantidad) {

        if (cantidad > 0) {

            this.saldo = this.saldo + cantidad;
            System.out.println("Saldo es: " + this.saldo);
            return saldo;
        }
        System.out.println("No es posible Consignar un valor NEGATIVO");
        System.out.println("Saldo es: " + this.saldo);
        return this.saldo;
    }
    
    /**
     * 
     * @param cantidad es de tipo double es ingresada por consola
     * @return se retorna saldo
     */
    public double retirar(double cantidad) {
        if (cantidad > 0) {
            if (cantidad < saldo) {
                this.saldo = this.saldo - cantidad;
                System.out.println("");
                System.out.println("Su nuevo Saldo es: " + this.saldo);
                System.out.println("");
                return saldo;
            }
            System.out.println("");
            System.out.println("-----> Saldo insuficiente!!!! <-----");
            System.out.println("");
            return this.saldo;
        }
        System.out.println("");
        System.out.println("----> No es posible Retirar un valor NEGATIVO <----");
        System.out.println("----> Debe ingresar un valor Positivo <----");
        System.out.println("");
        System.out.println("Saldo es: " + this.saldo);
        System.out.println("");
        return this.saldo;
    }

}
