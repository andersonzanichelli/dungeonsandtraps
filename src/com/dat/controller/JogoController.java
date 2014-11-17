package com.dat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dat.factory.EventoDoJogoManager;
import com.dat.service.JogoService;

@WebServlet("/jogoController")
public class JogoController extends HttpServlet{
	
	private static final long serialVersionUID = -7412285655843378898L;
	
	private EventoDoJogoManager eventosManager = new EventoDoJogoManager();
	private JogoService jogoService = new JogoService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			String acao = request.getParameter("acao");
			Map<String, String[]> req = request.getParameterMap();
			
			out.println(eventosManager.manage(acao, req, jogoService));
			
			out.close();
			
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			out.println("\"alert(\"" + e.getMessage() + "\");");
		}
	}

}
