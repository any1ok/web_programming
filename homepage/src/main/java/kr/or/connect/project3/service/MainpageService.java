package kr.or.connect.project3.service;


import java.util.List;

import kr.or.connect.project3.dto.EventCategory;

public interface MainpageService {
	public String[] getPromotion();
	public int promotionCount();
	public EventCategory[] eventAll();
	public List<EventCategory> selectEvent(int categoryId);
}
