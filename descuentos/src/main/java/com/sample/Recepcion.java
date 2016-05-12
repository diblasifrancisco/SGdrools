package com.sample;

public class Recepcion {

	Despacho despacho;
	Codigo codigo;
	private int nrorecepcion;
	
	private int fecha_reg;
	private int hora_reg;

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
	
	public int getFecha_reg() {
		return fecha_reg;
	}

	public void setFecha_reg(int fecha_reg) {
		this.fecha_reg = fecha_reg;
	}

	public int getHora_reg() {
		return hora_reg;
	}

	public void setHora_reg(int hora_reg) {
		this.hora_reg = hora_reg;
	}
}
