/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.aeropuerto;

import java.util.Scanner;

/**
 *
 * @author Ronan_Y_Julian
 */
public class Main {

    static Scanner entrada = new Scanner(System.in);
    final static int num = 2; //numero aeropuertos
    static Aeropuerto aeropuertos[] = new Aeropuerto[num];

    public static void main(String[] args) {
        //instertar datos de los aeropuertos
        insertarDatosAeropuerto(aeropuertos);
        System.out.println("---------------------------------");
        System.out.println("-\tIniciando programa\t-");
        System.out.println("---------------------------------");
        menu();
    }

    public static void insertarDatosAeropuerto(Aeropuerto aero[]) {
        ////////////////////////////////////////////////////////////////////////////////
        //publico 
        aero[0] = new Aeropuerto_publico(80000000, "David Cardona", "Cali", "Colombia");
        aero[0].insertarCompañia(new Compañia("AeroCol"));
        aero[0].insertarCompañia(new Compañia("SurAMC"));

        aero[0].getCompañia("AeroCol").insertarVuelo(new Vuelo("FG56", "Cali", "Pasto", 89.900, 140));
        aero[0].getCompañia("AeroCol").insertarVuelo(new Vuelo("DF66", "Cali", "Miami", 450.000, 120));
        aero[0].getCompañia("SurAMC").insertarVuelo(new Vuelo("HJ99", "Cali", "Moscu", 540.000, 180));

        aero[0].getCompañia("AeroCol").getVuelo("FG56").insertarPasajero(new Pasajero("Carlos", "65HBLO", "Colombiano"));
        aero[0].getCompañia("AeroCol").getVuelo("FG56").insertarPasajero(new Pasajero("Camilo", "99KIOP", "Argentino"));
        aero[0].getCompañia("SurAMC").getVuelo("HJ99").insertarPasajero(new Pasajero("Lucas", "76MNTR", "Panameño"));
        /////////////////////////////////////////////////////////////////////////////////
        //privado
        aero[1] = new Aeropuerto_privado("Guaymaral", "Bogota", "Colombia");
        aero[1].insertarCompañia(new Compañia("AeroLatam"));
        String empresas[] = {"ColCafe", "Nestle"};
        ((Aeropuerto_privado) aero[1]).insertarEmpresas(empresas);

        aero[1].getCompañia("AeroLatam").insertarVuelo(new Vuelo("GJ87", "Bogota", "Miami", 700.000, 100));
        aero[1].getCompañia("AeroLatam").getVuelo("GJ87").insertarPasajero(new Pasajero("Alejandro Zapata", "85NDUA", "Aleman"));

    }

