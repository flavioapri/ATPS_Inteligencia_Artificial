package br.com.sistemasg1.cardapio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Home extends Application {

	private static Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));
		Home.stage = stage;
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Cardápio 1.0");
		stage.setResizable(false);
		stage.show();
	}

	public static Stage getStage() {
		return stage;
	}
}
