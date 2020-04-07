package kr.or.connect.project3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {

	@GetMapping(path = "/bookinglogin")
	public String paymentPage(ModelMap model) {
		String name = "준규";
		String email = "dlwnsrb97@naver.com";
		String phone = "010-5060-6165";
		String address = "대구대구";
		int totalPrice = 100;

		model.put("name", name);
		model.put("email", email);
		model.put("phone", phone);
		model.put("address", address);
		model.put("totalPrice", totalPrice);

		return "payment";
	}

	@GetMapping(path = "/order/paySuccess")
	public String paySuccessPage(@RequestParam(name = "msg", required = false) String msg, ModelMap model) {

		model.put("msg", msg);
		return "sucess";
	}

	@GetMapping(path = "/order/payFail")
	public String payFailPage(ModelMap model) {

		return "Fail";
	}

}
