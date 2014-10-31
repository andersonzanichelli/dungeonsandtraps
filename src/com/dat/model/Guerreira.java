package com.dat.model;

import com.dat.enums.ClassePersonagem;
import com.dat.json.JSONObject;

public class Guerreira extends Protagonista {

	public Guerreira(JSONObject jsonObject) {
		super(ClassePersonagem.GUERREIRA, jsonObject);
	}

}
