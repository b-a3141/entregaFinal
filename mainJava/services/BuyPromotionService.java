package services;

import java.util.HashMap;
import java.util.Map;

import model.User;
import model.promotion;
import persistence.PromotionDAO;
import persistence.UserDAO;
import persistence.commons.DAOFactory;


public class BuyPromotionService  {
       
	
	PromotionDAO pd = DAOFactory.getPromotionDAO();
	UserDAO      ud = DAOFactory.getUserDAO();
	
	public Map<String, String> buy(Integer userId, Integer promotionId){
		
		Map<String, String> errors = new HashMap<String, String>();
		promotion promotion = pd.find(promotionId);
		User      user      = ud.find(userId);
		
		if (!promotion.hasCapacity()) {
			errors.put("capacity", "No hay cupo disponible");
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
			pd.update(promotion);
		}
		
		return errors;
	}

}
