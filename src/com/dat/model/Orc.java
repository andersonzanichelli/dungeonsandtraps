package com.dat.model;

import com.dat.enums.Dado;
import com.dat.interfaces.Evento;

public class Orc extends Monstro implements Evento {

	public Orc() {
		this.nome = "orc";
		this.forca = 15;
		this.destreza = 10;
		this.constituicao = 11;
		this.inteligencia = 9;
		this.sabedoria = 8;
		this.carisma = 8;
		this.ca = 14;
		this.iniciativa = 0;
		this.deslocamento = 6;
		this.pv = 4;
		this.fortitude = 2;
		this.reflexos = 0;
		this.vontade = -1;
		this.ataque = Dado.valueOf("D12");
		this.distancia = 0;
		this.img = "web/img/orc.png";
	}
}
