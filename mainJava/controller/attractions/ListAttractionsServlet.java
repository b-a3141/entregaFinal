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
		List<Attraction> attractions = attractionService.list();
		req.setAttribute("attractions", attractions);
		//Pedir el  usuario logueado para pasarlo al método
		
		User user = (User) req.getSession().getAttribute("user");
		
    	
    	
		System.out.println(user);
		List<Attraction> attractionsPreferidas = attractionService.getAtraccionesPreferidas(user);
		
		System.out.println(attractionsPreferidas);
		req.setAttribute("attractionsPreferidas", attractionsPreferidas);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/attractions/index.jsp");
		dispatcher.forward(req, resp);

	}
	
	
	
}
