package com.dat.model;

import com.dat.enums.Dado;

public abstract class Personagem {

	protected String nome;
	
	protected Integer forca;
	protected Integer destreza;
	protected Integer constituicao;
	protected Integer inteligencia;
	protected Integer sabedoria;
	protected Integer carisma;
	
	protected Integer pv;
	protected Integer ca;
	
	protected Integer deslocamento;
	protected Integer iniciativa;
	
	protected Integer fortitude;
	protected Integer reflexos;
	protected Integer vontade;
	
	protected Dado ataque;
	protected Integer distancia;
	protected String img;
	
	@Override
	public String toString() {
		return "{\"classe\": \""+ this.nome +"\""
				+ ", \"forca\": \""+ this.forca +"\""
				+ ", \"constituicao\": \""+ this.constituicao +"\""
				+ ", \"inteligencia\": \""+ this.inteligencia +"\""
				+ ", \"sabedoria\": \""+ this.sabedoria +"\""
				+ ", \"carisma\": \""+ this.carisma +"\""
				+ ", \"pv\": \""+ this.pv +"\""
				+ ", \"ca\": \""+ this.ca +"\""
				+ ", \"deslocamento\": \""+ this.deslocamento +"\""
				+ ", \"iniciativa\": \""+ this.iniciativa +"\""
				+ ", \"fortitude\": \""+ this.fortitude +"\""
				+ ", \"reflexos\": \""+ this.reflexos +"\""
				+ ", \"vontade\": \""+ this.vontade +"\""
				+ ", \"ataque\": \""+ this.ataque.toString() +"\""
				+ ", \"distancia\": \""+ this.distancia +"\""
				+ ", \"img\": \""+ this.img +"\""
				+ "}";
	}
}
