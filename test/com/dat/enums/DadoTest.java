package com.dat.enums;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DadoTest {

	List<Integer> rangeD4 = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
	List<Integer> rangeD6 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
	List<Integer> rangeD8 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8));
	List<Integer> rangeD10 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
	List<Integer> rangeD12 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12));
	List<Integer> rangeD20 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));

	
	@Test
	public void d4test() {
		Integer resultadoLancamento = Dado.D4.lancar();
		assertTrue(rangeD4.contains(resultadoLancamento));
	}
	
	@Test
	public void d6test() {
		Integer resultadoLancamento = Dado.D6.lancar();
		assertTrue(rangeD6.contains(resultadoLancamento));
	}
	
	@Test
	public void d8test() {
		Integer resultadoLancamento = Dado.D8.lancar();
		assertTrue(rangeD8.contains(resultadoLancamento));
	}
	
	@Test
	public void d10test() {
		Integer resultadoLancamento = Dado.D10.lancar();
		assertTrue(rangeD10.contains(resultadoLancamento));
	}
	
	@Test
	public void d12test() {
		Integer resultadoLancamento = Dado.D12.lancar();
		assertTrue(rangeD12.contains(resultadoLancamento));
	}
	
	@Test
	public void d20test() {
		Integer resultadoLancamento = Dado.D20.lancar();
		assertTrue(rangeD20.contains(resultadoLancamento));
		System.out.println(resultadoLancamento);
	}
}
