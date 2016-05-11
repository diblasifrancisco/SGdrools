package com.sample;

public class Movil {
	
	EstadoMovil estado;
	private int id;
	private String descripcion;
	
	public Movil(EstadoMovil e, int ID, String d){
		estado=e;
		id=ID;
		descripcion=d;
	}
	
	public EstadoMovil getEstado() {
		return estado;
	}
	public void setEstado(EstadoMovil estado) {
		this.estado = estado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
