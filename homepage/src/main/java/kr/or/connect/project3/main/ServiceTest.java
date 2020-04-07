package kr.or.connect.project3.main;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.project3.config.ApplicationConfig;

import kr.or.connect.project3.dto.EventCategory;
import kr.or.connect.project3.service.MainpageService;

public class ServiceTest {

	public static void main(String[] args) {
	 ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	 MainpageService mainpageservice = ac.getBean(MainpageService.class);
	 
	 EventCategory[] url = mainpageservice.eventAll();
	 List<EventCategory> urr = mainpageservice.selectEvent(3);
	 String[] a = mainpageservice.getPromotion();
	 int b= mainpageservice.promotionCount();
	 System.out.println("11111111111");
	 System.out.println(a[1]);
	 System.out.println("11111111111");
	 System.out.println(b);
	 for(EventCategory eve :urr) {
		 System.out.println(eve);
	 }
	 System.out.println("11111111111");
	 int size =url.length;
	 System.out.println(size);
	 System.out.println("11111111111");
	for(int i=0;i<size;i++) {
		System.out.println(url[i]);
	}
	
	}
}
