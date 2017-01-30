/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entidades.Estado;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetoAccesoDatos.OAD;

/**
 *
 * @author di.ruizdechavez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OAD oad = new OAD();
        Estado estado;
        estado = (Estado) oad.leer("SELECT idEstado, nombre, municipios, capital, comidaTipica, poblacion FROM estados WHERE idEstado = 2");
        System.out.println(estado);
    }
    
}
