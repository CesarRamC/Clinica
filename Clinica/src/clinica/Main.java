/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package clinica;

import clinica.util.FlowController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author ivann
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FlowController.getInstance().InitializeFlow(stage, null);
        //stage.getIcons().add(new Image("clinica/resources/clinica.png"));//Establece el icono del programa.
        stage.setTitle("Clinica");
        FlowController.getInstance().goMain("Base");
        FlowController.getInstance().goView("Inicio");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
