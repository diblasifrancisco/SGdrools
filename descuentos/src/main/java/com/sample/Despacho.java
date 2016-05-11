package com.sample;

public class Despacho {

	Movil movil;
	Desenlace desenlace;
	private int nrodespacho;

	public Despacho(Movil m, Desenlace d, int n) {
		movil = m;
		desenlace = d;
		nrodespacho = n;

	}
	
	public Despacho(){};

	public Movil getMovil() {
		return movil;
	}

	public void setMovil(Movil movil) {
		this.movil = movil;
	}

	public Desenlace getDesenlace() {
		return desenlace;
	}

	public void setDesenlace(Desenlace desenlace) {
		this.desenlace = desenlace;
	}

	public int getNrodespacho() {
		return nrodespacho;
	}

	public void setNrodespacho(int nrodespacho) {
		this.nrodespacho = nrodespacho;
	}

}