    public static void menu() {
        int opc, indiceAero, indiceCompa;
        String nombreAero, nombreCompa;
        do {
            System.out.println("\n\t :: MENU ::");
            System.out.println("1. Consultar los aeropuertos (publicos/privados)");
            System.out.println("2. Ver empresas(privado) o subvencion(publico)");
            System.out.println("3. listas de compañias por aeropuerto");
            System.out.println("4. Listas de vuelos por compañia");
            System.out.println("5. Listas posibles vuelos de origen a destino");
            System.out.println("6. Salir");

            System.out.print("\nElige una opcion = ");
            opc = entrada.nextInt();

            switch (opc) {
                case 1://Consultar los aeropuertos (publicos/privados)
                    System.out.println("\nMostrando Aeropuertos :");
                    System.out.println("--------------------------------");
                    mostrarAeropuertos();
                    break;
                case 2://Ver empresas(privado) o subvencion(publico)
                    entrada.nextLine();
                    System.out.print("\nCual es el nombre del aeropuerto = ");
                    nombreAero = entrada.nextLine();

                    indiceAero = buscarAereo(aeropuertos, nombreAero, num);
                    if (indiceAero == -1) {
                        System.out.println("\nNo se ha encontrado");
                    } else {

                        if (aeropuertos[indiceAero] instanceof Aeropuerto_privado) {
                            System.out.println("\nAeropuerto privado");
                            System.out.println("--------------------------------");
                            System.out.println("\t:: Empresas ::");
                            ((Aeropuerto_privado) aeropuertos[indiceAero]).getListaEmpresas();
                            System.out.println("--------------------------------");

                        } else {
                            System.out.println("\nAeropuerto publico");
                            System.out.println("--------------------------------");
                            ((Aeropuerto_publico) aeropuertos[indiceAero]).getSubvencion();
                            System.out.println("--------------------------------");
                        }
                    }

                    break;
                case 3://listas de compañias por aeropuerto
                    entrada.nextLine();
                    System.out.print("\nCual es el nombre del aeropuerto = ");
                    nombreAero = entrada.nextLine();

                    indiceAero = buscarAereo(aeropuertos, nombreAero, num);
                    if (indiceAero == -1) {
                        System.out.println("\nNo se ha encontrado");
                    } else {
                        System.out.println("--------------------------------");
                        System.out.println("\nLas compañias del aeropuerto son:");
                        System.out.println("\t:: Compañias ::");
                        aeropuertos[indiceAero].getListaCompañias();
                        System.out.println("--------------------------------");

                    }
                    break;
                case 4:// Listas de vuelos por compañia
                    entrada.nextLine();
                    System.out.print("\nCual es el nombre del aeropuerto = ");
                    nombreAero = entrada.nextLine();

                    indiceAero = buscarAereo(aeropuertos, nombreAero, num);
                    if (indiceAero == -1) {
                        System.out.println("\n No se ha encontrado");
                    } else {

                        System.out.print("Cual es el nombre de la compañia = ");
                        nombreCompa = entrada.nextLine();

                        Compañia compañia = aeropuertos[indiceAero].getCompañia(nombreCompa);
                        if (compañia == null) {
                            System.out.println("\nLa compañía no existe.");
                        } else {
                            System.out.println("\nMostrando resultados (id/origen/destino/precio)");
                            compañia.getListaVuelos();
                            System.out.println("");
                            System.out.println("--------------------------------");

                        }

                    }

                    break;
                case 5://Listas posibles vuelos de origen a destino
                    entrada.nextLine(); // Consumir el salto de línea
                    System.out.print("\nIngrese la ciudad de origen: ");
                    String origen = entrada.nextLine();
                    System.out.print("Ingrese la ciudad de destino: ");
                    String destino = entrada.nextLine();
                    System.out.println("\nVuelos encontrados:");
                    System.out.println("-----------------------------------------");
                    listarVuelosOrigenDestino(origen, destino, aeropuertos);
                    ;
                    break;
                case 6:
                    System.out.println("-----------------------------------------");
                    System.out.println("-\tSaliendo del programa\t\t-");
                    System.out.println("-----------------------------------------");
                    break;

                default:
                    System.out.println("Error, Opcion de menu incorrecto");

            }

            System.out.println("");

        } while (opc != 6);//se repite ciclo 
    }

    public static void mostrarAeropuertos() {
        for (int i = 0; i < num; i++) {

            System.out.println("Nombre: " + aeropuertos[i].getNombre());
            System.out.println("Ciudad: " + aeropuertos[i].getCiudad());
            System.out.println("País: " + aeropuertos[i].getPais());
            if (aeropuertos[i] instanceof Aeropuerto_privado) {
                System.out.println("Tipo: Privado");
            } else {
                System.out.println("Tipo: Público");
            }
            System.out.println("--------------------------------");
        }
    }

    public static int buscarAereo(Aeropuerto aero[], String nombreAero, int num) {
        int indice = 0;
        boolean encontrado = false;

        for (int i = 0; i < num; i++) {
            if (aero[i].getNombre().equals(nombreAero)) {
                encontrado = true;
                indice = i;
                break;
            }
        }
        if (encontrado == false) {
            indice = -1;
        }
        return indice;
    }

    public static void listarVuelosOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]) {
        boolean vuelosEncontrados = false; // Para verificar si se encuentran vuelos

        // Recorrer todos los aeropuertos
        for (Aeropuerto aeropuerto : aeropuertos) {
            // Recorrer todas las compañías de cada aeropuerto
            for (int i = 0; i < aeropuerto.getNumCompañia(); i++) {
                Compañia compañia = aeropuerto.getCompañia(i);

                // Recorrer todos los vuelos de cada compañía
                for (int j = 0; j < compañia.getNumVuelo(); j++) {
                    Vuelo vuelo = compañia.getVuelo(j);

                    // Si coinciden el origen y destino, mostrar el vuelo
                    if (vuelo.getCiudadOrigen().equalsIgnoreCase(origen) && vuelo.getCiudadDestino().equalsIgnoreCase(destino)) {

                        System.out.println("Compañía: " + compañia.getNombre());
                        System.out.println("ID Vuelo: " + vuelo.getIdentificador());
                        System.out.println("Precio: " + vuelo.getPrecio());
                        System.out.println("Capacidad: " + vuelo.getNumMaxPasajeros());
                        System.out.println("------------------------------------");
                        vuelosEncontrados = true; // Se encontró al menos un vuelo
                    }
                }
            }
        }

        if (!vuelosEncontrados) {
            System.out.println("No se encontraron vuelos con ese origen y destino.");
        }
    }
}
