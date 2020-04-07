package kr.or.connect.project3.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.project3.dto.EventCategory;
import kr.or.connect.project3.service.MainpageService;

@RestController
@RequestMapping(path = "/category")
public class MainpageApiController {

	@Autowired
	MainpageService mainpageservice;

	@GetMapping
	public Map<String, Object> list(@RequestParam(name = "category", required = false, defaultValue = "0") int category,
			@RequestParam(name = "more", required = false, defaultValue = "0") int more) {
		EventCategory[] eveA = mainpageservice.eventAll();
		List<EventCategory> eve = new ArrayList<>();
		List<EventCategory> eve1 = new ArrayList<>();
		List<EventCategory> eve2 = new ArrayList<>();

		int size = 0;
		int pinksize = 0;
		if (category == 0) {
			pinksize = eveA.length;
			for (int i = 0; i < eveA.length; i++) {
				eve.add(eveA[i]);
			}
			more++;
		} else {
			eve = mainpageservice.selectEvent(category);
			pinksize = eve.size();
			more++;
		}
		size = eve.size();
		for (int i = 0; i < (4 * more); i++) {
			if (size - 1 < i) {
				break;
			}

			if (i % 2 == 0) {
				eve1.add(eve.get(i));
			} else if (i % 2 == 1) {
				eve2.add(eve.get(i));
			}

		}

		Map<String, Object> map = new HashMap<>();

		map.put("eve1", eve1);
		map.put("eve2", eve2);
		map.put("category", category);
		map.put("more", more);
		map.put("pinksize", pinksize);
		return map;
	}

}
