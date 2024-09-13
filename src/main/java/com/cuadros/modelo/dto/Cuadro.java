package com.cuadros.modelo.dto;

public class Cuadro {
	int id;
	String titulo;
	int altura;
	int anchura;
	public Cuadro(int id, String titulo, int altura, int anchura) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.altura = altura;
		this.anchura = anchura;
	}
	public Cuadro() {
		super();
		this.id = 0;
		this.titulo = "";
		this.altura = 0;
		this.anchura = 0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getAnchura() {
		return anchura;
	}
	public void setAnchura(int anchura) {
		this.anchura = anchura;
	}
	@Override
	public String toString() {
		return "Cuadro [id=" + id + ", titulo=" + titulo + ", altura=" + altura + ", anchura=" + anchura + "]";
	}
}
