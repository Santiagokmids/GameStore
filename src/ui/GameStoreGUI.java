package ui;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class GameStoreGUI {
	  @FXML
	    private BorderPane mainPane; 
	@FXML
	    private ImageView numSimulsBackground;

	    @FXML
	    private ImageView numSimulsTitle;

	    @FXML
	    private TextField numSimulsNum;

	    @FXML
	    void numSimulsContinue(ActionEvent event) {
	    	int numSimul =0;
	    	if (numSimulsNum.getText().equals("") ) {
				JOptionPane.showMessageDialog(null, "Debe llenar los datos solicitados", "Error",
						JOptionPane.WARNING_MESSAGE);
			}else {
				try {
					numSimul= Integer.parseInt(numSimulsNum.getText());
					if(numSimul < 1) {
						JOptionPane.showMessageDialog(null, "La simulacion debe tener una o mas repeticiones", "Error",
								JOptionPane.WARNING_MESSAGE);
					}
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Debe ser un numero", "Error",
							JOptionPane.WARNING_MESSAGE);
				}
				
			}
	    }

		public void loadSimuls() throws IOException {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("num-Simuls.fxml"));

			loader.setController(this);
			Parent load = loader.load();
			mainPane.getChildren().clear();
			mainPane.setTop(load);
			
		}
}
