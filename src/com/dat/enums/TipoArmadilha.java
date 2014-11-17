package com.dat.enums;


public enum TipoArmadilha {

	ALCAPAO("alcapao", "D10", "web/img/alcapao.png",20 /*Dado.D10.lancar()*/, Habilidade.REFLEXOS)
	,SETA("seta", "D6", "web/img/seta.png",20 /*Dado.D12.lancar()*/, Habilidade.REFLEXOS)
	,GAZ("gas", "D12", "web/img/gas.png",20 /*Dado.D20.lancar()*/, Habilidade.FORTITUDE);
	
	String armadilha;
	Dado dano;
	String img;
	Integer dificuldade;
	Habilidade habilidade;
	
	private TipoArmadilha(String armadilha, String dano, String img, Integer dificuldade, Habilidade habilidade) {
		this.armadilha = armadilha;
		this.dano = Dado.valueOf(dano);
		this.img = img;
		this.dificuldade = dificuldade;
		this.habilidade = habilidade;
	}

	public String getArmadilha() {
		return armadilha;
	}

	public Dado getDano() {
		return dano;
	}
	
	public String getImg() {
		return img;
	}
	
	public Integer getDificuldade() {
		return dificuldade;
	}

	public Habilidade getHabilidade() {
		return habilidade;
	}
	
}
