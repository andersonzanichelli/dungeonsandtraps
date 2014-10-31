package com.dat.model;

import java.util.HashMap;
import java.util.Map;

import com.dat.enums.ClassePersonagem;

public class Grupo {

	private Map<ClassePersonagem, Protagonista> grupo = new HashMap<>(3);

	public Grupo(Protagonista p1, Protagonista p2, Protagonista p3) {
		grupo.put(p1.getClasse(), p1);
		grupo.put(p2.getClasse(), p2);
		grupo.put(p3.getClasse(), p3);
	}

	public Map<ClassePersonagem, Protagonista> getGrupo() {
		return grupo;
	}
}
