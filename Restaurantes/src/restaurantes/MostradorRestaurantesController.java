/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantes;

import Mundo.Restaurante;
import Mundo.Categoria;
import Mundo.Elemento;
import Mundo.Fachada;
import java.net.URL;
import Mundo.Sistema;
import javafx.fxml.FXML;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.application.Platform;
import javafx.scene.layout.StackPane;
import com.jfoenix.controls.JFXButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ScrollPane;
import com.jfoenix.controls.JFXMasonryPane;


public class MostradorRestaurantesController implements Initializable {

    private Fachada fachada;
    private FXMLLoader loader;
    private BorderPane cajitaRestaurante;
    private StackPane fondoPrincipal;
    private CajitaRestauranteController controllerCajitaRestaurante;

    @FXML
    private Label lblTitulo;
    @FXML
    private JFXButton botonCerrar;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private JFXMasonryPane juegos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fachada = new Fachada();
    }

    public void constructor(StackPane fondoPrincipal) {
        this.fondoPrincipal = fondoPrincipal;
        botonCerrar.setVisible(false);
        for (Elemento restaurante : fachada.getSistema().getRestaurantes()) {
            ponerCajita(restaurante);
        }
    }

    public void constructor(StackPane fondoPrincipal, Categoria categoria) {
        this.fondoPrincipal = fondoPrincipal;
        lblTitulo.setText(categoria.getNombre());
        botonCerrar.setVisible(true);
        for (Elemento restaurante : fachada.getSistema().getRestaurantes()) {
            if (categoria.equals(restaurante.getCategoria())) {
                ponerCajita(restaurante);
            }
        }
    }

    public void constructor(StackPane fondoPrincipal, boolean boton) {
        this.fondoPrincipal = fondoPrincipal;
        lblTitulo.setText("Tus Restaurantes Favoritos");
        botonCerrar.setVisible(boton);
        for (Elemento restaurante : fachada.getSistema().getRestaurantes()) {
            if (Sistema.USUARIO.getRestaurantesFavoritos().contains(restaurante.getNombre())) {
                ponerCajita(restaurante);
            }
        }
    }

    private void ponerCajita(Elemento restaurante) {
        try {
            //se carga cada cajita
            loader = new FXMLLoader();
            cajitaRestaurante = (BorderPane) loader.load(getClass().getResource("CajitaRestaurante.fxml").openStream());
            //se obtiene el controlador para pasar la informacion 
            controllerCajitaRestaurante = (CajitaRestauranteController) loader.getController();
            controllerCajitaRestaurante.constructor(restaurante, fondoPrincipal);
            //se agrega cada cajita al masonrypane
            juegos.getChildren().add(cajitaRestaurante);
            //para que el scrollpane no afecte al masonrypane
            Platform.runLater(() -> scrollPane.requestLayout());
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void accionCerrar(ActionEvent event) {
        fondoPrincipal.getChildren().remove(fondoPrincipal.getChildren().size() - 1);
    }

}
