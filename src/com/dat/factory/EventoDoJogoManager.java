package com.dat.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.dat.enums.ClassePersonagem;
import com.dat.enums.Dado;
import com.dat.enums.EventosDoJogo;
import com.dat.enums.Habilidade;
import com.dat.enums.Status;
import com.dat.model.Grupo;
import com.dat.model.Monstro;
import com.dat.model.Personagem;
import com.dat.model.Protagonista;
import com.dat.model.Tesouro;
import com.dat.service.JogoService;

public class EventoDoJogoManager {

	public String manage(String acao, Map<String, String[]> req,
			JogoService jogoService) {

		EventosDoJogo evento = EventosDoJogo.valueOf(acao.toUpperCase());

		switch (evento) {

		case GRUPO:
			return jogoService.montarGrupo(req);

		case ENCERRAR:
			jogoService.grupo = new HashMap<String, Grupo>();
			return "{\"status\": \"Game Over\"}";

		case EVENTO:
			return jogoService.gerarEvento(req.get("player")[0]);

		case ARMADILHA:
			return tratarArmadilha(req, jogoService);

		case DANO_ARMADILHA:
			tratarDanoArmadilha(req, jogoService);
			return jogoService.grupo.get(req.get("player")[0]).toString();

		case TESOURO:
			tratarTesouro(req, jogoService);
			return jogoService.grupo.get(req.get("player")[0]).toString();

		case INICIATIVA:
			return rolarIniciativa(req.get("player")[0], jogoService);
		
		case ATACAR:
			return tratarAtaque(req, jogoService);

		default:
			throw new IllegalArgumentException(evento
					+ ". Esse evento não foi reconhecido!");
		}
	}

	private String tratarAtaque(Map<String, String[]> req, JogoService jogoService) {
		Monstro monstro = jogoService.monstro.get(req.get("player")[0]);
		
		ClassePersonagem classe = ClassePersonagem.valueOf(req.get("classe")[0].toUpperCase());
		Protagonista protagonista = jogoService.getProtagonista(classe, req.get("player")[0]);
		
		String dado = protagonista.getAtaque();
		Integer dano = protagonista.atacar();
		monstro.sofrerDano(dano);
		
		String retorno = "";
		
		if(monstro.getStatus().equals(Status.MORTO)) {
			retorno = "[ {\"dado\": \"" + dado + "\""
					+ ", \"dano\": " + dano + ""
					+ ", \"classe\": \"" + classe.toString() + "\"}"
					+ ", " + monstro.toString()
					+ "]";
		} else {
			String dadoMonstro = monstro.getAtaque();
			Integer danoMonstro = monstro.atacar();
			protagonista.sofrerDano(danoMonstro);
			
			retorno = "[ {\"dado\": \"" + dado + "\""
					+ ", \"dano\": " + dano + ""
					+ ", \"classe\": \"" + classe.toString() + "\"}"
					+ ", " + monstro.toString()
					+ ", {\"dadoMonstro\": \"" + dadoMonstro + "\""
					+ ", \"danoMonstro\": " + danoMonstro + "}"
					+ "," + jogoService.grupo.get(req.get("player")[0])
					+ "]";
		}
		
		System.out.println(retorno);
		return retorno;
	}

	private String rolarIniciativa(String player, JogoService jogoService) {

		TreeMap<Integer, Personagem> ordem = new TreeMap<Integer, Personagem>();
		Grupo herois = jogoService.grupo.get(player);
		Monstro monstro = jogoService.monstro.get(player);
		
		StringBuffer json = new StringBuffer();

		ordem.put(Dado.D20.lancar() + monstro.getIniciativa(), monstro);

		for (ClassePersonagem classe : herois.getGrupo().keySet()) {
			Protagonista protagonista = herois.getProtagonista(classe);
			ordem.put(Dado.D20.lancar() + protagonista.getIniciativa(),
					protagonista);
		}

		json.append("[");
		int i = 0;
		
		for (Map.Entry<Integer, Personagem> entry : ordem.entrySet()) {
			Integer key = entry.getKey();
			Personagem value = entry.getValue();

			json.append("{\"" + value.getNome() + "\":");
			json.append("\"" + key + "\"}");
			
			if(i < (ordem.size() - 1)) {
				json.append(",");
				i++;
			}
		}
		
		json.append("]");
		
		System.out.println(json);

		return json.toString();
	}

	private void tratarTesouro(Map<String, String[]> req,
			JogoService jogoService) {
		Tesouro tesouro = new Tesouro(req.get("nome")[0], req.get("img")[0],
				new Integer(req.get("valor")[0]));
		ClassePersonagem classe = ClassePersonagem.valueOf(req.get("classe")[0]
				.toUpperCase());
		Protagonista protagonista = jogoService.getProtagonista(classe,
				req.get("player")[0]);
		protagonista.porTesouroNaBolsa(tesouro);
	}

	private void tratarDanoArmadilha(Map<String, String[]> req,
			JogoService jogoService) {
		Integer dano = new Integer(req.get("dano")[0]);
		ClassePersonagem classe = ClassePersonagem.valueOf(req.get("classe")[0]
				.toUpperCase());
		Protagonista protagonista = jogoService.getProtagonista(classe,
				req.get("player")[0]);
		protagonista.sofrerDano(dano);
	}

	private String tratarArmadilha(Map<String, String[]> req,
			JogoService jogoService) {

		Habilidade habilidade = Habilidade.valueOf(req.get("habilidade")[0]);
		Integer dificuldade = new Integer(req.get("dificuldade")[0]);
		ClassePersonagem classe = ClassePersonagem.valueOf(req.get("classe")[0]
				.toUpperCase());
		Protagonista protagonista = jogoService.getProtagonista(classe,
				req.get("player")[0]);

		return protagonista.testeDeResistencia(dificuldade, habilidade);
	}
}
