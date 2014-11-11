package com.dat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		out.close();
	}

}
