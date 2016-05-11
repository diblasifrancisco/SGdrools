package com.sample;

public class Recepcion {

	Despacho despacho;
	Codigo codigo;
	private int nrorecepcion;

	public Recepcion(Despacho despacho, Codigo codigo, int nrorecepcion) {
		super();
		this.despacho = despacho;
		this.codigo = codigo;
		this.nrorecepcion = nrorecepcion;
	}

	public Despacho getDespacho() {
		return despacho;
	}

	public void setDespacho(Despacho despacho) {
		this.despacho = despacho;
	}

	public Codigo getCodigo() {
		return codigo;
	}

	public void setCodigo(Codigo codigo) {
		this.codigo = codigo;
	}

	public int getNrorecepcion() {
		return nrorecepcion;
	}

	public void setNrorecepcion(int nrorecepcion) {
		this.nrorecepcion = nrorecepcion;
	}

}
