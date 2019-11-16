/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundo;

import java.util.ArrayList;


public class Usuario {
    private String nombre;
    private ArrayList<String> RestaurantesFavoritos;

    public Usuario(String nombre) {
        this.nombre = nombre;
        RestaurantesFavoritos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getRestaurantesFavoritos() {
        return RestaurantesFavoritos;
    }

    public void setRestaurantesFavoritos(ArrayList<String> RestaurantesFavoritos) {
        this.RestaurantesFavoritos = RestaurantesFavoritos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
