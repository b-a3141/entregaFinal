package controller.typeAttractions;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.typeAttractionService;


@WebServlet("/typeAttractions/create.do")
public class CreateTypeAttractionsServlet extends HttpServlet implements Servlet {


	private static final long serialVersionUID = 3559744551263933248L;
    typeAttractionService typeAttractionService;

    @Override
    public void init() throws ServletException {
    	super.init();
    	this.typeAttractionService = new typeAttractionService();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/typeAttractions/create.jsp");
		dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	String name = req.getParameter("name");


		typeAttractionService.create(name);

		resp.sendRedirect("/final1/index.jsp");


    }


}