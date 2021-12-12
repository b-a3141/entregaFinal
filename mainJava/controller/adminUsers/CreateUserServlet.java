package controller.adminUsers;

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
import model.User;
import model.promotion;
import services.PromotionService;
import services.adminUserService;


@WebServlet("/adminUsers/create.do")
public class CreateUserServlet extends HttpServlet implements Servlet {
 

	private static final long serialVersionUID = 2204233401659108404L;
	adminUserService adminUserService;
	


	@Override
	public void init() throws ServletException {
		super.init();
		this.adminUserService = new adminUserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/adminUsers/create.jsp");
		dispatcher.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		Integer coins = Integer.parseInt(req.getParameter("coins"));
		Double time = Double.parseDouble(req.getParameter("time"));
		
		boolean admin = (req.getParameter("admin").equals("true")) ? true : false;
		
		String typeAttractions = req.getParameter("typeAttractions");
		String password = req.getParameter("password");
		
		
		User user = adminUserService.create(username, password, coins, time, admin, typeAttractions);
		
		


		resp.sendRedirect("/final1/index.jsp");
	
	}

}

