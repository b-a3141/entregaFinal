package controller.promotions;

import java.io.IOException;

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
import persistence.PromotionDAO;
import persistence.commons.DAOFactory;

/**
 * Servlet implementation class DeletePromotionServlet
 */
@WebServlet("/promotions/delete.do")
public class DeletePromotionServlet extends HttpServlet implements Servlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5013410775608608111L;
    PromotionDAO promotionDAO;
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	promotionDAO = DAOFactory.getPromotionDAO();
    }
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	Integer id = Integer.parseInt(req.getParameter("id"));
    	promotion promotion = promotionDAO.find(id);
    	promotionDAO.delete(promotion);
    	
    	req.getRequestDispatcher("index.jsp").forward(req, resp);
    	
    	
    }
    
}
