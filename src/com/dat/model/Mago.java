package com.dat.model;

import java.util.ArrayList;
import java.util.List;

import com.dat.enums.ClassePersonagem;
import com.dat.interfaces.Conjurador;
import com.dat.json.JSONArray;
import com.dat.json.JSONObject;

public class Mago extends Protagonista implements Conjurador {

	List<Magia> magias = new ArrayList<Magia>();
	
	public Mago(JSONObject jsonObject) {
		super(ClassePersonagem.MAGO, jsonObject);
		JSONArray jmagias = (JSONArray) jsonObject.get("magia");
		magias = Magia.jsonToMagia(jmagias);
	}

	@Override
	public Integer lancarMagia(Magia magia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Magia> getMagias() {
		return magias;
	}

	@Override
	public void setMagias(List<Magia> magias) {
		this.magias = magias;
	}

}
