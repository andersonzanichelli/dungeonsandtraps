package com.dat.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dat.enums.ClassePersonagem;
import com.dat.enums.Dado;
import com.dat.enums.Habilidade;
import com.dat.json.JSONObject;

public abstract class Protagonista extends Personagem {

	private ClassePersonagem classe = null;
	private Map<Habilidade, Integer> habilidades = new HashMap<Habilidade, Integer>(3);
	private List<Tesouro> tesouros = new ArrayList<Tesouro>();

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
		
		habilidades.put(Habilidade.FORTITUDE, this.fortitude);
		habilidades.put(Habilidade.REFLEXOS, this.reflexos);
		habilidades.put(Habilidade.VONTADE, this.vontade);
		
		this.vida = this.pv;
		this.po = 0;
	}

	public ClassePersonagem getClasse() {
		return classe;
	}

	public void setClasse(ClassePersonagem classe) {
		this.classe = classe;
	}
	
	public String testeDeResistencia(Integer teste, Habilidade habilidade) {
		Boolean passou = false;
		
		Integer d20 = Dado.D20.lancar();
		Integer bonus = habilidades.get(habilidade);
		Integer total = d20 + bonus;
		
		if(total >= teste) {
			passou = true;
		}
		
		return "{ \"desviouArmadilha\": " + passou + ""
				+", \"d20\": \"" + d20 + " no d20 + " + bonus + " de bônus de " + habilidade.toString().toLowerCase() + " = " + total + "\""
				+"}";
	}
	
	public void porTesouroNaBolsa(Tesouro tesouro) {
		this.tesouros.add(tesouro);
		this.po += tesouro.getValor();
	}
	
	public String getJsonTesouro() {
		StringBuffer tesouro = new StringBuffer();
		int i = 0;
		
		for (Tesouro t : tesouros) {
			tesouro.append(t.toString());

			if(i < (tesouros.size() - 1)) {
				i++;
				tesouro.append(",");
			}
		}
		
		return "[" + tesouro + "]";
	}
}
