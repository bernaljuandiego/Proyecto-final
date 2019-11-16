/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundo;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Restaurante extends ElementoBuilder{
    
    public Restaurante() {
        super.elemento = new Elemento();
    }

    @Override
    public void imagen(Image imagen) {
        elemento.setImagen(imagen);
    }

    @Override
    public void nombre(String nombre) {
        elemento.setNombre("Restaurante "+nombre);
    }

    @Override
    public void descripcion(String descripcion) {
        elemento.setDescripcion(descripcion);
    }

    @Override
    public void calificacion(float calificacion) {
        elemento.setCalificacion(calificacion);
    }

    @Override
    public void categoria(Categoria categoria) {
        elemento.setCategoria(categoria);
    }
        
   
   
}