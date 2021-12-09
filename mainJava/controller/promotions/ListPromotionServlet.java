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
import model.promotion;
import services.PromotionService;

/**
 * Servlet implementation class ListPromotionServlet
 */
@WebServlet("/promotions/index.do")
public class ListPromotionServlet extends HttpServlet implements Servlet {


	private static final long serialVersionUID = 3178706074516494231L;
	private PromotionService promotionservice;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.promotionservice = new PromotionService();
	}
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			List<promotion> promotions = promotionservice.list();
			req.setAttribute("promotions", promotions);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promotions/index.jsp");
			dispatcher.forward(req, resp);
		}
	
	
}
