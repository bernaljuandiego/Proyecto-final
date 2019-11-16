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
public class Elemento {
     protected Image imagen;
    protected String nombre;
    protected String descripcion;
    protected float calificacion;
    protected Categoria categoria;
    protected int calificacionUsuario;
    protected ArrayList<Comentario> comentarios;
    protected ArrayList<Image> imagenesAdicionales;
    
     public Elemento() {
        comentarios = new ArrayList<>();
        imagenesAdicionales = new ArrayList<>();
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }   

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Image> getImagenesAdicionales() {
        return imagenesAdicionales;
    }

    public void setImagenesAdicionales(ArrayList<Image> imagenesAdicionales) {
        this.imagenesAdicionales = imagenesAdicionales;
    }

    public int getCalificacionUsuario() {
        return calificacionUsuario;
    }

    public void setCalificacionUsuario(int calificacionUsuario) {
        this.calificacionUsuario = calificacionUsuario;
    }
}
