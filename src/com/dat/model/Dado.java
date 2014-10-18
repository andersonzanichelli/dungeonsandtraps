package com.dat.model;

public enum Dado {

	D4("d4")
	, D6("d6")
	, D8("d8")
	, D10("d10")
	, D12("d12")
	, D20("d20");
	
	String dado;
	
	Dado(String dado) {
		this.dado = dado;
	}
}
