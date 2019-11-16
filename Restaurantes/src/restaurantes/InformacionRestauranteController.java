/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantes;

import Mundo.Elemento;
import Mundo.Restaurante;
import java.net.URL;
import javafx.fxml.FXML;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;



public class InformacionRestauranteController implements Initializable {

    private Elemento restaurante;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;
    @FXML
    private ImageView img5;
    @FXML
    private Label lblNombre;
    @FXML
    private ImageView imagen;
    @FXML
    private Label lblEstrellitas;
    @FXML
    private Label lblCategoria;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void darRestaurante(Elemento restaurante) {
        this.restaurante = restaurante;
        asignarCaracteristicas();
    }

    private String hacerEstrellitas() {
        String estrellitas = "";
        for (int i = 0; i <= 4; i++) {
            if (restaurante.getCalificacion() / i / 2 > 10) {
                estrellitas += "★";
            } else {
                estrellitas += "☆";
            }
        }
        return estrellitas+"  "+(int) restaurante.getCalificacion()+"%";
    }

    private void asignarCaracteristicas() {
        //asignar cada atributo del restaurante a un componente diseñado especificamente para este
        imagen.setImage(restaurante.getImagen());
        lblNombre.setText(restaurante.getNombre());
        lblCategoria.setText(restaurante.getCategoria().getNombre());
        lblEstrellitas.setText(hacerEstrellitas());
        try{
        img1.setImage(restaurante.getImagenesAdicionales().get(0));
        img2.setImage(restaurante.getImagenesAdicionales().get(1));
        img3.setImage(restaurante.getImagenesAdicionales().get(2));
        img4.setImage(restaurante.getImagenesAdicionales().get(3));
        img5.setImage(restaurante.getImagenesAdicionales().get(4));
        } catch(Exception ex){}   
    }
}