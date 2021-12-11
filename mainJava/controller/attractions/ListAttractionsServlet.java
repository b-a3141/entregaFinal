package controller.attractions;

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
import services.AttractionService;
import services.LoginService;

@WebServlet("/attractions/index.do")
public class ListAttractionsServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private AttractionService attractionService;
	private LoginService loginService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AttractionService();
		loginService = new LoginService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	//	String username = req.getParameter("username");
    //	String password = req.getParameter("password");
    	
    	//User user = loginService.login(username, password);
		User user =(User) req.getSession().getAttribute("user");
		
		List<Attraction> attractionsPreferidas = attractionService.getPreferidas(user);
		req.setAttribute("attractionsPreferidas", attractionsPreferidas);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/attractions/index.jsp");
		dispatcher.forward(req, resp);

	}
	
	
	
}
