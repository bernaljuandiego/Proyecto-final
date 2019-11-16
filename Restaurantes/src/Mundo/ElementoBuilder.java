/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundo;

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author juandiegobernalpedroza
 */
public abstract class ElementoBuilder {

    protected Elemento elemento;
   
    public abstract void imagen(Image imagen);

    public abstract void nombre(String nombre);

    public abstract void descripcion(String descripcion);
    
    public abstract void calificacion(float calificacion);
    
    public abstract void categoria(Categoria categoria);
    
   public Elemento getElemento() {
        return elemento;
    }
}
