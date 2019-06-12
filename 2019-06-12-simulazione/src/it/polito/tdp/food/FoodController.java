/**
 * Sample Skeleton for 'Food.fxml' Controller Class
 */
package it.polito.tdp.food;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.food.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FoodController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCalorie;

    @FXML
    private Button btnCreaGrafo;

    @FXML
    private ComboBox<?> boxIngrediente;

    @FXML
    private Button btnDietaEquilibrata;

    @FXML
    private TextArea TxtArea;

	private Model model;

    @FXML
    void doCalcolaDieta(ActionEvent event) {
    	

    }

    private void showAlert(String message) {
    	Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText(message);
		alert.show();
		
	}

	@FXML
    void doCreaGrafo(ActionEvent event) {
		String numero = txtCalorie.getText();

		if (numero != null && !numero.isEmpty()) {
			if (model.isValid(numero)) {
				String risultato = model.creaGrafo(numero);
				TxtArea.setText(risultato);
			} else {
				showAlert("Devi inserire un numero valido!");
			}
		} else {
			showAlert("Devi inserire un numero!");
		}

    }

    @FXML
    void initialize() {
        assert txtCalorie != null : "fx:id=\"txtCalorie\" was not injected: check your FXML file 'Food.fxml'.";
        assert btnCreaGrafo != null : "fx:id=\"btnCreaGrafo\" was not injected: check your FXML file 'Food.fxml'.";
        assert boxIngrediente != null : "fx:id=\"boxIngrediente\" was not injected: check your FXML file 'Food.fxml'.";
        assert btnDietaEquilibrata != null : "fx:id=\"btnDietaEquilibrata\" was not injected: check your FXML file 'Food.fxml'.";
        assert TxtArea != null : "fx:id=\"TxtArea\" was not injected: check your FXML file 'Food.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
		
		
	}
}
