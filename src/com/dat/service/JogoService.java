package com.dat.service;

import java.util.HashMap;
import java.util.Map;

import com.dat.enums.ClassePersonagem;
import com.dat.factory.ProtagonistaFactory;
import com.dat.model.Grupo;
import com.dat.model.Protagonista;

public class JogoService {

	public static Grupo montarGrupo(Map<String, String[]> req) {
		
		Map<String, Protagonista> classes = new HashMap<String, Protagonista>();
		Map<String, String> jsons = new HashMap<String, String>();
		
		for(String key : req.keySet()) {
			if(key.startsWith("classe")) {
				ClassePersonagem classe = ClassePersonagem.valueOf(req.get(key)[0].toUpperCase());
				Protagonista protagonista = ProtagonistaFactory.buildProtagonista(classe);
				classes.put(key, protagonista);
			} else if(key.startsWith("json")) {
				jsons.put(key, req.get(key)[0]);
			}
		}
		
		classes.get("classe0").setJson(jsons.get("json0"));
		classes.get("classe1").setJson(jsons.get("json1"));
		classes.get("classe2").setJson(jsons.get("json2"));
		
		return new Grupo(classes.get("classe0"), classes.get("classe1"), classes.get("classe2"));
	}

}
