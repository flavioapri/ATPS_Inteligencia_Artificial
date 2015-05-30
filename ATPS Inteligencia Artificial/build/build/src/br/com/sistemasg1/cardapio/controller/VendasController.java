package br.com.sistemasg1.cardapio.controller;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.sistemasg1.cardapio.Cadastro;
import br.com.sistemasg1.cardapio.Cliente;
import br.com.sistemasg1.cardapio.ItensProperty;
import br.com.sistemasg1.cardapio.Vendas;

public class VendasController implements Initializable {

	@FXML
	private Button btnLaranja;
	@FXML
	private Button btnLimao;
	@FXML
	private Button btnUva;
	@FXML
	private Button btnMorango;
	@FXML
	private Button btnMaracuja;
	@FXML
	private Button btnManga;
	@FXML
	private Button btnCola;
	@FXML
	private Button btnRefriLaranja;
	@FXML
	private Button btnSoda;
	@FXML
	private Button btnRefriUva;
	@FXML
	private Button btnGuarana;
	@FXML
	private Button btnTutiFruti;
	@FXML
	private Button btnFrango;
	@FXML
	private Button btnHamburguer;
	@FXML
	private Button btnSalada;
	@FXML
	private Button btnPeixe;
	@FXML
	private Button btnCalabresa;
	@FXML
	private Button btnPicanha;
	@FXML
	private Button btnPudim;
	@FXML
	private Button btnBolo;
	@FXML
	private Button btnPetitGateau;
	@FXML
	private Button btnGelatina;
	@FXML
	private Button btnCookie;
	@FXML
	private Button btnBrownie;
	@FXML
	private Button btnFechar;
	@FXML
	private Button btnCancelar;
	@FXML
	private CheckBox chkLeite;
	@FXML
	private CheckBox chkDiet;
	@FXML
	private CheckBox chkQueijo;
	@FXML
	private TableView<ItensProperty> tbvPedido;
	@FXML
	private TableColumn<ItensProperty, String> tbcProduto;
	@FXML
	private TableColumn<ItensProperty, Float> tbcPreco;
	@FXML
	private TableColumn<ItensProperty, Integer> tbcQuantidade;
	@FXML
	private TextField txtCodigo;
	@FXML
	private Pane pnePane;
	@FXML
	private Label lblCliente;
	@FXML
	private Label lblSaudacao;
	private static ObservableList<ItensProperty> listItens = FXCollections
			.observableArrayList();
	private static Cliente cliente;

