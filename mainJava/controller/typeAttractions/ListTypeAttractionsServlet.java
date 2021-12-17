package controller.typeAttractions;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ListTypeAttractionsServlet
 */
@WebServlet("/typeAttractions/index.do")
public class ListTypeAttractionsServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 178847280816194092L;
	private typeAttractionService typeAttractionService;

	@Override
	public void init() throws ServletException {
		super.init();
		typeAttractionService = new typeAttractionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<typeAttraction> typeAttractions = typeAttractionService.List();
		req.setAttribute("typeAttractions", typeAttractions);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/typeAttractions/index.jsp");
		dispatcher.forward(req, resp);
	}

}