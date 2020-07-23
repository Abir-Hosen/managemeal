package com.zero.managemeal.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.zero.managemeal.meal.DailyMeal;

@Repository("userRepository")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	
	@Query("select m from User m where m.username like %?1% or m.id like %?1%")
	Page<User> findAllBySortAndOrder(String username, Pageable pageable);
	
	public User findByEmail(String email);

}
