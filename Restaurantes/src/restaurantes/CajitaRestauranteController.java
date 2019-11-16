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
import javafx.scene.Parent;
import java.io.IOException;
import javafx.util.Duration;
import javafx.fxml.FXMLLoader;
import java.util.logging.Level;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.scene.layout.HBox;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.animation.FadeTransition;


public class CajitaRestauranteController implements Initializable {

    private Elemento restaurante;
    private HBox cajitaRestaurante;
    private FXMLLoader loader;
    private StackPane fondoPrincipal;
    private AnchorPane ventanaRestaurante;
    private InformacionRestauranteController controller;
    private VentanaRestauranteController controllerVentana;

    @FXML
    private Label lblTitulo;
    @FXML
    private BorderPane fondo;

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
    }

    private void asignarCaracteristicas() {
        //cambia las configuraciones de la cajita para dar la apariencia deseada
        ImageView imageView = new ImageView(restaurante.getImagen());
        imageView.setFitWidth(110);
        imageView.setFitHeight(110);
        imageView.setStyle("-fx-background-radius: 5;");
        fondo.setCenter(imageView);
        lblTitulo.setText(restaurante.getNombre());
    }

    @FXML
    private void entraMouse(MouseEvent event) throws IOException {
        //cambia el color del fondo de la cajita seleccionada por el mouse
        fondo.setStyle("-fx-background-color: #7D0F18; -fx-background-radius: 5;");
        //se carga el fxml de la cajita de informacion
        loader = new FXMLLoader();
        cajitaRestaurante = (HBox) loader.load(getClass().getResource("InformacionRestaurante.fxml").openStream());
        //se obtiene el controlador de esa cajita para poder hacerle modificaciones
        controller = (InformacionRestauranteController) loader.getController();
        controller.darRestaurante(restaurante);
        //se agrega la cajita de informacion del juego al stackPane principal y se calculan las posciciones
        fondoPrincipal.getChildren().add(cajitaRestaurante);
        //se coloca un efecto de entrada
        colocarEfecto(0, 0.95, cajitaRestaurante);
        //se calculan las coordenadas de la cajita
        cajitaRestaurante.setTranslateX(event.getSceneX() - fondoPrincipal.getWidth() / 2 + fondo.getWidth() / 2);
        cajitaRestaurante.setTranslateY(event.getSceneY() - fondoPrincipal.getHeight() / 2 + fondo.getHeight() / 2);
    }

    @FXML
    private void saleMouse(MouseEvent event) {
        //se vuelve a colocar el color por defecto de la cajita al salir el mouse
        fondo.setStyle("-fx-background-color: #C0C0C0; -fx-background-radius: 10;");
        //quita la cajita flotante de informacion
        fondoPrincipal.getChildren().remove(cajitaRestaurante);
    }


    private void colocarEfecto(double inicio, double fin, Parent parent) {
        FadeTransition transition1 = new FadeTransition(Duration.seconds(0.8), parent);
        transition1.setFromValue(inicio);
        transition1.setToValue(fin);
        transition1.setCycleCount(1);
        transition1.play();
    }

    @FXML
    private void clickRestaurante(MouseEvent event) {
        fondoPrincipal.getChildren().remove(cajitaRestaurante);
        try {
            //se carga el fxml de la cajita de informacion
            loader = new FXMLLoader();
            ventanaRestaurante = (AnchorPane) loader.load(getClass().getResource("VentanaRestaurante.fxml").openStream());
            //se obtiene el controlador de esa cajita para poder hacerle modificaciones
            controllerVentana = (VentanaRestauranteController) loader.getController();
            controllerVentana.constructor(restaurante, fondoPrincipal);
            //se agrega la cajita de informacion del juego al stackPane principal y se calculan las posciciones
            fondoPrincipal.getChildren().add(ventanaRestaurante);
            //se agrega un efecto de entrada de la informacion 
            colocarEfecto(0, 1, ventanaRestaurante);
        } catch (IOException ex) {
            Logger.getLogger(CajitaRestauranteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
