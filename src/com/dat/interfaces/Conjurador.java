package com.dat.interfaces;

import java.util.List;

public interface Conjurador {
	
	public Integer lancarMagia(String magia);
	
	public List<String> getMagias();
	public void setMagias(List<String> magias);
}
