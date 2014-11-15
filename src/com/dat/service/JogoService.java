package com.dat.service;

import java.util.Map;

import com.dat.enums.ClassePersonagem;
import com.dat.enums.Habilidade;
import com.dat.enums.TipoEvento;
import com.dat.factory.EventoFactory;
import com.dat.factory.ProtagonistaFactory;
import com.dat.interfaces.Evento;
import com.dat.json.JSONObject;
import com.dat.model.Grupo;
import com.dat.model.Protagonista;
import com.dat.util.EnumUtils;

public class JogoService {
	
	public Grupo grupo = null;

	public String montarGrupo(Map<String, String[]> req) {
		
		ClassePersonagem classe0 = ClassePersonagem.valueOf(req.get("classe0")[0].toUpperCase());
		Protagonista protagonista0 = ProtagonistaFactory.buildProtagonista(classe0, buildFromJson(req.get("json0")[0]));
		
		ClassePersonagem classe1 = ClassePersonagem.valueOf(req.get("classe1")[0].toUpperCase());
		Protagonista protagonista1 = ProtagonistaFactory.buildProtagonista(classe1, buildFromJson(req.get("json1")[0]));
		
		ClassePersonagem classe2 = ClassePersonagem.valueOf(req.get("classe2")[0].toUpperCase());
		Protagonista protagonista2 = ProtagonistaFactory.buildProtagonista(classe2, buildFromJson(req.get("json2")[0]));
		
		grupo = new Grupo(protagonista0, protagonista1, protagonista2);
		
		return grupo.toString();
	}
	
	public JSONObject buildFromJson(String json) {
		return new JSONObject(json);
	}

	public String gerarEvento() {
		Evento evento = EventoFactory.buildEvento(EnumUtils.randomEnum(TipoEvento.class));
		
		return evento.toString();
	}

	public String realizarTesteHabilidade(Protagonista protagonista, Integer dificuldade, Habilidade habilidade) {
		return protagonista.testeDeResistencia(dificuldade, habilidade);
	}

	public Protagonista getProtagonista(ClassePersonagem classe) {
		return grupo.getProtagonista(classe);
	}
}
