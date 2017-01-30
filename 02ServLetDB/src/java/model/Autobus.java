/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Clase Autobus que es la entidad de la tabla autobus de la base de datos
 * PLAIN OLD JAVA OBJECT (POJO)
 * @author di.ruizdechavez
 */
public class Autobus {
    private int num_autobus;
    private String siglas;
    private int modelo;
    private int capacidad;
    private String base;

    @Override
    public String toString() {
        return "Autobus{" + "num_autobus=" + num_autobus + ", siglas=" + siglas + ", modelo=" + modelo + ", capacidad=" + capacidad + ", base=" + base + "} \n";
    }
    
    public int getNum_autobus() {
        return num_autobus;
    }

    public void setNum_autobus(int num_autobus) {
        this.num_autobus = num_autobus;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
    
    
}
