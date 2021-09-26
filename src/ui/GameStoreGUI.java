package ui;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import threads.Loading;

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
	private ImageView gameBackground;

	@FXML
	private ImageView gameTitle;

	@FXML
	private TextField codeGame;

	@FXML
	private TextField priceGame;

	@FXML
	private Label numGame;

	@FXML
	private TextField unitsGame;
	@FXML
	private ImageView numClientsBackground;

	@FXML
	private ImageView numClientsTitle;

	@FXML
	private TextField numClients;

	@FXML
	private ImageView imageClientBac;

	@FXML
	private ImageView imgDatesClients;

	@FXML
	private TextField txtIdClients;

	@FXML
	private TextField txtCodesGamesClients;

	@FXML
	private Label datesClientsNum;

	@FXML
	private ImageView shortBackground;

	@FXML
	private ImageView shortTitle;

	@FXML
	private ImageView shortMen;

	@FXML
	private ImageView shortWoman;

	@FXML
	private ProgressIndicator shortProgreesInd;


	private int standsCont;
	
	private int numGames;

	private int contStand;
	
	private int contGames;
	
	private int numberClients;
	
	private int contClients;
	
	@FXML
    private ImageView selectGameBackground;

    @FXML
    private ImageView selectGameTitle;

    @FXML
    private ImageView selectGamesLeftStand;

    @FXML
    private ImageView selectGameMenChoosing;

    @FXML
    private ImageView selectGameWomanChoosing;

    @FXML
    private ImageView selectGameStandRigth;

    @FXML
    private ProgressIndicator selectGamesProgress;
    
    @FXML
    private ImageView listLeft;

    @FXML
    private ImageView listRight;
    
	public void loadSelectGame() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("selectGames.fxml"));
		loader.setController(this);
		Parent load = loader.load();
		mainPane.getChildren().clear();
		
		Image image = new Image("/images/background.png");
		selectGameBackground.setImage(image);
		Image image1 = new Image("/images/selectGames.png");
		selectGameTitle.setImage(image1);
		Image image2 = new Image("/images/stand.png");
		selectGamesLeftStand.setImage(image2);
		Image image3 = new Image("/images/stand.png");
		selectGameStandRigth.setImage(image3);
		Image image4 = new Image("/images/man.png");
		selectGameMenChoosing.setImage(image4);
		Image image5 = new Image("/images/woman.png");
		selectGameWomanChoosing.setImage(image5);
		mainPane.setTop(load);
		mainPane.setTop(load);
		Loading pc = new Loading(this,selectGamesProgress);
		pc.start();
	}
	public GameStoreGUI() {
		
	}
	
	@FXML
	void addCustomer(ActionEvent event) throws IOException {
		int idClients = 0;
		String codesGame = txtCodesGamesClients.getText();
		
		if (txtIdClients.getText().equals("") || txtCodesGamesClients.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Debe llenar los datos solicitados", "Error",
					JOptionPane.WARNING_MESSAGE);
		} else {
			try {
				idClients = Integer.parseInt(txtIdClients.getText());
				if (idClients > 0) {
					
					if(contClients < numberClients) {
						contClients++;
						Platform.runLater(new Thread(){
							public void run() {
								datesClientsNum.setText(contClients+"");
							}
						});
						txtIdClients.setText("");
						txtCodesGamesClients.setText("");
					}
					else {
						loadApp();
					}

				} else {
					JOptionPane.showMessageDialog(null, "Debe haber mas de un cliente", "Error",
							JOptionPane.WARNING_MESSAGE);
				}
			} catch (NumberFormatException nfe) {
				txtIdClients.setText("");
				JOptionPane.showMessageDialog(null, "Debe ser un numero", "Error", JOptionPane.WARNING_MESSAGE);
			}

		}
	}

	@FXML
	void numClientsContinues(ActionEvent event) throws IOException {
		if (numClients.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Debe llenar los datos solicitados", "Error",
					JOptionPane.WARNING_MESSAGE);
		} else {
			try {
				int numClient = Integer.parseInt(numClients.getText());
				if (numClient > 0) {
					
					numberClients = numClient;
					contClients = 1;

					FXMLLoader loader = new FXMLLoader(getClass().getResource("dates-clients.fxml"));
					loader.setController(this);
					Parent load = loader.load();
					mainPane.getChildren().clear();

					Image image = new Image("/images/background.png");
					imageClientBac.setImage(image);
					Image image1 = new Image("/images/datesClients.png");
					imgDatesClients.setImage(image1);
					mainPane.setTop(load);

				} else {
					JOptionPane.showMessageDialog(null, "Debe haber mas de un cliente", "Error",
							JOptionPane.WARNING_MESSAGE);
				}
			} catch (NumberFormatException nfe) {
				priceGame.setText("");
				unitsGame.setText("");
				JOptionPane.showMessageDialog(null, "Debe ser un numero", "Error", JOptionPane.WARNING_MESSAGE);
			}

		}
	}



	@FXML
	void addGame(ActionEvent event) throws IOException {
		int pricesGame = 0;
		int codeGam = 0;
		int unitGame = 0;
		if (priceGame.getText().equals("") || codeGame.getText().equals("") || unitsGame.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Debe llenar los datos solicitados", "Error",
					JOptionPane.WARNING_MESSAGE);
		} else {
			try {
				pricesGame = Integer.parseInt(priceGame.getText());
				unitGame = Integer.parseInt(unitsGame.getText());
				codeGam = Integer.parseInt(codeGame.getText());
				if (pricesGame < 1 || unitGame < 1) {
					JOptionPane.showMessageDialog(null, "Los datos deben ser mayor a 0", "Error",
							JOptionPane.WARNING_MESSAGE);
					priceGame.setText("");
					unitsGame.setText("");
				} else {
					
					if(contGames < numGames) {
						contGames++;
						Platform.runLater(new Thread(){
							public void run() {
								numGame.setText(contGames+"");
							}
						});
						bucleWindowGame();
					}
					
					else if(contStand == standsCont) {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("num-clients.fxml"));
						loader.setController(this);
						Parent load = loader.load();
						mainPane.getChildren().clear();

						Image image = new Image("/images/background.png");
						numClientsBackground.setImage(image);
						Image image1 = new Image("/images/numClients.png");
						numClientsTitle.setImage(image1);
						mainPane.setTop(load);
					}
						
					else {
						if(contStand < standsCont) {
							contStand++;
							Platform.runLater(new Thread(){
								public void run() {
									standsLabelNumStands.setText(contStand+"");
								}
							});		
						}
						contGames = 1;
						bucleWindowStands();
					}
				}
			} catch (NumberFormatException nfe) {
				priceGame.setText("");
				unitsGame.setText("");
				JOptionPane.showMessageDialog(null, "Debe ser un numero", "Error", JOptionPane.WARNING_MESSAGE);
			}

		}
	}

	@FXML
	void standsAddStands(ActionEvent event) throws IOException {
		int numGame = 0;

		if (standsNumGames.getText().equals("") || standsName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Debe llenar los datos solicitados", "Error",
					JOptionPane.WARNING_MESSAGE);
			standsNumGames.setText("");
			standsName.setText("");
		} else {
			try {
				numGame = Integer.parseInt(standsNumGames.getText());
				if (numGame < 1) {
					JOptionPane.showMessageDialog(null, "Los datos deben ser mayor a 0", "Error",
							JOptionPane.WARNING_MESSAGE);
					standsNumGames.setText("");
					standsName.setText("");
				} else {
					
					numGames = numGame;
					contGames = 1;
					FXMLLoader loader = new FXMLLoader(getClass().getResource("games.fxml"));
					loader.setController(this);
					Parent load = loader.load();
					mainPane.getChildren().clear();

					Image image = new Image("/images/background.png");
					gameBackground.setImage(image);
					Image image1 = new Image("/images/games.png");
					gameTitle.setImage(image1);
					mainPane.setTop(load);
				}

			} catch (NumberFormatException nfe) {
				standsNumGames.setText("");
				standsName.setText("");

			}

		}

	}
	
	public void bucleWindowClient() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("dates-clients.fxml"));
		loader.setController(this);
		Parent load = loader.load();
		mainPane.getChildren().clear();

		Image image = new Image("/images/background.png");
		imageClientBac.setImage(image);
		Image image1 = new Image("/images/datesClients.png");
		imgDatesClients.setImage(image1);
		mainPane.setTop(load);
	}
	
	public void bucleWindowGame() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("games.fxml"));
		loader.setController(this);
		Parent load = loader.load();
		mainPane.getChildren().clear();

		Image image = new Image("/images/background.png");
		gameBackground.setImage(image);
		Image image1 = new Image("/images/games.png");
		gameTitle.setImage(image1);
		mainPane.setTop(load);
	}

	public void bucleWindowStands() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("stands.fxml"));
		loader.setController(this);
		Parent load = loader.load();
		mainPane.getChildren().clear();

		Image image = new Image("/images/background.png");
		standsBackground.setImage(image);
		Image image1 = new Image("/images/infoStands.png");
		standsTitle.setImage(image1);
		mainPane.setTop(load);
	}


	@FXML
	public void addDatesSimuls(ActionEvent event) throws IOException {
		int numCashiers = 0;
		int  numStand = 0;
		if (numDatesStand.getText().equals("")||numDatesCashiers.getText().equals("") ) {

			JOptionPane.showMessageDialog(null, "Debe llenar los datos solicitados", "Error",
					JOptionPane.WARNING_MESSAGE);
			numDatesStand.setText("");
			numDatesCashiers.setText("");
		} else {
			try {
				numCashiers = Integer.parseInt(numDatesCashiers.getText());
				numStand = Integer.parseInt(numDatesStand.getText());
				if (numCashiers < 1 || numStand < 1) {
					JOptionPane.showMessageDialog(null, "Los datos deben ser mayor a 0", "Error",
							JOptionPane.WARNING_MESSAGE);
					numDatesStand.setText("");
					numDatesCashiers.setText("");
				} else {

					standsCont = numStand;
					contStand = 1;
					FXMLLoader loader = new FXMLLoader(getClass().getResource("stands.fxml"));
					loader.setController(this);
					Parent load = loader.load();
					mainPane.getChildren().clear();

					Image image = new Image("/images/background.png");
					standsBackground.setImage(image);
					Image image1 = new Image("/images/infoStands.png");
					standsTitle.setImage(image1);
					mainPane.setTop(load);
				}
			} catch (NumberFormatException nfe) {
				numDatesStand.setText("");
				numDatesCashiers.setText("");
				JOptionPane.showMessageDialog(null, "Debe ser un numero", "Error", JOptionPane.WARNING_MESSAGE);
			}

		}

	}



	@FXML
	public void numSimulsContinue(ActionEvent event) throws IOException {
		int numSimul =0;
		if (numSimulsNum.getText().equals("") ) {

			JOptionPane.showMessageDialog(null, "Debe llenar los datos solicitados", "Error",
					JOptionPane.WARNING_MESSAGE);
			numSimulsNum.setText("");
		} else {
			try {
				numSimul = Integer.parseInt(numSimulsNum.getText());
				if (numSimul < 1) {
					JOptionPane.showMessageDialog(null, "La simulacion debe tener una o mas repeticiones", "Error",
							JOptionPane.WARNING_MESSAGE);
					numSimulsNum.setText("");
				} else {

					FXMLLoader loader = new FXMLLoader(getClass().getResource("dates-simuls.fxml"));
					loader.setController(this);
					Parent load = loader.load();
					mainPane.getChildren().clear();

					Image image = new Image("/images/background.png");
					imageDatesBackground.setImage(image);
					Image image1 = new Image("/images/datesSimul.png");
					imageDateTitle.setImage(image1);

					mainPane.setTop(load);
				}
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Debe ser un numero", "Error", JOptionPane.WARNING_MESSAGE);
				numSimulsNum.setText("");
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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("sort.fxml"));
		
		loader.setController(this);
		Parent load = loader.load();
		mainPane.getChildren().clear();
		
		Image image = new Image("/images/background.png");
		shortBackground.setImage(image);
		Image image1 = new Image("/images/short.png");
		shortTitle.setImage(image1);
		Image image2 = new Image("/images/men.png");
		shortMen.setImage(image2);
		Image image3 = new Image("/images/women.png");
		shortWoman.setImage(image3);
		Image image4 = new Image("/images/list.png");
		listLeft.setImage(image4);
		Image image5 = new Image("/images/list.png");
		listRight.setImage(image5);
		mainPane.setTop(load);
		Loading pc = new Loading(this,shortProgreesInd);
		pc.start();
	}

	
}
