package com.dat.model;

import com.dat.enums.ClassePersonagem;
import com.dat.json.JSONObject;

public class Barbaro extends Protagonista {

	public Barbaro(JSONObject jsonObject) {
		super(ClassePersonagem.BARBARO, jsonObject);
	}
}
