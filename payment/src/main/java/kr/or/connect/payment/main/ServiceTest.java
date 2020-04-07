package kr.or.connect.payment.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.payment.config.ApplicationConfig;
import kr.or.connect.payment.dto.Payment;
import kr.or.connect.payment.service.PaymentService;

public class ServiceTest {

	public static void main(String[] args) {
		
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		PaymentService payment = ac.getBean(PaymentService.class);
		
		
		
		List<Payment> list =payment.paymentAll();
		
		for(Payment p : list) {
			System.out.println(p);
			
		}
		
	}

}
