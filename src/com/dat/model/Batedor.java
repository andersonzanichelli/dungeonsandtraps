package com.dat.model;

import com.dat.enums.ClassePersonagem;
import com.dat.json.JSONObject;

public class Batedor extends Protagonista {

	public Batedor(JSONObject jsonObject) {
		super(ClassePersonagem.BATEDOR, jsonObject);
	}
}
