package com.dat.model;

import java.util.ArrayList;
import java.util.List;

import com.dat.enums.ClassePersonagem;
import com.dat.interfaces.Conjurador;

public class Mago extends Protagonista implements Conjurador {

	List<String> magias = new ArrayList<String>();
	
	public Mago() {
		super(ClassePersonagem.MAGO);
	}

	@Override
	public Integer lancarMagia(String magia) {
		// TODO Auto-generated method stub
		return null;
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
