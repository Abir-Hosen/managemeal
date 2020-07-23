package com.zero.managemeal.meal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("dailyMealRepository")
public interface DailyMealRepository extends PagingAndSortingRepository<DailyMeal, Long>{
	
	@Query("select m from DailyMeal m where m.item like %?1% or m.id like %?1%")
	Page<DailyMeal> findAllBySortAndOrder(String item, Pageable pageable);

}
