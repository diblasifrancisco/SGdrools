package com.sample;

public class Codigo {
	
	private int codigo;
	private String descripcion;
	private String mensaje;
	
	public Codigo(int c, String d, String m){
		codigo=c;
		descripcion=d;
		mensaje=m;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
