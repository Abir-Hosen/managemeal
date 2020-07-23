package com.zero.managemeal.meal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zero.managemeal.abc.RequestParameter;
import com.zero.managemeal.user.User;

@Transactional
@RestController
@RequestMapping("/api/dailyMeal")
public class DailyMealController {
	
	@Autowired
	private DailyMealService service;
	
	private Logger logger = LoggerFactory.getLogger(DailyMealController.class);

	@GetMapping
	public ResponseEntity<Page<DailyMeal>> findAllBySortAndOrder(RequestParameter requestParameter, HttpSession session) {
		logger.info("Entering GET method");
		Page<DailyMeal> page = service.findAllBySortAndOrder(requestParameter);
		return ResponseEntity.ok(page);
	}
	
	@PostMapping
	public ResponseEntity<DailyMeal> create(@RequestBody @Valid DailyMeal entity, BindingResult bindingResult, HttpSession session) {
		if(!bindingResult.hasErrors()) {
			entity.setManager((User)session.getAttribute("user"));
			service.addEntity(entity);
			return ResponseEntity.ok(entity);
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DailyMeal> updateEntity(@PathVariable Long id, @RequestBody @Valid DailyMeal entity, BindingResult bindingResult) {
		if(!bindingResult.hasErrors()) {
			service.addEntity(entity);
			return ResponseEntity.ok(entity);
		}else {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<DailyMeal> deleteEntity(@PathVariable Long id) {
		service.deleteEntity(id);
		return ResponseEntity.ok(null);
	}
}
