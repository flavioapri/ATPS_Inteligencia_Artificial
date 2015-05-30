package br.com.sistemasg1.cardapio;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cliente {

	private String nome;
	private String codigo;
	private boolean diabetes;
	private boolean hipertensao;
	private boolean deficienciaFisica;
	private boolean vegetarianismo;
	private boolean surdes;
	private boolean intoleranciaALactose;
	private boolean alergia;
	private boolean cegueira;

	public Cliente() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public boolean isDiabetes() {
		return diabetes;
	}

	public void setDiabetes(boolean diabetes) {
		this.diabetes = diabetes;
	}

	public boolean isHipertensao() {
		return hipertensao;
	}

	public void setHipertensao(boolean hipertensao) {
		this.hipertensao = hipertensao;
	}

	public boolean isDeficienciaFisica() {
		return deficienciaFisica;
	}

	public void setDeficienciaFisica(boolean deficienciaFisica) {
		this.deficienciaFisica = deficienciaFisica;
	}

	public boolean isVegetarianismo() {
		return vegetarianismo;
	}

	public void setVegetarianismo(boolean vegetarianismo) {
		this.vegetarianismo = vegetarianismo;
	}

	public boolean isSurdes() {
		return surdes;
	}

	public void setSurdes(boolean surdes) {
		this.surdes = surdes;
	}

	public boolean isIntoleranciaALactose() {
		return intoleranciaALactose;
	}

	public void setIntoleranciaALactose(boolean intoleranciaALactose) {
		this.intoleranciaALactose = intoleranciaALactose;
	}

	public boolean isAlergia() {
		return alergia;
	}

	public void setAlergia(boolean alergia) {
		this.alergia = alergia;
	}

	public boolean isCegueira() {
		return cegueira;
	}

	public void setCegueira(boolean cegueira) {
		this.cegueira = cegueira;
	}
}
