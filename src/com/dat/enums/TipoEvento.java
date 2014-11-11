package com.dat.enums;

public enum TipoEvento {

	TESOURO("tesouro")
	,ORCS("orcs")
	,ARMADILHA("armadilha")
	,NENHUM("nenhum");
	
	String evento;

	private TipoEvento(String evento) {
		this.evento = evento;
	}
	
	@Override
	public String toString() {
		return this.evento;
	}
}
