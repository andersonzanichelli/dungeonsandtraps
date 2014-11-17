package com.dat.factory;

import java.util.Map;

import com.dat.enums.ClassePersonagem;
import com.dat.enums.EventosDoJogo;
import com.dat.enums.Habilidade;
import com.dat.model.Protagonista;
import com.dat.model.Tesouro;
import com.dat.service.JogoService;

public class EventoDoJogoManager {
	
	public String manage(String acao, Map<String, String[]> req, JogoService jogoService) {
		
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
				return tratarArmadilha(req, jogoService);
				
			case DANO_ARMADILHA:
				tratarDanoArmadilha(req, jogoService);
				return jogoService.grupo.get(req.get("player")[0]).toString();
				
			case TESOURO:
				tratarTesouro(req, jogoService);
				return jogoService.grupo.get(req.get("player")[0]).toString();
				
			default:
				throw new IllegalArgumentException(evento + ". Esse evento não foi reconhecido!");
		}
	}

	private void tratarTesouro(Map<String, String[]> req, JogoService jogoService) {
		Tesouro tesouro = new Tesouro(req.get("nome")[0], req.get("img")[0], new Integer(req.get("valor")[0]));
		ClassePersonagem classe = ClassePersonagem.valueOf(req.get("classe")[0].toUpperCase());
		Protagonista protagonista = jogoService.getProtagonista(classe, req.get("player")[0]);
		protagonista.porTesouroNaBolsa(tesouro);
	}

	private void tratarDanoArmadilha(Map<String, String[]> req, JogoService jogoService) {
		Integer dano = new Integer(req.get("dano")[0]);
		ClassePersonagem classe = ClassePersonagem.valueOf(req.get("classe")[0].toUpperCase());
		Protagonista protagonista = jogoService.getProtagonista(classe, req.get("player")[0]);
		protagonista.sofrerDano(dano);
	}

	private String tratarArmadilha(Map<String, String[]> req, JogoService jogoService) {
		
		Habilidade habilidade = Habilidade.valueOf(req.get("habilidade")[0]);
		Integer dificuldade = new Integer(req.get("dificuldade")[0]);
		ClassePersonagem classe = ClassePersonagem.valueOf(req.get("classe")[0].toUpperCase());
		Protagonista protagonista = jogoService.getProtagonista(classe, req.get("player")[0]);
		
		
		return protagonista.testeDeResistencia(dificuldade, habilidade);
	}
}
