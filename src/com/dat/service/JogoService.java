package com.dat.service;

import java.util.Map;

import com.dat.enums.ClassePersonagem;
import com.dat.factory.ProtagonistaFactory;
import com.dat.json.JSONObject;
import com.dat.model.Grupo;
import com.dat.model.Protagonista;

public class JogoService {
	
	public static Grupo grupo = null;

	public static void montarGrupo(Map<String, String[]> req) {
		
		ClassePersonagem classe0 = ClassePersonagem.valueOf(req.get("classe0")[0].toUpperCase());
		Protagonista protagonista0 = ProtagonistaFactory.buildProtagonista(classe0, buildFromJson(req.get("json0")[0]));
		
		ClassePersonagem classe1 = ClassePersonagem.valueOf(req.get("classe1")[0].toUpperCase());
		Protagonista protagonista1 = ProtagonistaFactory.buildProtagonista(classe1, buildFromJson(req.get("json1")[0]));
		
		ClassePersonagem classe2 = ClassePersonagem.valueOf(req.get("classe2")[0].toUpperCase());
		Protagonista protagonista2 = ProtagonistaFactory.buildProtagonista(classe2, buildFromJson(req.get("json2")[0]));
		
		grupo = new Grupo(protagonista0, protagonista1, protagonista2);
	}
	
	private static JSONObject buildFromJson(String json) {
		return new JSONObject(json);
	}

}
