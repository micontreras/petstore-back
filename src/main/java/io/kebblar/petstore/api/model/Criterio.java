package io.kebblar.petstore.api.model;

public class Criterio {

	private int idCategoria;
	private int valor;
	
	public Criterio() {

	}
	public Criterio(int idCategoria, int valor) {
		this.idCategoria = idCategoria;
		this.valor = valor;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
}