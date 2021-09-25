package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
	private GameStoreGUI gameStore;
	
	public Main() {
		gameStore = new GameStoreGUI(); 
}
	public static void main(String [] args) {
        launch(args);


    }
	@Override
	public void start(Stage primaryStage) throws Exception {		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
			
			fxmlLoader.setController(gameStore);
			
			Parent root = fxmlLoader.load();
			Image icon= new Image("/images/backgroundStart.png");
			Scene scene = new Scene(root);
			 scene.getStylesheets().add("/images/backgroundStart.png");
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(icon);
			primaryStage.setTitle("Game Store");
			primaryStage.setResizable(false);
			primaryStage.show();
			gameStore.loadApp();
	}
}
