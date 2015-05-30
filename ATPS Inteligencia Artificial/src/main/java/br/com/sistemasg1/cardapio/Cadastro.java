package br.com.sistemasg1.cardapio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Cadastro extends Application {

	private static Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Cadastro.stage = stage;
		Parent parent = FXMLLoader
				.load(getClass().getResource("/fxml/cadastro.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Cardápio 1.0 - Vendas");
		stage.setResizable(false);
		stage.show();
	}

	public static Stage getStage() {
		return stage;
	}
}
