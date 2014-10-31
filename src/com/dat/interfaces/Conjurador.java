package com.dat.interfaces;

import java.util.List;

import com.dat.model.Magia;

public interface Conjurador {
	
	public Integer lancarMagia(Magia magia);
	
	public List<Magia> getMagias();
	public void setMagias(List<Magia> magias);
}
