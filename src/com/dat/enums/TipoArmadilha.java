package com.dat.enums;

public enum TipoArmadilha {

	ALCAPAO("alcapao", "D8", "web/img/alcapao.png")
	,SETA("seta", "D4", "web/img/seta.png")
	,GAZ("gaz", "D10", "web/img/gaz.png");
	
	String armadilha;
	Dado dado;
	String img;
	
	private TipoArmadilha(String armadilha, String dado, String img) {
		this.armadilha = armadilha;
		this.dado = Dado.valueOf(dado);
		this.img = img;
	}

	public String getArmadilha() {
		return armadilha;
	}

	public Dado getDado() {
		return dado;
	}
	
	public String getImg() {
		return img;
	}
	
}
