/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Ronan_Y_Julian
package com.mycompany.aeropuerto;

public class Aeropuerto_privado extends Aeropuerto{
    private int tipo = 1;
    
    private String listaEmpresas[] = new String[10];
    private  int numEmpresa;

    public Aeropuerto_privado(String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
    }

    public Aeropuerto_privado(String nombre, String ciudad, String pais, Compañia[] c, String e[]) {
        super(nombre, ciudad, pais, c);
        
        this.listaEmpresas = e;
        numEmpresa = e.length;
    }
    public void insertarEmpresas(String e[]){
        this.listaEmpresas = e;
        this.numEmpresa = e.length;
    }
    
    public void insertarEmpresa (String e){
        this.listaEmpresas [numEmpresa] = e;
        numEmpresa++;
    }

    public void getListaEmpresas() {
        for (String empresa : listaEmpresas) {
        System.out.println("- " + empresa);
    }
    }

    public int getNumEmpresa() {
        return numEmpresa;
    }

    public int getTipo() {
        return tipo;
    }
    
    
}
