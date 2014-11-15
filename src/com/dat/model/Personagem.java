package com.dat.model;

import com.dat.enums.Dado;
import com.dat.enums.Status;

public abstract class Personagem {

	protected String nome;
	
	protected Integer vida = null;
	protected Status status = Status.VIVO;
	
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
	
	protected Integer po;
	
	public void sofrerDano(Integer dano) {
		this.pv -= dano;
		
		this.status = Status.qualStatus(this.vida, this.pv);
	}
	
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
				+ ", \"status\": \""+ this.status +"\""
				+ ", \"po\": \""+ this.po +"\""
				+ "}";
	}
}
