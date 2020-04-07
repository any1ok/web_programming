package kr.or.connect.project3.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.project3.config.ApplicationConfig;
import kr.or.connect.project3.dao.DisplayInfoDao;
import kr.or.connect.project3.dao.ProductDao;
import kr.or.connect.project3.dao.ProductImageDao;
import kr.or.connect.project3.dao.PromotionDao;
import kr.or.connect.project3.dto.DisplayInfo;
import kr.or.connect.project3.dto.Product;
import kr.or.connect.project3.dto.ProductImage;
import kr.or.connect.project3.dto.Promotion;

public class JDBCTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		PromotionDao promotionDao = ac.getBean(PromotionDao.class);
		ProductImageDao productImageDao = ac.getBean(ProductImageDao.class);
		DisplayInfoDao displayInfoDao = ac.getBean(DisplayInfoDao.class);
		List<DisplayInfo> list4 = displayInfoDao.displayInfoAll();
		ProductDao productdao = ac.getBean(ProductDao.class);
		List<Product> list3 = productdao.selectProduct(1);
		List<ProductImage> list = productImageDao.selectImagebyPid(1);
		List<Promotion> list2 = promotionDao.selectPromotion();
		System.out.println(promotionDao.promotionCount());
		/*for(ProductImage productImage: list) {
			
			System.out.println(productImage.getProductId());
			
		}
		*/
		for(ProductImage promotion: list) {
			System.out.println(promotion);
		}
			
	}

}
