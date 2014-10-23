package com.dat.enums;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DadoTest {

	@Test
	public void d4test() {
		Integer lancamento = Dado.D4.lancamento();
		List<Integer> range = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
		assertTrue(range.contains(lancamento));
	}

}
