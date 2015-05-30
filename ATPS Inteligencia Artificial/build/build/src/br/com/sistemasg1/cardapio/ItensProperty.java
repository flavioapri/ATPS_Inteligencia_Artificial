package br.com.sistemasg1.cardapio;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ItensProperty {

	private SimpleStringProperty produto;
	private SimpleIntegerProperty quantidade;
	private SimpleDoubleProperty preco;

	public ItensProperty(String produto, double preco, int quantidade) {
		this.produto = new SimpleStringProperty(produto);
		this.preco = new SimpleDoubleProperty(preco);
		this.quantidade = new SimpleIntegerProperty(quantidade);
	}

	public String getProduto() {
		return produto.get();
	}

	public void setProduto(String produto) {
		this.produto.set(produto);
	}

	public double getPreco() {
		return preco.get();
	}

	public void setPreco(double preco) {
		this.preco.set(preco);
	}

	public Integer getQuantidade() {
		return quantidade.get();
	}

	public void setQuantidade(int quantidade) {
		this.quantidade.set(quantidade);
	}
}
