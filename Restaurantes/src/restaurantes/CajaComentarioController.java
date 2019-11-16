/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantes;

import Mundo.Restaurante;
import java.net.URL;
import Mundo.Sistema;
import Mundo.Usuario;
import Mundo.Comentario;
import Mundo.Elemento;
import Mundo.Fachada;
import javafx.fxml.FXML;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.StackPane;
import com.jfoenix.controls.JFXTextArea;


public class CajaComentarioController implements Initializable, ISujeto {

    private Elemento restaurante;
    private StackPane fondoPrincipal;
    private ArrayList<IObservador> observadores;
    private Fachada fachada;

    @FXML
    private JFXTextArea comentario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        observadores = new ArrayList<>();
    }

    public void constructor(StackPane stack, Elemento restaurante) {
        this.fondoPrincipal = stack;
        this.restaurante = restaurante;
        fachada = new Fachada();
    }

    @FXML
    private void comentar(ActionEvent event) {
        if (!comentario.getText().isEmpty()) {
            restaurante.getComentarios().add(0, new Comentario(comentario.getText(), fachada.getUsuario()));
            fondoPrincipal.getChildren().remove(fondoPrincipal.getChildren().size() - 1);
            notificarObservadores();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Atencion!");
            alert.setHeaderText("Area de texto vacia!");
            alert.setContentText("Por favor escriba su comentario.");
            alert.showAndWait();
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
        fondoPrincipal.getChildren().remove(fondoPrincipal.getChildren().size() - 1);
    }

    @Override
    public void registrarObservador(IObservador o) {
        observadores.add(o);
    }

    @Override
    public void notificarObservadores() {
        for (IObservador observadore : observadores) {
            observadore.actualizar();
        }
    }

}
