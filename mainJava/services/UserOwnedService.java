package services;

import java.util.ArrayList;
import java.util.List;
import model.Attraction;
import model.User;
import model.promotion;
import persistence.AttractionDAO;
import persistence.PromotionDAO;
import persistence.UserDAO;
import persistence.commons.DAOFactory;

public class UserOwnedService {

	AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
	UserDAO userDAO = DAOFactory.getUserDAO();
	PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
	


	
	public List<promotion> promotionsOwnedList(Integer userId) {

		List<Integer> promoCompradasId =	userDAO.promotionObtained(userId);
		List<promotion> promotionsBuy = new ArrayList<promotion>();
		for(Integer promoCompradaId : promoCompradasId ) {
			promotionsBuy.add( promotionDAO.find(promoCompradaId) );
		}
		
		return promotionsBuy;
			
	}

	public List<Attraction> attractionsOwnedList(Integer userId) {
		List<Integer> atrCompradasId =	userDAO.attractionObtained(userId);
		List<Attraction> attractionsBuy = new ArrayList<Attraction>();
		for(Integer attracionId : atrCompradasId ) {
			attractionsBuy.add( attractionDAO.find(attracionId) );
		}
		
		return attractionsBuy;
	}

}
