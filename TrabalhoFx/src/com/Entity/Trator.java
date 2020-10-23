package com.Entity;

import java.util.List;

public class Trator {

	
	public String marca;
	public String modelo;
	public int ano;
	public float valor;
	
	

	public Trator() {
		super();
	}


	public Trator(String marca, String modelo, int ano, float valor) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
	}




	// METODOS


	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Trator [marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", valor=" + valor
				+ "]";
	}

}


