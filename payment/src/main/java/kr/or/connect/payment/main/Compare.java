package kr.or.connect.payment.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.payment.config.ApplicationConfig;
import kr.or.connect.payment.dao.PaymentDao;
import kr.or.connect.payment.dto.Payment;

public class Compare {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		PaymentDao paymentDao = ac.getBean(PaymentDao.class);
		List<Payment> list = paymentDao.allpayment();
		
		for(Payment payment : list) {
			System.out.println(payment);
		}

	}

}
