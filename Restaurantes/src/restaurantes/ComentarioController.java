/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantes;

import java.net.URL;
import Mundo.Comentario;
import javafx.fxml.FXML;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import com.jfoenix.controls.JFXTextArea;


public class ComentarioController implements Initializable {

    @FXML
    private Label nomUsuario;
    @FXML
    private JFXTextArea textoComentario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    public void constructor(Comentario comentario) {
        nomUsuario.setText(comentario.getUsuario().getNombre());
        textoComentario.setText(comentario.getComentario());
    }   
}