/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/**
 * FXML
 * Controller
 * class
 *
 * @author
 * Ivannia
 * Rojas
 */
public class BaseController extends Controller implements Initializable {

	@FXML
	private StackPane st_base;
	@FXML
	private ImageView img_fondoGeneral;
	@FXML
	private BorderPane bp_rootBase;

	/**
	 * Initializes
	 * the
	 * controller
	 * class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		img_fondoGeneral.fitWidthProperty().bind(bp_rootBase.widthProperty());
		img_fondoGeneral.fitHeightProperty().bind(bp_rootBase.heightProperty());
	}	

	@Override
	public void initialize() {
		
	}
	
}
