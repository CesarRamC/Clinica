/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.util;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.stage.Window;

public abstract class Mensaje{

    public static void show(AlertType tipo,String titulo,String mensaje) {
        Alert alert=new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();
    }
public static void showImage(AlertType tipo,String titulo,String mensaje) {
		ImageView image= new ImageView("juegoPreguntados/resources/ciencia.png");
		image.setFitHeight(100);
		image.setFitWidth(100);
		image.setPreserveRatio(true);
        Alert alert=new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
		alert.setGraphic(image);
        alert.show();
    }
    public static void showModal(AlertType tipo,String titulo,Window padre,String mensaje) {
        Alert alert=new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.initOwner(padre);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    public static Boolean showConfirmation(String titulo,Window padre,String mensaje) {
        Alert alert=new Alert(AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.initOwner(padre);
        alert.setContentText(mensaje);
        Optional<ButtonType>result=alert.showAndWait();
        return result.get()==ButtonType.OK;
    }

    public static void showAndWait(String validación, String nombre_inválido, String el_nombre_debe_tener_entre_3_y_100_caract) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
