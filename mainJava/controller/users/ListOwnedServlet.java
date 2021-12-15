package controller.users;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Attraction;
import model.User;
import model.*;
import services.UserOwnedService;

/**
 * Servlet implementation class ListPromotionServlet
 */
@WebServlet("/users/index.do")
public class ListOwnedServlet extends HttpServlet implements Servlet {


	private static final long serialVersionUID = 1L;
	private UserOwnedService userOwnedService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.userOwnedService = new UserOwnedService();
	}
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			User user = (User) req.getSession().getAttribute("user");
		
			List<promotion> promotionsOwned = userOwnedService.promotionsOwnedList(user.getId());
			req.setAttribute("promotionsOwned", promotionsOwned);
			
			List<Attraction> attractionsOwned = userOwnedService.attractionsOwnedList(user.getId());
			req.setAttribute("attractionsOwned", attractionsOwned);
			
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/users/carrito.jsp");
			dispatcher.forward(req, resp);
		}
	
	
}
