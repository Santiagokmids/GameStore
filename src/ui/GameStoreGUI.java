package ui;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
	private ImageView startStoreBackground;

	@FXML
	private ImageView startStoreTitle;

	@FXML
	private ImageView selectButton;

	@FXML
	private ImageView startButton;
	
	@FXML
    private ImageView shortBackground;

    @FXML
    private ImageView shortTitle;

    @FXML
    private ImageView shortMen;

    @FXML
    private ImageView shortWoman;


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

	@FXML
	public void loadApp() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("startStore.fxml"));

		loader.setController(this);
		Parent load = loader.load();
		mainPane.getChildren().clear();

		Image image = new Image("/images/backgroundStart.png");
		startStoreBackground.setImage(image);
		Image image1 = new Image("/images/title.png");
		startStoreTitle.setImage(image1);
		mainPane.setTop(load);
	}

	@FXML
	public void loadSimuls(MouseEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("num-Simuls.fxml"));

		loader.setController(this);
		Parent load = loader.load();
		mainPane.getChildren().clear();

		Image image = new Image("/images/background.png");
		numSimulsBackground.setImage(image);
		Image image1 = new Image("/images/numDates.png");
		numSimulsTitle.setImage(image1);
		mainPane.setTop(load);

	}

	@FXML
	public void startSimul(MouseEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("short.fxml"));

		loader.setController(this);
		Parent load = loader.load();
		mainPane.getChildren().clear();

		Image image = new Image("/images/background.png");
		.setImage(image);
		Image image1 = new Image("/images/numDates.png");
		numSimulsTitle.setImage(image1);
		mainPane.setTop(load);
	}
}
