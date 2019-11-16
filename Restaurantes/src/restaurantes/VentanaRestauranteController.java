/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantes;

import Mundo.Restaurante;
import java.net.URL;
import Mundo.Sistema;
import Mundo.Comentario;
import Mundo.Elemento;
import javafx.fxml.FXML;
import java.io.IOException;
import java.util.ArrayList;
import javafx.util.Duration;
import javafx.fxml.FXMLLoader;
import java.util.logging.Level;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.AnchorPane;
import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;


public class VentanaRestauranteController implements Initializable, IObservador {

    private Elemento restaurante;
    private FXMLLoader loader;
    private StackPane cajaComentario;
    private StackPane fondoPrincipal;
    private AnchorPane comentarioIndividual;
    private ArrayList<Comentario> comentarios;
    private CajaComentarioController controllerComentario;
    private ComentarioController controllerComentarioIndividual;

    @FXML
    private Label tituloRestaurante;
    @FXML
    private JFXTextArea descripcion;
    @FXML
    private JFXButton botonAnadirFavorito;
    @FXML
    private Label categoria;
    @FXML
    private Label calificacion;
    @FXML
    private ImageView imgRestaurante;
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
    private AnchorPane fondo;
    @FXML
    private VBox comentariosTorre;
    @FXML
    private JFXButton botonComentar;
    @FXML
    private JFXTextField calificacionText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void constructor(Elemento restaurante, StackPane fondoPrincipal) {
        this.restaurante = restaurante;
        this.fondoPrincipal = fondoPrincipal;
        asignarCaracteristicas();
        actualizar();
    }

    @FXML
    private void botonAtras(ActionEvent event) {
        FadeTransition transition = new FadeTransition(Duration.seconds(1), fondo);
        transition.setFromValue(1);
        transition.setToValue(0);
        transition.setCycleCount(1);
        transition.play();
        transition.setOnFinished((event1) -> {
            fondoPrincipal.getChildren().remove(fondoPrincipal.getChildren().size() - 1);
        });
    }

    @FXML
    private void anadirFavorito(ActionEvent event) {
        if(botonAnadirFavorito.getText().equals("Remover de Favoritos")){
            botonAnadirFavorito.setText("Añadir a Favoritos");
            Sistema.USUARIO.getRestaurantesFavoritos().remove(restaurante.getNombre());
        } else {
            botonAnadirFavorito.setText("Remover de Favoritos");
            Sistema.USUARIO.getRestaurantesFavoritos().add(restaurante.getNombre());
        }  
        actualizar();
    }

    @FXML
    private void comentarRestaurante(ActionEvent event) {
        try {
            //se carga la ventana que muestra
            loader = new FXMLLoader();
            cajaComentario = (StackPane) loader.load(getClass().getResource("CajaComentario.fxml").openStream());
            //se obtiene el controlador para modificar ese panel
            controllerComentario = (CajaComentarioController) loader.getController();
            controllerComentario.constructor(fondoPrincipal, restaurante);
            controllerComentario.registrarObservador(this);

            //se agrega junto con los demas componentes al stack principal
            fondoPrincipal.getChildren().add(cajaComentario);
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void actualizarCalificacion(ActionEvent event) {
        try {
            if (Integer.parseInt(calificacionText.getText()) >= 0 && Integer.parseInt(calificacionText.getText()) <= 100) {
                restaurante.setCalificacionUsuario(Integer.parseInt(calificacionText.getText()));
                actualizar();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Atencion!");
                alert.setHeaderText("Formato de calificacion Incorrecto!");
                alert.setContentText("Debe ingresar un valor entre 0 y 100.");
                alert.showAndWait();
                calificacionText.setText(Integer.toString(restaurante.getCalificacionUsuario()));
            }
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Atencion!");
            alert.setHeaderText("Formato de calificacion Incorrecto!");
            alert.setContentText("Solo se admiten valores enteros.");
            alert.showAndWait();
            calificacionText.setText(Integer.toString(restaurante.getCalificacionUsuario()));
        }
    }
    
    @Override
    public void actualizar() {
        if (Sistema.USUARIO.getRestaurantesFavoritos().contains(restaurante.getNombre())) {
            botonAnadirFavorito.setText("Remover de Favoritos");
            botonComentar.setDisable(false);
        }
        calificacionText.setDisable(false);
        calificacionText.setText(Integer.toString(restaurante.getCalificacionUsuario()));
        comentarios = restaurante.getComentarios();
        comentariosTorre.getChildren().clear();
        for (Comentario comentario : comentarios) {
            try {
                //se carga la ventana que muestra 
                loader = new FXMLLoader();
                comentarioIndividual = (AnchorPane) loader.load(getClass().getResource("Comentario.fxml").openStream());
                //se obtiene el controlador para modificar ese panel
                controllerComentarioIndividual = (ComentarioController) loader.getController();
                controllerComentarioIndividual.constructor(comentario);

                //se agrega junto con los demas componentes al stack principal
                comentariosTorre.getChildren().add(comentarioIndividual);
            } catch (IOException ex) {
                Logger.getLogger(VentanaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void asignarCaracteristicas() {
        imgRestaurante.setImage(restaurante.getImagen());
        tituloRestaurante.setText(restaurante.getNombre());
        calificacion.setText(hacerEstrellitas());
        descripcion.setText(restaurante.getDescripcion());
        categoria.setText(restaurante.getCategoria().getNombre());
        try {
            img1.setImage(restaurante.getImagenesAdicionales().get(0));
            img2.setImage(restaurante.getImagenesAdicionales().get(1));
            img3.setImage(restaurante.getImagenesAdicionales().get(2));
            img4.setImage(restaurante.getImagenesAdicionales().get(3));
            img5.setImage(restaurante.getImagenesAdicionales().get(4));
        } catch (Exception ex) {
        }
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
        return estrellitas + "  " + (int) restaurante.getCalificacion() + "%";
    }
}