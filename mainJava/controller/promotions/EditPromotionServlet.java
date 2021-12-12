package controller.promotions;

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
import model.Attraction;
import model.promotion;
import services.PromotionService;

/**
 * Servlet implementation class EditPromotionServlet
 */
@WebServlet("/EditPromotionServlet")
public class EditPromotionServlet extends HttpServlet implements Servlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6449741921353365751L;
	private PromotionService promotionservice;

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init();
		this.promotionservice = new PromotionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(req.getParameter("id"));

		promotion promotion = promotionservice.find(id);
		req.setAttribute("promotion", promotion);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promotions/edit.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id         = Integer.parseInt(req.getParameter("id"));
		String name        = req.getParameter("name");
		String type        = req.getParameter("type");
		String descripcion = req.getParameter("descripcion");
		String imagen      = req.getParameter("imagen");
		String typeAttraction = req.getParameter("typeAttraction");
		Boolean capacity   = Boolean.parseBoolean(req.getParameter("capacity"));
		int     cost       = Integer.parseInt(req.getParameter("cost"));
		int    discount    = Integer.parseInt(req.getParameter("discount"));
		
		promotion promotion = new promotion(id, name, type, descripcion, imagen, capacity, cost, discount,typeAttraction);
		
		promotionservice.update(id, name, type, descripcion, imagen, capacity, cost, discount);
		
		if(promotion.isValid()) {
			resp.sendRedirect("/views/promotions/index.jsp");
		} else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promotions/edit.jsp");
			dispatcher.forward(req, resp);
		}
		
		
		
	}

}
