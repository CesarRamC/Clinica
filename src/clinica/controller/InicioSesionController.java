/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package clinica.controller;

import clinica.model.Usuario;
import clinica.service.UsuarioService;
import clinica.util.AppContext;
import clinica.util.FlowController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ivann
 */
public class InicioSesionController extends Controller implements Initializable {

    @FXML
    private TextField txfUsuario;
    @FXML
    private PasswordField txfContrasena;
    
    private UsuarioService usuarioService;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usuarioService = new UsuarioService();
    }    

    @Override
    public void initialize() {
    }

    @FXML
    private void onAction_iniciarSesion(ActionEvent event) {
        usuarioService.buscarUsuario(txfUsuario.getText().toUpperCase(), txfContrasena.getText().toUpperCase(),"A");
        if(AppContext.getInstance().get("BusquedaUsuario") != null){
            FlowController.getInstance().goView("Menu");
        }  
    }
    
}
