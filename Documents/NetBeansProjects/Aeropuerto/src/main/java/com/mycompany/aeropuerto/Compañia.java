/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aeropuerto;

/**
 *
 * @author Ronan_Y_Julian
 */
public class Compañia {
    private String nombre;
    private Vuelo listaVuelos[] = new Vuelo [10];
    private int numVuelo = 0;

    public Compañia(String nombre) {
        this.nombre = nombre;
    }

    public Compañia(String nombre, Vuelo v[]) {
        this.nombre = nombre;
        listaVuelos = v;
        numVuelo = v.length;
    }
    
   /* public Compañia(String nombre, Vuelo[] listaVuelos) {
        this.nombre = nombre;
        this.listaVuelos = listaVuelos;
    }*/
    
    public void insertarVuelo (Vuelo v) {
        listaVuelos[numVuelo] = v ;
        numVuelo ++;
    }

    public String getNombre() {
        return nombre;
    }

    public void getListaVuelos() {
        for (Vuelo vuelos : listaVuelos) {
            if (vuelos != null) {
                System.out.println("---> " + vuelos.getIdentificador()+" | "+vuelos.getCiudadOrigen()+" | "+vuelos.getCiudadDestino()+" | "+vuelos.getPrecio()+"$ || ");
            } else {
                System.out.print("");
            }
        }
       
    }

    
    
    public int getNumVuelo() {
        return numVuelo;
    }
    
    public Vuelo getVuelo(int i) {
        return listaVuelos[i];
    }
    
    public Vuelo getVuelo(String id) {
        int i = 0;
        
        boolean encontrado=false;
        Vuelo v = null;
        
        while((encontrado == false)&& (i < listaVuelos.length)) {
            if(id == listaVuelos[i].getIdentificador()) {
                encontrado = true;
                v = listaVuelos[i];
                
            }
            i ++;
        }
        return v;
    }
    
}
