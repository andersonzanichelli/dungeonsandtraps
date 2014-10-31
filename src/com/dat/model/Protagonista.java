package com.dat.model;

import com.dat.enums.ClassePersonagem;
import com.dat.enums.Dado;
import com.dat.json.JSONObject;

public abstract class Protagonista extends Personagem {

	private ClassePersonagem classe = null;

	public Protagonista(ClassePersonagem classe, JSONObject jsonObject) {
		this.classe = classe;
		this.nome = classe.toString();
		this.forca = (Integer) jsonObject.get("forca");
		this.destreza = (Integer) jsonObject.get("destreza");
		this.constituicao = (Integer) jsonObject.get("constituicao");
		this.inteligencia = (Integer) jsonObject.get("inteligencia");
		this.sabedoria = (Integer) jsonObject.get("sabedoria");
		this.carisma = (Integer) jsonObject.get("carisma");
		this.ca = (Integer) jsonObject.get("ca");
		this.iniciativa = (Integer) jsonObject.get("iniciativa");
		this.deslocamento = (Integer) jsonObject.get("deslocamento");
		this.pv = (Integer) jsonObject.get("pv");
		this.fortitude = (Integer) jsonObject.get("fortitude");
		this.reflexos = (Integer) jsonObject.get("reflexos");
		this.vontade = (Integer) jsonObject.get("vontade");
		this.ataque = Dado.valueOf(jsonObject.get("ataque").toString().toUpperCase());
		this.distancia = (Integer) jsonObject.get("distancia");
		this.img = jsonObject.get("img").toString();
	}

	public ClassePersonagem getClasse() {
		return classe;
	}

	public void setClasse(ClassePersonagem classe) {
		this.classe = classe;
	}
}
