package com.dat.enums;

public enum Habilidade {

	FORTITUDE("fortitude")
	, REFLEXOS("reflexos")
	, VONTADE("vontade");
	
	String habil;
	
	private Habilidade(String habil) {
		this.habil = habil;
	}
}
