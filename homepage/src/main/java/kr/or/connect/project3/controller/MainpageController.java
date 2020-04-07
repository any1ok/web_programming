package kr.or.connect.project3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.connect.project3.service.MainpageService;

@Controller
public class MainpageController {

	@Autowired
	MainpageService mainpageservice;

	@GetMapping(path = "/mainpagek")
	public String mainpage(ModelMap model) {

		String[] url = mainpageservice.getPromotion();
		int count = mainpageservice.promotionCount();
		model.put("url", url);
		model.put("count",count);
		return "mainpage";

	}

}
