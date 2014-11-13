package com.dat.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dat.enums.Habilidade;
import com.dat.service.JogoService;

public class ProtagonistaTest {
	
	String json = "{"
			+"  \"classe\": \"mago\""
			+", \"forca\": 10"
			+", \"destreza\": 12"
			+", \"constituicao\": 13"
			+", \"inteligencia\": 18"
			+", \"sabedoria\": 15"
			+", \"carisma\": 13"
			+", \"ca\":  12"
			+", \"iniciativa\":  5"
			+", \"deslocamento\": 10"
			+", \"pv\":  18"
			+", \"fortitude\": 2"
			+", \"reflexos\":  2"
			+", \"vontade\":   8"
			+", \"ataque\":\"d6\""
			+", \"distancia\": 0"
			+", \"magia\": [{\"flexa_acida\": 3}"
			+"			,{\"golpe_raio\": 2}"
			+"			,{\"maos_ardentes\": 2}"
			+"			,{\"escudo_arcano\": 2}]"
			+", \"img\": \"web/img/mago.png\" }";

	@Test
	public void habilidadeTest() {
		JogoService jogoService = new JogoService();
		Protagonista protagonista = new Mago(jogoService.buildFromJson(json));
		assertTrue("Passou no teste", protagonista.testeDeResistencia(0, Habilidade.VONTADE));
		assertFalse("Falhou no teste", protagonista.testeDeResistencia(23, Habilidade.FORTITUDE));
	}

}
