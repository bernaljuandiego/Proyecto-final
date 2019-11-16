/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantes;

import Mundo.Elemento;
import Mundo.Fachada;
import Mundo.Restaurante;
import java.net.URL;
import Mundo.Sistema;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.util.Duration;
import javafx.fxml.FXMLLoader;
import java.util.logging.Level;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.animation.FadeTransition;
import com.jfoenix.controls.JFXTextField;


public class VentanaPrincipalController implements Initializable {

    private Fachada fachada;
    private FXMLLoader loader;
    private AnchorPane ventanaRestaurante;
    private BorderPane mostradorRestaurantes;
    private AnchorPane mostradorCategorias;
    private VentanaRestauranteController controllerVentana;
    private MostradorCategoriasController controllerCategorias;
    private MostradorRestaurantesController controllerMostradorController;

    @FXML
    private StackPane stack;
    @FXML
    private JFXTextField buscador;
    @FXML
    private ImageView botonComprado;
    @FXML
    private ImageView botonDestacados;
    @FXML
    private ImageView botonCategorias;
    @FXML
    private JFXTextField nombreTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //punto de entrada al sistema de los restaurantes
        fachada = new Fachada();
        //se coloca el panel de destacados como punto de entrada al programa
        colocarPanelDestacados();
    }

    private void colocarPanelDestacados() {
        botonDestacados.setImage(new Image("/botones/destacado1.png"));
        botonComprado.setImage(new Image("/botones/comprado.png"));
        botonCategorias.setImage(new Image("/botones/categorias.png"));
        try {
            //se limpia el stack Pane principal
            stack.getChildren().clear();
            //se carga la ventana 
            loader = new FXMLLoader();
            mostradorRestaurantes = (BorderPane) loader.load(getClass().getResource("MostradorRestaurantes.fxml").openStream());
            //se obtiene el controlador para modificar ese panel
            controllerMostradorController = (MostradorRestaurantesController) loader.getController();
            controllerMostradorController.constructor(stack);
            colocarEfecto(0, 1, mostradorRestaurantes);
            //se agrega junto con los demas componentes al stack principal
            stack.getChildren().add(mostradorRestaurantes);
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickDestacados(MouseEvent event) {
        colocarPanelDestacados();
    }

    @FXML
    private void clickCategorias(MouseEvent event) {
        botonDestacados.setImage(new Image("/botones/destacado.png"));
        botonComprado.setImage(new Image("/botones/comprado.png"));
        botonCategorias.setImage(new Image("/botones/categorias1.png"));
        try {
            //se limpia el stack Pane principal
            stack.getChildren().clear();
            //se carga la ventana que muestra
            loader = new FXMLLoader();
            mostradorCategorias = (AnchorPane) loader.load(getClass().getResource("MostradorCategorias.fxml").openStream());
            //se obtiene el controlador para modificar ese panel
            controllerCategorias = (MostradorCategoriasController) loader.getController();
            controllerCategorias.constructor(stack);
            colocarEfecto(0, 1, mostradorCategorias);
            //se agrega junto con los demas componentes al stack principal
            stack.getChildren().add(mostradorCategorias);
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickComprado(MouseEvent event) {
        botonDestacados.setImage(new Image("/botones/destacado.png"));
        botonComprado.setImage(new Image("/botones/comprado1.png"));
        botonCategorias.setImage(new Image("/botones/categorias.png"));
        try {
            //se limpia el stack Pane principal
            stack.getChildren().clear();
            //se carga la ventana que muestra
            loader = new FXMLLoader();
            mostradorRestaurantes = (BorderPane) loader.load(getClass().getResource("MostradorRestaurantes.fxml").openStream());
            //se obtiene el controlador para modificar ese panel
            controllerMostradorController = (MostradorRestaurantesController) loader.getController();
            controllerMostradorController.constructor(stack, false);
            colocarEfecto(0, 1, mostradorRestaurantes);
            //se agrega junto con los demas componentes al stack principal
            stack.getChildren().add(mostradorRestaurantes);
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void colocarEfecto(double inicio, double fin, Parent parent) {
        FadeTransition transition1 = new FadeTransition(Duration.seconds(0.8), parent);
        transition1.setFromValue(inicio);
        transition1.setToValue(fin);
        transition1.setCycleCount(1);
        transition1.play();
    }

    @FXML
    private void buscarRestaurante(ActionEvent event) {
        boolean encontro = false;
        for (Elemento restaurante : fachada.getSistema().getRestaurantes()) {
            if (restaurante.getNombre().equals(buscador.getText())) {
                encontro = true;
                buscador.setText("");
                try {
                    //se carga el fxml de la cajita de informacion
                    loader = new FXMLLoader();
                    ventanaRestaurante = (AnchorPane) loader.load(getClass().getResource("VentanaRestaurante.fxml").openStream());
                    //se obtiene el controlador de esa cajita para poder hacerle modificaciones
                    controllerVentana = (VentanaRestauranteController) loader.getController();
                    controllerVentana.constructor(restaurante, stack);
                    //se agrega la cajita de informacion del juego al stackPane principal y se calculan las posciciones
                    stack.getChildren().add(ventanaRestaurante);
                    colocarEfecto(0, 1, ventanaRestaurante);
                } catch (IOException ex) {
                    Logger.getLogger(CajitaRestauranteController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (!encontro) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Lo Sentimos!");
            alert.setHeaderText("No se ha encontrado ningun restaurante!");
            alert.setContentText("Al parecer no tenemos un restaurante con ese nombre.");
            alert.showAndWait();
            buscador.setText("");
        }
    }

    @FXML
    private void actualizarNombre(ActionEvent event) {
        fachada.getSistema().USUARIO.setNombre(nombreTxt.getText());
    }
}
