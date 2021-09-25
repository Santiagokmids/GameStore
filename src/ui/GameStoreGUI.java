package ui;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
	private ImageView startStoreBackground;

	@FXML
	private ImageView startStoreTitle;

	@FXML
	private ImageView selectButton;

	@FXML
	private ImageView startButton;
	@FXML
    private ImageView imageDatesBackground;

    @FXML
    private ImageView imageDateTitle;

    @FXML
    private TextField numDatesCashiers;

    @FXML
    private TextField numDatesStand;
    @FXML
    private ImageView standsBackground;

    @FXML
    private ImageView standsTitle;

    @FXML
    private TextField standsName;

    @FXML
    private TextField standsNumGames;

    @FXML
    private Label standsLabelNumStands;

    @FXML
    void standsAddStands(ActionEvent event) {

    }


    @FXML
    void addDatesSimuls(ActionEvent event) throws IOException {
    	int numCashiers = 0;
    	int  numStand = 0;
    	if (numDatesStand.getText().equals("")||numDatesCashiers.getText().equals("") ) {
			JOptionPane.showMessageDialog(null, "Debe llenar los datos solicitados", "Error",
					JOptionPane.WARNING_MESSAGE);
		}else {
			try {
				numCashiers= Integer.parseInt(numDatesCashiers.getText());
				numStand= Integer.parseInt(numDatesStand.getText());
				if(numCashiers < 1 || numStand< 1) {
					JOptionPane.showMessageDialog(null, "Los datos deben ser mayor a 0", "Error",
							JOptionPane.WARNING_MESSAGE);
				}else {
						
					// se piden datos de los stands 
					
					
					
					FXMLLoader loader = new FXMLLoader(getClass().getResource("stands.fxml"));			
					loader.setController(this);
					Parent load = loader.load();
					mainPane.getChildren().clear();
					mainPane.setTop(load);
				}
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Debe ser un numero", "Error",
						JOptionPane.WARNING_MESSAGE);
			}

		}
    }
	@FXML
	void numSimulsContinue(ActionEvent event) throws IOException {
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
				}else {
					
					
					
					
					// se piden los  datos para la simulacion 
					
					
					
					FXMLLoader loader = new FXMLLoader(getClass().getResource("dates-simuls.fxml"));			
					loader.setController(this);
					Parent load = loader.load();
					mainPane.getChildren().clear();
					mainPane.setTop(load);
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
	public void loadSimuls() throws IOException {
		mainPane.setPrefWidth(400);
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
}
