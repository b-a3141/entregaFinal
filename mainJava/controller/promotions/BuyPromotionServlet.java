package controller.promotions;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import persistence.commons.DAOFactory;
import services.BuyPromotionService;

/**
 * Servlet implementation class BuyPromotionServlet
 */
@WebServlet("/promotions/buy.do")
public class BuyPromotionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 3659549283285393970L;
	BuyPromotionService bps;

	@Override
	public void init() throws ServletException {
		super.init();
		bps = new BuyPromotionService();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer promotionId = Integer.parseInt(req.getParameter("id"));
		User user       = (User) req.getSession().getAttribute("user");
		Map<String, String> errors = bps.buy(user.getId(), promotionId);
		
		User user2 = DAOFactory.getUserDAO().find(user.getId());
		req.getSession().setAttribute("user", user2);
		
		if (errors.isEmpty()) {
			req.setAttribute("flash", "¡Gracias por comprar!");
		} else {
			req.setAttribute("errors", errors);
			req.setAttribute("flash", "No ha podido realizarse la compra");
		}

		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
		
	}

}
