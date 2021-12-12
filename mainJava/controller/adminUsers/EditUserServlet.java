package controller.adminUsers;


import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import services.adminUserService;

/**
 * Servlet implementation class EditPromotionServlet
 */
@WebServlet("/adminUsers/edit.do")
public class EditUserServlet extends HttpServlet implements Servlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6449741921353365751L;
	adminUserService adminUserService;

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init();
		this.adminUserService = new adminUserService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(req.getParameter("id"));

		User user = adminUserService.find(id);
		
		req.setAttribute("userToEdit", user);
		
		req.getRequestDispatcher("/views/adminUsers/edit.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(req.getParameter("id2"));
		System.out.println(req.getParameter("coins"));
		System.out.println(req.getParameter("time"));
		System.out.println(req.getParameter("username"));
		Integer id = Integer.parseInt(req.getParameter("id2"));
		Integer coins = Integer.parseInt(req.getParameter("coins"));
		Double time = Double.parseDouble(req.getParameter("time"));
		
		adminUserService.update(id, coins, time);
		
		resp.sendRedirect("/final1/index.jsp");
		
	
	}
}
