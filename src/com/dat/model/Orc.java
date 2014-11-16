package com.dat.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.dat.enums.Dado;
import com.dat.interfaces.Evento;

public class Orc extends Monstro implements Evento {

	List<String> imgOrcs = new ArrayList<>(Arrays.asList(
			"web/img/orc0.png"
			,"web/img/orc1.png"
			,"web/img/orc2.png"
			,"web/img/orc3.png"
			,"web/img/orc4.png"
			,"web/img/orc5.png"));
	
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
		this.pv = Dado.D12.lancar();
		this.fortitude = 2;
		this.reflexos = 0;
		this.vontade = -1;
		this.ataque = Dado.valueOf("D8");
		this.distancia = 0;
		this.img = getImgAleatoria();
	}

	private String getImgAleatoria() {
		Random random = new Random();
		Integer indice = random.nextInt(imgOrcs.size()) + 1;
		
		return imgOrcs.get(indice);
	}
}
