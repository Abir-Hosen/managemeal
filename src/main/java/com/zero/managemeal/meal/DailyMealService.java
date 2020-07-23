package com.zero.managemeal.meal;

import java.util.Optional;
import org.springframework.data.domain.Page;
import com.zero.managemeal.abc.RequestParameter;

public interface DailyMealService {
	
	public Page<DailyMeal> findAllBySortAndOrder(RequestParameter requestParameter);
	public Optional<DailyMeal> findById(Long id);
	public void addEntity(DailyMeal entity);
	public void deleteEntity(Long id);
	public void deleteAllEntity();

}
