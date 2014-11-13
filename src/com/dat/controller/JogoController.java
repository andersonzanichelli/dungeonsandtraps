package com.dat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dat.enums.ClassePersonagem;
import com.dat.enums.Habilidade;
import com.dat.model.Personagem;
import com.dat.model.Protagonista;
import com.dat.service.JogoService;

@WebServlet("/jogoController")
public class JogoController extends HttpServlet{
	
	private JogoService jogoService = new JogoService();

	private static final long serialVersionUID = -7412285655843378898L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String acao = request.getParameter("acao");
		Map<String, String[]> req = request.getParameterMap();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(acao.equals("grupo")) {
			out.println(jogoService.montarGrupo(req));
		}
		
		if(acao.equals("encerrar")) {
			jogoService.grupo = null;
		}
		
		if(acao.equals("evento")) {
			String jsonResposta = jogoService.gerarEvento();
			out.println(jsonResposta);
		}
		
		if(acao.equals("armadilha")) {
			Habilidade habilidade = Habilidade.valueOf(req.get("habilidade")[0]);
			Integer dificuldade = new Integer(req.get("dificuldade")[0]);
			ClassePersonagem classe = ClassePersonagem.valueOf(req.get("classe")[0].toUpperCase());
			Protagonista protagonista = jogoService.getProtagonista(classe);
			
			out.println(jogoService.realizarTesteHabilidade(protagonista, dificuldade, habilidade));
		}
		
		if(acao.equals("danoArmadilha")) {
			Integer dano = new Integer(req.get("dano")[0]);
			ClassePersonagem classe = ClassePersonagem.valueOf(req.get("classe")[0].toUpperCase());
			Protagonista protagonista = jogoService.getProtagonista(classe);
			protagonista.sofrerDano(dano);
			
			out.println(jogoService.grupo.toString());
		}
		
		out.close();
	}

}
