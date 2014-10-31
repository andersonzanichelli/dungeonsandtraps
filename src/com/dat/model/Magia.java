package com.dat.model;

import java.util.ArrayList;
import java.util.List;

import com.dat.json.JSONArray;

public class Magia {

	private String nome;
	private Integer qtde;
	
	public Magia(String nome, Integer qtde) {
		this.nome = nome;
		this.qtde = qtde;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQtde() {
		return qtde;
	}
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	public static List<Magia> jsonToMagia(JSONArray jmagias) {
		List<Magia> magias = new ArrayList<Magia>();
		
		for(int i = 0; i < jmagias.length(); i++) {
			Object str = jmagias.get(i);
			String[] obj = str.toString().split(":");
			String nome = preparaAttributo(obj[0]);
			Integer qtde = new Integer(preparaAttributo(obj[1])); 
			Magia magia = new Magia(nome, qtde);
			magias.add(magia);
		}
		
		return magias;
	}

	private static String preparaAttributo(String attr) {
		return attr.replaceAll("[\\W]", "");
	}
}
