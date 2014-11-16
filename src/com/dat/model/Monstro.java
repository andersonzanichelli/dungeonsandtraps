package com.dat.model;

public class Monstro extends Personagem {

	private String tipo = "inimigo";
	
	@Override
	public String toString() {
		String person = super.toString();
		return person.replace("{", "{\"tipo\":\"" + tipo + "\", ");
	}
}
