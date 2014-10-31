package com.dat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dat.model.Grupo;
import com.dat.service.JogoService;

@WebServlet("/jogoController")
public class JogoController extends HttpServlet{

	private static final long serialVersionUID = -7412285655843378898L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String acao = request.getParameter("acao");
		Map<String, String[]> req = request.getParameterMap();
		
		if(acao.equals("grupo")) {
			Grupo grupo = JogoService.montarGrupo(req);
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("{\"status\":\"success\"}");
		out.close();
	}

}