	public void initialize(URL url, ResourceBundle bundle) {
		try {
			recuperarCliente();
		} catch (JAXBException e1) {
			e1.printStackTrace();
		}
		tbcProduto
				.setCellValueFactory(new PropertyValueFactory<ItensProperty, String>(
						"produto"));
		tbcQuantidade
				.setCellValueFactory(new PropertyValueFactory<ItensProperty, Integer>(
						"quantidade"));
		tbcPreco.setCellValueFactory(new PropertyValueFactory<ItensProperty, Float>(
				"preco"));
		tbvPedido.setItems(listItens);
		txtCodigo.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				mostrarCardapio();
			}
		});
		btnLaranja.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (cliente.isDiabetes()) {
					listItens.add(new ItensProperty(btnLaranja.getText(), 4.50,
							1));
				}
			}
		});
		btnLimao.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty(btnLimao.getText(), 4.50, 1));
			}
		});
		btnUva.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty(btnUva.getText(), 4.50, 1));
			}
		});
		btnMorango.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty(btnMorango.getText(), 4.50, 1));
			}
		});
		btnMaracuja.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty(btnMaracuja.getText(), 4.50, 1));
			}
		});
		btnManga.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty(btnManga.getText(), 4.50, 1));
			}
		});
		btnCola.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty(btnCola.getText(), 6.50, 1));
			}
		});
		btnRefriLaranja.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty("Refrigerante de "
						+ btnRefriLaranja.getText(), 6.50, 1));
			}
		});
		btnSoda.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty(btnSoda.getText(), 6.50, 1));
			}
		});
		btnRefriUva.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty("Refrigerante de "
						+ btnRefriUva.getText(), 6.50, 1));
			}
		});
		btnGuarana.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty(btnGuarana.getText(), 6.50, 1));
			}
		});
		btnTutiFruti.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty(btnTutiFruti.getText(), 6.50, 1));
			}
		});
		btnFrango.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty(btnFrango.getText(), 10.00, 1));
			}
		});
		btnHamburguer.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty(btnHamburguer.getText(), 8.50,
						1));
			}
		});
		btnSalada.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty(btnSalada.getText(), 7.50, 1));
			}
		});
		btnPeixe.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty(btnPeixe.getText(), 7.50, 1));
			}
		});
		btnCalabresa.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty(btnCalabresa.getText(), 12.30,
						1));
			}
		});
		btnPicanha.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty(btnPicanha.getText(), 15.40, 1));
			}
		});
		btnPudim.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty(btnPudim.getText(), 4.70, 1));
			}
		});
		btnBolo.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty(btnBolo.getText(), 11.60, 1));
			}
		});
		btnPetitGateau.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty(btnPetitGateau.getText(),
						17.40, 1));
			}
		});
		btnGelatina.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty(btnGelatina.getText(), 5.50, 1));
			}
		});
		btnCookie.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty(btnCola.getText(), 6.50, 1));
			}
		});
		btnBrownie.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				listItens.add(new ItensProperty(btnBrownie.getText(), 13.60, 1));
			}
		});
		btnFechar.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Alert fechaPedido = new Alert(AlertType.CONFIRMATION,
						"Valor total do pedido. R$ " + somarPedido(),
						ButtonType.YES, ButtonType.NO);
				fechaPedido.setTitle("Fechamento do Pedido");
				fechaPedido.setHeaderText("Deseja fechar seu pedido?");
				Optional<ButtonType> resultado = fechaPedido.showAndWait();
				try {
					fecharPedido(resultado);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnCancelar.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Alert cancela = new Alert(AlertType.CONFIRMATION,
						"Deseja cancelar seu pedido?", ButtonType.YES,
						ButtonType.NO);
				Optional<ButtonType> result = cancela.showAndWait();
				if (result.get() == ButtonType.YES) {
					try {
						new Cadastro().start(new Stage());
						Vendas.getStage().close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	protected void fecharPedido(Optional<ButtonType> resultado)
			throws Exception {
		if (resultado.get() == ButtonType.YES) {
			Alert fechaPedido2 = new Alert(AlertType.CONFIRMATION,
					"Deseja fazer um novo pedido?", ButtonType.YES,
					ButtonType.NO);
			fechaPedido2.setTitle("Pedido Realizado");
			fechaPedido2
					.setHeaderText("Pedido Realizado! Obrigado Pela Preferência!");
			resultado = fechaPedido2.showAndWait();
			if (resultado.get() == ButtonType.NO) {
				new Cadastro().start(new Stage());
				Vendas.getStage().close();
			} else {
				listItens.clear();
			}
		}
	}

	protected double somarPedido() {
		double valorTotal = 0;
		for (ItensProperty itensProperty : listItens) {
			valorTotal += itensProperty.getPreco();
		}
		return valorTotal;
	}

	protected void mostrarCardapio() {
		if (cliente.getCodigo().equals(txtCodigo.getText())) {
			txtCodigo.setDisable(true);
			lblCliente.setText("Bem vindo " + cliente.getNome());
			lblCliente.setVisible(true);
			lblSaudacao.setVisible(true);
			if (cliente.isVegetarianismo()) {
				btnFrango.setDisable(true);
				btnHamburguer.setDisable(true);
				btnPeixe.setDisable(true);
				btnCalabresa.setDisable(true);
				btnPicanha.setDisable(true);
			}
			if (cliente.isIntoleranciaALactose()) {
				chkLeite.setDisable(true);
				chkQueijo.setSelected(true);
				btnPudim.setDisable(true);
				btnPetitGateau.setDisable(true);
			}
			if (cliente.isDiabetes()) {
				chkDiet.setSelected(true);
				btnPudim.setDisable(true);
				btnBolo.setDisable(true);
				btnPetitGateau.setDisable(true);
				btnGelatina.setDisable(true);
				btnCookie.setDisable(true);
				btnBrownie.setDisable(true);
			}
			if (cliente.isHipertensao()) {
				btnHamburguer.setDisable(true);
				btnCalabresa.setDisable(true);
				btnPicanha.setDisable(true);
			}
		} else {
			txtCodigo.clear();
			Alert clienteNaoExiste = new Alert(AlertType.ERROR,
					"O cliente informado não existe.", ButtonType.OK);
			clienteNaoExiste.setTitle("Erro");
			clienteNaoExiste.setHeaderText(null);
			clienteNaoExiste.showAndWait();
		}
	}

	public void recuperarCliente() throws JAXBException {
		JAXBContext context = JAXBContext
				.newInstance("br.com.sistemasg1.cardapio");
		Unmarshaller um = context.createUnmarshaller();
		Object obj = um.unmarshal(new File("cliente.xml"));
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(obj, System.out);
		cliente = (Cliente) obj;
	}
}
