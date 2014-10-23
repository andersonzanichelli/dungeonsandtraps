package com.dat.model;

import java.util.ArrayList;
import java.util.List;

import com.dat.enums.ClassePersonagem;
import com.dat.interfaces.Conjurador;

public class Sacerdotisa extends Protagonista implements Conjurador {

	List<String> magias = new ArrayList<String>();
	
	public Sacerdotisa() {
		super(ClassePersonagem.SACERDOTISA);
	}

	@Override
	public Integer lancarMagia(String magia) {
		return 0;
	}

	@Override
	public List<String> getMagias() {
		return magias;
	}

	@Override
	public void setMagias(List<String> magias) {
		this.magias = magias;
	}
	
}
