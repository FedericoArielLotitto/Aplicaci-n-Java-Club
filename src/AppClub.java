// HACER EL MENU SOCIO ; Y TERMINAR CON METODOS DE TODAS LAS CLASES

import java.util.Iterator;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Agustin
 */
public class AppClub {

    public static Club javaClub = new Club("JavaClub");
    public static Restaurant rest1 = new Restaurant(javaClub);

    public static void main(String[] args) {
        //HARDCODE
        char respuesta ;
        Scanner entrada  = new Scanner(System.in);
        javaClub.agregarRestaurant(rest1);

        rest1.agregarMenu(new Menu("Milanesa con papas fritas", 198));
        //MENU PRINCIPAL
      do{  
        menuPrincipal();
          System.out.println("Desea volver al menu principal?");
          respuesta = entrada.next().charAt(0);
        }while(respuesta == 's' || respuesta == 'S');
    }

    public static void menuPrincipal() {
        int opcion = 0;
        int id = 0;
        char respuesta;
        String nombre = " ";
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println("---------------");

            System.out.println("|MENU DEL CLUB|");

            System.out.println("---------------");

            System.out.println("1-Registrarse");

            System.out.println("2-Log in");

            System.out.println("3-Log in autorizado");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    //REGISTRO AL SOCIO
                    System.out.println("Ingrese nombre");

                    nombre = entrada.next();

                    System.out.println("Ingrese id");

                    id = entrada.nextInt();

                    javaClub.registrarSocio(new Socio(nombre, id, javaClub));

                    break;
                case 2:
                    System.out.println("Ingrese numero de id: ");

                    id = entrada.nextInt();

                    if (javaClub.esSocio(id)) {

                        System.out.println("BIENVENIDO");

                        menuClub(javaClub.devolverSocio(id));
                        break;
                    } else {
                        System.out.println("No es un socio válido");
                    }
                    break;
                case 3:
                    String nombreAutorizada = "";

                    System.out.println("Ingrese id de socio que lo autorizo:");

                    id = entrada.nextInt();
                    if (javaClub.esSocio(id)) {
                        System.out.println("Ingrese nombre con el que se registro:");

                        nombreAutorizada = entrada.next();
                            
                        if (javaClub.verificarInvitado(nombreAutorizada)) {
                            menuInvitado(javaClub.devolverAutorizado(nombreAutorizada));
                            break;
                        } else {
                            System.out.println("Persona no registrada.");
                        }

                    }

                    break;
                default:
                    System.out.println("Opción errónea!");
                    break;

            }

            System.out.println("Quiere volver al menu  de ingreso? S/N");
            
            respuesta = entrada.next().charAt(0);

            System.out.println("----------------------------------");
        } while (respuesta == 's' || respuesta == 'S');
    }

    // MENU INVITADO 
    public static void menuInvitado(Autorizada autorizada) {
        Autorizada usuarioAutorizado = autorizada;
        int opcion2= 0 ;
        char respuesta2 ;
        Scanner entrada2 = new Scanner(System.in);                
        
        do {
            System.out.println("---------------");

            System.out.println("|MENU DEL AUTORIZADO|");

            System.out.println("---------------");

            System.out.println("1-Consumir");
            

            opcion2 = entrada2.nextInt();

            switch (opcion2) {
                case 1:
                   usuarioAutorizado.comprar(rest1);

                    break;
                default:
                  System.out.println("Opción errónea!");

                    break;

            }

            System.out.println("Quiere volver al menu anterior ? S/N");

            respuesta2 = entrada2.next().charAt(0);

            //TODO: BOOLEAN O NO BOOLEAN? 
        } while (respuesta2 == 's' || respuesta2 == 'S');

    }
    
    
    // MENU USUARIO

    public static void menuClub(Socio user) {
        int opcion = 0;
        int id = 0, posicion;
        Socio usuario = user;
        char respuesta;
        String nombre = " ";
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println("---------------");

            System.out.println("|MENU SOCIO|");

            System.out.println("---------------");
            // TODO: MOSTRAR DEUDAS

            System.out.println("1-Consumir");

            System.out.println("2-Autorizar amigo/a");

            System.out.println("3-Cancelar factura");

            

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    user.comprar(rest1);

                    break;
                case 2:
                    String autorizado = "";
                    System.out.println("Ingrese nombre de persona a autorizar");
                    autorizado = entrada.next();

                    usuario.registrarAutorizado(new Autorizada(autorizado, usuario));
                    break;
                case 3:
                    do {
                        javaClub.mostrarFacturas(usuario);
                        System.out.println("¿Cual factura desea pagar? Ingrese el numero de factura que figura");
                        posicion = entrada.nextInt();
                        usuario.cancelarFactura(posicion);
                        System.out.println("Desea pagar otra factura? S/N");
                        respuesta = entrada.next().charAt(0);

                    } while (respuesta == 's' || respuesta == 'S');
                    break;
                default:
                         System.out.println("Opción errónea!");

                    break;

            }

            System.out.println("Quiere volver al menu anterior ? S/N");

            respuesta = entrada.next().charAt(0);

        } while (respuesta == 's' || respuesta == 'S');

    }
}
