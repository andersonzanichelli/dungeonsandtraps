package com.dat.enums;

public enum ClassePersonagem {

	ANAO("anao")
	, BARBARO("barbaro")
	, BATEDOR("batedor")
	, GUERREIRA("guerreira")
	, MAGO("mago")
	, SACERDOTISA("sacerdotisa");
	
	String classe;
	
	ClassePersonagem(String classe) {
		this.classe = classe;
	}
	
	@Override
	public String toString() {
		return this.classe;
	}
}
