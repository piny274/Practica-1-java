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
public class ProgCuentaBancaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ingresarOpcion();
    }

    public static void ingresarOpcion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una opción: A) Consignar B) Retirar S) Salir ");
        String opcion = scanner.next();
        Cuenta miPrimerUsuario = new Cuenta("", 0);
        while (!opcion.equals("S")) {

            if (opcion.equals("A")) {

                System.out.print("Ingrese nombre titular: ");
                String nombre = scanner.next();
                System.out.print("Ingrese cantidad a Consignar: ");
                double cantidad = scanner.nextDouble();
                double saldoFavor = miPrimerUsuario.ingresar(cantidad);

            }

            if (opcion.equals("B")) {

                System.out.print("Ingrese nombre titular: ");
                String nombre = scanner.next();
                System.out.print("Ingrese cantidad a retirar: ");
                double cantidad = scanner.nextDouble();
                double saldoFavor = miPrimerUsuario.retirar(cantidad);

            }

            System.out.println("Ingrese una opción: A) Consignar B) Retirar S) Salir");
            opcion = scanner.next();
            if (opcion.equals("F")) {
                opcion = "S";
            }
        }
    }

}
