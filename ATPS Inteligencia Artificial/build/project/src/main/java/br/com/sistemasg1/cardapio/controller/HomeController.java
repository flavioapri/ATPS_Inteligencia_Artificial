package br.com.sistemasg1.cardapio.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.sistemasg1.cardapio.Cadastro;
import br.com.sistemasg1.cardapio.Home;
import br.com.sistemasg1.cardapio.Vendas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController implements Initializable {

	@FXML private Button btnVendas;
	@FXML private Button btnCadastro;

	public void initialize(URL url, ResourceBundle bundle) {
		btnVendas.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					new Vendas().start(new Stage());
					Home.getStage().close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnCadastro.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					new Cadastro().start(new Stage());
					Home.getStage().close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
