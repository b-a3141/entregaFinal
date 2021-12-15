package controller.adminUsers;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.adminUserService;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/adminUsers/delete.do")
public class DeleteUserServlet extends HttpServlet implements Servlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2618700887462822493L;
	adminUserService adminUserService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init();
		this.adminUserService = new adminUserService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		adminUserService.delete(id);

		resp.sendRedirect("/final1/index.jsp");
	}
}
