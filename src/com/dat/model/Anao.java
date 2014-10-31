package com.dat.model;

import com.dat.enums.ClassePersonagem;
import com.dat.json.JSONObject;

public class Anao extends Protagonista {

	public Anao(JSONObject jsonObject) {
		super(ClassePersonagem.ANAO, jsonObject);
	}
}
