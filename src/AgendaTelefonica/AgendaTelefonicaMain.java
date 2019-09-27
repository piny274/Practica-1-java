/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgendaTelefonica;

import java.util.Scanner;

/**
 *
 * @author s109e12
 */
public class AgendaTelefonicaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ingresarDatos();

    }
    static Contacto[] VectorAgenda = new Contacto[15];
    /**
     * Variable "contador" de tipo entero
     * Función: encargada de asignar la posición en el vector
     */
    static int contador = 0;
    /**
     * Variable "puntoReferencia" de tipo entero
     * Función: Varia su valor entre 0 y 1 si entra por algun tipo de arreglo.
     */
    static int puntoReferencia = 0;

    public static void ingresarDatos() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una opción: A) Agregar contacto B) Buscar contacto C) Listar agenda D) Estado de Agenda E) Espacio libre S) Salir ");
        String opcion = scanner.next();
        
        while (!opcion.equals("S")) {

            if (opcion.equals("A")) {

                if (contador < 15) {

                    Scanner ingrDatosContactos = new Scanner(System.in);
                    System.out.print("Ingrese nombre: ");
                    String ingNombre = ingrDatosContactos.next();
                    System.out.print("Ingrese Telefono: ");
                    String ingTelefono = ingrDatosContactos.next();
                    System.out.print("Ingrese Correo: ");
                    String ingCorreo = ingrDatosContactos.next();
                    
                    //El primer contacto no necesita ser comparado. 
                    if (contador == 0) {
                        VectorAgenda[contador] = new Contacto(ingNombre, ingTelefono, ingCorreo);
                        contador = contador + 1;
                       
                    } else {
                        
                        //Se recorre el vector para comparar si ya exite un contacto igual.
                        for (int i = 0; i < contador; i++) {
                            String nombreComparar = VectorAgenda[i].getNombre();

                            if (ingNombre.equals(nombreComparar)) {

                                System.out.println("El Contacto ya Existe");
                                VectorAgenda[contador] = null;
                                puntoReferencia = 1;
                                break;
                            }
                        }
                        //Si se recorre el vector y el contacto a ingresar no existe se alamcena.
                        if (puntoReferencia != 1) {
                            VectorAgenda[contador] = new Contacto(ingNombre, ingTelefono, ingCorreo);
                            contador = contador + 1;
                            puntoReferencia = 0;
                        }
                    }

                    puntoReferencia = 0;
                } else {
                    System.out.println("No se pueden guardar mas contactos -> AGENDA LLENA");
                }
            }
            //OPCION B) Buscar Contacto
            if (opcion.equals("B")) {

                buscarContacto();

            }

            //OPCION C) Listar agenda
            if (opcion.equals("C")) {

                listarContactos();

            }
            
            //OPCION D) Ver si la agenda esta llena.
            if (opcion.equals("D")) {

                agendaLlena();

            }
            
            //OPCION E) Ver espacios libres de la agenda.
            if (opcion.equals("E")) {

                espacioLibre();

            }

            System.out.println("La opción seleccionada es " + opcion);

            System.out.println("Ingrese una opción: A) Agregar contacto B) Buscar contacto C) Listar agenda D) Estado de Agenda E) Espacio libre S) Salir ");
            opcion = scanner.next();
            if (opcion.equals("F")) {
                opcion = "S";
            }
        }

    }
    
    /**
     * Metodo para Buscar Contacto
     */
    public static void buscarContacto() {

        Scanner ingrDatoNombre = new Scanner(System.in);
        System.out.print("Ingrese el nombre a buscar: ");
        String ingNombre = ingrDatoNombre.next();

        for (int i = 0; i < contador; i++) {
            String nombreComparar = VectorAgenda[i].getNombre();

            if (ingNombre.equals(nombreComparar)) {
                String telefonoEncontrado = VectorAgenda[i].getTelefono();
                String correoEncontrado = VectorAgenda[i].getCorreo();
                System.out.println("El contacto " + nombreComparar + " fue encontrado y tiene los siguientes datos: ");
                System.out.println("Telefono: " + telefonoEncontrado);
                System.out.println("Correo: " + correoEncontrado);
                puntoReferencia = 1;
                break;
            }
        }
        if (puntoReferencia != 1) {
            System.out.println("El contacto " + ingNombre + " no se encuentra en la agenda");
            puntoReferencia = 0;
        }
        puntoReferencia = 0;
    }

    public static void listarContactos() {
        if (contador != 0) {
            for (int i = 0; i < contador; i++) {
                String nombreListar = VectorAgenda[i].getNombre();
                System.out.println("Contacto " + i + ") " + nombreListar);
            }
        } else {
            System.out.println("No hay contactos para mostrar");
        }

    }
    
    /**
     * Metodo para ver el estado de la agenda
     */
    public static void agendaLlena() {

        if (contador == 15) {
            System.out.println("AGENDA LLENA!!!");
        } else {
            System.out.println("Aun queda espacio en la Agenda");
        }
    }
    
    /**
     * Metodo para ver cuantos espacios hay libres.
     */
    public static void espacioLibre(){
    
        int resultadoEspacio= 15 - contador;
        System.out.println("HAY " + resultadoEspacio + " ESPACIO(S) LIBRE(S)");
    }

}
