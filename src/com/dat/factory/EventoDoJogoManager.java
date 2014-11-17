package com.dat.factory;

import java.util.Map;

import com.dat.enums.ClassePersonagem;
import com.dat.enums.EventosDoJogo;
import com.dat.enums.Habilidade;
import com.dat.model.Protagonista;
import com.dat.model.Tesouro;
import com.dat.service.JogoService;

public class EventoDoJogoManager {
	
	private JogoService jogoService = new JogoService();

	public String manage(String acao, Map<String, String[]> req) {
		
		EventosDoJogo evento = EventosDoJogo.valueOf(acao.toUpperCase());
		
		switch(evento) {
		
			case GRUPO:
				return jogoService.montarGrupo(req);
				
			case ENCERRAR:
				jogoService.grupo = null;
				return "{\"status\": \"Game Over\"}";
				
			case EVENTO:
				return jogoService.gerarEvento();
				
			case ARMADILHA:
				return tratarArmadilha(req);
				
			case DANO_ARMADILHA:
				return tratarDanoArmadilha(req);
				
			case TESOURO:
				return tratarTesouro(req);
				
			default:
				throw new IllegalArgumentException(evento + ". Esse evento não foi reconhecido!");
		}
	}

	private String tratarTesouro(Map<String, String[]> req) {
		Tesouro tesouro = new Tesouro(req.get("nome")[0], req.get("img")[0], new Integer(req.get("valor")[0]));
		Protagonista protagonista = getProtagonista(req.get("classe")[0].toUpperCase());
		protagonista.porTesouroNaBolsa(tesouro);
		
		return jogoService.grupo.toString();
	}

	private String tratarDanoArmadilha(Map<String, String[]> req) {
		Integer dano = new Integer(req.get("dano")[0]);
		Protagonista protagonista = getProtagonista(req.get("classe")[0].toUpperCase());
		protagonista.sofrerDano(dano);
		
		return jogoService.grupo.toString();
	}

	private String tratarArmadilha(Map<String, String[]> req) {
		
		Habilidade habilidade = Habilidade.valueOf(req.get("habilidade")[0]);
		Integer dificuldade = new Integer(req.get("dificuldade")[0]);
		Protagonista protagonista = getProtagonista(req.get("classe")[0].toUpperCase());
		
		return protagonista.testeDeResistencia(dificuldade, habilidade);
	}
	
	private Protagonista getProtagonista(String c) {
		ClassePersonagem classe = ClassePersonagem.valueOf(c);
		Protagonista protagonista = jogoService.getProtagonista(classe);
		return protagonista;
	}
}
