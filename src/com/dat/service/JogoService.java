package com.dat.service;

import java.util.HashMap;
import java.util.Map;

import com.dat.enums.ClassePersonagem;
import com.dat.enums.TipoEvento;
import com.dat.factory.EventoFactory;
import com.dat.factory.ProtagonistaFactory;
import com.dat.interfaces.Evento;
import com.dat.json.JSONObject;
import com.dat.model.Grupo;
import com.dat.model.Monstro;
import com.dat.model.Orc;
import com.dat.model.Protagonista;
import com.dat.util.EnumUtils;

public class JogoService {
	
	public Map<String, Grupo> grupo = new HashMap<String, Grupo>();
	public Map<String, Monstro> monstro = new HashMap<String, Monstro>();

	public String montarGrupo(Map<String, String[]> req) {
		
		ClassePersonagem classe0 = ClassePersonagem.valueOf(req.get("classe0")[0].toUpperCase());
		Protagonista protagonista0 = ProtagonistaFactory.buildProtagonista(classe0, buildFromJson(req.get("json0")[0]));
		
		ClassePersonagem classe1 = ClassePersonagem.valueOf(req.get("classe1")[0].toUpperCase());
		Protagonista protagonista1 = ProtagonistaFactory.buildProtagonista(classe1, buildFromJson(req.get("json1")[0]));
		
		ClassePersonagem classe2 = ClassePersonagem.valueOf(req.get("classe2")[0].toUpperCase());
		Protagonista protagonista2 = ProtagonistaFactory.buildProtagonista(classe2, buildFromJson(req.get("json2")[0]));
		
		Grupo herois = new Grupo(protagonista0, protagonista1, protagonista2);
		grupo.put(req.get("player")[0], herois);
		
		System.out.println("Novo grupo criado.\nPlayer: " + req.get("player")[0] + "\n");
		
		return grupo.get(req.get("player")[0]).toString();
	}
	
	public JSONObject buildFromJson(String json) {
		return new JSONObject(json);
	}

	public String gerarEvento(String player) {
		Evento evento = EventoFactory.buildEvento(EnumUtils.randomEnum(TipoEvento.class));
		
		if(evento instanceof Orc) {
			monstro.put(player, (Monstro) evento);
		}
		
		return evento.toString();
	}

	public Protagonista getProtagonista(ClassePersonagem classe, String player) {
		return grupo.get(player).getProtagonista(classe);
	}
}
