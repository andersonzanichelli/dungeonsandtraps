package com.dat.enums;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

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
		Integer resultadoLancamento = Dado.D4.lancamento();
		assertTrue(rangeD4.contains(resultadoLancamento));
	}
	
	@Test
	public void d6test() {
		Integer resultadoLancamento = Dado.D6.lancamento();
		assertTrue(rangeD6.contains(resultadoLancamento));
	}
	
	@Test
	public void d8test() {
		Integer resultadoLancamento = Dado.D8.lancamento();
		assertTrue(rangeD8.contains(resultadoLancamento));
	}
	
	@Test
	public void d10test() {
		Integer resultadoLancamento = Dado.D10.lancamento();
		assertTrue(rangeD10.contains(resultadoLancamento));
	}
	
	@Test
	public void d12test() {
		Integer resultadoLancamento = Dado.D12.lancamento();
		assertTrue(rangeD12.contains(resultadoLancamento));
	}
	
	@Test
	public void d20test() {
		Integer resultadoLancamento = Dado.D20.lancamento();
		assertTrue(rangeD20.contains(resultadoLancamento));
		System.out.println(resultadoLancamento);
	}
}
