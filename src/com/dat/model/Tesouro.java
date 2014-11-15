package com.dat.model;

import com.dat.enums.TipoTesouro;
import com.dat.interfaces.Evento;
import com.dat.util.EnumUtils;

public class Tesouro implements Evento {

	private String nome;
	private String img;
	private Integer valor;
	
	public Tesouro() {
		Tesouro t = geradorTesouro();
		this.nome = t.getNome();
		this.img = t.getImg();
		this.valor = t.getValor();
	}
	
	private Tesouro(String nome, String img, Integer valor) {
		this.nome = nome;
		this.img = img;
		this.valor = valor;
	}

	private String getNome() {
		return nome;
	}

	private String getImg() {
		return img;
	}

	public Integer getValor() {
		return valor;
	}

	private Tesouro geradorTesouro() {
		TipoTesouro tipoTesouro = EnumUtils.randomEnum(TipoTesouro.class);
		Tesouro tesouro = new Tesouro(tipoTesouro.getTesouro(), tipoTesouro.getImg(), tipoTesouro.getValor());
		return tesouro;
	}

	@Override
	public String toString() {
		return "{ \"tipo\": \"tesouro\""
				+ ", \"nome\": \"" + this.nome + "\""
				+ ", \"img\": \"" + this.img + "\""
				+ ", \"valor\": " + this.valor + "}";
	}
}
