/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundo;

import javafx.scene.image.Image;

/**
 *
 * @author juandiegobernalpedroza
 */
public class ElementoDirector {
    private ElementoBuilder builder;
	
	public void setElementoBuilder(ElementoBuilder elementoBuilder) {
		builder = elementoBuilder;
	}
	
	public Elemento getElemento() {
		return builder.getElemento();
	}
	
	public void construirElemento(Image imagen, String nombre, String descripcion, float calificacion, Categoria categoria) {
		builder.imagen(imagen);
                builder.nombre(nombre);
                builder.descripcion(descripcion);
                builder.calificacion(calificacion);
                builder.categoria(categoria);
	}
    
}
