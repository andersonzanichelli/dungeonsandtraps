package com.dat.enums;

public enum EventosDoJogo {

	GRUPO("grupo")
	,ENCERRAR("encerrar")
	,EVENTO("evento")
	,ARMADILHA("armadilha")
	,DANO_ARMADILHA("danoArmadilha")
	,TESOURO("tesouro")
	,INICIATIVA("iniciativa")
	,ATACAR("atacar");
	
	String evento;
	
	private EventosDoJogo(String evento) {
		this.evento = evento;
	}
}
