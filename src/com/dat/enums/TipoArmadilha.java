package com.dat.enums;


public enum TipoArmadilha {

	ALCAPAO("alcapao", "D10", "web/img/alcapao.png", 15, Habilidade.REFLEXOS)
	,SETA("seta", "D6", "web/img/seta.png", 20, Habilidade.REFLEXOS)
	,GAZ("gaz", "D12", "web/img/gaz.png", 10, Habilidade.FORTITUDE);
	
	String armadilha;
	Dado dado;
	String img;
	Integer dificuldade;
	Habilidade habilidade;
	
	private TipoArmadilha(String armadilha, String dado, String img, Integer dificuldade, Habilidade habilidade) {
		this.armadilha = armadilha;
		this.dado = Dado.valueOf(dado);
		this.img = img;
		this.dificuldade = dificuldade;
		this.habilidade = habilidade;
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
	
	public Integer getDificuldade() {
		return dificuldade;
	}

	public Habilidade getHabilidade() {
		return habilidade;
	}
	
}
