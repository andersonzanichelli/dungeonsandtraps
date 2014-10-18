package com.dat.model;

import com.dat.enums.ClassePersonagem;

public abstract class Protagonista extends Personagem {

	private ClassePersonagem classe = null;
	private String json;

	public Protagonista(ClassePersonagem classe) {
		this.classe = classe;
	}

	public ClassePersonagem getClasse() {
		return classe;
	}

	public void setClasse(ClassePersonagem classe) {
		this.classe = classe;
	}
	
	public void setJson(String json) {
		this.json = json;
	}
}
