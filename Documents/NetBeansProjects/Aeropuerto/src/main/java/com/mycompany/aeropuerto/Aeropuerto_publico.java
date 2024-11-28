/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Ronan_Y_Julian
package com.mycompany.aeropuerto;

public class Aeropuerto_publico extends Aeropuerto {
    private int tipo = 0;
    private double subvencion;

    public Aeropuerto_publico(String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
    }

    public Aeropuerto_publico(double subvencion, String nombre, String ciudad, String pais, Compañia[] c) {
        super(nombre, ciudad, pais, c);
        this.subvencion = subvencion;
    }

    public Aeropuerto_publico(double subvencion, String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
        this.subvencion = subvencion;
    }

    public void getSubvencion() {
        System.out.println("la subvencion es = "+ subvencion + "$");
    }

    public int getTipo() {
        return tipo;
    }
    
    

   
 }
    
    
    

