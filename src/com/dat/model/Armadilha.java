package com.dat.model;

import com.dat.enums.Dado;
import com.dat.enums.TipoArmadilha;
import com.dat.interfaces.Evento;
import com.dat.util.EnumUtils;

public class Armadilha implements Evento {

	private String nome;
	private Dado dano;
	private String img;
	
	public Armadilha() {
		Armadilha a = geradorArmadilha();
		this.nome = a.getNome();
		this.dano = a.getDado();
		this.img = a.getImg();
	}


	private Armadilha(String nome, Dado dado, String img) {
		this.nome = nome;
		this.dano = dado;
		this.img = img;
	}

	private String getNome() {
		return nome;
	}

	private Dado getDado() {
		return dano;
	}
	
	private String getImg() {
		return img;
	}
	
	private Armadilha geradorArmadilha() {
		TipoArmadilha tipoArmadilha = EnumUtils.randomEnum(TipoArmadilha.class);
		Armadilha armadilha = new Armadilha(tipoArmadilha.getArmadilha(), tipoArmadilha.getDado(), tipoArmadilha.getImg());
		return armadilha;
	}

	@Override
	public String toString() {
		return "{ \"tipo\": \"armadilha\""
				+ ", \"nome\": \"" + this.nome + "\""
				+ ", \"dado\": " + this.dano.lancar() + ""
				+ ", \"img\": \"" + this.img + "\""
				+ "}";
	}
	
	
}
