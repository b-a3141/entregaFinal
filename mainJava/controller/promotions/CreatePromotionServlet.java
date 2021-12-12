package controller.promotions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.promotion;
import services.PromotionService;

/**
 * Servlet implementation class CreatePromotionServlet
 */
@WebServlet("/promotions/create.do")
public class CreatePromotionServlet extends HttpServlet implements Servlet {
 
	PromotionService promotionService;
	
	private static final long serialVersionUID = -7089260286336265668L;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promotionService = new PromotionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promotions/create.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String name = req.getParameter("name");
		String type = req.getParameter("type");
		String descripcion = req.getParameter("descripcion");
		String imagen = req.getParameter("imagen");
		String typeAttraction = req.getParameter("typeAttraction");
		Integer cost = Integer.parseInt(req.getParameter("cost"));
		int discount = (int) Double.parseDouble(req.getParameter("discount"));
		System.out.println("lleg");
		String[] atraccionesEnString = req.getParameter("attractionContained").split(",");
		
		List<Integer> listaDeId = new ArrayList<Integer>();
		
		for (String  i : atraccionesEnString) {
			
			Integer idDeAtraccion = Integer.parseInt(i);
			listaDeId.add(idDeAtraccion);
		}

		promotion promotion = promotionService.create(name, type, descripcion, imagen, false, cost, discount,typeAttraction,listaDeId);



		
		if (promotion.isValid()) {
			resp.sendRedirect("/final1/promotions/index.do");
		} else { 
			req.setAttribute("promotion", promotion);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promotions/create.jsp");
			dispatcher.forward(req, resp);
		

	}

}}
