package com.dat.enums;

public enum TipoTesouro {

	OURO("ouro", "web/img/ouro.png", 10)
	,JOIAS("joias", "web/img/joia.png", 100)
	,POCAO("pocao", "web/img/pocao.png", 10)
	,COMIDA("comida", "web/img/comida.png", 3)
	,OSSO("osso", "web/img/osso.png", 0)
	,CHAVE("chave", "web/img/chave.png", 1);
	
	String tesouro;
	String img;
	Integer valor;

	private TipoTesouro(String tesouro, String img, Integer valor) {
		this.tesouro = tesouro;
		this.img = img;
		this.valor = valor;
	}
	
	public String getTesouro() {
		return tesouro;
	}

	public String getImg() {
		return img;
	}

	public Integer getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "{\"nome\":\"" + this.tesouro + "\""
				+ ", \"img\":\"" + this.img + "\""
				+ ", \"valor\":\"" + this.valor + "\"}";
	}
}
