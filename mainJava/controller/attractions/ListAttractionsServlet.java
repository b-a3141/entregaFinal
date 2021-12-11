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
	

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AttractionService();
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		User user =(User) req.getSession().getAttribute("user");
		
		List<Attraction> attractionsPreferidas = attractionService.getPreferidas(user);
		req.setAttribute("attractionsPreferidas", attractionsPreferidas);

		List<Attraction> attractionsNotPreferidas = attractionService.getNotPreferidas(user);
		req.setAttribute("attractionsNotPreferidas", attractionsNotPreferidas);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/attractions/index.jsp");
		dispatcher.forward(req, resp);

	}
	
	
	
}
