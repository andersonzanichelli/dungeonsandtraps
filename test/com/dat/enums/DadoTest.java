package com.dat.enums;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DadoTest {

	List<Integer> rangeD4 = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
	List<Integer> rangeD6 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
	
	@Test
	public void d4test() {
		Integer resultadoLancamento = Dado.D4.lancamento();
		assertTrue(rangeD4.contains(resultadoLancamento));
	}
	
	@Test
	public void d6test() {
		Integer resultadoLancamento = Dado.D6.lancamento();
		assertTrue(rangeD6.contains(resultadoLancamento));
	}
}
