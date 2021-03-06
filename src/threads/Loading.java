package threads;

import java.io.IOException;

import javafx.application.Platform;
import javafx.scene.control.ProgressIndicator;
import ui.GameStoreGUI;

public class Loading extends Thread{
	private ProgressIndicator prgres1;
	private double porcentaje;
	private GameStoreGUI gameStore;
	public Loading(GameStoreGUI gameStoreGUI,ProgressIndicator pg) {
		prgres1=pg;
		porcentaje = 0;
		gameStore = gameStoreGUI;
	}
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			porcentaje+=0.05;
			Platform.runLater(() -> { // Para cambiar algo grafico-- desde un hilo alternativo
				prgres1.setProgress(porcentaje);	//setprogre para el avance	
					
			});
			delay();
		
		}
		Platform.runLater(() -> { // Para cambiar algo grafico-- desde un hilo alternativo
			try {
				gameStore.loadSelectGame();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	//setprogre para el avance	
				
		});
	}
	private void delay() {
		try {
			if(gameStore.amountGames > 7) {
				Thread.sleep(700);
				
			}else {
				Thread.sleep(50*gameStore.amountGames);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}