package com.dat.model;

import com.dat.enums.Dado;
import com.dat.enums.Habilidade;
import com.dat.enums.TipoArmadilha;
import com.dat.interfaces.Evento;
import com.dat.util.EnumUtils;

public class Armadilha implements Evento {

	private String nome;
	private Dado dano;
	private String img;
	private Integer dificuldade;
	private Habilidade habilidade;
	
	public Armadilha() {
		Armadilha a = geradorArmadilha();
		this.nome = a.getNome();
		this.dano = a.getDado();
		this.img = a.getImg();
		this.dificuldade = a.getDificuldade();
		this.habilidade = a.getHabilidade();
	}


	private Armadilha(String nome, Dado dado, String img, Integer dificuldade, Habilidade habilidade) {
		this.nome = nome;
		this.dano = dado;
		this.img = img;
		this.dificuldade = dificuldade;
		this.habilidade = habilidade;
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
	
	public Integer getDificuldade() {
		return dificuldade;
	}
	
	public Habilidade getHabilidade() {
		return habilidade;
	}
	
	private Armadilha geradorArmadilha() {
		TipoArmadilha tipoArmadilha = EnumUtils.randomEnum(TipoArmadilha.class);
		Armadilha armadilha = new Armadilha(tipoArmadilha.getArmadilha(), tipoArmadilha.getDano(), tipoArmadilha.getImg(), tipoArmadilha.getDificuldade(), tipoArmadilha.getHabilidade());
		return armadilha;
	}

	@Override
	public String toString() {
		return "{ \"tipo\": \"armadilha\""
				+ ", \"nome\": \"" + this.nome + "\""
				+ ", \"dano\": " + this.dano.lancar() + ""
				+ ", \"img\": \"" + this.img + "\""
				+ ", \"dificuldade\": " + this.dificuldade + ""
				+ ", \"habilidade\": \"" + this.habilidade + "\""
				+ "}";
	}
	
	
}
