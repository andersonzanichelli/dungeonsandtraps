package com.dat.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesouroTest {

	@Test
	public void construtorTest() {
		Tesouro tesouro = new Tesouro();
		assertNotNull("Foi criado um tesouro", tesouro);
	}
}
