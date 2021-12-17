package controller.typeAttractions;


import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.typeAttraction;
import services.typeAttractionService;

/**
 * Servlet implementation class EditTypeAttractionsServlet
 */
@WebServlet("/typeAttractions/delete.do")
public class DeleteTypeAttractionsServlet extends HttpServlet implements Servlet {


	private static final long serialVersionUID = 8411966518313238499L;
	typeAttractionService typeAttractionService;

	@Override
	public void init() throws ServletException {
		super.init();
		typeAttractionService = new typeAttractionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		typeAttractionService.delete(id);


		resp.sendRedirect("/final1/index.jsp");


	}


}