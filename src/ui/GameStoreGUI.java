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
import model.Game;
import model.GameStore;
import model.Stand;
import threads.Load;
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

	@FXML
	private ImageView sortMethodBack;

	@FXML
	private ImageView sortMethodTitle;

	@FXML
	private ImageView sortImg;

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
	private ImageView payingBackgroud;

	@FXML
	private ImageView payingTitle;

	@FXML
	private ImageView payingCashier;

	@FXML
	private ImageView payingQueue;

	@FXML
	private Label payingLabelNumCashier;

	@FXML
	private Label payingNumPeople;

	@FXML
	private Label money;

	@FXML
	private ImageView listRight;

	private boolean enter = false;

	private int contSimuls;

	private int numCashier;

	private GameStore gameStore;

	public GameStoreGUI() {
		gameStore = new GameStore();
	}

	public void payingGame() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("paying.fxml"));
		loader.setController(this);
		Parent load = loader.load();
		mainPane.getChildren().clear();

		Image image = new Image("/images/background.png");
		payingBackgroud.setImage(image);
		Image image1 = new Image("/images/paying.png");
		payingTitle.setImage(image1);
		Image image2 = new Image("/images/cashier.png");
		payingCashier.setImage(image2);
		Image image3 = new Image("/images/queue.png");
		payingQueue.setImage(image3);
		mainPane.setTop(load);

		Platform.runLater(new Thread(){
			public void run() {
				payingLabelNumCashier.setText(numCashier+"");
				payingNumPeople.setText(numberClients+"");
			}
		});
	}

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
		Load pc = new Load(this,selectGamesProgress);
		pc.start();
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
				
				boolean verify = gameStore.verifyGames(codesGame);	
				boolean verifyGames = gameStore.checkTheGames(codesGame);
				
				if(!verify) {
					JOptionPane.showMessageDialog(null, "Datos sobre los juegos inválidos, ingreselos de nuevo", "Error",
							JOptionPane.WARNING_MESSAGE);
				}else if(!verifyGames) {
					JOptionPane.showMessageDialog(null, "Alguno de los juegos ingresados no existe", "Error",
							JOptionPane.WARNING_MESSAGE);
				}else if(idClients > 0){
					
					gameStore.addClient(txtIdClients.getText());
					
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
						enter = true;
						loadApp();
					}
				} else {
					JOptionPane.showMessageDialog(null, "La cédula o código del cliente es inválida", "Error",
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
					unitsGame.setText("");
				} else {

					boolean verify = gameStore.searchGame(codeGam);

					if(verify) {
						JOptionPane.showMessageDialog(null, "El código que ingresó ya le pertenece a otro juego", "Error", JOptionPane.WARNING_MESSAGE);
						codeGame.setText("");
						priceGame.setText("");
						unitsGame.setText("");
						
					}else {
						Game game = new Game(codeGam, pricesGame, unitGame, standsName.getText());
						gameStore.getStands().get(contStand-1).getHash().inserTable(codeGam, game);

						if(contGames < numGames) {
							contGames++;
							Platform.runLater(new Thread(){
								public void run() {
									numGame.setText(contGames+"");
								}
							});
							bucleWindowGame();
							
						}else if(contStand == standsCont) {

							FXMLLoader loader = new FXMLLoader(getClass().getResource("num-clients.fxml"));
							loader.setController(this);
							Parent load = loader.load();
							mainPane.getChildren().clear();

							Image image = new Image("/images/background.png");
							numClientsBackground.setImage(image);
							Image image1 = new Image("/images/numClients.png");
							numClientsTitle.setImage(image1);
							mainPane.setTop(load);

						}else {

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
				}

			}catch (NumberFormatException nfe) {
				priceGame.setText("");
				unitsGame.setText("");
				codeGame.setText("");
				JOptionPane.showMessageDialog(null, "Debe ser un numero", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public Stand search(String name) {
		boolean stop = false;
		Stand stand = null;

		for (int i = 0; i < gameStore.getStands().size() && !stop; i++) {
			if(name.equalsIgnoreCase(gameStore.getStands().get(i).getName())) {
				stop = true;
				stand = gameStore.getStands().get(i);
			}
		}

		return stand;
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

					if(search(standsName.getText()) == null) {
						
						gameStore.changeInformation(standsName.getText(), numGame, (contStand-1));

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

					} else {
						JOptionPane.showMessageDialog(null, "El nombre de la estantería ya se encuentra registrado", "Error",
								JOptionPane.WARNING_MESSAGE);
						standsNumGames.setText("");
						standsName.setText("");
					}
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

					gameStore.createStand(numStand);

					numCashier = numCashiers;
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

					contSimuls = numSimul;
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

		if(enter) {
			JOptionPane.showMessageDialog(null, "Ya se ingresaron los datos de la simulación. Pulse START para iniciar.", "Error", JOptionPane.WARNING_MESSAGE);
		}
		else {
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

	@FXML
	public void selectSort(MouseEvent event) throws IOException {

		if(!enter) {
			JOptionPane.showMessageDialog(null, "Antes de iniciar la simulación debe ingresar los datos. Para ello pulse select.", "Error", JOptionPane.WARNING_MESSAGE);
		}
		else {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("sortMethod.fxml"));

			loader.setController(this);
			Parent load = loader.load();
			mainPane.getChildren().clear();

			Image image = new Image("/images/background.png");
			sortMethodBack.setImage(image);
			Image image1 = new Image("/images/sortMethod.png");
			sortMethodTitle.setImage(image1);
			Image image2 = new Image("/images/listGame.png");
			sortImg.setImage(image2);
			mainPane.setTop(load);
			enter = false;
		}
	}

	@FXML
	public void startSimul(ActionEvent event) throws IOException {

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

	public GameStore getGameStore() {
		return gameStore;
	}

	public void setGameStore(GameStore gameStore) {
		this.gameStore = gameStore;
	}
	
	   @FXML
	    void insertionBotton(ActionEvent event) {

	    }

	    @FXML
	    void selectionBotton(ActionEvent event) throws IOException {
	    	gameStore.initializatedSelectionSort();
	    	startSimul(event);
	    }
}
