package controller.promotions;

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
import model.Attraction;
import model.promotion;
import services.AttractionService;
import services.PromotionService;

/**
 * Servlet implementation class CreatePromotionServlet
 */
@WebServlet("/promotions/create.do")
public class CreatePromotionServlet extends HttpServlet implements Servlet {
  
	private static final long serialVersionUID = 1L;
	private PromotionService promotionService;

	
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
		String description = req.getParameter("description");
		String imagen = req.getParameter("imagen");
		Boolean capacity = Boolean.parseBoolean(req.getParameter("capacity"));
		Integer cost = Integer.parseInt(req.getParameter("cost"));
		Integer discount = Integer.parseInt(req.getParameter("discount"));
		
		
		

		promotion promotion = promotionService.create(name, type, description, 
				imagen, capacity, cost, discount);
		if (promotion.isValid()) {
			resp.sendRedirect("/final1/promotions/index.do");
		} else {
			req.setAttribute("promotion", promotion);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/promotions/create.jsp");
			dispatcher.forward(req, resp);
		}

	}


}
