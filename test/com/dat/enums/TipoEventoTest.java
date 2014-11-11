package com.dat.enums;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.dat.util.EnumUtils;

public class TipoEventoTest {

	@Test
	public void tipoEventoRandomTest() {
		TipoEvento[] eventos = TipoEvento.values();
		TipoEvento evento = EnumUtils.randomEnum(TipoEvento.class);
		assertTrue(Arrays.asList(eventos).contains(evento));
	}
	
	@Test
	public void getOrcTest() {
		TipoEvento orc = TipoEvento.valueOf("ORCS");
		assertEquals(orc, TipoEvento.ORCS);
	}
	
	@Test
	public void getTesouroTest() {
		TipoEvento tesouro = TipoEvento.valueOf("TESOURO");
		assertEquals(tesouro, TipoEvento.TESOURO);
	}
}
