package controller.adminUsers;

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
import model.User;
import model.promotion;
import services.PromotionService;
import services.adminUserService;

@WebServlet("/adminUsers/index.do")
public class ListUserServlet extends HttpServlet implements Servlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3297312016400909693L;
	private adminUserService adminUserService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.adminUserService = new adminUserService();
	}
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			List<User> users = adminUserService.list();
			req.setAttribute("users", users);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/adminUsers/index.jsp");
			dispatcher.forward(req, resp);
		}
	
	
}