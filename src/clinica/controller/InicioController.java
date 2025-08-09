/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.controller;

import clinica.util.FlowController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Ivannia Rojas
 */
public class InicioController extends Controller implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private VBox vb_opciones;

    @FXML
    private Button btn_iniciarSesion;
    @FXML
    private Button btn_registrar;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vb_opciones.setAlignment(Pos.CENTER);
        vb_opciones.setSpacing(30);

        //clickBoton= getClass().getResource("clickBoton.mp3");
        //clickBtn= new AudioClip(clickBoton.toString());
        //clickBtn.setVolume(1);
        // TODO
    }

    @Override
    public void initialize() {

    }

    @FXML
    private void onAction_registrar(ActionEvent event) {
        FlowController.getInstance().goView("Registro");
    }

    @FXML
    private void onAction_iniciarSesion(ActionEvent event) {
        FlowController.getInstance().goView("InicioSesion");
    }


}
