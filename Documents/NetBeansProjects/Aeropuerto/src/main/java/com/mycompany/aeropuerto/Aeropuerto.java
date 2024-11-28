/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
// Ronan_Y_Julian
package com.mycompany.aeropuerto;

public class Aeropuerto {
    private String nombre;
    private String ciudad;
    private String pais;
    private Compañia listaCompañias[]= new Compañia[10];
    private int numCompañia;

    public Aeropuerto(String nombre, String ciudad, String pais) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.numCompañia=0;
    }
    
    public Aeropuerto(String nombre, String ciudad, String pais, Compañia c[]) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        listaCompañias=c;
        this.numCompañia = c.length;
    }
     public void insertarCompañia(Compañia compañia){
         listaCompañias[numCompañia]=compañia;
         numCompañia++;
     }     

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void getListaCompañias() {
        for (Compañia compañia : listaCompañias) {
            if (compañia != null) {
                System.out.println("- " + compañia.getNombre());
            } else {
                System.out.print("");
            }
        }
    }
    

    public int getNumCompañia() {
        return numCompañia;
    }
    
    public Compañia getCompañia(int i){
        return listaCompañias[i];
    } 
    
    
public Compañia getCompañia(String nombre) {
        for (int i = 0; i < numCompañia; i++) {
            if (listaCompañias[i] != null && listaCompañias[i].getNombre().equals(nombre)) {
                return listaCompañias[i];
            }
        }
        return null; // Retorna null si no encuentra la compañía
    }
    }
   

