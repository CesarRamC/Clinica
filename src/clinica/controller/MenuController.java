/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package clinica.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ivann
 */
public class MenuController extends Controller implements Initializable  {
 @FXML
    private TextField txfCodigo;
    @FXML
    private Tab tabRegistrarCita;
    @FXML
    private ComboBox<String> cbxMedicos;
    @FXML
    private ComboBox<String> cbxPacientes;
    @FXML
    private DatePicker dpFecha;
    @FXML
    private TextArea txaDescripcion;
    @FXML
    private Tab tabModificarCita;
    
    int contador;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        contador = 0;
        txfCodigo.setText(generarCodigoCita());
    }    

    @Override
    public void initialize() {
        
    }
    
    public String generarCodigoCita(){
        String prefijo= "CITA-";
        String numeroSecuencial = String.format("%03d", contador);
        contador++;
        return prefijo+numeroSecuencial;
    }
 
    public void limpiar(){
        txaDescripcion.setText("");
        txfCodigo.setText(generarCodigoCita());
        cbxMedicos.getSelectionModel().clearSelection();
        cbxPacientes.getSelectionModel().clearSelection();
    }
    
    @FXML
    private void onAction_agregarCita(ActionEvent event) {
        
        
         limpiar();
     }

    @FXML
    private void onAction_buscarCita(ActionEvent event) {
    }

}
