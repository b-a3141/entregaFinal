package persistence;

import java.util.List;

import model.promotion;
import persistence.commons.GenericDAO;

public interface PromotionDAO extends GenericDAO<promotion> {
	
	public promotion findByName(promotion promotion);
	public int insertAttractionContained(int idPromotion, List<Integer> lista);
}
