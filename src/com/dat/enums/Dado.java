package com.dat.enums;

import java.util.Random;

public enum Dado {
	
	  D4("d4", 4)
	, D6("d6", 6)
	, D8("d8", 8)
	, D10("d10", 10)
	, D12("d12", 12)
	, D20("d20", 20);
	
	String dado;
	Integer face;
	
	Dado(String dado, Integer face) {
		this.dado = dado;
		this.face = face;
	}
	
	public Integer lancar(){
		
		Random random = new Random();
		
		Integer faceDado = random.nextInt(face) + 1;
		
		return faceDado;
	}
	
	
}
