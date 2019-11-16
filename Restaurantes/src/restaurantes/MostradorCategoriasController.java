/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantes;

import java.net.URL;
import Mundo.Categoria;
import Mundo.Fachada;
import Mundo.Sistema;
import javafx.fxml.FXML;
import java.io.IOException;
import javafx.util.Duration;
import javafx.fxml.FXMLLoader;
import java.util.logging.Level;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import com.jfoenix.controls.JFXListView;
import javafx.collections.ObservableList;

public class MostradorCategoriasController implements Initializable {

    private Fachada fachada;
    private FXMLLoader loader;
    private StackPane fondoPrincipal;
    private BorderPane mostradorRestaurantes;
    private ObservableList<Categoria> categoriasObservable;
    private MostradorRestaurantesController controllerMostradorRestaurantes;
    
    @FXML
    private JFXListView<Categoria> listaCategorias;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fachada = new Fachada();
        categoriasObservable = FXCollections.observableArrayList(fachada.getSistema().getCategorias());
        listaCategorias.setItems(categoriasObservable);
    }    
    
    public void constructor(StackPane stack) {
        this.fondoPrincipal = stack;
    }

    @FXML
    private void clickCategorias(MouseEvent event) {
       try {
            //se carga la ventana que muestra los restaurantes
            loader = new FXMLLoader();
            mostradorRestaurantes = (BorderPane) loader.load(getClass().getResource("MostradorRestaurantes.fxml").openStream());
            //se obtiene el controlador para modificar ese panel
            controllerMostradorRestaurantes = (MostradorRestaurantesController) loader.getController();
            controllerMostradorRestaurantes.constructor(fondoPrincipal, listaCategorias.getSelectionModel().getSelectedItem());
            //se coloca un efecto de entrada para la ventana de clasificacion
            FadeTransition transition1 = new FadeTransition(Duration.seconds(0.8), mostradorRestaurantes);
            transition1.setFromValue(0);
            transition1.setToValue(1);
            transition1.setCycleCount(1);
            transition1.play();
            //se agrega junto con los demas componentes al stack principal
            fondoPrincipal.getChildren().add(mostradorRestaurantes);
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}