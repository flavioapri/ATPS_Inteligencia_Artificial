package br.com.sistemasg1.cardapio.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.com.sistemasg1.cardapio.Cadastro;
import br.com.sistemasg1.cardapio.Cliente;
import br.com.sistemasg1.cardapio.Vendas;

public class CadastroController implements Initializable {

	@FXML private VBox vbxAlergias;
	@FXML private TextField txtNome;
	@FXML private CheckBox chkDiabetico;
	@FXML private MenuItem mniVendas;
	@FXML private TextField txtCodigo;
	@FXML private CheckBox chkSurdo;
	@FXML private CheckBox chkLactose;
	@FXML private CheckBox chkAlergico;
	@FXML private CheckBox chkCego;
	@FXML private CheckBox chkAleijado;
	@FXML private CheckBox chkVegetariano;
	@FXML private CheckBox chkHipertenso;
	@FXML private Button btnCadastrar;
	@FXML private Button btnLimpar;
	private static Cliente cliente = new Cliente();

	public void initialize(URL url, ResourceBundle bundle) {
		chkAlergico.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (chkAlergico.isSelected()) {
					vbxAlergias.setDisable(false);
				} else {
					vbxAlergias.setDisable(true);
					cliente.setAlergia(false);
				}
			}
		});
		chkDiabetico.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (chkDiabetico.isSelected()) {
					cliente.setDiabetes(true);
				} else {
					cliente.setDiabetes(false);
				}
			}
		});
		chkVegetariano.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (chkVegetariano.isSelected()) {
					cliente.setVegetarianismo(true);
				} else {
					cliente.setVegetarianismo(false);
				}
			}
		});
		chkLactose.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (chkLactose.isSelected()) {
					cliente.setIntoleranciaALactose(true);
				} else {
					cliente.setIntoleranciaALactose(false);
				}
			}
		});
		chkHipertenso.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (chkHipertenso.isSelected()) {
					cliente.setHipertensao(true);
				} else {
					cliente.setHipertensao(false);
				}
			}
		});
		btnLimpar.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				limparCampos();
			}
		});
		btnCadastrar.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				cadastrar();
			}
		});
		mniVendas.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					new Vendas().start(new Stage());
					Cadastro.getStage().close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void cadastrar() {
		if (txtNome.getText().isEmpty() || txtCodigo.getText().isEmpty()) {
			Alert cadastroIncompleto = new Alert(AlertType.ERROR,
					"Falta nome e/ou código do cliente.", ButtonType.OK);
			cadastroIncompleto.setTitle("Erro");
			cadastroIncompleto.setHeaderText(null);
			cadastroIncompleto.showAndWait();
		} else {
			Alert cadastroCompleto = new Alert(
					AlertType.INFORMATION,
					"Cliente " + txtNome.getText() + " cadastrado com sucesso.",
					ButtonType.OK);
			cadastroCompleto.setTitle("Contato cadastrado");
			cadastroCompleto.setHeaderText(null);
			cadastroCompleto.showAndWait();
			cliente.setNome(txtNome.getText());
			cliente.setCodigo(txtCodigo.getText());
			try {
				gravarCliente(cliente);
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (JAXBException e1) {
				e1.printStackTrace();
			}
			limparCampos();
			try {
				new Vendas().start(new Stage());
				Cadastro.getStage().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void limparCampos() {
		txtNome.clear();
		txtCodigo.clear();
		chkDiabetico.setSelected(false);
		chkAleijado.setSelected(false);
		chkAlergico.setSelected(false);
		chkCego.setSelected(false);
		chkHipertenso.setSelected(false);
		chkLactose.setSelected(false);
		chkSurdo.setSelected(false);
		chkVegetariano.setSelected(false);
		vbxAlergias.setDisable(true);
	}

	public void gravarCliente(Cliente cliente) throws IOException,
			JAXBException {
		JAXBContext context = JAXBContext
				.newInstance("br.com.sistemasg1.cardapio");
		File registro = new File("cliente.xml");
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(cliente, new FileOutputStream(registro));
	}
}
