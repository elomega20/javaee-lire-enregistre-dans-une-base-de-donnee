package com.el.servlet;

import java.io.IOException;

import com.el.bdd.Noms;
import com.el.beans.Utilisateur;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Noms tableNoms = new Noms();
		request.setAttribute("utilisateurs", tableNoms.recupererUtilisateurs());
		this.getServletContext().getRequestDispatcher("/WEB-INF/vue.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom(request.getParameter("nom"));
		utilisateur.setPrenom(request.getParameter("prenom"));

		Noms tableNoms = new Noms();
		tableNoms.ajouterUtilisateur(utilisateur);

		request.setAttribute("utilisateurs", tableNoms.recupererUtilisateurs());

		this.getServletContext().getRequestDispatcher("/WEB-INF/vue.jsp").forward(request, response);
	}

}
