/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundo;

/**
 *
 * @author juandiegobernalpedroza
 */
public class Fachada {
    private final Sistema sistema = Sistema.INSTANCIA;
    private final Usuario usuario = Sistema.USUARIO;
    
    public Usuario getUsuario(){
        return usuario;
    }
    
    public Sistema getSistema(){
        return sistema;
    }
}
