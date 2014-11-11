package com.dat.model;

import com.dat.interfaces.Evento;

public class Nenhum implements Evento{

	public Nenhum() {
	}

	@Override
	public String toString() {
		return "{ \"tipo\": \"nenhum\" }";
	}
}
