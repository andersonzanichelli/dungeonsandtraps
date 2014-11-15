package com.dat.enums;

import static org.junit.Assert.*;

import org.junit.Test;

public class StatusTest {

	@Test
	public void vivinhoTest() {
		assertEquals(Status.VIVO, Status.qualStatus(100, 100));
	}
	
	@Test
	public void vivoTest() {
		assertEquals(Status.VIVO, Status.qualStatus(100, 16));
	}
	
	@Test
	public void morrendoTest() {
		assertEquals(Status.MORRENDO, Status.qualStatus(100, 15));
	}

	@Test
	public void morrendoMaisTest() {
		assertEquals(Status.MORRENDO, Status.qualStatus(100, 14));
	}
	
	@Test
	public void mortoTest() {
		assertEquals(Status.MORTO, Status.qualStatus(100, 0));
	}
	
	@Test
	public void mortinhoDaSilvaTest() {
		assertEquals(Status.MORTO, Status.qualStatus(100, -15));
	}
}
