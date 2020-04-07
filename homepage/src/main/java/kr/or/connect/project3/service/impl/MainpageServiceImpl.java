package kr.or.connect.project3.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.project3.dao.DisplayInfoDao;
import kr.or.connect.project3.dao.ProductDao;
import kr.or.connect.project3.dao.ProductImageDao;
import kr.or.connect.project3.dao.PromotionDao;
import kr.or.connect.project3.dto.DisplayInfo;
import kr.or.connect.project3.dto.EventCategory;
import kr.or.connect.project3.dto.Product;
import kr.or.connect.project3.dto.ProductImage;
import kr.or.connect.project3.dto.Promotion;
import kr.or.connect.project3.service.MainpageService;


@Service
public class MainpageServiceImpl implements MainpageService {
	@Autowired
	PromotionDao promotionDao;
	@Autowired
	ProductImageDao productimagedao;
	@Autowired
	DisplayInfoDao displayInfoDao;
	@Autowired
	ProductDao productDao;
	
	@Override
	@Transactional
	public String[] getPromotion() {
		
		List<ProductImage> list = productimagedao.selectImage("th");
		int size = list.size();
		int tt[] = new int[size+1];
		List<Promotion> list2 = promotionDao.selectPromotion();
		int size2 =list2.size();
		String[] url = new String[size2];
		for(ProductImage productImage : list) {
			tt[productImage.getProductId()] = productImage.getId();
		}
		int k=0;
		for(Promotion promotion: list2) {
			url[k] = "img/"+promotion.getProductId()+"_th_"+tt[promotion.getProductId()]+".png";
			k++;
		}
		return url;
		}
	
	@Override
	public int promotionCount(){
		return promotionDao.promotionCount();
	}
	
	@Override
	@Transactional
	public EventCategory[] eventAll() {
		List<Product> list1 = productDao.allProduct();
		List<DisplayInfo> list2 = displayInfoDao.displayInfoAll();
		List<ProductImage> list3 = productimagedao.selectImage("th");
		int size = list2.size();
		EventCategory[] eventArr = new EventCategory[size];
		for(int i=0;i<size ;i++) {
			eventArr[i] = new EventCategory();
		}
		
		int index =0;
		int id = 0;
		EventCategory eve = new EventCategory();
		while(index != size) {
			eventArr[index].setPlace(list2.get(index).getPlaceName());
			eventArr[index].setContent(list1.get(id).getContent());
			eventArr[index].setDescription(list1.get(id).getDescription());
			String url =  "img/"+(id+1)+"_th_"+list3.get(id).getId()+".png";
			eventArr[index].setUrl(url);
			
			
			if(index !=(size-1) ) {
			if(list2.get(index).getProductId()!=list2.get(index+1).getProductId()) {
				id++;
			}
			}
			index++;
		}
		return eventArr;
		
	}
	
	@Override
	@Transactional
	public List<EventCategory> selectEvent(int categoryId) {
		List<Product> list1 = productDao.selectProduct(categoryId);
		List<DisplayInfo> list2 = displayInfoDao.displayInfoAll();
		List<ProductImage> list3 = productimagedao.selectImage("th");
		
		int indexD=0;
		int indexP=0;
		List<EventCategory> eve = new ArrayList<>();;
		int limit = list2.size();
		
		for(Product product :list1) {
			
			String a = product.getContent();
			String b = product.getDescription();
			
			
			while(product.getId() != list3.get(indexP).getProductId()) {
				indexP++;
			}
			
			while(product.getId() != list2.get(indexD).getProductId()) {
				indexD++;
				
				
			}
			while(product.getId() == list2.get(indexD).getProductId()) {
				EventCategory e = new EventCategory();
				e.setContent(a);
				e.setDescription(b);
				e.setPlace(list2.get(indexD).getPlaceName());
				String url =  "img/"+list3.get(indexP).getProductId()+"_th_"+list3.get(indexP).getId()+".png";
				e.setUrl(url);
				System.out.println(b);
				System.out.println(a);
				
				System.out.println(list2.get(indexD).getPlaceName());
				System.out.println(url);
				eve.add(e);
				indexD++;
				if(indexD == limit) {
					break;
				}
				
			}
			
		}
		return eve;
	}
	
	
}
