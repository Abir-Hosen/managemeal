package com.zero.managemeal.meal;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.zero.managemeal.abc.RequestParameter;

@Service("dailyMealService")
public class DailyMealServiceImpl implements DailyMealService {
	
	Logger logger = LoggerFactory.getLogger(DailyMealService.class);
	
	@Autowired
	private DailyMealRepository repository;
	private Pageable pagable;

	@Override
	public Page<DailyMeal> findAllBySortAndOrder(RequestParameter requestParameter) {
		logger.info("Entering findAllBySortAndOrder Method");
		if(requestParameter.getPage() >= 1) {
			requestParameter.setPage(requestParameter.getPage()-1);
		}
		if(requestParameter.getOrder().charAt(0) == '-') {
			String sortOrder = requestParameter.getOrder().substring(1);
			pagable = PageRequest.of(requestParameter.getPage(), requestParameter.getLimit(), Sort.by(sortOrder).descending());
		}
		else {
			pagable = PageRequest.of(requestParameter.getPage(), requestParameter.getLimit(), Sort.by(requestParameter.getOrder()).ascending());
		}
		return repository.findAllBySortAndOrder(requestParameter.getFilter(), pagable);
	}

	@Override
	public Optional<DailyMeal> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public void addEntity(DailyMeal entity) {
		repository.save(entity);
	}

	@Override
	public void deleteEntity(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void deleteAllEntity() {
		repository.deleteAll();
	}

}
