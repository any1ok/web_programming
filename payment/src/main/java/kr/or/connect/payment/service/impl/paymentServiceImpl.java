package kr.or.connect.payment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.payment.dao.PaymentDao;
import kr.or.connect.payment.dto.Payment;
import kr.or.connect.payment.service.PaymentService;

@Service
public class paymentServiceImpl implements PaymentService {

	@Autowired
	PaymentDao paymentDao;
	
	@Override
	@Transactional
	public List<Payment> paymentAll(){
		List<Payment> list = paymentDao.allpayment();
		return list;
	}

}
