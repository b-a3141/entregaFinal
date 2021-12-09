package services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import model.User;
import model.promotion;
import persistence.PromotionDAO;
import persistence.UserDAO;
import persistence.commons.DAOFactory;

/**
 * Servlet implementation class BuyPromotionService
 */
@WebServlet("/BuyPromotionService")
public class BuyPromotionService extends HttpServlet implements Servlet {
       
	
	PromotionDAO pd = DAOFactory.getPromotionDAO();
	UserDAO      ud = DAOFactory.getUserDAO();
	
	public Map<String, String> buy(Integer userId, Integer promotionId){
		Map<String, String> errors = new HashMap<String, String>();
		promotion promotion = pd.find(promotionId);
		User      user      = ud.find(userId);
		
		if (promotion.getCapacity()) {
			errors.put("attraction", "No hay cupo disponible");
		}
		if (!user.canAfford(promotion)) {
			errors.put("user", "No tienes dinero suficiente");
		}
		if (!user.canAttend(promotion)) {
			errors.put("user", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			user.addToItinerary(promotion);
			promotion.discountCapacity();

			// no grabamos para no afectar la base de pruebas
			ud.update(user);
		}
		
		return errors;
	}

}
