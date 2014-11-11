package com.dat.factory;

import com.dat.enums.TipoEvento;
import com.dat.interfaces.Evento;
import com.dat.model.Armadilha;
import com.dat.model.Nenhum;
import com.dat.model.Orc;
import com.dat.model.Tesouro;

public class EventoFactory {

	public static Evento buildEvento(TipoEvento tipoEvento) {
		Evento evento = null;
		
		switch (tipoEvento) {
			case ARMADILHA:
				evento = new Armadilha();
				break;
			
			case NENHUM:
				evento = new Nenhum();
				break;
				
			case ORCS:
				evento = new Orc();
				break;
				
			case TESOURO:
				evento = new Tesouro();
				break;
				
			default:
				throw new IllegalArgumentException("Evento não reconhecido.");
		}
		
		return evento;
	}
}
