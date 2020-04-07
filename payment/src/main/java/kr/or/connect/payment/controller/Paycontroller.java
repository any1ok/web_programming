package kr.or.connect.payment.controller;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.connect.payment.dto.Payment;
import kr.or.connect.payment.fun.Tokenfun;
import kr.or.connect.payment.service.PaymentService;

@Controller
public class Paycontroller {
	
	@Autowired
	PaymentService paymentservice;
	
	@GetMapping(path = "/paymentpage")
	public String paymentpage(ModelMap model) {
		Tokenfun tokenfun = new Tokenfun();
		String token = tokenfun.token();
        
        
        List<Payment> list = paymentservice.paymentAll();
        model.put("token", token);
		model.put("list", list);
		return "paymentPage";
	}
	
}
